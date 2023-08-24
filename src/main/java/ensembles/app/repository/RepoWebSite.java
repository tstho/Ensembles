package ensembles.app.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ensembles.app.entity.User;
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
}
