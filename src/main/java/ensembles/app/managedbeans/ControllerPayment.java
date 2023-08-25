package ensembles.app.managedbeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import ensembles.app.entity.Journey;
import ensembles.app.entity.ProfilAgence;
import ensembles.app.entity.User;
import ensembles.app.entity.WebSite;
import ensembles.app.repository.RepoPayment;
import ensembles.app.repository.RepoProfilAgence;
import ensembles.app.repository.RepoUser;
import ensembles.app.repository.RepoWebSite;
import ensembles.app.service.PaymentService;
import ensembles.app.service.WebSiteService;
import ensembles.app.viewmodels.PaymentViewmodel;
import ensembles.app.viewmodels.WebSiteViewModel;

@ManagedBean
@SessionScoped
public class ControllerPayment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	public PaymentViewmodel paymentViewModel;

	@Inject
	private PaymentService paymentService;
	
	@Inject
	private RepoProfilAgence rPA;
	
	@Inject
	private RepoWebSite repoWebSite;

	public void initModifierPrix() {
		int prix1 = 30;
		int prix2 = 90;
		int prix3 = 500;

		System.out.println("Prix 1 : " + prix1);
		System.out.println("Prix 2 : " + prix2);
		System.out.println("Prix 3 : " + prix3);

	}

	public String savePaymentWebsite(Long userId) {
		
		paymentService.savePayment(paymentViewModel.getCardNumber(), paymentViewModel.getCvv(),
				paymentViewModel.getCardHolderName(), paymentViewModel.getExpirationDate(),
				paymentViewModel.getPaymentMethod(), paymentViewModel.getPaypalAmount());

		System.out.println("Je crée ton site là");
		
		//TODO Créer le website en base de données et lui attribuer l'id de l'agence
		
				ProfilAgence pA = rPA.findById(userId);// trouver l'id de l'agence
				
				WebSite webSite = new WebSite(); //instancier un site vide 
				
				webSite.setProfilAgence(pA);
				
				repoWebSite.saveWebSite(webSite);
				
				
				
		// Réinitialiser le view model
		
		paymentViewModel = new PaymentViewmodel();

		return "/agency/mainAgence.xhtml?faces-redirect=true";
		
		
	
	}

	public PaymentViewmodel getPaymentViewModel() {
		return paymentViewModel;
	}

	public void setPaymentViewModel(PaymentViewmodel paymentViewModel) {
		this.paymentViewModel = paymentViewModel;
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

}

