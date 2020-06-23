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

public class HottestPan extends JPanel {

	private static final long serialVersionUID = 1L;
	private DiscussionImplDB dbdiscussion = new DiscussionImplDB();

	public HottestPan(final User user) {

		drawComp(user);
	}

	private void drawComp(final User user) {
		hottest_panel = new JPanel();
		topdiscussiontable = new JTable() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// Panel Title
		hottest_panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0, 0, 0)), "Hottest Topics", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 14))); // NOI18N
		hottest_panel.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		// Draw Table
		topdiscussiontable.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		model_hot = new DefaultTableModel(new Object[] { "Title", "ID" }, 0);
		topdiscussiontable.setModel(model_hot);
		topdiscussiontable.setFocusable(true);
		topdiscussiontable.setEnabled(true);

		topdiscussiontable.getColumnModel().getColumn(0).setResizable(false);
		topdiscussiontable.getColumnModel().getColumn(0).setPreferredWidth(320);
		topdiscussiontable.removeColumn(topdiscussiontable.getColumnModel().getColumn(1));

		topdiscussiontable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
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
		GroupLayout hottest_panelLayout = new GroupLayout(hottest_panel);
		hottest_panel.setLayout(hottest_panelLayout);
		hottest_panelLayout.setHorizontalGroup(hottest_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(hottest_panelLayout.createSequentialGroup().addContainerGap()
						.addComponent(topdiscussiontable, 210, 210, Short.MAX_VALUE).addContainerGap()));
		hottest_panelLayout.setVerticalGroup(hottest_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						hottest_panelLayout.createSequentialGroup().addContainerGap()
								.addComponent(topdiscussiontable, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
								.addContainerGap()));
		add(hottest_panel);
	}

	private void fillTable() {
		List<DiscussionImpl> list = dbdiscussion.getTopDiscussion().get();
		for (Discussion d : list) {
			model_hot.addRow(new Object[] { d.getTitle(), d.getIdDiscussion() });
		}
		topdiscussiontable.setModel(model_hot);
		topdiscussiontable.revalidate();
	}

	private javax.swing.JPanel hottest_panel;
	private javax.swing.JTable topdiscussiontable;
	private DefaultTableModel model_hot;

}
