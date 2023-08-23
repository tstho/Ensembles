package ensembles.app.managedbeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ensembles.app.entity.Adresse;
import ensembles.app.entity.ProfilAgence;
import ensembles.app.entity.Role;
import ensembles.app.entity.User;
import ensembles.app.repository.RepoProfilAgence;
import ensembles.app.service.ProfilAgenceService;
import ensembles.app.service.UserService;
import ensembles.app.viewmodels.UserViewModel;

@ManagedBean
@SessionScoped
public class AuthBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private UserViewModel userVM = new UserViewModel();
	private User currentUser;

	@Inject
	private UserService userService;
	

	public String login() {

		currentUser = userService.authenticate(userVM.getEmail(), userVM.getPassword());

		if (currentUser != null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentUser", currentUser);
			
			return "/index.xhtml?faces-redirect=true"; // redirige vers la page d'acceuil
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Identifiant ou mot de passe incorrect."));
			return null;
		}
	}

	public String logout() {
		currentUser = null;

		// Mettre fin à la session et rediriger vers la page d'acceuil
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index.xhtml?faces-redirect=true";
	}
	
	public String redirectEspace() {
		if (currentUser.getRole()==Role.AGENCY) {
			return "/agency/adminAgency.xhtml?faces-redirect=true";
		}
		if (currentUser.getRole()==Role.PARTNER) {
			return "/partners/mainPartner.xhtml?faces-redirect=true";
		}
		if (currentUser.getRole()==Role.CLIENT) {
			return "/client/profilClient.xhtml?faces-redirect=true";
		}
		return "";
	}

	public String payTemplate() {
		if(isAuthenticated() && currentUser.getRole()==Role.AGENCY) {
			System.out.println("Agence");
			return "/Payement/Payement.xhtml?faces-redirect=true";
		}else {
			return "/login/inscription.xhtml?faces-redirect=true";
		}
	}
	
	public boolean isRole(Role role) {
		return currentUser != null && currentUser.getRole() == role;
	}

	public boolean isAuthenticated() {
		return currentUser != null;
	}

	public UserViewModel getUserVM() {
		return userVM;
	}

	public void setUserVM(UserViewModel userVM) {
		this.userVM = userVM;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
