package controller.table;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.database.CommentsImplDB;
import controller.database.DiscussionImplDB;
import controller.database.LikeDislikeImplDiscussionDB;
import controller.database.UserImplDB;
import model.base.Category;
import model.base.Discussion;
import model.base.DiscussionImpl;
import model.base.User;
import topic.TopicPan;

public class TableDiscussion {

	private JTable tableDiscussion;
	private DefaultTableModel modelDiscussion;
	private LikeDislikeImplDiscussionDB dblike = new LikeDislikeImplDiscussionDB();
	private CommentsImplDB dbcomment = new CommentsImplDB();
	private UserImplDB dbuser = new UserImplDB();
	private DiscussionImplDB dbdiscussion = new DiscussionImplDB();

	public TableDiscussion(final User user) {
		tableDiscussion = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tableDiscussion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		modelDiscussion = new DefaultTableModel(
				new Object[] { "Titolo", "Categoria", "Like", "Dislike", "Created By", "Risposte", "ID" }, 0);
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
		tableDiscussion.getColumnModel().getColumn(5).setPreferredWidth(90);
		tableDiscussion.removeColumn(tableDiscussion.getColumnModel().getColumn(6));

		tableDiscussion.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 2) {

					DiscussionImpl disc = dbdiscussion.getDiscussion(Integer.parseInt(
							tableDiscussion.getModel().getValueAt(tableDiscussion.getSelectedRow(), 6).toString()))
							.get();
					JFrame fr = new JFrame();
					fr.setContentPane(new TopicPan(disc, user));
					fr.pack();
					fr.setVisible(true);
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
			model.addRow(new Object[] { s.getTitle(), s.getCategory().getName(), dblike.getLikes(s.getIdDiscussion()),
					dblike.getDislikes(s.getIdDiscussion()), dbuser.getUser(s.getIdUser()).get().getUsername(),
					dbcomment.getComments(s.getIdDiscussion()).get().size(), s.getIdDiscussion() });
		}
	}

	private void loadDiscussion(DefaultTableModel model, final Category category) {
		for (Discussion s : dbdiscussion.getDiscussion(category).get()) {
			model.addRow(new Object[] { s.getTitle(), s.getCategory().getName(), dblike.getLikes(s.getIdDiscussion()),
					dblike.getDislikes(s.getIdDiscussion()), dbuser.getUser(s.getIdUser()).get().getUsername(),
					dbcomment.getComments(s.getIdDiscussion()).get().size(), s.getIdDiscussion() });
		}
	}

	private void loadDiscussion(DefaultTableModel model, final String filter) {
		for (Discussion s : dbdiscussion.getDiscussion(filter).get()) {
			model.addRow(new Object[] { s.getTitle(), s.getCategory().getName(), dblike.getLikes(s.getIdDiscussion()),
					dblike.getDislikes(s.getIdDiscussion()), dbuser.getUser(s.getIdUser()).get().getUsername(),
					dbcomment.getComments(s.getIdDiscussion()).get().size(), s.getIdDiscussion() });
		}
	}

}
