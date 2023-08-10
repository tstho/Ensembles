package ensembles.app.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ensembles.app.entity.Adresse;

@Stateless
public class RepoAdresse {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Adresse adresse) {
		entityManager.persist(adresse);
	}

}
