package ensembles.app.entity;

import java.io.Serializable;
//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;


import javax.persistence.*;
//import java.util.Set;

//import javax.persistence.ManyToMany;

@Entity
@Table(name="Journey")
public class Journey implements Serializable  {
	
	
	    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String Description;
	private String Destination; 
	private Date DepartureDate; 
	private Date DestinationDate;
	private Conveyance conveyance;
	
	private Double price;
	

	    @ManyToOne
	    @JoinColumn(name="agency_id")   
	    private ProfilAgence profilAgence;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
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

	public ProfilAgence getProfilAgence() {
		return profilAgence;
	}
	public void setProfilAgence(ProfilAgence profilAgence) {
		this.profilAgence = profilAgence;
	}
	
	

}
