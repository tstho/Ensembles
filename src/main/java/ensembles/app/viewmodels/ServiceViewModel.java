package ensembles.app.viewmodels;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import ensembles.app.entity.ServiceType;

@ManagedBean
public class ServiceViewModel {
	
	private ServiceType serviceType;
	
	private String name;

	private Date startDate;
	
	private Date endDate;
	
	private String place;
	
	private Double price; 
	
	private String Description;

	public ServiceType getServiceType() {
		return serviceType;
	}

	public String getName() {
		return name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
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

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

