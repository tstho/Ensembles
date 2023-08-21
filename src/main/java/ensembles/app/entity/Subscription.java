package ensembles.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Subscription")
public class Subscription {
	

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		
		private Long id;
		
		private SubscriptionType subscriptionType;
		
		private Date startDate;
		
		private Date endDate;
		
		private double price;
		
		private SubscriptionStatut subscriptionStatut;
		
		private PaymentPeriod paymentPeriod;
		
		private PaymentMethod paymentMethod;
		

		public Subscription() {
			super();
		}


		public Subscription(Long id, ensembles.app.entity.SubscriptionType subscriptionType, Date startDate,
				Date endDate, double price, ensembles.app.entity.SubscriptionStatut subscriptionStatut, PaymentPeriod paymentPeriod,
				PaymentMethod paymentMethod) {
			super();
			this.id = id;
			this.subscriptionType = subscriptionType;
			this.startDate = startDate;
			this.endDate = endDate;
			this.price = price;
			this.subscriptionStatut = subscriptionStatut;
			this.paymentPeriod = paymentPeriod;
			this.paymentMethod = paymentMethod;
			
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

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
			return "Subcription [id=" + id + ", subscriptionType=" + subscriptionType + ", startDate=" + startDate
					+ ", endDate=" + endDate + ", price=" + price + ", subscriptionStatut=" + subscriptionStatut
					+ ", paymentPeriod=" + paymentPeriod + ", paymentMethod=" + paymentMethod + "]";
		}
		
		
}