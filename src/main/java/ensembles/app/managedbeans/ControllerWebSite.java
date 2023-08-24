package ensembles.app.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ensembles.app.entity.ProfilAgence;
import ensembles.app.entity.WebSite;
import ensembles.app.repository.RepoProfilAgence;
import ensembles.app.service.ProfilAgenceService;
import ensembles.app.service.WebSiteService;
import ensembles.app.viewmodels.JourneyViewModel;
import ensembles.app.viewmodels.ProfilAgenceViewModel;
import ensembles.app.viewmodels.WebSiteViewModel;

import java.io.Serializable;
import java.util.List;

@ManagedBean
public class ControllerWebSite implements Serializable {

	private static final long serialVersionUID = 1L;
	
	WebSiteViewModel webSiteViewModel = new WebSiteViewModel();
	
	@Inject
	private WebSiteService webSiteService;
	
	@Inject
	private ProfilAgenceService profilAgenceService;
	
	@Inject
	private RepoProfilAgence repoProfilAgence;
	
	public void saveWebSite() {
		webSiteService.saveWebSite(webSiteViewModel);
	}
	
	// Modification du profil de l'agence
	public String redirectToEdit(Long userId) {
		initModifierWebsite(userId);
		return "/agency/configTemplate.xhtml?faces-redirect=true";
	}

	public void initModifierWebsite(Long userId) {

		ProfilAgence profilAgence = profilAgenceService.findByUserId(userId);
		WebSite webSite = repoProfilAgence.getWebsiteByAgence(profilAgence.getId());
		webSiteViewModel = new WebSiteViewModel();
		
		// initialisation des champs du viewModel
		webSiteViewModel.setAboutUs(webSite.getAboutUs());
		webSiteViewModel.setColor(webSite.getColor());
		webSiteViewModel.setImageAboutUs(webSite.getImageAboutUs());
		webSiteViewModel.setImageBackground(webSite.getImage());
		webSiteViewModel.setLogo(webSite.getLogo());

	}
		
	public String modifierWebsite() {

		webSiteService.modifyWebsite(webSiteViewModel);
//			profilList = rU.findAll();

//			resetViewModel();

		return "/login/authentification.xhtml?faces-redirect=true";
	}
    /**
	 * @return the webSiteViewModel
	 */
	public WebSiteViewModel getWebSiteViewModel() {
		return webSiteViewModel;
	}


	/**
	 * @param webSiteViewModel the webSiteViewModel to set
	 */
	public void setWebSiteViewModel(WebSiteViewModel webSiteViewModel) {
		this.webSiteViewModel = webSiteViewModel;
	}




	
	
}
