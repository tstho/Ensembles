package ensembles.app.managedbeans;

import java.beans.beancontext.BeanContext;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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

	    public String savePayment() {
	        paymentService.savePayment(paymentViewModel.getCardNumber(), paymentViewModel.getCvv(),paymentViewModel.getCardHolderName(),paymentViewModel.getExpirationDate(),paymentViewModel.getPaymentMethod(),paymentViewModel.getPaypalAmount());
	        
	        
	        	
	    		
	        // Réinitialiser le view model
	        paymentViewModel = new PaymentViewmodel();
	        
	        
	        String confirmationMessage = "Votre paiement a été effectué avec succès.";
	        paymentViewModel.setShowPaymentConfirmation(true, confirmationMessage);

	        return "";
	        
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
	
	


