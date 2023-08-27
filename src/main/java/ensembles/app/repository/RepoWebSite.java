package ensembles.app.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ensembles.app.entity.WebSite;

@Stateless
public class RepoWebSite {

	@PersistenceContext
	 private EntityManager entityManager;
	

	public Long saveWebSite(WebSite webSite) {
		
		entityManager.persist(webSite);
		entityManager.flush();
		
		return webSite.getId();
		
	}


	public WebSite findById(Long id) {
		return entityManager.find(WebSite.class, id);
	}


	public void update(WebSite webSite) {
		entityManager.merge(webSite);
        entityManager.flush();
		
	}


	public WebSite getWebsiteByAgence(Long id) {

		TypedQuery<WebSite> query = entityManager
				.createQuery("SELECT wS FROM WebSite wS WHERE profilAgence_id = :id", WebSite.class);
		query.setParameter("id", id);
		

		try {
			return query.setMaxResults(1).getSingleResult();
					//query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	
	}


	public List<WebSite> findAll() {

			String reqSelect = "SELECT w FROM WebSite w";

			return entityManager.createQuery(reqSelect, WebSite.class).getResultList();

	}

}
