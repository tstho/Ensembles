package ensembles.app.service;

import javax.inject.Inject;

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
		profilAgence.setNumeroSociete(profilAgenceViewModel.getNumeroSociete());
		profilAgence.setComplementSociete(profilAgenceViewModel.getComplementSociete());
		profilAgence.setVoieSociete(profilAgenceViewModel.getVoieSociete());
		profilAgence.setCodePostalSociete(profilAgenceViewModel.getCodePostalSociete());
		profilAgence.setVilleSociete(profilAgenceViewModel.getVilleSociete());
		profilAgence.setPaysSociete(profilAgenceViewModel.getPaysSociete());
		profilAgence.setNomResponsableSociete(profilAgenceViewModel.getNomResponsableSociete());
		profilAgence.setPrenomResponsableSociete(profilAgenceViewModel.getPrenomResponsableSociete());
		profilAgence.setEmailResponsableSociete(profilAgenceViewModel.getEmailResponsableSociete());
		profilAgence.setTelephoneResponsableSociete(profilAgenceViewModel.getTelephoneResponsableSociete());

		repoProfilAgence.save(profilAgence);

	}

}
