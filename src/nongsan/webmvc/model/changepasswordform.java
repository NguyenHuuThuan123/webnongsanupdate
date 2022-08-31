package nongsan.webmvc.model;

public class changepasswordform {
	private String email;
	private String password;
	private String confirmpassword;
	private String currenpassword;
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
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getCurrenpassword() {
		return currenpassword;
	}
	public void setCurrenpassword(String currenpassword) {
		this.currenpassword = currenpassword;
	}
	public changepasswordform() {
		
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.currenpassword = currenpassword;
	}
	
}
