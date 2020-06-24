package controller.table;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.database.DiscussionImplDB;
import model.base.Discussion;
import model.base.DiscussionImpl;
import model.base.User;
import view.topic.TopicPan;

public class TopPan extends JPanel {
/*
 * Shows the most answered discussions (which means more attention).
 */
	private static final long serialVersionUID = 1L;
	private DiscussionImplDB dbdiscussion = new DiscussionImplDB();

	public TopPan(final User user) {

		drawComp(user);
	}

	private void drawComp(final User user) {
		topPanel = new JPanel();
		topdiscussiontable = new JTable() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(final int row, final int column) {
				return false;
			}
		};
		// Panel Title
		topPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0, 0, 0)), "Hottest Topics", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 14))); // NOI18N
		topPanel.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		// Draw Table
		topdiscussiontable.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		modelHot = new DefaultTableModel(new Object[] { "Title", "ID" }, 0);
		topdiscussiontable.setModel(modelHot);
		topdiscussiontable.setFocusable(true);
		topdiscussiontable.setEnabled(true);

		topdiscussiontable.getColumnModel().getColumn(0).setResizable(false);
		topdiscussiontable.getColumnModel().getColumn(0).setPreferredWidth(320);
		topdiscussiontable.removeColumn(topdiscussiontable.getColumnModel().getColumn(1));

		topdiscussiontable.addMouseListener(new MouseAdapter() {
			public void mousePressed(final MouseEvent mouseEvent) {
				DiscussionImpl disc = dbdiscussion.getDiscussion(Integer.parseInt(
						topdiscussiontable.getModel().getValueAt(topdiscussiontable.getSelectedRow(), 1).toString()))
						.get();
				JFrame fr = new JFrame();
				fr.setContentPane(new TopicPan(disc, user));
				fr.pack();
				fr.setVisible(true);
				topdiscussiontable.setFocusable(false);
				topdiscussiontable.setFocusable(true);
			}
		});

		topdiscussiontable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		topdiscussiontable.setAutoscrolls(false);
		topdiscussiontable.setRowHeight(25);
		topdiscussiontable.getTableHeader().setReorderingAllowed(false);
		fillTable();
		GroupLayout topPanelLayout = new GroupLayout(topPanel);
		topPanel.setLayout(topPanelLayout);
		topPanelLayout.setHorizontalGroup(topPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(topPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(topdiscussiontable, 210, 210, Short.MAX_VALUE).addContainerGap()));
		topPanelLayout.setVerticalGroup(topPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						topPanelLayout.createSequentialGroup().addContainerGap()
								.addComponent(topdiscussiontable, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
								.addContainerGap()));
		add(topPanel);
	}

	private void fillTable() {
		List<DiscussionImpl> list = dbdiscussion.getTopDiscussion().get();
		for (Discussion d : list) {
			modelHot.addRow(new Object[] { d.getTitle(), d.getIdDiscussion() });
		}
		topdiscussiontable.setModel(modelHot);
		topdiscussiontable.revalidate();
	}

	private JPanel topPanel;
	private JTable topdiscussiontable;
	private DefaultTableModel modelHot;

}
