package view.util;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class RulesPan extends JPanel {

private static final long serialVersionUID = 1L;

	/**
	 * Creates panel for NewTopic Rules.
	 */
	public RulesPan() {
		initComponents();
	}

	private void initComponents() {

		rulesPanel = new JPanel();
		rulesScroll = new JScrollPane();
		rulesArea = new JEditorPane("text/html", "");

		rulesPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(194, 192, 192)), "Regole della Community",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 14))); // NOI18N

		rulesScroll.setEnabled(false);
		rulesScroll.setOpaque(false);

		importRules();

		rulesArea.setEnabled(false);
		rulesScroll.setViewportView(rulesArea);
		GroupLayout rulesPanelLayout = new GroupLayout(rulesPanel);
		rulesPanel.setLayout(rulesPanelLayout);
		rulesPanelLayout.setHorizontalGroup(rulesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(rulesPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(rulesScroll, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		rulesPanelLayout.setVerticalGroup(rulesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						rulesPanelLayout.createSequentialGroup().addContainerGap()
								.addComponent(rulesScroll, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		add(rulesPanel);
	}

	private JScrollPane rulesScroll;
	private JEditorPane rulesArea;
	private JPanel rulesPanel;
	
	private void importRules() {
			BufferedReader buf;
			InputStreamReader in = new InputStreamReader(this.getClass().getResourceAsStream("/docs/Rules.txt"));
			try {
				buf = new BufferedReader(in);
				rulesArea.read(buf, null);
			} catch (IOException e) {
				System.out.println("File Rules.txt non trovato! ");
				e.printStackTrace();
			}
	}

}
