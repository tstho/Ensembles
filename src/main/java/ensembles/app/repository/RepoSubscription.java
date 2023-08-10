package ensembles.app.repository;



import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



import ensembles.app.entity.Subscription;





@Stateless
public class RepoSubscription {
	
	
		@PersistenceContext
		 private EntityManager entityManager;
		

		public Long saveSubscription(Subscription subscription) {
//			EntityTransaction tx = this.entityManager.getTransaction();
//			tx.begin();
			entityManager.persist(subscription);
			entityManager.flush();
//			tx.commit();
//			entityManager.close();
//			HibernateUtil.closeEntityManagerFactory();
			return subscription.getId();
			
		}			
			
		 public List<Subscription> displaySubscriptions() {
		        String reqSelect = "SELECT * FROM Subscription";
		        Query query = entityManager.createNativeQuery(reqSelect, Subscription.class);

		        @SuppressWarnings("unchecked")
		        List<Subscription> resultList = (List<Subscription>) query.getResultList();

		        return resultList;
		    }

		    public List<Subscription> findAll() {
		        String reqSelect = "SELECT s FROM Subscription s";
		        return entityManager.createQuery(reqSelect, Subscription.class).getResultList();
		    }
		}
			
			
					
				
