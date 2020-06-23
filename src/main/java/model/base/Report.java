package model.base;

public class Report {
	
	/* Fields */
	private final int idReport;
	private final int idDiscuss;
	private final int idUser;

	private final String descrtiption;
	private boolean pending;

	/* Builder */
	public Report(final int idReport, final int idDiscuss, final int idUser, final String descrtiption,
			final boolean pending) {
		this.idReport = idReport;
		this.idDiscuss = idDiscuss;
		this.idUser = idUser;
		this.descrtiption = descrtiption;
		this.pending = pending;
	}

	/* Getter methods */
	public final int getIdReport() {
		return idReport;
	}

	public final int getIdDiscuss() {
		return idDiscuss;
	}

	public final int getIdUser() {
		return idUser;
	}

	public final String getDescrtiption() {
		return descrtiption;
	}

	public final boolean isPending() {
		return pending;
	}

}
