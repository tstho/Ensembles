package ensembles.app.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import ensembles.app.entity.Reservation;


@Stateless
public class RepoReservation {
	
	
	@PersistenceContext
	 private EntityManager entityManager;

	 public void save(Reservation reservation) {
	        entityManager.persist(reservation);
			entityManager.flush();
		
	    }
	 
	 public List<Reservation> displayAllJourney() {
			
			String reqSelect="SELECT * FROM Reservation";
			

			Query query= entityManager.createNativeQuery(reqSelect, Reservation.class);
			
			
			@SuppressWarnings("unchecked")
			
			List<Reservation> resultList = (List<Reservation>)query.getResultList();
			
			return resultList;
			
		}

	public List<Reservation> findAll() {
		
		String reqSelect="SELECT r FROM Reservation r";
		
		
		return entityManager.createQuery(reqSelect, Reservation.class).getResultList();
	}

}
