package util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class RulesPan extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates panel for NewTopic Rules
	 */
	public RulesPan() {
		initComponents();
	}
	private void initComponents() {
	
		rules_panel = new JPanel();
		jScrollPane3 = new JScrollPane();
		rules_area = new JEditorPane("text/html", "");
	
		rules_panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0)), "Regole della Community",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 14))); // NOI18N

		jScrollPane3.setEnabled(false);
		jScrollPane3.setOpaque(false);
		rules_area.setText(
				"<h2>Regole per una nuova discussione:</h2><h3>Le cose giuste al posto giusto.</h3>Fai lo sforzo di scrivere le cose giuste nel posto giusto, così possiamo dedicare più tempo a discutere e meno tempo a sistemare le cose. In particolare:<ul><li>Non iniziare un topic in una categoria sbagliata;</li><li>Non pubblicare la stessa cosa in più topic;</li><li>Non firmare i tuoi post, ogni post ha le info sul tuo profilo;</li></ul><h3>L'educazione è importante.</h3><ul><li>Sii educato. Non pubblicare niente che una persona considererebbe offensivo, oltraggioso o che possa istigare all’odio;</li><li>Evita gli eccessi: non pubblicare contenuti osceni o sessualmente espliciti;</li><li>Cerca di rispettare tutti. Non infastidire o ferire nessuno, non divulgare informazioni relative ad altri, non assumere l’identità di altri;</li></ul>");
		rules_area.setEnabled(false);
		jScrollPane3.setViewportView(rules_area);

		GroupLayout rules_panelLayout = new GroupLayout(rules_panel);
		rules_panel.setLayout(rules_panelLayout);
		rules_panelLayout.setHorizontalGroup(rules_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(rules_panelLayout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		rules_panelLayout.setVerticalGroup(rules_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						rules_panelLayout.createSequentialGroup().addContainerGap()
								.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));	
		add(rules_panel);
	}
	
	private JScrollPane jScrollPane3;
	private JEditorPane rules_area;
	private JPanel rules_panel;

}

