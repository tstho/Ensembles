package ensembles.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ensembles.app.entity.Journey;
import ensembles.app.entity.Reservation;
import ensembles.app.entity.User;
import ensembles.app.repository.RepoJourney;
import ensembles.app.repository.RepoReservation;
import ensembles.app.repository.RepoUser;
import ensembles.app.viewmodels.ReservationViewModel;

@Stateless
public class ReservationService {
	
	 @Inject
	  private RepoReservation repoReservation;
	 
	 @Inject
	  private RepoJourney repoJourney;
	 
	 @Inject
	  private RepoUser repoUser;
	 

	public RepoJourney getRepoJourney() {
		return repoJourney;
	}

	public void setRepoJourney(RepoJourney repoJourney) {
		this.repoJourney = repoJourney;
	}

	public RepoUser getRepoUser() {
		return repoUser;
	}

	public void setRepoUser(RepoUser repoUser) {
		this.repoUser = repoUser;
	}

	public RepoReservation getRepoReservation() {
		return repoReservation;
	}

	public void setRepoReservation(RepoReservation repoReservation) {
		this.repoReservation = repoReservation;
	}

	public Reservation saveReservation(Long journeyId, Long userId) { 
		
		Journey journey = repoJourney.findById(journeyId);
		
		User user = repoUser.findById(userId);
		
		Reservation reservation = new Reservation();
		
		reservation.setJourney(journey);
		reservation.setUser(user);// mettre "authBean.currentUser.id"?
		
		reservation = repoReservation.save(reservation);
		
		System.out.println("Réservation dans Service après save :"+ reservation);
		
		return reservation;
		
		
	}

}
