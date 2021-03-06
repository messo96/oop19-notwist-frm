package controller.database;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.base.Report;
import model.database.ReportDB;

/**
 *
 *
 */
public class ReportImplDiscussionDB {

	private ReportDB dbr = new ReportDB();

	// list of all report in DB
	public final List<Report> getAll() {
		return this.dbr.read().stream().filter(r -> r.getIdDiscuss().isPresent()).collect(Collectors.toList());
	}

	// list of all report of a user
	public final List<Report> getAll(final Integer idUser) {
		return this.getAll().stream().filter(R -> R.getIdUser() == idUser).collect(Collectors.toList());
	}

	// create a new report
	public final boolean createReport(final Integer idUser, final Integer idDiscussion, final String description) {

		return this.dbr.create(new Report(0, Optional.of(idDiscussion), Optional.empty(), idUser, description, false));

	}
	
	public final Integer numberOfReport(final Integer idDiscussion) {
		return this.getAll().stream()
				.filter(r -> r.getIdDiscuss().get() == idDiscussion && r.getIdComment().isEmpty())
				.collect(Collectors.toList()).size();
	}

	// report solved
	public final boolean setSolved(final Integer idReport) {

		return this.dbr.update(this.dbr.read().stream().filter(R -> R.getIdReport() == idReport).findFirst().get());
	}

	// remove report
	public final boolean removeReport(final Integer idReport) {
		return this.dbr.delete(idReport);
	}

}
