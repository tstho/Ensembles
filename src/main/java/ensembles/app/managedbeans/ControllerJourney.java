package ensembles.app.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import ensembles.app.entity.Conveyance;
import ensembles.app.entity.Journey;
import ensembles.app.repository.RepoJourney;
import ensembles.app.service.JourneyService;
import ensembles.app.viewmodels.JourneyViewModel;

@ManagedBean
@SessionScoped
public class ControllerJourney implements Serializable {

	private static final long serialVersionUID = 1L;

	// JourneyViewModel journeyViewModel = new JourneyViewModel();

	@Inject
	private JourneyViewModel journeyViewModel;
	@Inject
	private JourneyService journeyService;
	@Inject
	private RepoJourney repoJourney;

	private List<Journey> journeyList;

	@PostConstruct
	public void init() {
		journeyList = repoJourney.findAll();
		System.out.println(journeyList);
	}

	public RepoJourney getRepoJourney() {
		return repoJourney;
	}

	public void setRepoJourney(RepoJourney repoJourney) {
		this.repoJourney = repoJourney;
	}

	public String saveJourney() {
		journeyService.saveJourney(journeyViewModel);
		journeyList = repoJourney.findAll();
		resetViewModel();

		return "/Journey/displayAllJourney.xhtml?faces-redirect=true";
		

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

	public List<Conveyance> getConveyanceOptions() {
		List<Conveyance> options = new ArrayList<>();
		for (Conveyance conveyance : Conveyance.values()) {
			options.add(conveyance);
		}
		return options;
	}

	public String redirectToEdit(Long journeyId) {
		initModifierJourney(journeyId);
		return "/Journey/ModifierJourney.xhtml?faces-redirect=true";
	}
	
	public void initModifierJourney(Long journeyId) {
		Journey journey = repoJourney.findById(journeyId);
		journeyViewModel = new JourneyViewModel();
		journeyViewModel.setId(journey.getId());
		journeyViewModel.setDeparture(journey.getDeparture());
		journeyViewModel.setDestination(journey.getDestination());
		journeyViewModel.setDestinationDate(journey.getDestinationDate());
		journeyViewModel.setPrice(journey.getPrice());
		journeyViewModel.setConveyance(journey.getConveyance());
		journeyViewModel.setDepartureDate(journey.getDepartureDate());

		System.out.println(journey.toString());
		System.out.println(journeyViewModel.toString());
	}

	public String modifierJourney() {
		System.out.println("ID du voyage à modifier : " + journeyViewModel.getId());
		journeyService.modifierJourney(journeyViewModel);
		journeyList = repoJourney.findAll();
		resetViewModel();

		return "/Journey/displayAllJourney.xhtml?faces-redirect=true";
	}

//	public String redirectToDelete(Long journeyId) {
//		initSupprimerJourney(journeyId);
//		return "/Journey/SupprimerJourney.xhtml?faces-redirect=true";
//	}

//	public void initSupprimerJourney(Long journeyId) {
//
//		Journey journey = repoJourney.findById(journeyId);
//		journeyViewModel = new JourneyViewModel();
//		journeyViewModel.setId(journey.getId());
//		journeyViewModel.setDeparture(journey.getDeparture());
//		journeyViewModel.setDestination(journey.getDestination());
//		journeyViewModel.setDestinationDate(journey.getDestinationDate());
//		journeyViewModel.setPrice(journey.getPrice());
//		journeyViewModel.setConveyance(journey.getConveyance());
//		journeyViewModel.setDepartureDate(journey.getDepartureDate());
//
//		System.out.println(journey.toString());
//		System.out.println(journeyViewModel.toString());
//		
//		
//	}

//	private boolean showDeleteConfirmation = false;
//
//	public boolean isShowDeleteConfirmation() {
//	    return showDeleteConfirmation;
//	}
//
//	public void setShowDeleteConfirmation(boolean showDeleteConfirmation) {
//	    this.showDeleteConfirmation = showDeleteConfirmation;
//	}
//	
//	
//	public void prepareDeleteJourney() {
//	    
//	    showDeleteConfirmation = true;
//	}
//	
//	public void cancelDelete() {
//	    showDeleteConfirmation = false;
//	}
//	
	public void supprimerJourney(Long id) {
		System.out.println("ID du voyage à supprimer : " + journeyViewModel.getId());
	    journeyService.supprimerJourney(id);
	    journeyList = repoJourney.findAll();
	    resetViewModel();
	}

	
	
	
	
	public void resetViewModel() {
		journeyViewModel = new JourneyViewModel();
	}
	public JourneyViewModel getJourneyViewModel() {
		return journeyViewModel;
	}

	public void setJourneyViewModel(JourneyViewModel journeyViewModel) {
		this.journeyViewModel = journeyViewModel;
	}

}
