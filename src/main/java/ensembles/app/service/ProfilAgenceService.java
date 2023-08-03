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
		profilAgence.setAdresseSociete(profilAgenceViewModel.getAdresseSociete());
		profilAgence.setNomResponsableSociete(profilAgenceViewModel.getNomResponsableSociete());
		profilAgence.setPrenomResponsableSociete(profilAgenceViewModel.getPrenomResponsableSociete());
		
		repoProfilAgence.save(profilAgence);
		
		
	}
	
	

}
