package ensembles.app.managedbeans;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Scanner;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;

import org.primefaces.model.file.UploadedFile;

import ensembles.app.entity.Journey;
import ensembles.app.entity.ProfilAgence;
import ensembles.app.entity.WebSite;
import ensembles.app.repository.RepoJourney;
import ensembles.app.repository.RepoProfilAgence;
import ensembles.app.repository.RepoWebSite;
import ensembles.app.service.ProfilAgenceService;
import ensembles.app.service.WebSiteService;
import ensembles.app.viewmodels.WebSiteViewModel;

@ManagedBean
@SessionScoped
public class ControllerWebSite implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Part uploadedFile;
	private String text;
	private byte[] logo;
	
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
	@Inject
	private RepoJourney repoJourney;
	
	private List<Journey> journeyList; 
	
	private Long websiteId;
	
	/*
	 * Redirection Index -> Website
	 */

	public String redirectWebsite(Long websiteId) {
	    return "/templates/templateOne.xhtml?wsId=" + websiteId + "&faces-redirect=true";
	}
	/*
	 * Redirection EspaceAgence -> Website
	 */

	public String redirectWebsiteViaAgence(Long userId) {
		ProfilAgence profilAgence = profilAgenceService.findByUserId(userId);
		WebSite webSite = repoWebSite.getWebsiteByAgence(profilAgence.getId());
		websiteId = webSite.getId();

	    return "/templates/templateOne.xhtml?wsId=" + websiteId + "&faces-redirect=true";
	}
	
    public void onPageLoad() {
        if (websiteId != null) {
        	
        	WebSite webSite = repoWebSite.findById(websiteId);

    		webSiteViewModel.setId(webSite.getId());
    		webSiteViewModel.setAboutUs(webSite.getAboutUs());
    		webSiteViewModel.setColor(webSite.getColor());
    		webSiteViewModel.setImageAboutUs(webSite.getImageAboutUs());
    		webSiteViewModel.setImageBackground(webSite.getImageBackground());
    		webSiteViewModel.setLogo(webSite.getLogo());
    		webSiteViewModel.setProfilAgence(webSite.getProfilAgence());
    		
    		journeyListByProfilAgence(webSite.getProfilAgence().getId());
    		
    		
        }
    }

    /*
	 * Méthode pour récupérer la liste des voyages de l'agence 
	 */
	public List<Journey> journeyListByProfilAgence(Long agenceId) {
		
		journeyList = repoJourney.findByAgenceId(agenceId);

		return journeyList;

	}
    
	public void saveWebSite() {
				webSiteService.saveWebSite(webSiteViewModel);
	}

	// Redirection Modification du website
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
		webSiteViewModel.setImageBackground(webSite.getImageBackground());
		webSiteViewModel.setLogo(webSite.getLogo());
		webSiteViewModel.setProfilAgence(profilAgence);

	}

	/*
	 * Méthode pour modifier les champs du website
	 */
	public String modifierWebsite() {

		webSiteService.modifyWebsite(webSiteViewModel);

		return redirectWebsite(webSiteViewModel.getId());
	}
	
	public void upload() {
		
		System.out.println("uploaded file :" + uploadedFile);
		
        if (null != uploadedFile) {
            try {
                InputStream is = uploadedFile.getInputStream();
                text = new Scanner(is).useDelimiter("\\A").next();
                
                System.out.println("After upload :" + text);
            } catch (IOException ex) {
            }
        }
	}
	
//	private UploadedFile getUploadedPicture()
//    {
//        FacesContext context = FacesContext.getCurrentInstance();
//        ELContext elContext = context.getELContext();
//        UploadBean uploadBean = (UploadBean) elContext.getELResolver().getValue(elContext, null, "uploadBean");
//        return uploadBean.getUploadedFile();
//    }
//        


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

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public List<Journey> getJourneyList() {
		return journeyList;
	}

	public void setJourneyList(List<Journey> journeyList) {
		this.journeyList = journeyList;
	}
	public Long getWebsiteId() {
		return websiteId;
	}
	public void setWebsiteId(Long websiteId) {
		this.websiteId = websiteId;
	}

	
}
