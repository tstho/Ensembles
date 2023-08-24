package ensembles.app.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import ensembles.app.entity.Journey;
import ensembles.app.entity.ProfilAgence;
import ensembles.app.entity.ProfilPartenaire;
import ensembles.app.entity.Service;
import ensembles.app.entity.ServiceType;
import ensembles.app.repository.RepoProfilAgence;
import ensembles.app.repository.RepoProfilPartenaire;
import ensembles.app.repository.RepoService;
import ensembles.app.service.ServiceService;
import ensembles.app.viewmodels.ServiceViewModel;

@ManagedBean
@SessionScoped
public class ControllerService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServiceViewModel serviceViewModel;
	@Inject
	private ServiceService serviceService;
	@Inject
	private RepoService repoService;
	@Inject
	private RepoProfilPartenaire repoProfilPartenaire;
	
	private List<Service> serviceList;
	
	@PostConstruct
	public void init() {
		serviceList = repoService.findAll();
	}

	public String saveService(Long idUser) {
		
		ProfilPartenaire profilPartenaire = repoProfilPartenaire.findByUserId(idUser);
		
		serviceService.saveService(serviceViewModel.getName(), serviceViewModel.getPlace(),serviceViewModel.getBegin(),serviceViewModel.getEnd(),serviceViewModel.getServiceType(),serviceViewModel.getPrice(), serviceViewModel.getDescription(),profilPartenaire);
		
		serviceList = repoService.findAll();
		
		
		//setServiceList(repoService.findAll());
		
		//reset le view model
		serviceViewModel = new ServiceViewModel();
		
		return "/ensembles/displayAllService.xhtml?faces-redirect=true";
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
		
		serviceViewModel.setId(service.getId());
		serviceViewModel.setName(service.getName());
		serviceViewModel.setBegin(service.getBegin());
		serviceViewModel.setEnd(service.getEnd());
		serviceViewModel.setServiceType(service.getServiceType());
		serviceViewModel.setPrice(service.getPrice());
		serviceViewModel.setPlace(service.getPlace());
		serviceViewModel.setDescription(service.getDescription());
		
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
	/*
	 * getters & setters
	 */
	
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
	public RepoProfilPartenaire getRepoProfilPartenaire() {
		return repoProfilPartenaire;
	}

	public void setRepoProfilPartenaire(RepoProfilPartenaire repoProfilPartenaire) {
		this.repoProfilPartenaire = repoProfilPartenaire;
	}

	public List<Service> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<Service> serviceList) {
		this.serviceList = serviceList;
	}

	
}
