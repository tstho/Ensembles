package ensembles.app.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ensembles.app.entity.Service;
import ensembles.app.repository.RepoService;

@ManagedBean
public class ControllerServiceManagement {
	
	@Inject
	private RepoService rS;

	private List<Service> serviceList;
	
	@PostConstruct
	public void init() {
		
		serviceList = rS.findAll();
		System.out.println(serviceList);
		
	}

	public List<Service> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<Service> serviceList) {
		this.serviceList = serviceList;
	}

}
