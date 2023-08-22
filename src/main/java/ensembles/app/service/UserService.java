package ensembles.app.service;


import javax.ejb.Stateless;
import javax.inject.Inject;

import ensembles.app.entity.Journey;
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
		
		Long userId = repoUser.saveUser(user);
		
		user = repoUser.findById(userId);
		
		createProfil(user);
				
	}


	public void createProfil(User user) {
		if(user.getRole() == Role.AGENCY) {

			ProfilAgence pa = new ProfilAgence();
			pa.setUser(user);
			pa.setAdresse(new Adresse());
			repoProfilAgence.save(pa);
		}
		if(user.getRole() == Role.CLIENT) {

			ProfilClient pc = new ProfilClient();
			pc.setUser(user);
			pc.setAdresse(new Adresse());
			repoProfilClient.save(pc);
		}

		if(user.getRole() == Role.PARTNER) {

			ProfilPartenaire pp = new ProfilPartenaire();
			pp.setUser(user);
			pp.setAdresse(new Adresse());
			repoProfilPartenaire.save(pp);
		}
	}
	
	   public void supprimerUser(Long id) {
			 
   		User user= repoUser.findById(id);
           repoUser.delete(user);
           
      
   }
	public void modifyUser(UserViewModel userViewModel) {
		
		User user = new User();
		user.setId(userViewModel.getId());
		user.setEmail(userViewModel.getEmail());
		user.setPassword(userViewModel.getPassword());
		user.setRole(userViewModel.getRole());
		repoUser.update(user);
		
		
		
	}



	public User authenticate(String email, String password) {
		
		return repoUser.authenticateUser(email, password);
	}
	
}	

	

	
		
	
	
	
	

