package ensembles.app.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;


import javax.persistence.PersistenceContext;

import ensembles.app.entity.Service;

@Stateless
public class RepoService {
	
	@PersistenceContext
	 private EntityManager entityManager;
	
//	public RepoUser() {
//		
//		this.entityManager=HibernateUtil.createEntityManager();
//	}

	public Long saveService(Service service) {
//		EntityTransaction tx = this.entityManager.getTransaction();
//		tx.begin();
		entityManager.persist(service);
//		entityManager.flush();
//		tx.commit();
//		entityManager.close();
//		HibernateUtil.closeEntityManagerFactory();
		return service.getId();
		

}
}
