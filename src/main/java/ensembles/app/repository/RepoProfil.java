//package ensembles.app.repository;
//
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//
//
//import ensembles.app.entity.Profil;
//import ensembles.app.utils.HibernateUtil;
//
//@Stateless
//public class RepoProfil {
//	
//	
//	
//
//		 private EntityManager entityManager;
//		
//		public RepoProfil() {
//			
//			this.entityManager=HibernateUtil.createEntityManager();
//		}
//
//		public long persister (Profil profil) {
//			EntityTransaction tx = this.entityManager.getTransaction();
//			tx.begin();
//			this.entityManager.persist(profil);
//			this.entityManager.flush();
//			tx.commit();
//			return profil.getId();
//			
//		}
//	}
//
//
//
