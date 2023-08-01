package ensembles.app.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import ensembles.app.service.PartenaireService;
import ensembles.app.service.UserService;
import ensembles.app.viewmodels.PartenaireViewModel;
import ensembles.app.viewmodels.UserViewModel;

@ManagedBean(name="controllerPartenaire")
@RequestScoped
public class ControllerPartenaire implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Inject
	private PartenaireViewModel partenaireViewModel;
	@Inject
	PartenaireService partenaireService;

	public String savePartenaire() {
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
