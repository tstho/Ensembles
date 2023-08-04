package ensembles.app.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import ensembles.app.service.ServiceService;
import ensembles.app.viewmodels.ServiceViewModel;

@ManagedBean(name="controllerService")
@RequestScoped
public class ControllerService implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Inject
	private ServiceViewModel serviceViewModel;
	@Inject
	ServiceService serviceService;

	public String saveService() {
		serviceService.saveService(serviceViewModel.getName(), serviceViewModel.getPlace(),serviceViewModel.getBegin(),serviceViewModel.getEnd(),serviceViewModel.getServiceType(),serviceViewModel.getPrice(), serviceViewModel.getDescription());
		
		//reset le view model
		serviceViewModel = new ServiceViewModel();
		
		return "";
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

	

}
