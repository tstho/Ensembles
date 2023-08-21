package ensembles.app.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import ensembles.app.entity.ServiceType;
import ensembles.app.repository.RepoService;
import ensembles.app.service.ServiceService;
import ensembles.app.viewmodels.ServiceViewModel;

@ManagedBean
@RequestScoped
public class ControllerService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServiceViewModel serviceViewModel;
	@Inject
	private ServiceService serviceService;
	@Inject
	private RepoService repoService;
	// Possibilités de modifications en rapport avec le ControllerUser.java
	
	
	public String saveService() {
		serviceService.saveService(serviceViewModel.getName(), serviceViewModel.getPlace(),serviceViewModel.getStartDate(),serviceViewModel.getEndDate(),serviceViewModel.getServiceType(),serviceViewModel.getPrice(), serviceViewModel.getDescription());
		
		//reset le view model
		serviceViewModel = new ServiceViewModel();
		
		return "";
	}
	
	public List<ServiceType> getServiceTypeOptions(){
		List<ServiceType> options = new ArrayList<>();
		for (ServiceType type : ServiceType.values()) {
			options.add(type);
		}
		return options;
	}
	

	public ServiceViewModel getServiceViewModel() {
		return serviceViewModel;
	}

	public void setServiceViewModel(ServiceViewModel serviceViewModel) {
		this.serviceViewModel = serviceViewModel;
	}

	public ServiceService getServiceService() {
		return serviceService;
	}

	public void setServiceService(ServiceService serviceService) {
		this.serviceService = serviceService;
	}


	public RepoService getRepoService() {
		return repoService;
	}


	public void setRepoService(RepoService repoService) {
		this.repoService = repoService;
	}

	

}
