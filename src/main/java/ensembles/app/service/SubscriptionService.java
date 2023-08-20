package ensembles.app.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ensembles.app.entity.PaymentMethod;
import ensembles.app.entity.PaymentPeriod;
import ensembles.app.entity.Subscription;
import ensembles.app.entity.SubscriptionStatut;
import ensembles.app.entity.SubscriptionType;
import ensembles.app.repository.RepoSubscription;


@Stateless
public class SubscriptionService {
		
		@Inject
		private RepoSubscription repoSubscription;
		@Inject
		private Subscription subscription;

		
		
		@Override
		public String toString() {
			return "SubscriptionService [repoSubscription=" + repoSubscription + "]";
		}

		public void saveSubscription(SubscriptionType subscriptionType, Date startDate, Date endDate, double price, SubscriptionStatut subscriptionStatut , PaymentPeriod paymentPeriod,PaymentMethod paymentMethod) {
		
			Subscription subscription = new Subscription();
			subscription.setSubscriptionType(subscriptionType);
			subscription.setStartDate(startDate);
			subscription.setEndDate(endDate);
			subscription.setprice(price);
			subscription.setSubscriptionStatut(subscriptionStatut);
			subscription.setPaymentPeriod(paymentPeriod);
			subscription.setPaymentMethod(paymentMethod);
			repoSubscription.saveSubscription(subscription);
			
			
		}
		
		public Long createSubscription(SubscriptionType subscriptionType, Date startDate, Date endDate,
                double price, SubscriptionStatut subscriptionStatut,
                PaymentPeriod paymentPeriod, PaymentMethod paymentMethod) {

          Subscription subscription = new Subscription();
          subscription.setSubscriptionType(subscriptionType);
          subscription.setStartDate(startDate);
          subscription.setEndDate(endDate);
          subscription.setprice(price);
          subscription.setSubscriptionStatut(subscriptionStatut);
          subscription.setPaymentPeriod(paymentPeriod);
          subscription.setPaymentMethod(paymentMethod);

    return repoSubscription.saveSubscription(subscription);
    }
		
		
		 public void deleteSubscription(Subscription subscription) {
		        repoSubscription.delete(subscription);
		    }

		    public Subscription findById(Long id) {
		        return repoSubscription.findById(id);
		    }	
		

		public Subscription updateSubscription(Subscription subscription) {
	        return repoSubscription.updateSubscription(subscription);
	    }

	    public List<Subscription> displaySubscriptions() {
	        return repoSubscription.displaySubscriptions();
	    }

	    public List<Subscription> getAllSubscriptions() {
	        return repoSubscription.findAll();
	    }
		
		
		
		

		public RepoSubscription getRepoSubscription() {
			return repoSubscription;
		}

		public void setRepoSubscription(RepoSubscription repoSubscription) {
			
			this.repoSubscription = repoSubscription;
		}

		
		
		public Subscription getSubscription() {
			return subscription;
		}

		public void setSubscription(Subscription subscription) {
			this.subscription = subscription;
		}

		

		

}
