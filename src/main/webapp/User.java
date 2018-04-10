package main.webapp;

public class User {
	private String username;
	private String password;
	private String email;
	private boolean premium;
	private boolean admin;
	
	public User(String username,String password, String email){
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isPremium() {
		return premium;
	}
	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public void updateChanges(){
		
	}
}
