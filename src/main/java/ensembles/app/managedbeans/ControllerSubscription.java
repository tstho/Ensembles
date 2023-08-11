package ensembles.app.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import ensembles.app.entity.PaymentMethod;
import ensembles.app.entity.PaymentPeriod;
import ensembles.app.entity.Role;
import ensembles.app.entity.Subscription;
import ensembles.app.entity.SubscriptionStatut;
import ensembles.app.entity.SubscriptionType;
import ensembles.app.repository.RepoSubscription;
import ensembles.app.service.SubscriptionService;
import ensembles.app.viewmodels.SubscriptionViewModel;


@ManagedBean
@RequestScoped
public class ControllerSubscription implements Serializable {
	

		private static final long serialVersionUID = 1L;
		
		@Inject
		private SubscriptionViewModel subscriptionViewModel;
		@Inject
		SubscriptionService subscriptionService;
        @Inject
        private RepoSubscription reposubscription;
        
		public String saveSubscription() {
			subscriptionService.saveSubscription(subscriptionViewModel.getSubscriptionType(), subscriptionViewModel.getStartDate(),subscriptionViewModel.getEndDate(),subscriptionViewModel.getprice(),subscriptionViewModel.getSubscriptionStatut(),subscriptionViewModel.getPaymentPeriod(),subscriptionViewModel.getPaymentMethod());
			
			//reset le view model
			subscriptionViewModel = new SubscriptionViewModel();
			
			return "";
		}
		 
		public List<SubscriptionType> getSubscriptionTypeOptions() {
		    List<SubscriptionType> options = new ArrayList<>();
		    for (SubscriptionType type : SubscriptionType.values()) {
		        options.add(type);
		    }
		    return options;
		}

		public List<SubscriptionStatut> getSubscriptionStatutOptions() {
		    List<SubscriptionStatut> options = new ArrayList<>();
		    for (SubscriptionStatut statut : SubscriptionStatut.values()) {
		        options.add(statut);
		    }
		    return options;
		}
		
		public List<PaymentMethod> getPaymentMethodOptions() {
		    List<PaymentMethod> options = new ArrayList<>();
		    for (PaymentMethod method : PaymentMethod.values()) {
		        options.add(method);
		    }
		    return options;
		}

		public List<PaymentPeriod> getPaymentPeriodOptions() {
		    List<PaymentPeriod> options = new ArrayList<>();
		    for (PaymentPeriod period : PaymentPeriod.values()) {
		        options.add(period);
		    }
		    return options;
		}

		public SubscriptionViewModel getSubscriptionViewModel() {
			return subscriptionViewModel;
		}


		public void setSubscriptionViewModel(SubscriptionViewModel subscriptionViewModel) {
			this.subscriptionViewModel = subscriptionViewModel;
		}



		public SubscriptionService getSubscriptionService() {
			return subscriptionService;
		}


		public void setSubscriptionService(SubscriptionService subscriptionService) {
			this.subscriptionService = subscriptionService;
		}

		public RepoSubscription getReposubscription() {
			return reposubscription;
		}

		public void setReposubscription(RepoSubscription reposubscription) {
			this.reposubscription = reposubscription;
		}

		



		



		
	}



