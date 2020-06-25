package user;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;

import controller.database.CommentsImplDB;
import controller.database.DiscussionImplDB;
import model.base.DiscussionImpl;
import model.base.User;
import view.topic.TopicPan;

public class UserDiscussions extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private CommentsImplDB dbcomment = new CommentsImplDB();
	private DiscussionImplDB dbdiscussion = new DiscussionImplDB();
	private User user;

	/**
	 * Shows the activies of a certain user.
	 * 
	 * @param user
	 */
	public UserDiscussions(final User user) {
		this.user = user;
		initComponents();
	}

	private void initComponents() {

		tableHolder = new JPanel();
		tableScroll = new JScrollPane();
		discussionTable = new JTable();

		tableHolder.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(new Color(0, 0, 0)), "Le mie discussioni"));
		tableHolder.setAutoscrolls(true);

			model = new DefaultTableModel(new Object[] { "Titolo", "Categoria", "ID", "N.Commenti" }, 0);
			fillTable(discussionTable);
			discussionTable.addMouseListener(new MouseAdapter() {
				public void mousePressed(final MouseEvent mouseEvent) {
					DiscussionImpl disc = dbdiscussion
							.getDiscussion(Integer
									.parseInt(discussionTable.getModel().getValueAt(discussionTable.getSelectedRow(), 2).toString()))
							.get();
					JFrame fr = new JFrame();
					Image icon = Toolkit.getDefaultToolkit()
							.getImage(this.getClass().getClassLoader().getResource("img/icon.jpg.png"));
					fr.setIconImage(icon);
					fr.setResizable(false);
					fr.setContentPane(new TopicPan(disc, user));
					fr.pack();
					fr.setVisible(true);
				}
			});

		tableScroll.setViewportView(discussionTable);
		if (discussionTable.getColumnModel().getColumnCount() > 0) {
			discussionTable.getColumnModel().getColumn(0).setResizable(false);
			discussionTable.getColumnModel().getColumn(0).setPreferredWidth(450);
			discussionTable.getColumnModel().getColumn(1).setResizable(false);
			discussionTable.removeColumn(discussionTable.getColumnModel().getColumn(2));

		}

		GroupLayout jPanel3Layout = new GroupLayout(tableHolder);
		tableHolder.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addComponent(tableScroll, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addComponent(tableScroll,
						GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 6, Short.MAX_VALUE)));

		add(tableHolder, new AbsoluteConstraints(10, 340, 650, 240));

	}



	private void fillTable(final JTable table) {
		model.getDataVector().removeAllElements();
		for (DiscussionImpl d : dbdiscussion.getDiscussions(user.getId()).get()) {
			model.addRow(new Object[] { d.getTitle(), d.getCategory().getName(), d.getIdDiscussion(),
					dbcomment.getComments(d.getIdDiscussion()).get().size() });
		}
		
		table.setModel(model);
	}
	private JPanel tableHolder;
	private JScrollPane tableScroll;
	private JTable discussionTable;
}
