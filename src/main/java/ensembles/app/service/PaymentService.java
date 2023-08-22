package ensembles.app.service;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;
import ensembles.app.entity.Payment;
import ensembles.app.entity.PaymentMethod;
import ensembles.app.entity.PaymentPeriod;
import ensembles.app.entity.SubscriptionStatut;
import ensembles.app.repository.RepoPayment;

@Stateless
public class PaymentService {

	@Inject
    private RepoPayment repoPayment;

    public void savePayment(int cardNumber, int cvv, String cardHolderName, Date expirationDate,PaymentMethod paymentMethod, String paypalAmount) {
        Payment payment = new Payment();
        payment.setCardNumber(cardNumber);
        payment.setCvv(cvv);
        payment.setCardHolderName(cardHolderName);
        payment.setExpirationDate(expirationDate);
        payment.setPaymentMethod(paymentMethod);
        payment.setPaypalAmount(paypalAmount);
        
        repoPayment.save(payment);
        //SubscriptionService.saveSubscription( duration,  price);
    }
    
    

    public RepoPayment getPaymentRepository() {
        return repoPayment;
    }

    public RepoPayment getRepoPayment() {
		return repoPayment;
	}

	public void setRepoPayment(RepoPayment repoPayment) {
		this.repoPayment = repoPayment;
	}

	public void setPaymentRepository(RepoPayment repoPayment) {
        this.repoPayment = repoPayment;
	

	
	   

    }

	
		
	}    



	
	

