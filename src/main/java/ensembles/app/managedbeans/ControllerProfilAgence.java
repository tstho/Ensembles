package ensembles.app.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import ensembles.app.entity.ProfilAgence;
import ensembles.app.entity.User;
import ensembles.app.repository.RepoProfilAgence;
import ensembles.app.repository.RepoUser;
import ensembles.app.service.ProfilAgenceService;
import ensembles.app.service.UserService;
import ensembles.app.viewmodels.JourneyViewModel;
import ensembles.app.viewmodels.ProfilAgenceViewModel;
import ensembles.app.viewmodels.UserViewModel;

@ManagedBean
@SessionScoped
public class ControllerProfilAgence implements Serializable {

	private static final long serialVersionUID = 1L;

	ProfilAgenceViewModel profilAgenceViewModel = new ProfilAgenceViewModel();

	@Inject
	private ProfilAgenceService profilAgenceService;
	

	@Inject
	private RepoProfilAgence repoProfilAgence;

	@Inject
	private ProfilAgenceService proAgenceService;

	private List<ProfilAgence> profilAgenceList;

	@PostConstruct
	public void init() {

		profilAgenceList = repoProfilAgence.findAll();
		System.out.println(profilAgenceList);
	}
	
	
	
	
	

//	
//	public void saveProfilAgence() {
//		profilAgenceService.saveProfilAgence(profilAgenceViewModel);
//	}

	

	// Modification du profil de l'agence
	public String redirectToEdit(Long userId) {
		initModifierProfilA(userId);
		return "/agency/profilAgence.xhtml?faces-redirect=true";
	}

	public void initModifierProfilA(Long userId) {

		ProfilAgence profilAgence = profilAgenceService.findByUserId(userId);

		profilAgenceViewModel = new ProfilAgenceViewModel();

		// identification de l'agence et de son adresse

		profilAgenceViewModel.setUser(profilAgence.getUser());
		profilAgenceViewModel.setid(profilAgence.getId());
		profilAgenceViewModel.setAdresseId(profilAgence.getAdresse().getId());

		// infos de l'agence

		profilAgenceViewModel.setNomResponsableSociete(profilAgence.getNomResponsableSociete());
		profilAgenceViewModel.setPrenomResponsableSociete(profilAgence.getPrenomResponsableSociete());
		profilAgenceViewModel.setSiretSociete(profilAgence.getSiretSociete());

		profilAgenceViewModel.setTelephoneResponsableSociete(profilAgence.getTelephoneResponsableSociete());

		// infos de l'adresse de l'Agence

		profilAgenceViewModel.setNomSociete(profilAgence.getNomSociete());
		profilAgenceViewModel.setCodePostal(profilAgence.getAdresse().getCodePostal());
		profilAgenceViewModel.setComplement(profilAgence.getAdresse().getComplement());

		profilAgenceViewModel.setEmailResponsableSociete(profilAgence.getEmailResponsableSociete());

		profilAgenceViewModel.setNumero(profilAgence.getAdresse().getNumero());
		profilAgenceViewModel.setPays(profilAgence.getAdresse().getPays());

		profilAgenceViewModel.setVille(profilAgence.getAdresse().getVille());
		profilAgenceViewModel.setVoie(profilAgence.getAdresse().getVoie());

		System.out.println(profilAgence.toString());
		System.out.println(profilAgenceViewModel.toString());

		// Infos voyages associer a l'agence

		List<JourneyViewModel> journeyViewModels = profilAgenceViewModel.getJourneyViewModels();
		profilAgenceViewModel.setJourneyViewModels(journeyViewModels);

	}

	public List<JourneyViewModel> getJourneysForAgence() {
		return profilAgenceViewModel.getJourneyViewModels();
	}

	public void updateJourneys() {
		profilAgenceViewModel.setJourneyViewModels(new ArrayList<>(profilAgenceViewModel.getJourneyViewModels()));
	}

	public String modifierProfilA() {

		profilAgenceService.modifyProfilAgence(profilAgenceViewModel);
//			profilList = rU.findAll();

//			resetViewModel();

		return "/login/authentification.xhtml?faces-redirect=true";
	}
	
	
	
	public RepoProfilAgence getRepoProfilAgence() {
		return repoProfilAgence;
	}

	public void setRepoProfilAgence(RepoProfilAgence repoProfilAgence) {
		this.repoProfilAgence = repoProfilAgence;
	}

	public ProfilAgenceService getProAgenceService() {
		return proAgenceService;
	}

	public void setProAgenceService(ProfilAgenceService proAgenceService) {
		this.proAgenceService = proAgenceService;
	}

	public List<ProfilAgence> getProfilAgenceList() {
		return profilAgenceList;
	}

	public void setProfilAgenceList(List<ProfilAgence> profilAgenceList) {
		this.profilAgenceList = profilAgenceList;
	}






	private List<JourneyViewModel> journeyViewModels = new ArrayList<>();



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

	public void updateJourneyViewModel(JourneyViewModel journeyViewModel) {

	}

	public ProfilAgenceViewModel getProfilAgenceViewModel() {
		return profilAgenceViewModel;
	}

	public void setProfilAgenceViewModel(ProfilAgenceViewModel profilAgenceViewModel) {
		this.profilAgenceViewModel = profilAgenceViewModel;
	}

}
