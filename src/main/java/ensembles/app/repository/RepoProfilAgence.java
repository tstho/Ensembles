package ensembles.app.repository;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import ensembles.app.entity.ProfilAgence;


@Stateless
public class RepoProfilAgence {

	@PersistenceContext
	 private EntityManager entityManager;
	
	public Long save(ProfilAgence profilAgence) {

		entityManager.persist(profilAgence);
		entityManager.flush();
		
		return profilAgence.getId();
	}
	
	// methode Modifier
	
		  public void update(ProfilAgence profilAgence) {
		        entityManager.merge(profilAgence);
		  }
		  
		  
		  public ProfilAgence findById(Long id) {
		        return entityManager.find(ProfilAgence.class, id);
		    }

		public ProfilAgence findByUserId(Long userId) {
			
			TypedQuery<ProfilAgence> query = entityManager
					.createQuery("SELECT pA FROM ProfilAgence pA WHERE pA.user.id = :userId", ProfilAgence.class);
			query.setParameter("userId",userId);
			

			try {
				return query.setMaxResults(1).getSingleResult();
						//query.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
		
		}	

}
