package ensembles.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {

@Id
@GeneratedValue (strategy= GenerationType.AUTO)
        private Long id;

		private String Email;
		
		private String Password;
			
		
		public User(String email, String password) {
			super();
			Email = email;
			Password = password;
			
		}
		
		

		public User() {
			super();
		}



		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		
		
	}


