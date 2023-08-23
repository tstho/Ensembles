package ensembles.app.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import ensembles.app.entity.ProfilAgence;
import ensembles.app.entity.Role;
import ensembles.app.entity.SubscriptionType;
import ensembles.app.entity.User;
import ensembles.app.repository.RepoUser;
import ensembles.app.service.ProfilAgenceService;
import ensembles.app.service.UserService;
import ensembles.app.viewmodels.UserViewModel;

@ManagedBean
@SessionScoped
public class ControllerUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserService userService;

	@Inject
	private UserViewModel userViewModel;

	@Inject
	private RepoUser rU;

	@Inject
	private ProfilAgenceService proAgenceService;

	private List<User> userList;

	@PostConstruct
	public void init() {

		userList = rU.findAll();
		System.out.println(userList);
	}

	/*
	 * Méthode appelé depuis la vue pour enregistrer un user
	 */

	/*
	 * Efface les champs du view model
	 */
	public void clearUserViewModel() {
		userViewModel = new UserViewModel();
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
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

	public String saveUser() {
		userService.saveUser(userViewModel);
		userList = rU.findAll();
		resetViewModel();

		return "/index.xhtml?faces-redirect=true";
	}

	// Modification utilisateur
	public String redirectToEdit(Long userId) {
		initModifierUser(userId);
		return "/user/ModifierUser.xhtml?faces-redirect=true";
	}

	public void initModifierUser(Long userId) {

		User user = rU.findById(userId);
		userViewModel = new UserViewModel();
		userViewModel.setId(userId);
		userViewModel.setEmail(user.getEmail());
		userViewModel.setRole(user.getRole());
		userViewModel.setPassword(user.getPassword());

		System.out.println(user.toString());
		System.out.println(userViewModel.toString());
	}

	public String modifierUser() {
		System.out.println("ID de l'utilisateur à modifier : " + userViewModel.getId());
		userService.modifyUser(userViewModel);
		userList = rU.findAll();
		resetViewModel();

		return "/user/displayAllUser.xhtml?faces-redirect=true";
	}

	// suppression utilisateur

	public void supprimerUser(Long id) {
		System.out.println("ID de l'utilisateur à supprimer : " + userViewModel.getId());
		userService.supprimerUser(id);
		userList = rU.findAll();
		resetViewModel();
	}

	public void resetViewModel() {
		userViewModel = new UserViewModel();
	}

}
