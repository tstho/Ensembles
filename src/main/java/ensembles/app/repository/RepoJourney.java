package ensembles.app.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ensembles.app.entity.Journey;

@Stateless
public class RepoJourney {

	@PersistenceContext
	private EntityManager entityManager;

	public Journey save(Journey journey) {
		entityManager.persist(journey);
		entityManager.flush();
		System.out.println("Réservation dans repo après save :" + journey.toString());
		return journey;
	}

	public List<Journey> displayJourney() {

		String reqSelect = "SELECT * FROM Journey";

		Query query = entityManager.createNativeQuery(reqSelect, Journey.class);

		@SuppressWarnings("unchecked")

		List<Journey> resultList = (List<Journey>) query.getResultList();

		return resultList;

	}

	public List<Journey> findAll() {

		String reqSelect = "SELECT j FROM Journey j";

		return entityManager.createQuery(reqSelect, Journey.class).getResultList();

	}

	public Journey findById(Long id) {
		return entityManager.find(Journey.class, id);
	}

	public List<Journey> findByAgenceId(Long id) {
		String reqSelect = "SELECT j FROM Journey j WHERE agency_id = :id";
		TypedQuery<Journey> query = entityManager.createQuery(reqSelect, Journey.class);
		query.setParameter("id", id);

		try {
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// methode Modifier

	public void update(Journey journey) {
		entityManager.merge(journey);
		entityManager.flush();
	}

	// methode Supprimer

	public void delete(Journey journey) {
		entityManager.remove(journey);
		entityManager.flush();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
