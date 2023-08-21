package ensembles.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Service")
public class Service {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String place;
	
	private Date begin;
	
	private Date end;
	
	@Enumerated(EnumType.STRING)
	private ServiceType ServiceType ;
	
	private Double price;
	
	private String Description;
//
//	@ManyToMany(mappedBy = "services")
//	    private List<Journey> journeys = new ArrayList<>();
//	
//	public List<Journey> getJourneys() {
//		return journeys;
//	}
//
//	public void setJourneys(List<Journey> journeys) {
//		this.journeys = journeys;
//	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double prix) {
		price = prix;
	}
	public String getName() {
		return name;
	}
	public void setName(String nom) {
		name = nom;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String lieu) {
		place = lieu;
	}
	public ServiceType getServiceType() {
		return ServiceType;
	}
	public void setServiceType(ServiceType serviceType) {
		ServiceType = serviceType;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date debut) {
		begin = debut;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date fin) {
		end = fin;
	}
}
