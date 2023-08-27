package ensembles.app.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ensembles.app.entity.ProfilClient;

@Stateless
public class RepoProfilClient {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Long save(ProfilClient profilClient) {
		
		entityManager.persist(profilClient);
		entityManager.flush();
		
		return profilClient.getId();
	}
	
	// methode Modifier
	
	  public void update(ProfilClient profilClient) {
	        entityManager.merge(profilClient);
			entityManager.flush();
	  }
	  
	  
	  public ProfilClient findById(Long id) {
	        return entityManager.find(ProfilClient.class, id);
	    }

	public ProfilClient findByUserId(Long userId) {
		
		TypedQuery<ProfilClient> query = entityManager
				.createQuery("SELECT pC FROM ProfilClient pC WHERE pC.user.id = :userId", ProfilClient.class);
		query.setParameter("userId",userId);
		

		try {
			return query.setMaxResults(1).getSingleResult();
					//query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	
	}	
	

}
