package ensembles.app.entity;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private ServiceType ServiceType ;
	private Double price;
	private String Description;
	
	 @ManyToOne
	 @JoinColumn(name="partenaire_id")   
	 private ProfilPartenaire profilPartenaire;
	 
	 
  
	@Override
	public String toString() {
		return "Service [id=" + id + ", name=" + name + ", place=" + place + ", begin=" + begin + ", end=" + end
				+ ", ServiceType=" + ServiceType + ", price=" + price + ", Description=" + Description
				+ ", profilPartenaire=" + profilPartenaire + "]";
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPlace() {
		return place;
	}
	public Date getBegin() {
		return begin;
	}
	public Date getEnd() {
		return end;
	}
	public ServiceType getServiceType() {
		return ServiceType;
	}
	public Double getPrice() {
		return price;
	}
	public String getDescription() {
		return Description;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public void setServiceType(ServiceType serviceType) {
		ServiceType = serviceType;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public ProfilPartenaire getProfilPartenaire() {
		return profilPartenaire;
	}
	public void setProfilPartenaire(ProfilPartenaire profilPartenaire) {
		this.profilPartenaire = profilPartenaire;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
}

