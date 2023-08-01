package ensembles.app.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ensembles.app.entity.User;
import ensembles.app.service.UserService;
import ensembles.app.viewmodels.UserViewModel;

@ManagedBean(name="controllerUser")
@RequestScoped
public class ControllerUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UserViewModel userViewModel;
	@Inject
	UserService userService;

	public String saveUser() {
		userService.saveUser(userViewModel.getEmail(), userViewModel.getPassword());
		
		//reset le view model
		userViewModel = new UserViewModel();
		
		return "index.xhtml?faces-redirect=true";
	}

	public UserViewModel getUserViewModel() {
		return userViewModel;
	}

	public void setUserViewModel(UserViewModel userViewModel) {
		this.userViewModel = userViewModel;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
}
