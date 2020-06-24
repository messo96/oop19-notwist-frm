package controller.table;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import view.TableDiscussion;

public class Homepage extends JPanel {

	/*
	 *Homepage of the BuildAfterGui, shows the table.
	 */
	private static final long serialVersionUID = 1L;

	public Homepage(final TableDiscussion tableDiscussion) {
		drawComp(tableDiscussion);
	}

	private void drawComp(final TableDiscussion tableDiscussion) {
		tablePanel = new JPanel();
		mainTable = new JScrollPane();

		tablePanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0, 0, 0)), "What's new",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
				new Font("Tahoma", 0, 14))); // NOI18N
		tablePanel.setName(""); // NOI18N

		mainTable.setViewportView(tableDiscussion.getTableDiscussion());
		tableDiscussion.refreshTableDiscussion();

		GroupLayout tablePanelLayout = new GroupLayout(tablePanel);
		tablePanel.setLayout(tablePanelLayout);
		tablePanelLayout.setHorizontalGroup(tablePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(tablePanelLayout.createSequentialGroup().addContainerGap()
								.addComponent(mainTable, GroupLayout.PREFERRED_SIZE, 730,
								GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		tablePanelLayout.setVerticalGroup(tablePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(tablePanelLayout.createSequentialGroup().addGap(4, 4, 4)
								.addComponent(mainTable, GroupLayout.PREFERRED_SIZE, 350,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addContainerGap(14, Short.MAX_VALUE)));
		add(tablePanel);
	}

	// Variables declaration - do not modify
	private JPanel tablePanel;
	private JScrollPane mainTable;
	// End of variables declaration.
}
