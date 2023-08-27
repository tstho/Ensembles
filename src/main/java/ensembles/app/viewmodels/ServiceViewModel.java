package ensembles.app.viewmodels;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import ensembles.app.entity.ProfilAgence;
import ensembles.app.entity.ProfilPartenaire;
import ensembles.app.entity.ServiceType;

@ManagedBean
public class ServiceViewModel {
	
	private ServiceType serviceType;
	
	private Long Id;
	private String name;
	private Date begin;
	private Date end;	
	private String place;	
	private Double price; 
	private String Description;
	private ProfilPartenaire profilPartenaire;
	
	/**
	 * @return the profilPartenaire
	 */
	public ProfilPartenaire getProfilPartenaire() {
		return profilPartenaire;
	}

	/**
	 * @param profilPartenaire the profilPartenaire to set
	 */
	public void setProfilPartenaire(ProfilPartenaire profilPartenaire) {
		this.profilPartenaire = profilPartenaire;
	}

	@Override
	public String toString() {
		return "ServiceViewModel [serviceType=" + serviceType + ", Id=" + Id + ", name=" + name + ", begin="
				+ begin + ", end=" + end + ", place=" + place + ", price=" + price + ", Description="
				+ Description + "]";
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public String getName() {
		return name;
	}

	public Date getBegin() {
		return begin;
	}

	public Date getEnd() {
		return end;
	}

	public String getPlace() {
		return place;
	}

	public Double getPrice() {
		return price;
	}

	public String getDescription() {
		return Description;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setDescription(String description) {
		Description = description;
	} 

	
	
	
}

