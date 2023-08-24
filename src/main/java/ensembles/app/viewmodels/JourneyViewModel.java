package ensembles.app.viewmodels;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import ensembles.app.entity.Conveyance;
import ensembles.app.entity.Service;


@ManagedBean
public class JourneyViewModel {
	
	    private Long Id;
	    private String destination;
	    private Date departureDate;
	    private Date destinationDate;
	    private Double price;
	    private Conveyance conveyance;
	    private String description;
	    private List<Service> services; 
       
	    
	    @Override
		public String toString() {
			return "JourneyViewModel [Id=" + Id + ", description=" + description + ", destination=" + destination
					+ ", departureDate=" + departureDate + ", destinationDate=" + destinationDate + ", price=" + price
					+ ", conveyance=" + conveyance + ", services=" + services + ", selectedServices=" + selectedServices
					+ "]";
		}

		public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getDestination() {
	        return destination;
	    }

	    public void setDestination(String destination) {
	        this.destination = destination;
	    }

	    public Date getDepartureDate() {
	        return departureDate;
	    }

	    public void setDepartureDate(Date departureDate) {
	        this.departureDate = departureDate;
	    }

	    public Date getDestinationDate() {
	        return destinationDate;
	    }

	    public void setDestinationDate(Date destinationDate) {
	        this.destinationDate = destinationDate;
	    }

	    private List<Service> selectedServices;

	    public List<Service> getSelectedServices() {
	        return selectedServices;
	    }

	    public void setSelectedServices(List<Service> selectedServices) {
	        this.selectedServices = selectedServices;
	    }

		public List<Service> getServices() {
			return services;
		}

		public void setServices(List<Service> services) {
			this.services = services;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Conveyance getConveyance() {
			return conveyance;
		}

		public void setConveyance(Conveyance conveyance) {
			this.conveyance = conveyance;
		}

		public long getId() {
			return Id;
		}

		public void setId(long id) {
			Id = id;
		}

		
		}
	



