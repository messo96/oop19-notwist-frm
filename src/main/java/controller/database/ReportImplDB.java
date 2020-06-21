package controller.database;

import java.util.List;
import java.util.stream.Collectors;

import model.base.Report;
import model.database.ReportDB;

/**
 * 
 * @author Francesco Rombaldoni
 *
 */
public class ReportImplDB {
	private ReportDB dbr = new ReportDB();

	// list of all report in DB
	public List<Report> getAll() {
		return this.dbr.read();
	}

	// list of all report of a user
	public List<Report> getAll(final Integer idUser) {
		return this.dbr.read().stream().filter(R -> R.getIdUser() == idUser).collect(Collectors.toList());
	}

	// crea nuova segnalazione
	public boolean createReport(final Integer idUser, final Integer idDiscussion, final String description) {

		return this.dbr.create(new Report(0, idDiscussion, idUser, description, false));

	}

	// si è risolta una segnalazione
	public boolean setSolved(final Integer idReport) {

		return this.dbr.update(this.dbr.read().stream().filter(R -> R.getIdReport() == idReport).findFirst().get());
	}

	// rimuovi segnalazione
	public boolean removeReport(final Integer idReport) {
		return this.dbr.delete(idReport);
	}

	/* Builder senza argometni */
	public ReportImplDB() {
	}

}
