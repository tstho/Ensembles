package ensembles.app.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import ensembles.app.entity.WebSite;
import ensembles.app.repository.RepoWebSite;

@ManagedBean
@RequestScoped
public class ControllerIndex implements Serializable {

	private static final long serialVersionUID = 1L;	

	private List<WebSite> webSiteList;

	
	@Inject
	private RepoWebSite repoWebSite;
	
	public void onPageLoad() {
        // Code à exécuter lors du chargement de la page
		webSiteList = repoWebSite.findAll();
		
    }
	

	public List<WebSite> getWebSiteList() {
		return webSiteList;
	}

	public void setWebSiteList(List<WebSite> webSiteList) {
		this.webSiteList = webSiteList;
	}


	
	
}
