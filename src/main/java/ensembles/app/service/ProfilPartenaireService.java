package ensembles.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ensembles.app.entity.Adresse;

import ensembles.app.entity.ProfilPartenaire;
import ensembles.app.repository.RepoAdresse;
import ensembles.app.repository.RepoProfilPartenaire;
import ensembles.app.viewmodels.ProfilPartenaireViewModel;

@Stateless
public class ProfilPartenaireService {
	
	@Inject
	RepoProfilPartenaire repoProfilPartenaire;
	
	@Inject
	RepoAdresse repoAdresse;
	
	public void saveProfilPartenaire(ProfilPartenaireViewModel profilPartenaireViewModel) {
		
		ProfilPartenaire profilPartenaire = new ProfilPartenaire();
		profilPartenaire.setNomPartenaire(profilPartenaireViewModel.getNomPartenaire());
		profilPartenaire.setSiretPartenaire(profilPartenaireViewModel.getSiretPartenaire());
		profilPartenaire.setNomResponsablePartenaire(profilPartenaireViewModel.getNomResponsablePartenaire());
		profilPartenaire.setPrenomResponsablePartenaire(profilPartenaireViewModel.getPrenomResponsablePartenaire());
		profilPartenaire.setEmailResponsablePartenaire(profilPartenaireViewModel.getEmailResponsablePartenaire());
		profilPartenaire.setTelephoneResponsablePartenaire(profilPartenaireViewModel.getTelephoneResponsablePartenaire());
		
		Adresse adresse = new Adresse();
		adresse.setNumero(profilPartenaireViewModel.getNumero());
		adresse.setComplement(profilPartenaireViewModel.getComplement());
		adresse.setVoie(profilPartenaireViewModel.getVoie());
		adresse.setCodePostal(profilPartenaireViewModel.getCodePostal());
		adresse.setVille(profilPartenaireViewModel.getVille());
		adresse.setPays(profilPartenaireViewModel.getPays());
		
		profilPartenaire.setAdresse(adresse);
		
		repoProfilPartenaire.save(profilPartenaire);
	}

	public ProfilPartenaire findByUserId(Long userId) {
		System.out.println(repoProfilPartenaire.findByUserId(userId));
		return repoProfilPartenaire.findByUserId(userId);
	}

	public void modifyProfilPartenaire(ProfilPartenaireViewModel profilPartenaireViewModel) {
		
		ProfilPartenaire profilPartenaire = repoProfilPartenaire.findById(profilPartenaireViewModel.getId());
		
		profilPartenaire.setNomPartenaire(profilPartenaireViewModel.getNomPartenaire());
		profilPartenaire.setSiretPartenaire(profilPartenaireViewModel.getSiretPartenaire());
		profilPartenaire.setNomResponsablePartenaire(profilPartenaireViewModel.getNomResponsablePartenaire());
		profilPartenaire.setPrenomResponsablePartenaire(profilPartenaireViewModel.getPrenomResponsablePartenaire());
		profilPartenaire.setEmailResponsablePartenaire(profilPartenaireViewModel.getEmailResponsablePartenaire());
		profilPartenaire.setTelephoneResponsablePartenaire(profilPartenaireViewModel.getTelephoneResponsablePartenaire());
		
		Adresse adresse = profilPartenaire.getAdresse();
		
		adresse.setNumero(profilPartenaireViewModel.getNumero());
		adresse.setComplement(profilPartenaireViewModel.getComplement());
		adresse.setVoie(profilPartenaireViewModel.getVoie());
		adresse.setCodePostal(profilPartenaireViewModel.getCodePostal());
		adresse.setVille(profilPartenaireViewModel.getVille());
		adresse.setPays(profilPartenaireViewModel.getPays());
		
		repoAdresse.update(adresse);

		repoProfilPartenaire.update(profilPartenaire);
		
	}

}
