package ensembles.app.repository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import ensembles.app.entity.User;

@Stateless
public class RepoUser  {
	
	@PersistenceContext(unitName = "EnsemblesBDD")
	 private EntityManager entityManager;
	
//	public RepoUser() {
//		
//		this.entityManager=HibernateUtil.createEntityManager();
//	}

	public Long saveUser(User user) {
//		EntityTransaction tx = this.entityManager.getTransaction();
//		tx.begin();
		entityManager.persist(user);
//		entityManager.flush();
//		tx.commit();
//		entityManager.close();
//		HibernateUtil.closeEntityManagerFactory();
		return user.getId();
		
	}
	
	
}
