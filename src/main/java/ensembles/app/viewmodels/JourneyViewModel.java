package ensembles.app.viewmodels;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import ensembles.app.entity.Conveyance;
import ensembles.app.entity.ProfilAgence;

@ManagedBean
public class JourneyViewModel {

	private Long Id;
	private String destination;
	private Date departureDate;
	private Date destinationDate;
	private Double price;
	private Conveyance conveyance;
	private String description;
	private ProfilAgence profilAgence;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProfilAgence getProfilAgence() {
		return profilAgence;
	}
	public void setProfilAgence(ProfilAgence profilAgence) {
		this.profilAgence = profilAgence;
	}

	
	
}
