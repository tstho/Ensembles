package ensembles.app.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ensembles.app.service.ProfilPartenaireService;
import ensembles.app.viewmodels.ProfilPartenaireViewModel;

@ManagedBean
public class ControllerProfilPartenaire implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	ProfilPartenaireViewModel profilPartenaireViewModel = new ProfilPartenaireViewModel();
	
	@Inject
	ProfilPartenaireService profilPartenaireService;
	
	public void saveProfilPartenaire() {
		profilPartenaireService.saveProfilPartenaire(profilPartenaireViewModel);
	}
	
	public ProfilPartenaireViewModel getProfilPartenaireViewModel() {
		return profilPartenaireViewModel;
	}

	public void setProfilPartenaireViewModel(ProfilPartenaireViewModel profilPartenaireViewModel) {
		this.profilPartenaireViewModel = profilPartenaireViewModel;
	}
}
