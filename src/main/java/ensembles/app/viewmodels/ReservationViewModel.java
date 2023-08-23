package ensembles.app.viewmodels;

import java.util.Date;

import ensembles.app.entity.Conveyance;
import ensembles.app.entity.Journey;
import ensembles.app.entity.User;

public class ReservationViewModel {
	
	private Long Id; 
	
	private Long journeyId;
	
	private String Departure;
	private String Destination; 
	private Date DepartureDate; 
	private Date DestinationDate;
	private Conveyance conveyance;
	private Double price;
	
	private String email;
	
	
	
	
	
	public String getDeparture() {
		return Departure;
	}
	public void setDeparture(String departure) {
		Departure = departure;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public Date getDepartureDate() {
		return DepartureDate;
	}
	public void setDepartureDate(Date departureDate) {
		DepartureDate = departureDate;
	}
	public Date getDestinationDate() {
		return DestinationDate;
	}
	public void setDestinationDate(Date destinationDate) {
		DestinationDate = destinationDate;
	}
	public Conveyance getConveyance() {
		return conveyance;
	}
	public void setConveyance(Conveyance conveyance) {
		this.conveyance = conveyance;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getJourneyId() {
		return journeyId;
	}
	public void setJourneyId(Long journeyId) {
		this.journeyId = journeyId;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	
	
}
