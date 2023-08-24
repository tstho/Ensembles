package ensembles.app.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import ensembles.app.entity.ProfilAgence;
import ensembles.app.entity.WebSite;
import ensembles.app.repository.RepoProfilAgence;
import ensembles.app.repository.RepoWebSite;
import ensembles.app.service.ProfilAgenceService;
import ensembles.app.service.WebSiteService;
import ensembles.app.viewmodels.JourneyViewModel;
import ensembles.app.viewmodels.ProfilAgenceViewModel;
import ensembles.app.viewmodels.WebSiteViewModel;

import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class ControllerWebSite implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	WebSiteViewModel webSiteViewModel;
	
	@Inject
	private WebSiteService webSiteService;
	
	@Inject
	private ProfilAgenceService profilAgenceService;
	
	@Inject
	private RepoProfilAgence repoProfilAgence;
	@Inject
	private RepoWebSite repoWebSite;
	
	public void saveWebSite() {
		webSiteService.saveWebSite(webSiteViewModel);
	}
	
	// Modification du profil de l'agence
	public String redirectToEdit(Long userId) {
		initModifierWebsite(userId);
		return "/templates/configTemplate.xhtml?faces-redirect=true";
	}

	public void initModifierWebsite(Long userId) {

		ProfilAgence profilAgence = profilAgenceService.findByUserId(userId);
		WebSite webSite = repoWebSite.getWebsiteByAgence(profilAgence.getId());
		webSiteViewModel = new WebSiteViewModel();
		
		// initialisation des champs du viewModel
		webSiteViewModel.setId(webSite.getId());
		webSiteViewModel.setAboutUs(webSite.getAboutUs());
		webSiteViewModel.setColor(webSite.getColor());
		webSiteViewModel.setImageAboutUs(webSite.getImageAboutUs());
		webSiteViewModel.setImageBackground(webSite.getImage());
		webSiteViewModel.setLogo(webSite.getLogo());
		webSiteViewModel.setProfilAgence(webSite.getProfilAgence());
		System.out.println(webSiteViewModel.toString());
	}
		
	public String modifierWebsite() {

		System.out.println("Je modifie ton site là");
		webSiteService.modifyWebsite(webSiteViewModel);
//			profilList = rU.findAll();

//			resetViewModel();

		return "/templates/templateOne.xhtml?faces-redirect=true";
	}

	/*
	 * getters & setters
	 */
	
	

	public WebSiteViewModel getWebSiteViewModel() {
		return webSiteViewModel;
	}

	public void setWebSiteViewModel(WebSiteViewModel webSiteViewModel) {
		this.webSiteViewModel = webSiteViewModel;
	}

	public WebSiteService getWebSiteService() {
		return webSiteService;
	}

	public void setWebSiteService(WebSiteService webSiteService) {
		this.webSiteService = webSiteService;
	}

	public ProfilAgenceService getProfilAgenceService() {
		return profilAgenceService;
	}

	public void setProfilAgenceService(ProfilAgenceService profilAgenceService) {
		this.profilAgenceService = profilAgenceService;
	}

	public RepoProfilAgence getRepoProfilAgence() {
		return repoProfilAgence;
	}

	public void setRepoProfilAgence(RepoProfilAgence repoProfilAgence) {
		this.repoProfilAgence = repoProfilAgence;
	}

	public RepoWebSite getRepoWebSite() {
		return repoWebSite;
	}

	public void setRepoWebSite(RepoWebSite repoWebSite) {
		this.repoWebSite = repoWebSite;
	}



	
	
}
