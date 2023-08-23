package ensembles.app.service;

import ensembles.app.entity.Journey;
import ensembles.app.entity.ProfilAgence;
import ensembles.app.entity.Reservation;
import ensembles.app.repository.RepoJourney;
import ensembles.app.repository.RepoReservation;
import ensembles.app.viewmodels.JourneyViewModel;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class JourneyService {

	@Inject
	private RepoJourney repoJourney;
	@Inject
	private RepoReservation repoReservation;
 
	    public void saveJourney(JourneyViewModel journeyViewModel, ProfilAgence profilAgence) {
	        Journey journey = new Journey();
	        journey.setDeparture(journeyViewModel.getDeparture());
	        journey.setDestination(journeyViewModel.getDestination());
	        journey.setDepartureDate(journeyViewModel.getDepartureDate());
	        journey.setDestinationDate(journeyViewModel.getDestinationDate());
	        journey.setPrice(journeyViewModel.getPrice());
	        journey.setConveyance(journeyViewModel.getConveyance());

	        journey.setProfilAgence(profilAgence);

		repoJourney.save(journey);
	}

	public void modifierJourney(JourneyViewModel journeyViewModel) {

		Journey journey = new Journey();
		journey.setDeparture(journeyViewModel.getDeparture());
		journey.setDestination(journeyViewModel.getDestination());
		journey.setDepartureDate(journeyViewModel.getDepartureDate());
		journey.setDestinationDate(journeyViewModel.getDestinationDate());
		journey.setPrice(journeyViewModel.getPrice());
		journey.setConveyance(journeyViewModel.getConveyance());
		journey.setId(journeyViewModel.getId());
		repoJourney.update(journey);

	}

	public void supprimerJourney(Long id) {
		
		deleteReservationsAssociated(id);
		
		Journey journey = repoJourney.findById(id);
		repoJourney.delete(journey);

	}

	public void deleteReservationsAssociated(Long id) {
		List<Reservation> reservations = repoReservation.getAllReservationsByJourneyId(id);
		
		for(Reservation reservation : reservations){
			repoReservation.delete(reservation);			
		}
	}

	public RepoJourney getRepoJourney() {
		return repoJourney;
	}

	public void setRepoJourney(RepoJourney repoJourney) {
		this.repoJourney = repoJourney;
	}
}
