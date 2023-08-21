package ensembles.app.service;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ensembles.app.entity.Service;
import ensembles.app.entity.ServiceType;
import ensembles.app.repository.RepoService;

@Stateless
public class ServiceService {
	
	@Inject
	private RepoService repoService;
	@Inject
	private Service service;
	
	public void saveService(String name,String place,Date begin, Date end, ServiceType ServiceType, Double price, String Description) {
		
		service = new Service();
		service.setName(name);
		service.setPlace(place);
		service.setBegin(begin);
		service.setEnd(end);
		service.setServiceType(ServiceType);
		service.setPrice(price);
		service.setDescription(Description);
		repoService.saveService(service);
		
		
	}

	public RepoService getRepoService() {
		return repoService;
	}

	public void setRepoService(RepoService repoService) {
		this.repoService = repoService;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

}
