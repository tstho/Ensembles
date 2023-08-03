package ensembles.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ensembles.app.entity.User;
import ensembles.app.repository.RepoUser;

@Stateless
public class UserService {
	
	@Inject
	private RepoUser repoUser;
	

	public void saveUser(String email, String password) {
	
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		repoUser.saveUser(user);
		
		
	}


	
	
}
