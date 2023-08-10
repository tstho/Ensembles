package ensembles.app.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ensembles.app.entity.User;
import ensembles.app.service.UserService;
import ensembles.app.viewmodels.UserViewModel;

@ManagedBean
@RequestScoped
public class AuthBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private UserViewModel userVM = new UserViewModel();
	private User currentUser;

	@Inject
	private UserService userService;

	public void login() {

		currentUser = userService.authenticate(userVM.getEmail(), userVM.getPassword());

//		if (currentUser != null) {
//			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentUser", currentUser);
//			return "index?faces-redirect=true"; // redirige vers la page d'acceuil
//		}else {
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Identifiant ou mot de passe incorrect."));
//			return null;
//		}
		System.out.println(currentUser.getEmail());
		System.out.println(currentUser.getPassword());
	}

	public String logout() {
		currentUser = null;

		// Mettre fin à la session et rediriger vers la page d'acceuil
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index?faces-redirect=true";
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