
package ensembles.app.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ensembles.app.entity.Journey;
import ensembles.app.entity.ProfilPartenaire;
import ensembles.app.entity.Service;
import ensembles.app.entity.ServiceType;
import ensembles.app.repository.RepoProfilPartenaire;
import ensembles.app.repository.RepoService;
import ensembles.app.service.ServiceService;
import ensembles.app.service.ProfilPartenaireService;
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
	@Inject
	private ProfilPartenaireService profilPartenaireService;

	private List<Service> serviceList;
	
	private Service currentService;

	@PostConstruct
	public void init() {
		serviceList = repoService.findAll();
	}

	/*
	 * Méthode pour récupérer le service en cours
	 */

	public Service getCurrentService() {

		currentService = (Service) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("currentService");

		return currentService;

	}
	/*
	 * Méthode d'enregistrement d'un service
	 */

	public String saveService(Long idUser) {

		ProfilPartenaire profilPartenaire = repoProfilPartenaire.findByUserId(idUser);

		serviceService.saveService(profilPartenaire, serviceViewModel);

		serviceList = serviceListByProfilPartenaire(profilPartenaire.getId());

		resetViewModel();

		return "/partners/displayAllService.xhtml?faces-redirect=true";
	}
	
	/*
	 * Méthode pour récupérer la liste des services du partenaire
	 */
	public List<Service> serviceListByProfilPartenaire(Long partnerId) {
		
		serviceList = repoService.findByPartnerId(partnerId);

		return serviceList;

	}

	public List<ServiceType> getServiceOptions() {
		List<ServiceType> options = new ArrayList<>();
		for (ServiceType serviceType : ServiceType.values()) {
			options.add(serviceType);
		}
		return options;
	}

	public String redirectToEdit(Long serviceId) {
		initModifierService(serviceId);

		return "/partners/modifyService.xhtml?faces-redirect=true";
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

		return "/partners/displayAllService.xhtml?faces-redirect=true";
	}

	public void supprimerService(Long id) {
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
