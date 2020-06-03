package main;

import model.base.Discussion;
import model.base.User;


public class Emily {

	private User u;
	private Discussion d;
	
	public Emily(User u, Discussion d) {
		this.u = u;
		this.d = d;
	}

	public User getU() {
		return u;
	}

	public Discussion getD() {
		return d;
	}
	
	
	
}
