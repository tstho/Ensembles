package ensembles.app.repository;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import ensembles.app.entity.Client;
import ensembles.app.utils.HibernateUtil;

@Stateless
public class RepoClient {
	
	
	 private EntityManager entityManager;
	
	
	    public RepoClient (){
	        this.entityManager = HibernateUtil.createEntityManager();
	    }

	    public Long persister(Client client) {
	        // TODO
	    	 //EntityTransaction tx = this.entityManager.getTransaction();
	        //tx.begin();
	        this.entityManager.persist(client);
	        // On appelle le flush pour forcer l'EM a persister et 
	        // affecter un identifiant à l'entité 
	        this.entityManager.flush();
	        //tx.commit();
	        return client.getId();
	        
	    }

	    public void insertClient(String client) {
		     
	 	   EntityTransaction transaction = this.entityManager.getTransaction();
	 	   transaction.begin();
	 	   entityManager.createQuery(client);
	 	   transaction.commit();
	    }
	    public Optional<Client> rechercheParId(Long identifiantClient) {
	    	
	    return Optional.ofNullable(entityManager.find(Client.class, identifiantClient));
	        
	    }

	    public void supprimerClient(Client client) {
	     
	   EntityTransaction transaction = this.entityManager.getTransaction();
	   transaction.begin();
	   entityManager.remove(client);
	   transaction.commit();
	    	
	    }

	    public Client modifierClient(Client client) {
	        // TODO
	    	 EntityTransaction transaction = this.entityManager.getTransaction();
	         transaction.begin();
	         Client mergedClient = entityManager.merge(client);
	         transaction.commit();
	         return mergedClient;
	     };
	    

	    public void closeEntityManager() {
	        entityManager.close();
	    }


}
