package ensembles.app.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ensembles.app.entity.ProfilPartenaire;

@Stateless
public class RepoProfilPartenaire extends RepoProfil {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(ProfilPartenaire profilPartenaire) {
		
		entityManager.persist(profilPartenaire);
	}
}
