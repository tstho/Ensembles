package ensembles.app.viewmodels;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import ensembles.app.entity.PaymentMethod;
import ensembles.app.entity.PaymentPeriod;
import ensembles.app.entity.SubscriptionStatut;
import ensembles.app.entity.SubscriptionType;

@ManagedBean
public class SubscriptionViewModel {

	private SubscriptionType subscriptionType;

	private Date startDate;

	private Date endDate;

	private double price;

	private SubscriptionStatut subscriptionStatut;

	private PaymentPeriod paymentPeriod;

	private PaymentMethod paymentMethod;

	public SubscriptionType getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(SubscriptionType subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getprice() {
		return price;
	}

	public void setprice(double price) {
		this.price = price;
	}

	public SubscriptionStatut getSubscriptionStatut() {
		return subscriptionStatut;
	}

	public void setSubscriptionStatut(SubscriptionStatut subscriptionStatut) {
		this.subscriptionStatut = subscriptionStatut;
	}

	public PaymentPeriod getPaymentPeriod() {
		return paymentPeriod;
	}

	public void setPaymentPeriod(PaymentPeriod paymentPeriod) {
		this.paymentPeriod = paymentPeriod;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "SubscriptionViewModel [subscriptionType=" + subscriptionType + ", startDate=" + startDate + ", endDate="
				+ endDate + ", price=" + price + ", subscriptionStatut=" + subscriptionStatut + ", paymentPeriod="
				+ paymentPeriod + ", paymentMethod=" + paymentMethod + "]";
	}

}
