package ensembles.app.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ensembles.app.entity.Journey;
import ensembles.app.service.JourneyService;
import ensembles.app.viewmodels.JourneyViewModel;

@ManagedBean
public class ControllerJourney implements Serializable {

	private static final long serialVersionUID = 1L;
	
	JourneyViewModel journeyViewModel = new JourneyViewModel();
	
	    @Inject
	    private JourneyService journeyService; 

	    

	    public void saveJourney() {
	        Journey journey = journeyViewModel.getJourney();
	        journeyService.saveJourney(journey);
	    }

	    public void modifyJourney(Long journeyId) {
	        Journey journey = journeyViewModel.getJourney();
	        Journey existingJourney = journeyService.getJourneyById(journeyId);
	        if (existingJourney != null) {
	            existingJourney.setDeparture(journey.getDeparture());
	            existingJourney.setDestination(journey.getDestination());
	            
	            journeyService.saveJourney(existingJourney); 
	        }
	    }

	    public void deleteJourney(Long journeyId) {
	        journeyService.deleteJourney(journeyId);
	    }

	    public void loadJourneyForModify(Long journeyId) {
	        Journey existingJourney = journeyService.getJourneyById(journeyId);
	        journeyViewModel.setJourney(existingJourney);
	    }

	    public List<Journey> getAllJourneys() {
	        return journeyService.getAllJourneys();
	    }

	    public JourneyViewModel getJourneyViewModel() {
	        return journeyViewModel;
	    }

	    // ... Autres méthodes ...
	}

	
}
