package ensembles.app.managedbeans;

import javax.faces.bean.ManagedBean;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.inject.Inject;

import ensembles.app.entity.Subscription;
import ensembles.app.repository.RepoSubscription;
@ManagedBean
public class ControllerSubscriptionMangement {
	
	 @Inject
	    private RepoSubscription repoSubscription;

	    private List<Subscription> subscriptionList;

	    @PostConstruct
	    public void init() {
	        subscriptionList = repoSubscription.findAll();
	        System.out.println(subscriptionList);
	    }

	    public List<Subscription> getSubscriptionList() {
	        return subscriptionList;
	    }

	    public void setSubscriptionList(List<Subscription> subscriptionList) {
	        this.subscriptionList = subscriptionList;
	    } 	
	

}
