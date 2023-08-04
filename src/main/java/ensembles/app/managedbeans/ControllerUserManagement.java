package ensembles.app.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ensembles.app.entity.User;
import ensembles.app.repository.RepoUser;

@ManagedBean
public class ControllerUserManagement {
	
	@Inject
	private RepoUser rU;
	
	private List<User> userList;
	
	
	@PostConstruct
	public void init() {
		
		userList = rU.findAll();
		System.out.println(userList);
	}
	
	public void deleteUser(User user) {
		
		rU.deleteUser(user);
		
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	} 

}
