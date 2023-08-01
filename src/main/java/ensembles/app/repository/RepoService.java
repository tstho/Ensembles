package ensembles.app.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ensembles.app.entity.Service;
public class RepoService {
	
	@PersistenceContext(unitName = "EnsemblesBDD")
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
