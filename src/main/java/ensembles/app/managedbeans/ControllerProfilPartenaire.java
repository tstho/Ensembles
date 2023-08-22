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
	
	// Modification du profil du partenaire 
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
				
				//infos du partenaire
				
				profilPartenaireViewModel.setNomPartenaire(profilPartenaire.getNomPartenaire());
				profilPartenaireViewModel.setEmailResponsablePartenaire(profilPartenaire.getEmailResponsablePartenaire());
				profilPartenaireViewModel.setNomResponsablePartenaire(profilPartenaire.getNomResponsablePartenaire());
				profilPartenaireViewModel.setPrenomResponsablePartenaire(profilPartenaire.getPrenomResponsablePartenaire());
				profilPartenaireViewModel.setSiretPartenaire(profilPartenaire.getSiretPartenaire());
				profilPartenaireViewModel.setTelephoneResponsablePartenaire(profilPartenaire.getTelephoneResponsablePartenaire());
				
				// infos de l'adresse du partenaire 
				
				profilPartenaireViewModel.setCodePostal(profilPartenaire.getAdresse().getCodePostal());
				
				profilPartenaireViewModel.setComplement(profilPartenaire.getAdresse().getComplement());
				
				profilPartenaireViewModel.setNumero(profilPartenaire.getAdresse().getNumero());
				profilPartenaireViewModel.setPays(profilPartenaire.getAdresse().getPays());
				profilPartenaireViewModel.setVille(profilPartenaire.getAdresse().getVille());
				
				profilPartenaireViewModel.setVoie(profilPartenaire.getAdresse().getVoie());
				
				
				
				
				System.out.println(profilPartenaire.toString());
				System.out.println(profilPartenaireViewModel.toString());
			}
			
			public String modifierProfilP() {
			
				profilPartenaireService.modifyProfilPartenaire(profilPartenaireViewModel);
//					profilList = rU.findAll();
//					resetViewModel();

					return "/login/authentification.xhtml?faces-redirect=true";
				}
}
