package ensembles.app.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import ensembles.app.service.WebSiteService;
import ensembles.app.viewmodels.WebSiteViewModel;

import java.io.Serializable;

@ManagedBean
public class ControllerWebSite implements Serializable {

	private static final long serialVersionUID = 1L;
	
	WebSiteViewModel webSiteViewModel = new WebSiteViewModel();
	
	@Inject
	private WebSiteService webSiteService;
	
	public void saveWebSite() {
		webSiteService.saveWebSite(webSiteViewModel);
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
