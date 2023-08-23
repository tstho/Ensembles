package ensembles.app.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import ensembles.app.entity.ProfilClient;
import ensembles.app.service.ProfilClientService;
import ensembles.app.viewmodels.ProfilClientViewModel;

@ManagedBean
@SessionScoped
public class ControllerProfilClient implements Serializable {
	
	private static final long serialVersionUID = 1L;

	ProfilClientViewModel profilClientViewModel = new ProfilClientViewModel();
	
	@Inject
	ProfilClientService profilClientService;
	
	public void saveProfilClient() {
		profilClientService.saveProfilClient(profilClientViewModel);
	}


	public ProfilClientViewModel getProfilClientViewModel() {
		return profilClientViewModel;
	}


	public void setProfilClientViewModel(ProfilClientViewModel profilClientViewModel) {
		this.profilClientViewModel = profilClientViewModel;
	}
	
	// Modification du profil de l'agence 
			public String redirectToEdit(Long userId) {
				initModifierProfilC(userId);
				return "/client/profilClient.xhtml?faces-redirect=true";
			}
			
			public void initModifierProfilC(Long userId) {

				ProfilClient profilClient = profilClientService.findByUserId(userId);
				
				profilClientViewModel = new ProfilClientViewModel();
				
				// identification du client et de son adresse 
				profilClientViewModel.setUser(profilClient.getUser());
				profilClientViewModel.setId(profilClient.getId());
				
				profilClientViewModel.setAdresseId(profilClient.getAdresse().getId());
				
				//infos du client
				
				profilClientViewModel.setEmailClient(profilClient.getEmailClient());
				profilClientViewModel.setNomClient(profilClient.getNomClient());
				profilClientViewModel.setPrenomClient(profilClient.getPrenomClient());
				profilClientViewModel.setTelephoneClient(profilClient.getTelephoneClient());
				
				// infos de l'adresse du client 
				
				profilClientViewModel.setCodePostal(profilClient.getAdresse().getCodePostal());
				
				profilClientViewModel.setComplement(profilClient.getAdresse().getComplement());
				
				profilClientViewModel.setNumero(profilClient.getAdresse().getNumero());
				profilClientViewModel.setPays(profilClient.getAdresse().getPays());
				profilClientViewModel.setVille(profilClient.getAdresse().getVille());
				
				profilClientViewModel.setVoie(profilClient.getAdresse().getVoie());
				
				
				
				
				System.out.println(profilClient.toString());
				System.out.println(profilClientViewModel.toString());
			}
			
			public String modifierProfilC() {
				
				
				
				profilClientService.modifyProfilClient(profilClientViewModel);
//					profilList = rU.findAll();
//					resetViewModel();

					return "/login/authentification.xhtml?faces-redirect=true";
				}
}
