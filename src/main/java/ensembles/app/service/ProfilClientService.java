package ensembles.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ensembles.app.entity.Adresse;
import ensembles.app.entity.ProfilClient;
import ensembles.app.repository.RepoProfilClient;
import ensembles.app.viewmodels.ProfilClientViewModel;


@Stateless
public class ProfilClientService extends ProfilService {

	@Inject
	RepoProfilClient repoProfilClient;
	
	public void saveProfilClient(ProfilClientViewModel profilClientViewModel) {
		ProfilClient profilClient = new ProfilClient();
		profilClient.setPrenomClient(profilClientViewModel.getPrenomClient());
		profilClient.setNomClient(profilClientViewModel.getNomClient());
		profilClient.setEmailClient(profilClientViewModel.getEmailClient());
		profilClient.setTelephoneClient(profilClientViewModel.getTelephoneClient());
		

		Adresse adresse = new Adresse();
		adresse.setNumero(profilClientViewModel.getNumero());
		adresse.setComplement(profilClientViewModel.getComplement());
		adresse.setVoie(profilClientViewModel.getVoie());
		adresse.setCodePostal(profilClientViewModel.getCodePostal());
		adresse.setVille(profilClientViewModel.getVille());
		adresse.setPays(profilClientViewModel.getPays());
		
		profilClient.setAdresse(adresse);
		
		repoProfilClient.save(profilClient);
	}
	
}
