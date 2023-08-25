package ensembles.app.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import ensembles.app.entity.Conveyance;
import ensembles.app.entity.Journey;
import ensembles.app.entity.ProfilAgence;
import ensembles.app.entity.Reservation;
import ensembles.app.repository.RepoJourney;
import ensembles.app.repository.RepoProfilAgence;
import ensembles.app.repository.RepoReservation;
import ensembles.app.service.JourneyService;
import ensembles.app.service.ReservationService;
import ensembles.app.viewmodels.JourneyViewModel;

@ManagedBean
@SessionScoped
public class ControllerJourney implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private JourneyViewModel journeyViewModel;
	@Inject
	private JourneyService journeyService;
	@Inject
	private RepoJourney repoJourney;
	@Inject
	private RepoProfilAgence repoProfilAgence;

	private List<Journey> journeyList;

	private Journey currentJourney;
	
	@PostConstruct
	


	/*
	 * Méthode d'enregistrement d'un voyage
	 */

	public String saveJourney(Long userId) {

		ProfilAgence profilAgence = repoProfilAgence.findByUserId(userId);
		
		journeyService.saveJourney(profilAgence, journeyViewModel);
		
		journeyList = repoJourney.findByAgenceId(profilAgence.getId());

		return "/Journey/displayAllJourney.xhtml?faces-redirect=true";
	}

	/*
	 * Méthode pour récupérer le voyage en cours
	 */

	public Journey getCurrentJourney() {

		currentJourney = (Journey) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("currentJourney");

		return currentJourney;

	}

	/*
	 * Méthode pour récupérer la liste des modes de transport
	 */
	public List<Conveyance> getConveyanceOptions() {
		List<Conveyance> options = new ArrayList<>();
		for (Conveyance conveyance : Conveyance.values()) {
			options.add(conveyance);
		}
		return options;
	}

	/*
	 * Méthode de redirection vers le formulaire de modification
	 */
	public String redirectToEdit(Long journeyId) {
		initModifierJourney(journeyId);
		return "/Journey/ModifierJourney.xhtml?faces-redirect=true";
	}

	/*
	 * Méthode d'initialisation du formulaire de modification
	 */

	public void initModifierJourney(Long journeyId) {
		
		Journey journey = repoJourney.findById(journeyId);
		
		journeyViewModel = new JourneyViewModel();
		// initialisation des champs du viewModel
		journeyViewModel.setId(journey.getId());
		journeyViewModel.setDescription(journey.getDescription());
		journeyViewModel.setDestination(journey.getDestination());
		journeyViewModel.setDestinationDate(journey.getDestinationDate());
		journeyViewModel.setPrice(journey.getPrice());
		journeyViewModel.setConveyance(journey.getConveyance());
		journeyViewModel.setDepartureDate(journey.getDepartureDate());
		journeyViewModel.setProfilAgence(journey.getProfilAgence());

		System.out.println(journey.toString());
		System.out.println(journeyViewModel.toString());
	}

	/*
	 * Méthode de modification d'un voyage
	 */

	public String modifierJourney() {
		journeyService.modifierJourney(journeyViewModel);
		resetViewModel();
		
		journeyList = journeyListByProfilAgence(journeyViewModel.getProfilAgence().getId());
//

		return "/Journey/displayAllJourney.xhtml?faces-redirect=true";
	}

	/*
	 * Méthode de suppression d'un voyage
	 */

	public void supprimerJourney(Long id) {
		journeyService.supprimerJourney(id);
		journeyList = repoJourney.findAll();
		resetViewModel();
	}
	/*
	 * Méthode pour récupérer la liste des voyages de l'agence 
	 */
	public List<Journey> journeyListByProfilAgence(Long agenceId) {
		
		journeyList = repoJourney.findByAgenceId(agenceId);

		return journeyList;

	}
	

	/*
	 * Méthode pour reset le view model
	 */
	public void resetViewModel() {
		journeyViewModel = new JourneyViewModel();
	}

	/*
	 * Getters & setters
	 */

	public JourneyViewModel getJourneyViewModel() {
		return journeyViewModel;
	}

	public void setJourneyViewModel(JourneyViewModel journeyViewModel) {
		this.journeyViewModel = journeyViewModel;
	}

	public RepoJourney getRepoJourney() {
		return repoJourney;
	}

	public void setRepoJourney(RepoJourney repoJourney) {
		this.repoJourney = repoJourney;
	}

	public JourneyService getJourneyService() {
		return journeyService;
	}

	public void setJourneyService(JourneyService journeyService) {
		this.journeyService = journeyService;
	}

	public List<Journey> getJourneyList() {
		return journeyList;
	}

	public void setJourneyList(List<Journey> journeyList) {
		this.journeyList = journeyList;
	}

	public RepoProfilAgence getRepoProfilAgence() {
		return repoProfilAgence;
	}

	public void setRepoProfilAgence(RepoProfilAgence repoProfilAgence) {
		this.repoProfilAgence = repoProfilAgence;
	}

	public void setCurrentJourney(Journey currentJourney) {
		this.currentJourney = currentJourney;
	}

}