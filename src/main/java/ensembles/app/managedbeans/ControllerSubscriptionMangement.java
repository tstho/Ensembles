package ensembles.app.managedbeans;

import javax.faces.bean.ManagedBean;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.inject.Inject;

import ensembles.app.entity.Subscription;
import ensembles.app.repository.RepoSubscription;
import ensembles.app.viewmodels.SubscriptionViewModel;
@ManagedBean
public class ControllerSubscriptionMangement {
	@Inject 
	private SubscriptionViewModel subscriptionViewModel;
	 @Inject
	    private RepoSubscription repoSubscription;

	    private List<Subscription> subscriptionList;

	    @PostConstruct
	    public void init() {
	        subscriptionList = repoSubscription.findAll();
	        System.out.println(subscriptionList);
	    }

	    
	    public RepoSubscription getRepoSubscription() {
			return repoSubscription;
		}


		public void setRepoSubscription(RepoSubscription repoSubscription) {
			this.repoSubscription = repoSubscription;
		}


		public void addSubscription(Subscription subscription) {
	        repoSubscription.save(subscription);
	        subscriptionList = repoSubscription.findAll(); // Rafraîchir la liste après l'ajout
	    }
	    
	    public void updateSubscription(Subscription subscription) {
	        
	        repoSubscription.save(subscription);
	    }

	    public void deleteSubscription(Subscription subscription) {
			repoSubscription.delete(subscription);
			subscriptionList = repoSubscription.findAll(); // Rafraîchir la liste après la suppression
		}
	    
	    
	    public List<Subscription> getSubscriptionList() {
	        return subscriptionList;
	    }

	    public void setSubscriptionList(List<Subscription> subscriptionList) {
	        this.subscriptionList = subscriptionList;
	    }


		public SubscriptionViewModel getSubscriptionViewModel() {
			return subscriptionViewModel;
		}


		public void setSubscriptionViewModel(SubscriptionViewModel subscriptionViewModel) {
			this.subscriptionViewModel = subscriptionViewModel;
		} 	
	

}
