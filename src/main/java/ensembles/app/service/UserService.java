package ensembles.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ensembles.app.entity.User;
import ensembles.app.repository.RepoUser;
import ensembles.app.viewmodels.UserViewModel;

@Stateless
public class UserService {
	
	@Inject
	private RepoUser repoUser;
	

	public void saveUser(UserViewModel userViewModel) {
	
		User user = new User();
		user.setEmail(userViewModel.getEmail());
		user.setPassword(userViewModel.getPassword());
		user.setRole(userViewModel.getRole());
		repoUser.saveUser(user);
		
		System.out.println(userViewModel.getRole());
		
	}

	
	
}
