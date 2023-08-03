package ensembles.app.repository;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}