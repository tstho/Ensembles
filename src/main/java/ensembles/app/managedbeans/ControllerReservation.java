package ensembles.app.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ensembles.app.entity.Reservation;

import ensembles.app.repository.RepoReservation;

import ensembles.app.service.ReservationService;

import ensembles.app.viewmodels.ReservationViewModel;

@ManagedBean
@RequestScoped
public class ControllerReservation implements Serializable {

	private static final long serialVersionUID = 1L;

	private ReservationViewModel reservationViewModel;

	@Inject
	private ReservationService reservationService;
	@Inject
	private RepoReservation repoReservation;

	private Reservation currentReservation;

	private List<Reservation> reservationList;

	/*
	 * Méthode de création d'une réservation
	 */

	public String saveReservation(Long journeyId, Long userId) {

		currentReservation = reservationService.saveReservation(journeyId, userId);

		// ici on récupère la session pour y mettre la réservation courante

		// TODO faire le point sur cette méthode et remettre au propre

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentReservation",
				currentReservation);
		// reservationList = repoReservation.findAll();
		// resetViewModel();

		return "/reservation/confirmationReservation.xhtml?faces-redirect=true";
	}
	
	/*
	 * Méthode pour récupérer la réservation en cours
	 */

	public Reservation getCurrentReservation() {

		currentReservation = (Reservation) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("currentReservation");

		return currentReservation;
	}

	/*
	 * Méthode pour reset le view model
	 */
	public void resetViewModel() {
		reservationViewModel = new ReservationViewModel();
	}

	/*
	 * gettes & setters
	 */

	public ReservationViewModel getReservationViewModel() {
		return reservationViewModel;
	}

	public void setReservationViewModel(ReservationViewModel reservationViewModel) {
		this.reservationViewModel = reservationViewModel;
	}

	public ReservationService getReservationService() {
		return reservationService;
	}

	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	public RepoReservation getRepoReservation() {
		return repoReservation;
	}

	public void setRepoReservation(RepoReservation repoReservation) {
		this.repoReservation = repoReservation;
	}

	public List<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}

}
