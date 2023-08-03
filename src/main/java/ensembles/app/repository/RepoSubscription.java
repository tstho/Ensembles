package ensembles.app.repository;


import javax.inject.Inject;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import ensembles.app.entity.Subscription;



@Stateless
public class RepoSubscription {
	
	
		@PersistenceContext(unitName = "EnsemblesBDD")
		 private EntityManager entityManager;
		
//		public RepoSubscription() {
//			
//			this.entityManager=HibernateUtil.createEntityManager();
//		}

		public Long saveSubscription(Subscription subscription) {
//			EntityTransaction tx = this.entityManager.getTransaction();
//			tx.begin();
			entityManager.persist(subscription);
//			entityManager.flush();
//			tx.commit();
//			entityManager.close();
//			HibernateUtil.closeEntityManagerFactory();
			return subscription.getId();
			

}
}