package ensembles.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ensembles.app.entity.Adresse;
import ensembles.app.entity.ProfilAgence;
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
		webSite.setId(webSiteViewModel.getId());
		webSite.setColor(webSiteViewModel.getColor());
		webSite.setImage(webSiteViewModel.getImageBackground());
		webSite.setImageAboutUs(webSiteViewModel.getImageAboutUs());
		
		webSite.setLogo(webSiteViewModel.getLogo());
		
		repoWebSite.saveWebSite(webSite);
	}


	public void modifyWebsite(WebSiteViewModel webSiteViewModel) {
	
		WebSite webSite = repoWebSite.findById(webSiteViewModel.getId());

		webSite.setAboutUs(webSiteViewModel.getAboutUs());
		webSite.setColor(webSiteViewModel.getColor());
		webSite.setImage(webSiteViewModel.getImageAboutUs());
		webSite.setImageAboutUs(webSiteViewModel.getImageBackground());
		webSite.setLogo(webSiteViewModel.getLogo());
		
		repoWebSite.update(webSite);
	}
	

}
