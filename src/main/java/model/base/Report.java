package model.base;

public class Report {
 
	/*Fields*/
	private final int idReport;
	private final int idDiscuss;
	private final int idUser;
	
	private final String descrtiption;
	private boolean pending;
	
	/*Builkder*/
	public Report(int idReport, int idDiscuss, int idUser, String descrtiption, boolean pending) {
		this.idReport = idReport;
		this.idDiscuss = idDiscuss;
		this.idUser = idUser;
		this.descrtiption = descrtiption;
		this.pending = pending;
	}

	
	/*Getter methods*/
	public int getIdReport() {
		return idReport;
	}

	public int getIdDiscuss() {
		return idDiscuss;
	}

	public int getIdUser() {
		return idUser;
	}

	public String getDescrtiption() {
		return descrtiption;
	}

	public boolean isPending() {
		return pending;
	}

	
}
