package ensembles.app.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ensembles.app.entity.Journey;
import ensembles.app.entity.Service;

@Stateless
public class RepoService {

	@PersistenceContext
	private EntityManager entityManager;

//	public RepoUser() {
//		
//		this.entityManager=HibernateUtil.createEntityManager();
//	}

	public Service saveService(Service service) {
		entityManager.persist(service);
		entityManager.flush();
		return service;

	}

	public List<Service> displayService() {

		String reqSelect = "SELECT * FROM Service";

		Query query = entityManager.createNativeQuery(reqSelect, Service.class);

		@SuppressWarnings("unchecked")

		List<Service> resultList = (List<Service>) query.getResultList();

		return resultList;

	}

	public List<Service> findAll() {

		String reqSelect = "SELECT s FROM Service s";

		return entityManager.createQuery(reqSelect, Service.class).getResultList();
	}

	public void update(Service service) {
		entityManager.merge(service);
		entityManager.flush();
		
	}
	
	public void delete(Service service) {
		entityManager.remove(service);
		entityManager.flush();
		
	}

	public Service findById(Long id) {
		return entityManager.find(Service.class, id);
	}

	public List<Service> findByPartenaireId(Long id) {
		String reqSelect = "SELECT s FROM Service s WHERE partenaire_id = :id";
		TypedQuery<Service> query = entityManager.createQuery(reqSelect, Service.class);
		query.setParameter("id", id);

		try {
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}