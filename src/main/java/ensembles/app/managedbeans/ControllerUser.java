package ensembles.app.managedbeans;


import javax.faces.bean.ManagedBean;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ManagedBean
public class ControllerUser {

@Id
@GeneratedValue (strategy= GenerationType.AUTO)
        private Long id;
		private String Email;
		private String Password;
			
		
		public ControllerUser(String email, String password) {
			super();
			Email = email;
			Password = password;
			
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


