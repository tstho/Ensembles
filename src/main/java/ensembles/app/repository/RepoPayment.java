package ensembles.app.repository;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ensembles.app.entity.Payment;

@Stateless
public class RepoPayment {
	
		@PersistenceContext
		private EntityManager entityManager;
		
		public Long save(Payment payment) {
			entityManager.persist(payment);
			entityManager.flush();
			return payment.getId();
		}

	}



