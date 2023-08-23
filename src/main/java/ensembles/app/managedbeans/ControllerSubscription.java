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
        
//		public String saveSubscription() {
//			subscriptionService.saveSubscription( subscriptionViewModel.getStartDate(),subscriptionViewModel.getEndDate(),subscriptionViewModel.getprice());
//			
//			//reset le view model
//			subscriptionViewModel = new SubscriptionViewModel();
//			
//			return "";
//		}
		
		
}	   
		
		

		



		



		
	



