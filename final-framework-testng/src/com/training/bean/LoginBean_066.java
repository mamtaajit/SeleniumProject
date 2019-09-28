package com.training.bean;

public class LoginBean_066 
{
	private String yourname;
	private String youremail;
	private String yoursubj;
	private String yourmessage;


	public LoginBean_066() 
	{
	}

	public LoginBean_066(String yourname, String youremail, String yoursubj, String yourmessage) {
		super();
		this.yourname = yourname;
		this.youremail = youremail;
		this.yoursubj = yoursubj;
		this.yourmessage = yourmessage;
	}

	public String getyourname() 
	{
		return yourname;
	}

	public void setyourname(String yourname) {
		this.yourname = yourname;
	}

	public String getyouremail() {
		return youremail;
	}

	public void setyouremail(String youremail) {
		this.youremail = youremail;
	}
	
	public String getyoursubj() {
		return yoursubj;
	}

	public void setyoursubj(String yoursubj) {
		this.yoursubj = yoursubj;
	}

	
	public String getyourmessage() {
		return yourmessage;
	}

	public void setyourmessage(String yourmessage) {
		this.yourmessage = yourmessage;
	}


	@Override
	public String toString() {
		return "LoginBean_066 [yourname=" + yourname + ", youremail=" + youremail + " +yoursubj" + yoursubj + ", yourmessage=" + yourmessage + "]";
	}

}
