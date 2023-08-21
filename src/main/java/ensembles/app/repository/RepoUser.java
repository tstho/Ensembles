package ensembles.app.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ensembles.app.entity.Journey;
import ensembles.app.entity.User;

@Stateless
public class RepoUser {

	@PersistenceContext
	private EntityManager entityManager;

	public RepoUser() {

		// this.entityManager=HibernateUtil.createEntityManager();
	}

	public Long saveUser(User user) {
//		EntityTransaction tx = this.entityManager.getTransaction();
//		tx.begin();
		entityManager.persist(user);
		entityManager.flush();
//		tx.commit();
//		entityManager.close();
//		HibernateUtil.closeEntityManagerFactory();
		return user.getId();

	}

	public List<User> displayUser() {

		String reqSelect = "SELECT * FROM User";

		Query query = entityManager.createNativeQuery(reqSelect, User.class);

		@SuppressWarnings("unchecked")

		List<User> resultList = (List<User>) query.getResultList();

		return resultList;

	}

	public List<User> findAll() {

		String reqSelect = "SELECT u FROM User u";

		return entityManager.createQuery(reqSelect, User.class).getResultList();
	}

	public User authenticateUser(String email, String password) {
		TypedQuery<User> query = entityManager
				.createQuery("SELECT u FROM User u WHERE u.email = :email AND u.password = :password", User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	// methode Modifier
	
	  public void update(User user) {
	        entityManager.merge(user);
	        entityManager.flush();
	    }
     
	  // methode Supprimer
	  
	  public void delete(User user) {
	        entityManager.remove(user);
	        entityManager.flush();
	  }
	  
	  
	    public EntityManager getEntityManager() {
		return entityManager;
	}



	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}



		public User findById(Long id) {
	        return entityManager.find(User.class, id);
	    }	
		

}
