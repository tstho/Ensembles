package ensembles.app.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ensembles.app.entity.Role;
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
	
	public List<Role> getRole() {
		List<Role> userType = new ArrayList<>();
		for (Role role : Role.values()) {
			userType.add(role);
			}
		return userType;
		}


	
}
