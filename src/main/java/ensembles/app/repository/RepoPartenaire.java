package ensembles.app.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ensembles.app.entity.Partenaire;


@Stateless
public class RepoPartenaire {
	
	@PersistenceContext
	 private EntityManager entityManager;
	
//	public RepoUser() {
//		
//		this.entityManager=HibernateUtil.createEntityManager();
//	}

	public Long savePartenaire(Partenaire partenaire) {
//		EntityTransaction tx = this.entityManager.getTransaction();
//		tx.begin();
		entityManager.persist(partenaire);
//		entityManager.flush();
//		tx.commit();
//		entityManager.close();
//		HibernateUtil.closeEntityManagerFactory();
		return partenaire.getId();
		

}

}
