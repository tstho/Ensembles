package ensembles.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Journey")
public class Journey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String Departure;
	private String Destination; 
	
	
	private Date DepartureDate; 
	private Date DestinationDate;
	
	private Conveyance conveyance;
	
	
	
	private Double price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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

}
