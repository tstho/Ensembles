package ensembles.app.service;

import ensembles.app.entity.Journey;
import ensembles.app.repository.RepoJourney;
import ensembles.app.viewmodels.JourneyViewModel;
import javax.ejb.Stateless;
import javax.inject.Inject;


@Stateless
public class JourneyService {


	
	 
	    @Inject
	  private RepoJourney repoJourney;

	    public void saveJourney(JourneyViewModel journeyViewModel) {
	        Journey journey = new Journey();
	        journey.setDeparture(journeyViewModel.getDeparture());
	        journey.setDestination(journeyViewModel.getDestination());
	        journey.setDepartureDate(journeyViewModel.getDepartureDate());
	        journey.setDestinationDate(journeyViewModel.getDestinationDate());
	        journey.setPrice(journeyViewModel.getPrice());
	        journey.setConveyance(journeyViewModel.getConveyance());

			
//	   List<Service> selectedServices = journeyViewModel.getSelectedServices();
//	        if (selectedServices != null && !selectedServices.isEmpty()) {
//	            journey.setServices(selectedServices);
//	        }

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
	 
	    		Journey journey = repoJourney.findById(id);
	            repoJourney.delete(journey);
	            
	       
	    }




		public RepoJourney getRepoJourney() {
			return repoJourney;
		}



		public void setRepoJourney(RepoJourney repoJourney) {
			this.repoJourney = repoJourney;
		}
	    }
	    
	

	

