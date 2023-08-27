package ensembles.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ensembles.app.entity.Adresse;
import ensembles.app.entity.ProfilAgence;
import ensembles.app.repository.RepoAdresse;
import ensembles.app.repository.RepoProfilAgence;
import ensembles.app.viewmodels.ProfilAgenceViewModel;

@Stateless
public class ProfilAgenceService {

	@Inject
	RepoProfilAgence repoProfilAgence;
	@Inject
	RepoAdresse repoAdresse;

	public void saveProfilAgence(ProfilAgenceViewModel profilAgenceViewModel) {

		ProfilAgence profilAgence = new ProfilAgence();
		profilAgence.setUser(profilAgenceViewModel.getUser());
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

	public void saveProfilAgence(ProfilAgence profilAgence) {

		Adresse adresse = new Adresse();
		profilAgence.setAdresse(adresse);

		repoProfilAgence.save(profilAgence);
	}

	public void modifyProfilAgence(ProfilAgenceViewModel profilAgenceViewModel) {

		ProfilAgence profilAgence = repoProfilAgence.findById(profilAgenceViewModel.getId());
				
		profilAgence.setNomSociete(profilAgenceViewModel.getNomSociete());
		profilAgence.setSiretSociete(profilAgenceViewModel.getSiretSociete());
		profilAgence.setNomResponsableSociete(profilAgenceViewModel.getNomResponsableSociete());
		profilAgence.setPrenomResponsableSociete(profilAgenceViewModel.getPrenomResponsableSociete());
		profilAgence.setEmailResponsableSociete(profilAgenceViewModel.getEmailResponsableSociete());
		profilAgence.setTelephoneResponsableSociete(profilAgenceViewModel.getTelephoneResponsableSociete());

		Adresse adresse = profilAgence.getAdresse();

		adresse.setId(profilAgenceViewModel.getAdresseId());
		adresse.setNumero(profilAgenceViewModel.getNumero());
		adresse.setComplement(profilAgenceViewModel.getComplement());
		adresse.setVoie(profilAgenceViewModel.getVoie());
		adresse.setCodePostal(profilAgenceViewModel.getCodePostal());
		adresse.setVille(profilAgenceViewModel.getVille());
		adresse.setPays(profilAgenceViewModel.getPays());
		
		profilAgence.setAdresse(adresse);

		repoAdresse.update(adresse);

		repoProfilAgence.update(profilAgence);

	}

	public ProfilAgence findByUserId(Long id) {
		System.out.println("Service find by user id");

		return repoProfilAgence.findByUserId(id);
	}

}
