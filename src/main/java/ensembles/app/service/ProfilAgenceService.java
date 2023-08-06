package ensembles.app.service;

import javax.inject.Inject;

import ensembles.app.entity.Adresse;
import ensembles.app.entity.ProfilAgence;
import ensembles.app.repository.RepoProfilAgence;
import ensembles.app.viewmodels.ProfilAgenceViewModel;

public class ProfilAgenceService {

	@Inject
	RepoProfilAgence repoProfilAgence;

	public void saveProfilAgence(ProfilAgenceViewModel profilAgenceViewModel) {
		
		ProfilAgence profilAgence = new ProfilAgence();
		profilAgence.setNomSociete(profilAgenceViewModel.getNomSociete());
		profilAgence.setSiretSociete(profilAgenceViewModel.getSiretSociete());
		profilAgence.setNomResponsableSociete(profilAgenceViewModel.getNomResponsableSociete());
		profilAgence.setPrenomResponsableSociete(profilAgenceViewModel.getPrenomResponsableSociete());
		profilAgence.setEmailResponsableSociete(profilAgenceViewModel.getEmailResponsableSociete());
		profilAgence.setTelephoneResponsableSociete(profilAgenceViewModel.getTelephoneResponsableSociete());
		
		Adresse adresse = new Adresse();
		adresse.setNumero(profilAgenceViewModel.getNumero());
		adresse.setComplement(profilAgenceViewModel.getComplement());
		adresse.setVoie(profilAgenceViewModel.getVoie());
		adresse.setCodePostal(profilAgenceViewModel.getCodePostal());
		adresse.setVille(profilAgenceViewModel.getVille());
		adresse.setPays(profilAgenceViewModel.getPays());
		
		profilAgence.setAdresse(adresse);

		repoProfilAgence.save(profilAgence);

	}

}
