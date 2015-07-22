package backend;

import frontend.Driver;

public class User {
	
	
	private String firstName;
	private String lastName;
	private String loginName;
	private String loginPass;
	private String email;
	
	
	public User(String firstName, String lastName, String loginName,
			String loginPass, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginName = loginName;
		this.loginPass = loginPass;
		this.email = email;
		
	}

	
	public String getFirstName() {
		return firstName;
	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
	public String getLastName() {
		return lastName;
	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
	public String getLoginName() {
		return loginName;
	}
//	public void setLoginName(String loginName) {
//		this.loginName = loginName;
//	}
	public String getLoginPass() {
		return loginPass;
	}
//	public void setLoginPass(String loginPass) {
//		this.loginPass = loginPass;
//	}
	public String getEmail() {
		return email;
	}
//	public void setEmail(String email) {
//		this.email = email;
//	}

}
