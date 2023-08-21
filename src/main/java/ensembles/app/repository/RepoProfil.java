package ensembles.app.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ensembles.app.entity.Profil;

@Stateless
public abstract class RepoProfil {

	@PersistenceContext
    private EntityManager entityManager;

    public void save(Profil profil) {
        entityManager.persist(profil);
    }
}
	
	

