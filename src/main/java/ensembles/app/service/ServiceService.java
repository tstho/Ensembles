package ensembles.app.service;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ensembles.app.entity.ProfilAgence;
import ensembles.app.entity.ProfilPartenaire;
import ensembles.app.entity.Service;
import ensembles.app.entity.ServiceType;
import ensembles.app.repository.RepoService;
import ensembles.app.viewmodels.ServiceViewModel;

@Stateless
public class ServiceService {

	@Inject
	private RepoService repoService;
	@Inject
	private Service service;
	
	public void saveService(String name,String place,Date begin, Date end, ServiceType ServiceType, Double price, String Description,ProfilPartenaire profilPartenaire) {
		
		service = new Service();
		service.setName(name);
		service.setPlace(place);
		service.setBegin(begin);
		service.setEnd(end);
		service.setServiceType(ServiceType);
		service.setPrice(price);
		service.setDescription(Description);
		
		service.setProfilPartenaire(profilPartenaire);
		repoService.saveService(service);

	}

	public void modifierService(ServiceViewModel serviceViewModel) {
		Service service = new Service();
		service.setId(serviceViewModel.getId());
		service.setName(serviceViewModel.getName());
		service.setPlace(serviceViewModel.getPlace());
		service.setBegin(serviceViewModel.getBegin());
		service.setEnd(serviceViewModel.getEnd());
		service.setServiceType(serviceViewModel.getServiceType());
		service.setPrice(serviceViewModel.getPrice());
		service.setDescription(serviceViewModel.getDescription());
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
