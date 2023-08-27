package ensembles.app.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import ensembles.app.entity.ProfilPartenaire;
import ensembles.app.service.ProfilPartenaireService;

import ensembles.app.viewmodels.ProfilPartenaireViewModel;

@ManagedBean
@SessionScoped
public class ControllerProfilPartenaire implements Serializable {

	public static final long serialVersionUID = 1L;

	ProfilPartenaireViewModel profilPartenaireViewModel = new ProfilPartenaireViewModel();

	@Inject
	ProfilPartenaireService profilPartenaireService;

	public void saveProfilPartenaire() {
		profilPartenaireService.saveProfilPartenaire(profilPartenaireViewModel);
	}

	public ProfilPartenaireViewModel getProfilPartenaireViewModel() {
		return profilPartenaireViewModel;
	}

	public void setProfilPartenaireViewModel(ProfilPartenaireViewModel profilPartenaireViewModel) {
		this.profilPartenaireViewModel = profilPartenaireViewModel;
	}

	// redirection modification du profil du partenaire
	public String redirectToEdit(Long userId) {
		initModifierProfilP(userId);
		return "/partners/profilPartenaire.xhtml?faces-redirect=true";
	}

	public void initModifierProfilP(Long userId) {

		ProfilPartenaire profilPartenaire = profilPartenaireService.findByUserId(userId);

		profilPartenaireViewModel = new ProfilPartenaireViewModel();

		// identification du partenaire et de son adresse

		profilPartenaireViewModel.setUser(profilPartenaire.getUser());
		profilPartenaireViewModel.setId(profilPartenaire.getId());

		profilPartenaireViewModel.setAdresseId(profilPartenaire.getAdresse().getId());

		// infos du partenaire

		profilPartenaireViewModel.setNomPartenaire(profilPartenaire.getNomPartenaire());
		profilPartenaireViewModel.setSiretPartenaire(profilPartenaire.getSiretPartenaire());
		profilPartenaireViewModel.setNomResponsablePartenaire(profilPartenaire.getNomResponsablePartenaire());
		profilPartenaireViewModel.setPrenomResponsablePartenaire(profilPartenaire.getPrenomResponsablePartenaire());
		profilPartenaireViewModel.setEmailResponsablePartenaire(profilPartenaire.getEmailResponsablePartenaire());
		profilPartenaireViewModel.setTelephoneResponsablePartenaire(profilPartenaire.getTelephoneResponsablePartenaire());

		// infos de l'adresse du partenaire
		profilPartenaireViewModel.setAdresseId(profilPartenaire.getAdresse().getId());

		profilPartenaireViewModel.setNumero(profilPartenaire.getAdresse().getNumero());
		profilPartenaireViewModel.setComplement(profilPartenaire.getAdresse().getComplement());
		profilPartenaireViewModel.setVoie(profilPartenaire.getAdresse().getVoie());
		profilPartenaireViewModel.setCodePostal(profilPartenaire.getAdresse().getCodePostal());
		profilPartenaireViewModel.setVille(profilPartenaire.getAdresse().getVille());
		profilPartenaireViewModel.setPays(profilPartenaire.getAdresse().getPays());
		
		//infos de services associés au partenaire
		profilPartenaireViewModel.setServices(profilPartenaire.getServices());


	}

	public String modifierProfilP(Long userId) {

		profilPartenaireService.modifyProfilPartenaire(profilPartenaireViewModel);
		resetViewModel();

		return redirectToEdit(userId);
	}

	private void resetViewModel() {
		profilPartenaireViewModel = new ProfilPartenaireViewModel();
	}
}
