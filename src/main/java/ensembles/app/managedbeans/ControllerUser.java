package ensembles.app.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ensembles.app.service.UserService;
import ensembles.app.viewmodels.UserViewModel;

@ManagedBean
public class ControllerUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserService userService;

	private UserViewModel userViewModel = new UserViewModel();

	/*
	 * Méthode appelé depuis la vue pour enregistrer un user
	 */
	public String saveUser() {
		System.out.println(userViewModel.toString());
		userService.saveUser(userViewModel);
		
		//reset le view model
	//	clearUserViewModel();
		//redirection vers l'index
		return "index.xhtml?faces-redirect=true";
	}

	/*
	 * Efface les champs du view model
	 */
	public void clearUserViewModel() {
		userViewModel = new UserViewModel();
	}

	/*
	 * getters & setters
	 */
	public UserViewModel getUserViewModel() {
		return userViewModel;
	}

	public void setUserViewModel(UserViewModel userViewModel) {
		this.userViewModel = userViewModel;
	}


	
}
