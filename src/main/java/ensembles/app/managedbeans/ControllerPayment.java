package ensembles.app.managedbeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import ensembles.app.service.PaymentService;
import ensembles.app.viewmodels.PaymentViewmodel;

@ManagedBean
@RequestScoped
public class ControllerPayment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	public PaymentViewmodel paymentViewModel;

	@Inject
	PaymentService paymentService;

	public void initModifierPrix() {
		int prix1 = 30;
		int prix2 = 90;
		int prix3 = 500;

		System.out.println("Prix 1 : " + prix1);
		System.out.println("Prix 2 : " + prix2);
		System.out.println("Prix 3 : " + prix3);

	}

	public void savePaymentWebsite() {
		paymentService.savePayment(paymentViewModel.getCardNumber(), paymentViewModel.getCvv(),
				paymentViewModel.getCardHolderName(), paymentViewModel.getExpirationDate(),
				paymentViewModel.getPaymentMethod(), paymentViewModel.getPaypalAmount());

		// Réinitialiser le view model
		paymentViewModel = new PaymentViewmodel();

		//TODO Créer le website en base de données
		//TODO Attribuer le website au profilAgence
		
		String confirmationMessage = "Votre paiement a été effectué avec succès.";
		paymentViewModel.setShowPaymentConfirmation(true, confirmationMessage);


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
