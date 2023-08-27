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

	public String redirectToEdit(Long userId) {
		initModifierProfilC(userId);
		return "/client/profilClient.xhtml?faces-redirect=true";
	}

	public void initModifierProfilC(Long userId) {

		ProfilClient profilClient = profilClientService.findByUserId(userId);

		profilClientViewModel = new ProfilClientViewModel();

		// identification du client
		profilClientViewModel.setId(profilClient.getId());
		profilClientViewModel.setUser(profilClient.getUser());

		// infos du client

		profilClientViewModel.setNomClient(profilClient.getNomClient());
		profilClientViewModel.setPrenomClient(profilClient.getPrenomClient());
		profilClientViewModel.setTelephoneClient(profilClient.getTelephoneClient());

		// infos de l'adresse du client
		profilClientViewModel.setAdresseId(profilClient.getAdresse().getId());

		profilClientViewModel.setNumero(profilClient.getAdresse().getNumero());
		profilClientViewModel.setComplement(profilClient.getAdresse().getComplement());
		profilClientViewModel.setVoie(profilClient.getAdresse().getVoie());
		profilClientViewModel.setCodePostal(profilClient.getAdresse().getCodePostal());
		profilClientViewModel.setPays(profilClient.getAdresse().getPays());
		profilClientViewModel.setVille(profilClient.getAdresse().getVille());

	}

	// Modification du profil du client
	public String modifierProfilC(Long userId) {

		profilClientService.modifyProfilClient(profilClientViewModel);
		resetViewModel();

		return redirectToEdit(userId);
	}

	private void resetViewModel() {
		profilClientViewModel = new ProfilClientViewModel();

	}
	
	public ProfilClientViewModel getProfilClientViewModel() {
		return profilClientViewModel;
	}

	public void setProfilClientViewModel(ProfilClientViewModel profilClientViewModel) {
		this.profilClientViewModel = profilClientViewModel;
	}
}
