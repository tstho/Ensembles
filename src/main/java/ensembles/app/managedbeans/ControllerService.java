package ensembles.app.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import ensembles.app.entity.ProfilPartenaire;
import ensembles.app.entity.Service;
import ensembles.app.entity.ServiceType;
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

	/*
	 * Méthode pour récupérer la liste des types de services
	 */
	public List<ServiceType> getServiceOptions() {
		List<ServiceType> options = new ArrayList<>();
		for (ServiceType serviceType : ServiceType.values()) {
			options.add(serviceType);
		}
		return options;
	}

	/*
	 * Méthode pour enregistrer un nouveau service
	 */
	public String saveService(Long idUser) {
		
		System.out.println("Méthode save service : userID : " + idUser);
		System.out.println("service VM : ");
		System.out.println(serviceViewModel);

		ProfilPartenaire profilPartenaire = repoProfilPartenaire.findByUserId(idUser);

		serviceService.saveService(serviceViewModel, profilPartenaire);

		resetViewModel();

		return redirectToServiceList(idUser);
	}
	
	/*
	 * Méthode redirection vers listes de voyages
	 */

	public String redirectToServiceList(Long userId) {

		ProfilPartenaire profilPartenaire = repoProfilPartenaire.findByUserId(userId);
		
		serviceList = serviceListByProfilPartenaire(profilPartenaire.getId());

		return "/partners/displayAllService.xhtml?faces-redirect=true";
	}
	
	/*
	 * Méthode pour récupérer la liste des voyages de l'agence 
	 */
	public List<Service> serviceListByProfilPartenaire(Long partenaireId) {
		
		serviceList = repoService.findByPartenaireId(partenaireId);

		return serviceList;

	}
	

	/*
	 * Méthode de redirection vers le formulaire de modification
	 */
	
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

	public String modifierService(Long userId) {
		serviceService.modifierService(serviceViewModel);

		resetViewModel();

		return redirectToServiceList(userId);
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