package ensembles.app.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ensembles.app.entity.Reservation;


@Stateless
public class RepoReservation {
	
	
	@PersistenceContext
	 private EntityManager entityManager;

	 public Reservation save(Reservation reservation) {
	        entityManager.persist(reservation);
			entityManager.flush();
			
			System.out.println("Réservation dans repo après save :"+ reservation.toString());//
			
			return reservation;
		
	    }
	 
	 public List<Reservation> displayAllReservation() {
			
			String reqSelect="SELECT * FROM Reservation";
			

			Query query= entityManager.createNativeQuery(reqSelect, Reservation.class);
			
			
			@SuppressWarnings("unchecked")
			
			List<Reservation> resultList = (List<Reservation>)query.getResultList();
			
			return resultList;
			
		}
	 
	 public List<Reservation> getAllReservationsByUserId(Long id) {

			String reqSelect="SELECT r FROM Reservation r WHERE user_id = :id";
			TypedQuery<Reservation> query = entityManager.createQuery(reqSelect, Reservation.class);
			query.setParameter("id", id);
			
			try {
				return query.getResultList();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}

	public List<Reservation> findAll() {
		
		String reqSelect="SELECT r FROM Reservation r";
		
		
		return entityManager.createQuery(reqSelect, Reservation.class).getResultList();
	}

	public List<Reservation> getAllReservationsByJourneyId(Long id) {

		String reqSelect="SELECT r FROM Reservation r WHERE journey_id = :id";
		TypedQuery<Reservation> query = entityManager.createQuery(reqSelect, Reservation.class);
		query.setParameter("id", id);
		
		try {
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void delete(Reservation reservation) {
        entityManager.remove(reservation);
        entityManager.flush();
	}

}
