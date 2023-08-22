package ensembles.app.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import ensembles.app.entity.ProfilAgence;
import ensembles.app.entity.User;
import ensembles.app.repository.RepoProfilAgence;
import ensembles.app.service.ProfilAgenceService;
import ensembles.app.viewmodels.ProfilAgenceViewModel;
import ensembles.app.viewmodels.UserViewModel;

@ManagedBean
@SessionScoped
public class ControllerProfilAgence implements Serializable {


	private static final long serialVersionUID = 1L;
	
	ProfilAgenceViewModel profilAgenceViewModel = new ProfilAgenceViewModel();
	
	@Inject
	ProfilAgenceService profilAgenceService;
	
//	
//	public void saveProfilAgence() {
//		profilAgenceService.saveProfilAgence(profilAgenceViewModel);
//	}

	public ProfilAgenceViewModel getProfilAgenceViewModel() {
		return profilAgenceViewModel;
	}

	public void setProfilAgenceViewModel(ProfilAgenceViewModel profilAgenceViewModel) {
		this.profilAgenceViewModel = profilAgenceViewModel;
	}
	
	// Modification du profil de l'agence 
		public String redirectToEdit(Long userId) {
			initModifierProfilA(userId);
			return "/agency/profilAgence.xhtml?faces-redirect=true";
		}
		
		
		public void initModifierProfilA(Long userId) {

			ProfilAgence profilAgence = profilAgenceService.findByUserId(userId);
			
			profilAgenceViewModel = new ProfilAgenceViewModel();
			
			profilAgenceViewModel.setUser(profilAgence.getUser());
			profilAgenceViewModel.setId(profilAgence.getId());
			profilAgenceViewModel.setNomSociete(profilAgence.getNomSociete());
			profilAgenceViewModel.setCodePostal(profilAgence.getAdresse().getCodePostal());
			profilAgenceViewModel.setComplement(profilAgence.getAdresse().getComplement());
			
			profilAgenceViewModel.setEmailResponsableSociete(profilAgence.getEmailResponsableSociete());
			
			profilAgenceViewModel.setAdresseId(profilAgence.getAdresse().getId());
			profilAgenceViewModel.setNumero(profilAgence.getAdresse().getNumero());
			profilAgenceViewModel.setPays(profilAgence.getAdresse().getPays());
			
			profilAgenceViewModel.setNomResponsableSociete(profilAgence.getNomResponsableSociete());
			profilAgenceViewModel.setPrenomResponsableSociete(profilAgence.getPrenomResponsableSociete());
			profilAgenceViewModel.setSiretSociete(profilAgence.getSiretSociete());
			
			profilAgenceViewModel.setTelephoneResponsableSociete(profilAgence.getTelephoneResponsableSociete());
			profilAgenceViewModel.setVille(profilAgence.getAdresse().getVille());
			profilAgenceViewModel.setVoie(profilAgence.getAdresse().getVoie());
			
			
			System.out.println(profilAgence.toString());
			System.out.println(profilAgenceViewModel.toString());
		}

		public String modifierProfilA() {
			
		profilAgenceService.modifyProfilAgence(profilAgenceViewModel);
//			profilList = rU.findAll();
//			resetViewModel();

			return "/login/authentification.xhtml?faces-redirect=true";
		}
	
	
}
