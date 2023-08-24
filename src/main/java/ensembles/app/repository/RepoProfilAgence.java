package ensembles.app.repository;



import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import ensembles.app.entity.ProfilAgence;
import ensembles.app.entity.User;
import ensembles.app.entity.WebSite;


@Stateless
public class RepoProfilAgence {

	@PersistenceContext
	 private EntityManager entityManager;
	
	public Long save(ProfilAgence profilAgence) {

		entityManager.persist(profilAgence);
		entityManager.flush();
		
		System.out.println("profilAgence created :" + profilAgence.getId());
		
		return profilAgence.getId();
	}
	
	public List<ProfilAgence> displayProfilAgence() {

		String reqSelect = "SELECT * FROM ProfilAgence";

		Query query = entityManager.createNativeQuery(reqSelect, User.class);

		@SuppressWarnings("unchecked")

		List<ProfilAgence> resultList = (List<ProfilAgence>) query.getResultList();

		return resultList;

	}
	
	public List<ProfilAgence> findAll() {

		String reqSelect = "SELECT p FROM ProfilAgence p";

		return entityManager.createQuery(reqSelect, ProfilAgence.class).getResultList();
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
