package user;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import controller.database.CommentsImplDB;
import controller.database.DiscussionImplDB;
import controller.database.ReportImplDiscussionDB;
import controller.database.UserImplDB;
import model.base.DiscussionImpl;
import model.base.Report;
import model.base.User;
import view.topic.TopicPan;

public class UserDiscussions extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private ReportImplDiscussionDB dbreport = new ReportImplDiscussionDB();
	private CommentsImplDB dbcomment = new CommentsImplDB();
	private DiscussionImplDB dbdiscussion = new DiscussionImplDB();
	private User user;
	private Report report;

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

		jPanel3 = new javax.swing.JPanel();
		jScrollPane13 = new javax.swing.JScrollPane();
		jTable3 = new javax.swing.JTable();
		JButton btn = new JButton();
		reportDialog = new javax.swing.JDialog();
		containerDialog = new javax.swing.JPanel();
		titleDialog = new javax.swing.JTextField();
		deletebtn = new javax.swing.JButton();
		discussionScroll = new javax.swing.JScrollPane();
		discussionArea = new javax.swing.JEditorPane();
		username = new javax.swing.JTextField();
		ignorebtn = new javax.swing.JButton();
		nReport = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();

		reportDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		reportDialog.setTitle("Report Discussione");

		titleDialog.setText("Titolo");

		discussionScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		discussionScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		discussionScroll.setViewportView(discussionArea);

		discussionArea.setText("Discussione");

		jLabel1.setText("Creata da:");
		username.setText("username");
		jLabel2.setText("Numero report:");
		nReport.setText("numReport");

		deletebtn.setText("Cancella");
		deletebtn.addActionListener(e -> {
			if (report != null)
				dbreport.removeReport(report.getIdReport());
		});
		ignorebtn.setText("Ignora");

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(containerDialog);
		containerDialog.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGap(21, 21, 21).addGroup(jPanel4Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(discussionScroll).addComponent(username)
						.addGroup(jPanel4Layout.createSequentialGroup()
								.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel1)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(titleDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 163,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(ignorebtn))
								.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel4Layout.createSequentialGroup().addGap(143, 143, 143)
												.addComponent(deletebtn))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout
												.createSequentialGroup()
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jLabel2).addGap(18, 18, 18)
												.addComponent(nReport, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
														javax.swing.GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(21, Short.MAX_VALUE)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGap(20, 20, 20)
						.addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(discussionScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 151,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(titleDialog, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1)
								.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(nReport, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(ignorebtn).addComponent(deletebtn))
						.addContainerGap(18, Short.MAX_VALUE)));

		reportDialog.add(containerDialog);

		jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Attività"));
		jPanel3.setAutoscrolls(true);

		if (user.isModerator()) {
			model = new DefaultTableModel(new Object[] { "Discussion", "Report", "ID" }, 0);
			fillTableMod(jTable3);
			jTable3.addMouseListener(new MouseAdapter() {
				public void mousePressed(final MouseEvent mouseEvent) {
					DiscussionImpl disc = dbdiscussion
							.getDiscussion(Integer
									.parseInt(jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 2).toString()))
							.get();
					username.setText(new UserImplDB().getUser(disc.getIdUser()).get().getUsername());
					nReport.setText(String.valueOf(dbreport.numberOfReport(report.getIdDiscuss().get())));

//					reportDialog.getContentPane();
//					reportDialog.setSize(600, 500);
//					reportDialog.pack();
//					reportDialog.setLocationRelativeTo(getParent());
//					reportDialog.setVisible(true);
				}
			});

		} else {
			model = new DefaultTableModel(new Object[] { "Titolo", "Category", "ID", "N.Commenti" }, 0);
			fillTable(jTable3);
			jTable3.addMouseListener(new MouseAdapter() {
				public void mousePressed(final MouseEvent mouseEvent) {
					DiscussionImpl disc = dbdiscussion
							.getDiscussion(Integer
									.parseInt(jTable3.getModel().getValueAt(jTable3.getSelectedRow(), 2).toString()))
							.get();
					JFrame fr = new JFrame();
					fr.setContentPane(new TopicPan(disc, user));
					fr.pack();
					fr.setVisible(true);
				}
			});
		}

		jScrollPane13.setViewportView(jTable3);
		if (jTable3.getColumnModel().getColumnCount() > 0) {
			jTable3.getColumnModel().getColumn(0).setResizable(false);
			jTable3.getColumnModel().getColumn(0).setPreferredWidth(450);
			jTable3.getColumnModel().getColumn(1).setResizable(false);
			jTable3.removeColumn(jTable3.getColumnModel().getColumn(2));

		}

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addComponent(jScrollPane13,
						javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 6, Short.MAX_VALUE)));
		btn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnMouseClicked(evt);
			}
		});
		add(btn);
		add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 650, 240));

	}

	private void fillTableMod(final JTable table) {
		model.getDataVector().removeAllElements();
		for (Report r : dbreport.getAll()) {
			model.addRow(new Object[] { dbdiscussion.getDiscussion(r.getIdDiscuss().get()).get().getTitle(),
					r.getDescrtiption(), r.getIdDiscuss().get() });
		}
		table.setModel(model);
	}

	private void fillTable(final JTable table) {
		model.getDataVector().removeAllElements();
		for (DiscussionImpl d : dbdiscussion.getDiscussions(user.getId()).get()) {
			model.addRow(new Object[] { d.getTitle(), d.getCategory().getName(), d.getIdDiscussion(),
					dbcomment.getComments(d.getIdDiscussion()).get().size() });
		}
		table.setModel(model);
	}

	private void btnMouseClicked(java.awt.event.MouseEvent evt) {
		try {

			reportDialog.getContentPane();
			reportDialog.setSize(600, 500);
			reportDialog.pack();
			reportDialog.setLocationRelativeTo(getParent());
			reportDialog.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private javax.swing.JPanel jPanel3;

	private javax.swing.JScrollPane jScrollPane13;

	private javax.swing.JTable jTable3;

	private javax.swing.JButton deletebtn;
	private javax.swing.JButton ignorebtn;
	private javax.swing.JDialog reportDialog;
	private javax.swing.JEditorPane discussionArea;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel containerDialog;
	private javax.swing.JScrollPane discussionScroll;
	private javax.swing.JTextField titleDialog;
	private javax.swing.JTextField username;
	private javax.swing.JTextField nReport;

}
