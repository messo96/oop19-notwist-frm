package controller.database;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.base.Report;
import model.database.ReportDB;

public class ReportImplCommentDB {

	private ReportDB dbr = new ReportDB();

	// list of all report in DB
	public final List<Report> getAll() {
		return this.dbr.read().stream().filter(r -> r.getIdComment().isPresent()).collect(Collectors.toList());
	}

	// list of all report of a user
	public final List<Report> getAll(final Integer idUser) {
		return this.getAll().stream().filter(u -> u.getIdUser() == idUser).collect(Collectors.toList());
	}

	// crea nuova segnalazione
	public final boolean createReport(final Integer idUser, final Integer idComment, final String description) {

		return this.dbr.create(new Report(0, Optional.empty(), Optional.of(idComment), idUser, description, false));

	}

	public final Integer numberOfReport(final Integer idDiscussion, final Integer idComment) {
		return this.getAll().stream()
				.filter(r -> r.getIdDiscuss().get() == idDiscussion && r.getIdComment().get() == idComment)
				.collect(Collectors.toList()).size();
	}

	// si è risolta una segnalazione
	public final boolean setSolved(final Integer idReport) {

		return this.dbr.update(this.dbr.read().stream().filter(R -> R.getIdReport() == idReport).findFirst().get());
	}

	// rimuovi segnalazione
	public final boolean removeReport(final Integer idReport) {
		return this.dbr.delete(idReport);
	}

}
