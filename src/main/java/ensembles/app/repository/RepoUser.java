package ensembles.app.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import ensembles.app.entity.User;
import ensembles.app.utils.HibernateUtil;

@Stateless
public class RepoUser  {
	
	
	 private EntityManager entityManager;
	
	public RepoUser() {
		
		this.entityManager=HibernateUtil.createEntityManager();
	}

	public String persister (User user) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		this.entityManager.persist(user);
		this.entityManager.flush();
		tx.commit();
		return user.getPassword();
		
	}
}
