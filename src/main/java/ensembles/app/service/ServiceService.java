package ensembles.app.service;


import javax.ejb.Stateless;
import javax.inject.Inject;

import ensembles.app.entity.ProfilPartenaire;
import ensembles.app.entity.Service;
import ensembles.app.repository.RepoService;
import ensembles.app.viewmodels.ServiceViewModel;

@Stateless
public class ServiceService {

	@Inject
	private RepoService repoService;
	@Inject
	private Service service;
	
	public void saveService(ServiceViewModel serviceViewModel, ProfilPartenaire profilPartenaire) {
		System.out.println("Serviceservice saveService() : ");
		service = new Service();
		service.setName(serviceViewModel.getName());
		service.setPlace(serviceViewModel.getPlace());
		service.setBegin(serviceViewModel.getBegin());
		service.setEnd(serviceViewModel.getEnd());
		service.setServiceType(serviceViewModel.getServiceType());
		service.setPrice(serviceViewModel.getPrice());
		service.setDescription(serviceViewModel.getDescription());
		service.setProfilPartenaire(profilPartenaire);
		
		System.out.println("Service : ");
		System.out.println(service);
		
		repoService.saveService(service);

	}

	public void modifierService(ServiceViewModel serviceViewModel) {
		Service service = repoService.findById(serviceViewModel.getId());
		
		service.setName(serviceViewModel.getName());
		service.setPlace(serviceViewModel.getPlace());
		service.setBegin(serviceViewModel.getBegin());
		service.setEnd(serviceViewModel.getEnd());
		service.setServiceType(serviceViewModel.getServiceType());
		service.setPrice(serviceViewModel.getPrice());
		service.setDescription(serviceViewModel.getDescription());
		service.setProfilPartenaire(serviceViewModel.getProfilPartenaire());
		
		repoService.update(service);
	}

	public void supprimerService(Long id) {

		Service service = repoService.findById(id);
		repoService.delete(service);
	}

	public RepoService getRepoService() {
		return repoService;
	}

	public Service getService() {
		return service;
	}

	public void setRepoService(RepoService repoService) {
		this.repoService = repoService;
	}

	public void setService(Service service) {
		this.service = service;
	}

}