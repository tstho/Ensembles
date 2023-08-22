package ensembles.app.viewmodels;



import ensembles.app.entity.Role;

public class UserViewModel {
	
	@Override
	public String toString() {
		return "UserViewModel [Id=" + Id + ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}
	private Long Id; 
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	private String email;
	private String password;
	private Role role;
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
