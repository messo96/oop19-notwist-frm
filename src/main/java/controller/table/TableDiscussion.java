package controller.table;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.stream.Collectors;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.base.Category;
import model.base.CommentsImplements;
import model.base.Discussion;
import model.base.DiscussionImpl;
import model.base.User;
import model.database.DBComments;
import model.database.DBDiscussion;
import model.database.DBLikeDislike;
import model.database.DBLikeDislikeImpl;
import model.database.DBDiscussion;
import model.database.DBUserImpl;
import model.database.Dao;
import rombo.new_class.CommentsImplement;
import topic_gui.Topic_gui;

public class TableDiscussion {

	private JTable tableDiscussion;
	private DefaultTableModel modelDiscussion;
	private DBLikeDislike dblike = new DBLikeDislikeImpl();
	private Dao<CommentsImplement> dbcomment = new DBComments();
	private Dao<DiscussionImpl> dbdiscussion = new DBDiscussion();

	public TableDiscussion(final User user) {
		tableDiscussion = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tableDiscussion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		modelDiscussion = new DefaultTableModel(
				new Object[] { "Titolo", "Categoria", "Like", "Created By", "Risposte", "ID" }, 0);
		tableDiscussion.setModel(modelDiscussion);

		tableDiscussion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
		tableDiscussion.setAutoscrolls(false);
		tableDiscussion.setEnabled(true);
		tableDiscussion.setGridColor(new java.awt.Color(0, 0, 0));
		tableDiscussion.setShowGrid(true);
		if (tableDiscussion.getColumnModel().getColumnCount() > 0) {
			tableDiscussion.getColumnModel().getColumn(0).setResizable(false);
			tableDiscussion.getColumnModel().getColumn(1).setResizable(false);
			tableDiscussion.getColumnModel().getColumn(2).setResizable(false);
			tableDiscussion.getColumnModel().getColumn(3).setResizable(false);
			tableDiscussion.getColumnModel().getColumn(4).setResizable(false);
			tableDiscussion.getColumnModel().getColumn(5).setResizable(false);

		}
		tableDiscussion.getColumnModel().getColumn(0).setPreferredWidth(320);
		tableDiscussion.getColumnModel().getColumn(1).setPreferredWidth(108);
		tableDiscussion.getColumnModel().getColumn(2).setPreferredWidth(60);
		tableDiscussion.getColumnModel().getColumn(3).setPreferredWidth(60);
		tableDiscussion.getColumnModel().getColumn(4).setPreferredWidth(90);
		tableDiscussion.getColumnModel().getColumn(5).setPreferredWidth(0);

		tableDiscussion.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 2) {

					Discussion disc = dbdiscussion
							.getAll().stream().filter(d -> d.getIdDiscussion() == Integer.parseInt(tableDiscussion
									.getModel().getValueAt(tableDiscussion.getSelectedRow(), 5).toString()))
							.findFirst().get();
					new Topic_gui(disc, user);
				}
			}
		});

	}

	public JTable getTableDiscussion() {
		return tableDiscussion;
	}

	public DefaultTableModel getModelDiscussion() {
		return modelDiscussion;
	}

	/*--------------UTIL METHODS?? ----------*/

	public void refreshTableDiscussion() {
		this.getModelDiscussion().getDataVector().removeAllElements();
		loadDiscussion(this.getModelDiscussion());
		tableDiscussion.setModel(this.getModelDiscussion());
		tableDiscussion.revalidate();
	}

	public void refreshTableDiscussion(Category category) {
		this.getModelDiscussion().getDataVector().removeAllElements();
		loadDiscussion(this.getModelDiscussion(), category);
		tableDiscussion.setModel(this.getModelDiscussion());
		tableDiscussion.revalidate();
	}

	public void refreshTableDiscussion(String filter) {
		this.getModelDiscussion().getDataVector().removeAllElements();
		loadDiscussion(this.getModelDiscussion(), filter);
		tableDiscussion.setModel(this.getModelDiscussion());
		tableDiscussion.revalidate();
	}

	private void loadDiscussion(DefaultTableModel model) {
		for (Discussion s : dbdiscussion.getAll()) {
			model.addRow(new Object[] {
					s.getTitle(), s.getCategory().getName(), dblike.getLike(s.getIdDiscussion()), new DBUserImpl()
							.getAll().stream().filter(u -> u.getId() == s.getIdUser()).findFirst().get().getUsername(),
					(int) dbcomment.getAll().stream().filter(c -> c.GetIDDiscussion().get() == s.getIdDiscussion())
					.count(), s.getIdDiscussion() });
		}
	}

	private void loadDiscussion(DefaultTableModel model, final Category category) {
		for (Discussion s : dbdiscussion.getAll().stream().filter(d -> d.getCategory().getId() == category.getId())
				.collect(Collectors.toList())) {
			model.addRow(new Object[] { s.getTitle(), s.getCategory().getName(), dblike.getLike(s.getIdDiscussion()),
					new DBUserImpl().getAll().stream().filter(u -> u.getId() == s.getIdUser()).findFirst().get()
							.getUsername(),
					(int) dbcomment.getAll().stream().filter(c -> c.GetIDDiscussion().get() == s.getIdDiscussion())
							.count(),
					s.getIdDiscussion() });
		}
	}

	private void loadDiscussion(DefaultTableModel model, final String filter) {
		for (Discussion s : dbdiscussion.getAll().stream().filter(d -> d.getTitle().contains(filter))
				.collect(Collectors.toList())) {
			model.addRow(new Object[] {
					s.getTitle(), s.getCategory().getName(), dblike.getLike(s.getIdDiscussion()), new DBUserImpl()
							.getAll().stream().filter(u -> u.getId() == s.getIdUser()).findFirst().get().getUsername(),
							(int) dbcomment.getAll().stream().filter(c -> c.GetIDDiscussion().get() == s.getIdDiscussion())
							.count(), s.getIdDiscussion() });
		}
	}

}
