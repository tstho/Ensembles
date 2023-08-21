package ensembles.app.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ensembles.app.entity.Service;

@Stateless
public class RepoService {

	@PersistenceContext
	private EntityManager entityManager;

//	public RepoUser() {
//		
//		this.entityManager=HibernateUtil.createEntityManager();
//	}

	public Long saveService(Service service) {
//		EntityTransaction tx = this.entityManager.getTransaction();
//		tx.begin();
		entityManager.persist(service);
		entityManager.flush();
//		tx.commit();
//		entityManager.close();
//		HibernateUtil.closeEntityManagerFactory();
		return service.getId();

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
}
