package ensembles.app.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ensembles.app.service.ProfilAgenceService;
import ensembles.app.viewmodels.ProfilAgenceViewModel;

@ManagedBean
public class ControllerProfilAgence implements Serializable {


	private static final long serialVersionUID = 1L;
	
	ProfilAgenceViewModel profilAgenceViewModel = new ProfilAgenceViewModel();
	
	@Inject
	ProfilAgenceService profilAgenceService;
	
	public void saveProfilAgence() {
		profilAgenceService.saveProfilAgence(profilAgenceViewModel);
	}

	public ProfilAgenceViewModel getProfilAgenceViewModel() {
		return profilAgenceViewModel;
	}

	public void setProfilAgenceViewModel(ProfilAgenceViewModel profilAgenceViewModel) {
		this.profilAgenceViewModel = profilAgenceViewModel;
	}
	
	
	
}
