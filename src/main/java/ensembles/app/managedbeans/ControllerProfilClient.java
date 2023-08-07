package ensembles.app.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ensembles.app.service.ProfilClientService;
import ensembles.app.viewmodels.ProfilClientViewModel;

@ManagedBean
public class ControllerProfilClient {

	ProfilClientViewModel profilClientViewModel = new ProfilClientViewModel();
	
	@Inject
	ProfilClientService profilClientService;
	
	public void saveProfilClient() {
		profilClientService.saveProfilClient(profilClientViewModel);
	}


	public ProfilClientViewModel getProfilClientViewModel() {
		return profilClientViewModel;
	}


	public void setProfilClientViewModel(ProfilClientViewModel profilClientViewModel) {
		this.profilClientViewModel = profilClientViewModel;
	}
	
}
