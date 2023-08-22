package ensembles.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ensembles.app.entity.WebSite;
import ensembles.app.repository.RepoWebSite;
import ensembles.app.viewmodels.WebSiteViewModel;

@Stateless
public class WebSiteService {

	@Inject
	RepoWebSite repoWebSite;
	
	
	public void saveWebSite(WebSiteViewModel webSiteViewModel) {
		
		WebSite webSite = new WebSite();
		webSite.setAboutUs(webSiteViewModel.getAboutUs());
		
		repoWebSite.saveWebSite(webSite);
	}
	
}
