package ensembles.app.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ensembles.app.entity.ProfilClient;

@Stateless
public class RepoProfilClient {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(ProfilClient profilClient) {
		
		entityManager.persist(profilClient);
		entityManager.flush();
	}
	

}
