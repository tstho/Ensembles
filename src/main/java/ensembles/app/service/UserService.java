package ensembles.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ensembles.app.entity.User;
import ensembles.app.repository.RepoUser;

@Stateless
public class UserService {
	
	@Inject
	private RepoUser repoUser;
	@Inject
	private User user;

	public void saveUser(String email, String password) {
	
		user = new User();
		user.setEmail(email);
		user.setPassword(password);
		repoUser.saveUser(user);
		
		
	}

	public RepoUser getRepoUser() {
		return repoUser;
	}

	public void setRepoUser(RepoUser repoUser) {
		this.repoUser = repoUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
