package ensembles.app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ensembles.app.entity.User;

@Stateless
public class RepoUser  {
	
	@PersistenceContext
	 private EntityManager entityManager;
	
	public RepoUser() {
		
		//this.entityManager=HibernateUtil.createEntityManager();
	}
 //Ajout en BDD
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
	
	
	 //Affichage 
	
	public List<User> findAll() {
		
		String reqSelect="SELECT u FROM User u";
		
		
		return entityManager.createQuery(reqSelect, User.class).getResultList();
	}
	
	//Suppression
	
	public void deleteUser(User user) {
		
        
        entityManager.remove(user);
		
        
       	
	}
	
	
	//update
}
