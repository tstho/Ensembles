package ensembles.app.viewmodels;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import ensembles.app.entity.ServiceType;

@ManagedBean
public class ServiceViewModel {
	

	private String name;

	private String place;
	
	private Date begin;
	
	private Date end;
	
	private ServiceType ServiceType ;
	
	private Double price; 
	
	private String Description; 

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

	public ServiceType getServiceType() {
		return ServiceType;
	}

	public void setServiceType(ServiceType serviceType) {
		ServiceType = serviceType;
	}
	
	

}
