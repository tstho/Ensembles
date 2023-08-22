package ensembles.app.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import ensembles.app.entity.Service;
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
	
	private List<Service> serviceList;
	
	@PostConstruct
	public void init() {
		serviceList = repoService.findAll();
		System.out.println(serviceList);
	}
	
	public RepoService getRepoService() {
		return repoService;
	}

	public void setRepoService(RepoService repoService) {
		this.repoService = repoService;
	}
	
	public String saveService() {
		serviceService.saveService(serviceViewModel);
		serviceList = repoService.findAll();
		resetViewModel();		
		return "/ensembles/displayAllService.xhtml?faces-redirect=true";
			
	}
	
	public List<Service> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<Service> serviceList) {
		this.serviceList = serviceList;
	}

	public List<ServiceType> getServiceTypeOptions(){
		List<ServiceType> options = new ArrayList<>();
		for (ServiceType type : ServiceType.values()) {
			options.add(type);
		}
		return options;
	}

	public String redirectToEdit(Long serviceId) {
		initModifierService(serviceId);
		return "/ensembles/modifyService.xhtml?faces-redirect=true";
	}

	private void initModifierService(Long serviceId) {
		Service service = repoService.findById(serviceId);
		serviceViewModel = new ServiceViewModel();
		serviceViewModel.setId(service.getId());
		serviceViewModel.setName(service.getName());
		serviceViewModel.setBegin(service.getBegin());
		serviceViewModel.setEnd(service.getEnd());
		serviceViewModel.setServiceType(service.getServiceType());
		serviceViewModel.setPrice(service.getPrice());
		serviceViewModel.setPlace(service.getPlace());
		serviceViewModel.setDescription(service.getDescription());
		
		System.out.println(service.toString());
		System.out.println(serviceViewModel.toString());
		
	}
	
	public String modifierService() {
		System.out.println("ID du service à modifier : " + serviceViewModel.getId());
		serviceService.modifierService(serviceViewModel);
		serviceList = repoService.findAll();
		resetViewModel();
		
		return "/ensembles/displayAllService.xhtml?faces-redirect=true";
	}
	
	public void supprimerService (Long id) {
		System.out.println("ID du voyage à supprimer : " + serviceViewModel.getId());
		serviceService.supprimerService(id);
		serviceList = repoService.findAll();
		
	}
	
	public void resetViewModel() {
		serviceViewModel = new ServiceViewModel();
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
