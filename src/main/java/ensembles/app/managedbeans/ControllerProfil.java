package ensembles.app.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import ensembles.app.service.ProfilAgenceService;
import ensembles.app.service.ProfilClientService;
import ensembles.app.service.ProfilPartenaireService;
import ensembles.app.viewmodels.PartenaireViewModel;
import ensembles.app.viewmodels.ProfilAgenceViewModel;
import ensembles.app.viewmodels.ProfilClientViewModel;
import ensembles.app.viewmodels.ProfilPartenaireViewModel;
import ensembles.app.viewmodels.ProfilViewModel;

@ManagedBean
public abstract class ControllerProfil implements Serializable{
	

	    private static final long serialVersionUID = 1L;
	    
	  
	   
	   @Inject
		private ProfilViewModel profilViewModel;
	   
	    public ProfilViewModel getProfilViewModel() {
		return profilViewModel;
	}

	public void setProfilViewModel(ProfilViewModel profilViewModel) {
		this.profilViewModel = profilViewModel;
	}

		@Inject
	    ProfilAgenceService profilAgenceService;

	    @Inject
	    ProfilClientService profilClientService;

	    @Inject
	    ProfilPartenaireService profilPartenaireService;

	    private ProfilAgenceViewModel profilAgenceViewModel = new ProfilAgenceViewModel();
	    private ProfilClientViewModel profilClientViewModel = new ProfilClientViewModel();
	    private ProfilPartenaireViewModel profilPartenaireViewModel = new ProfilPartenaireViewModel();



		private Object profilService;

	    // Sauvegarder un profil d'agence
	    
	    public void saveProfilAgence() {
			profilAgenceService.saveProfilAgence(profilAgenceViewModel);
		}
	    
	    // Sauvegarder un profil client
	    
	    
	    public void saveProfilClient() {
			profilClientService.saveProfilClient(profilClientViewModel);
		}

	    // Sauvegarder un profil partenaire
	    
	    
	    public void saveProfilPartenaire() {
			profilPartenaireService.saveProfilPartenaire(profilPartenaireViewModel);
		}
	    
       // Sauvegarder un profil 
	    
	    
	    public void saveProfil() {
			profilService.saveProfil(profilViewModel);
		}
	   

	    
	    
		public ProfilAgenceService getProfilAgenceService() {
			return profilAgenceService;
		}

		public void setProfilAgenceService(ProfilAgenceService profilAgenceService) {
			this.profilAgenceService = profilAgenceService;
		}

		public ProfilClientService getProfilClientService() {
			return profilClientService;
		}

		public void setProfilClientService(ProfilClientService profilClientService) {
			this.profilClientService = profilClientService;
		}

		public ProfilPartenaireService getProfilPartenaireService() {
			return profilPartenaireService;
		}

		public void setProfilPartenaireService(ProfilPartenaireService profilPartenaireService) {
			this.profilPartenaireService = profilPartenaireService;
		}

		public ProfilAgenceViewModel getProfilAgenceViewModel() {
			return profilAgenceViewModel;
		}

		public void setProfilAgenceViewModel(ProfilAgenceViewModel profilAgenceViewModel) {
			this.profilAgenceViewModel = profilAgenceViewModel;
		}

		public ProfilClientViewModel getProfilClientViewModel() {
			return profilClientViewModel;
		}

		public void setProfilClientViewModel(ProfilClientViewModel profilClientViewModel) {
			this.profilClientViewModel = profilClientViewModel;
		}

		public ProfilPartenaireViewModel getProfilPartenaireViewModel() {
			return profilPartenaireViewModel;
		}

		public void setProfilPartenaireViewModel(ProfilPartenaireViewModel profilPartenaireViewModel) {
			this.profilPartenaireViewModel = profilPartenaireViewModel;
		}

	   
	  
	    }
	
	


