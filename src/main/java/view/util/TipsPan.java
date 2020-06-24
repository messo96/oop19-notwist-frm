package view.util;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class TipsPan extends JPanel {

	/**
	 * Creating tips panel by importing a txt.
	 */
	private static final long serialVersionUID = 1L;


	public TipsPan() {

		drawPan();
	}

	private void drawPan() {
		markupsPanel = new JPanel();
		tipsScroll = new JScrollPane();
		tipsPanel = new JTextArea();

		markupsPanel.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(194, 192, 192)),
						"Tips", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 14))); // NOI18N

		tipsScroll.setEnabled(false);

		importTips();
		tipsPanel.setWrapStyleWord(true);
		tipsPanel.setLineWrap(true);
		tipsPanel.setEnabled(false);
		tipsScroll.setViewportView(tipsPanel);

		GroupLayout markupsPanelLayout = new GroupLayout(markupsPanel);
		markupsPanel.setLayout(markupsPanelLayout);
		markupsPanelLayout.setHorizontalGroup(markupsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(markupsPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(tipsScroll, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		markupsPanelLayout.setVerticalGroup(markupsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(markupsPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(tipsScroll, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		add(markupsPanel);

	}
	
	private JScrollPane tipsScroll;
	private JPanel markupsPanel;
	private JTextArea tipsPanel;

	private void importTips() {
		BufferedReader buf;
		InputStreamReader in = new InputStreamReader(this.getClass().getResourceAsStream("/docs/Tips.txt"));
		try {
			buf = new BufferedReader(in);
			tipsPanel.read(buf, null);
		} catch (IOException e) {
			System.out.println("File Tips.txt non trovato! ");
			e.printStackTrace();
		}
	}
}
