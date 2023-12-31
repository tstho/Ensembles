package ensembles.app.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import ensembles.app.entity.ProfilAgence;
import ensembles.app.service.ProfilAgenceService;
import ensembles.app.viewmodels.JourneyViewModel;
import ensembles.app.viewmodels.ProfilAgenceViewModel;

@ManagedBean
@SessionScoped
public class ControllerProfilAgence implements Serializable {

	private static final long serialVersionUID = 1L;

	ProfilAgenceViewModel profilAgenceViewModel = new ProfilAgenceViewModel();

	@Inject
	private ProfilAgenceService profilAgenceService;
	
	private List<JourneyViewModel> journeyViewModels = new ArrayList<>();

	private List<ProfilAgence> profilAgenceList;

	

	// Modification du profil de l'agence
	public String redirectToEdit(Long userId) {
		initModifierProfilA(userId);
		return "/agency/profilAgence.xhtml?faces-redirect=true";
	}

	public void initModifierProfilA(Long userId) {
		System.out.println("init modifier profilA");

		ProfilAgence profilAgence = profilAgenceService.findByUserId(userId);
		System.out.println(profilAgence.toString());

		profilAgenceViewModel = new ProfilAgenceViewModel();

		// identification de l'agence et de son user

		profilAgenceViewModel.setId(profilAgence.getId());
		profilAgenceViewModel.setUser(profilAgence.getUser());

		// infos de l'agence

		profilAgenceViewModel.setNomSociete(profilAgence.getNomSociete());
		profilAgenceViewModel.setSiretSociete(profilAgence.getSiretSociete());
		profilAgenceViewModel.setNomResponsableSociete(profilAgence.getNomResponsableSociete());
		profilAgenceViewModel.setPrenomResponsableSociete(profilAgence.getPrenomResponsableSociete());
		profilAgenceViewModel.setEmailResponsableSociete(profilAgence.getEmailResponsableSociete());
		profilAgenceViewModel.setTelephoneResponsableSociete(profilAgence.getTelephoneResponsableSociete());

		// infos de l'adresse de l'Agence
		
		profilAgenceViewModel.setAdresseId(profilAgence.getAdresse().getId());

		profilAgenceViewModel.setNumero(profilAgence.getAdresse().getNumero());
		profilAgenceViewModel.setComplement(profilAgence.getAdresse().getComplement());
		profilAgenceViewModel.setVoie(profilAgence.getAdresse().getVoie());
		profilAgenceViewModel.setCodePostal(profilAgence.getAdresse().getCodePostal());
		profilAgenceViewModel.setVille(profilAgence.getAdresse().getVille());
		profilAgenceViewModel.setPays(profilAgence.getAdresse().getPays());

		// Infos voyages associer a l'agence

		profilAgenceViewModel.setJourneys(profilAgence.getJourneys());

		System.out.println(profilAgenceViewModel.toString());

	}

//
//	public void updateJourneys() {
//		profilAgenceViewModel.setJourneyViewModels(new ArrayList<>(profilAgenceViewModel.getJourneyViewModels()));
//	}

	public String modifierProfilA(Long userId) {

		profilAgenceService.modifyProfilAgence(profilAgenceViewModel);
		resetViewModel();

		return redirectToEdit(userId);
	}



	private void resetViewModel() {
		profilAgenceViewModel = new ProfilAgenceViewModel();
		
	}
/*
 * getters & setters
 */

	public ProfilAgenceViewModel getProfilAgenceViewModel() {
		return profilAgenceViewModel;
	}

	public void setProfilAgenceViewModel(ProfilAgenceViewModel profilAgenceViewModel) {
		this.profilAgenceViewModel = profilAgenceViewModel;
	}

	public ProfilAgenceService getProfilAgenceService() {
		return profilAgenceService;
	}

	public void setProfilAgenceService(ProfilAgenceService profilAgenceService) {
		this.profilAgenceService = profilAgenceService;
	}

	public List<JourneyViewModel> getJourneyViewModels() {
		return journeyViewModels;
	}

	public void setJourneyViewModels(List<JourneyViewModel> journeyViewModels) {
		this.journeyViewModels = journeyViewModels;
	}

	public List<ProfilAgence> getProfilAgenceList() {
		return profilAgenceList;
	}

	public void setProfilAgenceList(List<ProfilAgence> profilAgenceList) {
		this.profilAgenceList = profilAgenceList;
	}
	
}
