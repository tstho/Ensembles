package ensembles.app.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ensembles.app.entity.Adresse;
import ensembles.app.entity.ProfilAgence;

@Stateless
public class RepoAdresse {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Adresse adresse) {
		entityManager.persist(adresse);
		entityManager.flush();
	}

	public void update(Adresse adresse) {
		entityManager.merge(adresse);
		entityManager.flush();
	}
}
