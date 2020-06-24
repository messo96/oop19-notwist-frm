package model.base;

import java.util.Optional;

public class Report {

	/* Fields */
	private final int idReport;
	private final Optional<Integer> idDiscuss;
	private final Optional<Integer> idComment;
	private final int idUser;

	private final String descrtiption;
	private boolean pending;

	/* Builder */
	public Report(final int idReport, final Optional<Integer> idDiscuss, final Optional<Integer> idComment,
			final int idUser, final String descrtiption, final boolean pending) {
		this.idReport = idReport;
		this.idDiscuss = idDiscuss;
		this.idComment = idComment;
		this.idUser = idUser;
		this.descrtiption = descrtiption;
		this.pending = pending;
	}

	/* Getter methods */
	public final int getIdReport() {
		return idReport;
	}

	public final Optional<Integer> getIdDiscuss() {
		return idDiscuss;
	}
	
	public final Optional<Integer> getIdComment() {
		return idComment;
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
