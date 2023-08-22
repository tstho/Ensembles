package ensembles.app.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ensembles.app.entity.ProfilAgence;
import ensembles.app.entity.ProfilPartenaire;

@Stateless
public class RepoProfilPartenaire {

	@PersistenceContext
	private EntityManager entityManager;

	public Long save(ProfilPartenaire profilPartenaire) {
		
		entityManager.persist(profilPartenaire);
		entityManager.flush();
		
		return profilPartenaire.getId();
	}
	// methode Modifier
	
	  public void update(ProfilPartenaire profilPartenaire) {
	        entityManager.merge(profilPartenaire);
	  }
	  
	  
	  public ProfilPartenaire findById(Long id) {
	        return entityManager.find(ProfilPartenaire.class, id);
	    }

	public ProfilPartenaire findByUserId(Long userId) {
		
		TypedQuery<ProfilPartenaire> query = entityManager
				.createQuery("SELECT pPa FROM ProfilPartenaire pPa WHERE pPa.user.id = :userId", ProfilPartenaire.class);
		query.setParameter("userId",userId);
		

		try {
			return query.setMaxResults(1).getSingleResult();
					//query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
}
}
