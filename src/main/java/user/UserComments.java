package user;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import controller.database.CommentsImplDB;
import controller.database.ReportImplCommentDB;
import controller.database.UserImplDB;
import rombo.new_class.CommentsImplement;
import model.base.Report;
import model.base.User;

public class UserComments extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private ReportImplCommentDB dbreport = new ReportImplCommentDB();
	private CommentsImplDB dbcomment = new CommentsImplDB();
	private CommentsImplement comment;
	private User user;

	/**
	 * Shows the activies of a certain user.
	 */
	public UserComments(User user) {
		this.user = user;
		initComponents();
	}

	private void initComponents() {

		JButton btn = new JButton();

		jPanel2 = new javax.swing.JPanel();
		jScrollPane12 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();

		discussionScroll = new javax.swing.JScrollPane();
		discussionArea = new javax.swing.JEditorPane();
		userName = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jTextField9 = new javax.swing.JTextField();
		delAddbtn = new javax.swing.JButton();
		delbtn = new javax.swing.JButton();
		nReportLabel = new JLabel();
		jTextField10 = new JTextField();
		titleDiscussion = new JTextField();
		ignoreBtn = new JButton();

		commentPanel = new JPanel();
		commentScroll = new JScrollPane();
		commentArea = new JEditorPane();
		commentDialog = new JDialog();

		commentDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		commentDialog.setTitle("Report Commento");

		discussionScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		discussionScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		discussionScroll.setViewportView(discussionArea);

		userName.setText("username");

		jLabel4.setText("User");

		jLabel6.setText("N.Strike");

		jTextField9.setText("nStrike");

		delAddbtn.setText("Cancella e Aggiungi Strike");
		delbtn.setText("Cancella");
		ignoreBtn.setText("Ignora");
		nReportLabel.setText("nReport");

		jTextField10.setText("nReport");

		commentScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		commentScroll.setViewportView(commentArea);

		titleDiscussion.setText("Titolo");

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(commentPanel);
		commentPanel.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel4Layout.createSequentialGroup().addComponent(ignoreBtn).addGap(104, 104, 104)
								.addComponent(delbtn).addGap(18, 18, 18).addComponent(delAddbtn))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(titleDiscussion, javax.swing.GroupLayout.PREFERRED_SIZE, 116,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel4Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel4)
												.addGap(18, 18, 18)
												.addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 116,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(28, 28, 28).addComponent(nReportLabel)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel6)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(commentScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 415,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(discussionScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 415,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap()));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(titleDiscussion, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(discussionScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 151,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(commentScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(nReportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(ignoreBtn).addComponent(delAddbtn).addComponent(delbtn))
						.addContainerGap()));

		commentDialog.add(commentPanel);

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Attività"));
		jPanel2.setAutoscrolls(true);

		if (user.isModerator()) {
			model = new DefaultTableModel(new Object[] { "Commento", "Number", "IdDisc", "IdComm" }, 0);
			fillTableMod(jTable2);
			jTable2.addMouseListener(new MouseAdapter() {
				public void mousePressed(final MouseEvent mouseEvent) {
					Integer idDisc = Integer.valueOf(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 2).toString());
					Integer idComm = Integer.valueOf(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 3).toString());
					comment = dbcomment.getComments(idDisc).get().stream().filter(c -> c.getIDComment().get() == idComm).findFirst().get();
					userName.setText(new UserImplDB().getUser(comment.getIDUser()).get().getUsername());
					commentDialog.getContentPane();
					commentDialog.setResizable(false);
					commentDialog.pack();
					commentDialog.setLocationRelativeTo(getParent());
					commentDialog.setVisible(true);
				}
			});
		}

			javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
			jPanel2.setLayout(jPanel2Layout);
			jPanel2Layout.setHorizontalGroup(jPanel2Layout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
							.addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
							.addContainerGap()));
			jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jScrollPane12,
							javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGap(6, 6, 6)));

			btn.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					btnMouseClicked(evt);
				}
			});
			add(btn);
			add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 650, 240));

		}


	private void fillTableMod(JTable table) {
		model.getDataVector().removeAllElements();
		for (Report r : dbreport.getAll()) {
			model.addRow(new Object[] { "AA",
					dbreport.numberOfReport(r.getIdDiscuss().get(), r.getIdComment().get()), r.getIdDiscuss(),
					r.getIdComment().get() });
		}
		table.setModel(model);
	}

	private void btnMouseClicked(java.awt.event.MouseEvent evt) {
		try {

			commentDialog.getContentPane();
			commentDialog.setResizable(false);
			commentDialog.pack();
			commentDialog.setLocationRelativeTo(getParent());
			commentDialog.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private javax.swing.JPanel jPanel2;

	private javax.swing.JScrollPane jScrollPane12;

	private javax.swing.JTable jTable2;

	private javax.swing.JButton ignoreBtn;

	private javax.swing.JButton delAddbtn;
	private javax.swing.JButton delbtn;

	private javax.swing.JEditorPane discussionArea;

	private javax.swing.JLabel jLabel4;

	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel nReportLabel;

	private javax.swing.JScrollPane discussionScroll;

	private javax.swing.JTextField jTextField10;
	private javax.swing.JTextField titleDiscussion;

	private javax.swing.JTextField userName;

	private javax.swing.JTextField jTextField9;

	private JDialog commentDialog;
	private javax.swing.JPanel commentPanel;
	private javax.swing.JEditorPane commentArea;
	private JScrollPane commentScroll;

}