package ensembles.app.viewmodels;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import ensembles.app.entity.PaymentMethod;

@ManagedBean
public class PaymentViewmodel {

    private PaymentMethod paymentMethod;
    public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	private int cardNumber;
    private String cardHolderName;
    private Date expirationDate;
    private int cvv;
    private String paypalAmount;

   

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getPaypalAmount() {
        return paypalAmount;
    }

    public void setPaypalAmount(String paypalAmount) {
        this.paypalAmount = paypalAmount;
    }

    private boolean showPaymentConfirmation = false;
    private String paymentConfirmationMessage = "";

    public boolean isShowPaymentConfirmation() {
        return showPaymentConfirmation;
    }

    public void setShowPaymentConfirmation(boolean showPaymentConfirmation, String message) {
        this.showPaymentConfirmation = showPaymentConfirmation;
        this.paymentConfirmationMessage = message;
    }

    public String getPaymentConfirmationMessage() {
        return paymentConfirmationMessage;
    }

    

		
	}



