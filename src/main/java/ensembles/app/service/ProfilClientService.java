package ensembles.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ensembles.app.entity.ProfilClient;
import ensembles.app.repository.RepoProfilClient;
import ensembles.app.viewmodels.ProfilClientViewModel;


@Stateless
public class ProfilClientService {

	@Inject
	RepoProfilClient repoProfilClient;
	
	public void saveProfilClient(ProfilClientViewModel profilClientViewModel) {
		ProfilClient profilClient = new ProfilClient();
		profilClient.setPrenomClient(profilClientViewModel.getPrenomClient());
		profilClient.setNomClient(profilClientViewModel.getNomClient());
		profilClient.setVoie(profilClientViewModel.getVoie());
		profilClient.setVille(profilClientViewModel.getVille());
		profilClient.setCodepostal(profilClientViewModel.getCodepostal());
		profilClient.setPays(profilClientViewModel.getPays());
		profilClient.setEmailClient(profilClientViewModel.getEmailClient());
		profilClient.setTelephoneClient(profilClientViewModel.getTelephoneClient());
		
		repoProfilClient.save(profilClient);
	}
	
}
