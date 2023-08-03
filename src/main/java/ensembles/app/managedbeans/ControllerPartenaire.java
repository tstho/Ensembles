package ensembles.app.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import ensembles.app.service.PartenaireService;

import ensembles.app.viewmodels.PartenaireViewModel;


@ManagedBean(name="controllerPartenaire")
@RequestScoped
public class ControllerPartenaire implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Inject
	private PartenaireViewModel partenaireViewModel;
	@Inject
	PartenaireService partenaireService;

	public String savePartenaire() {
		partenaireService.savePartenaire(partenaireViewModel.getNom(), partenaireViewModel.getLocalisation());
		
		//reset le view model
		partenaireViewModel = new PartenaireViewModel();
		
		return "index.xhtml?faces-redirect=true";
	}

	public PartenaireViewModel getPartenaireViewModel() {
		return partenaireViewModel;
	}

	public void setPartenaireViewModel(PartenaireViewModel partenaireViewModel) {
		this.partenaireViewModel = partenaireViewModel;
	}

	public PartenaireService getPartenaireService() {
		return partenaireService;
	}

	public void setPartenaireService(PartenaireService partenaireService) {
		this.partenaireService = partenaireService;
	}



}
