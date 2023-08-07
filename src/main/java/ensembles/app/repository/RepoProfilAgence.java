package ensembles.app.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ensembles.app.entity.ProfilAgence;
@Stateless
public class RepoProfilAgence {

	@PersistenceContext
	 private EntityManager entityManager;
	
	public void save(ProfilAgence profilAgence) {

		entityManager.persist(profilAgence);
		
	}

}
