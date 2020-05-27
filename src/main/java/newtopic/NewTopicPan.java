/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtopic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.kefirsf.bb.BBProcessorFactory;
import org.kefirsf.bb.ConfigurationFactory;
import org.kefirsf.bb.TextProcessor;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import notwist.base.Category;
import notwist.base.Discussion;
import notwist.base.DiscussionImpl;
import notwist.base.User;
import notwist.database.DBCategory;
import notwist.database.DBDiscussionImpl;

/**
 *
 * @author emily
 */
public class NewTopicPan extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form Homepage_gui
	 */

	// private User actualUser=null;
	// private JTable table;
	// public newtopic_gui(User user, JTable table)
	public NewTopicPan() {
		initComponents();
		// this.actualUser = user;
		// this.setVisible(true);
		// this.table = table;

	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		newtopic_panel = new JPanel();
		category_filter = new JComboBox<>();
		topic_panel = new JPanel();
		category = new JComboBox<>();
		category_label = new JLabel();
		title_label = new JLabel();
		jTextField1 = new JTextField();
		textPreview_label = new JLabel();
		jScrollPane1 = new JScrollPane();
		preview_textarea = new JTextArea();
		jSeparator2 = new JSeparator();
		jScrollPane2 = new JScrollPane();
		editorPane = new JEditorPane();
		notify_checkbox = new JCheckBox();
		post_button = new JButton();
		preview_button = new JButton();
		textPreview_label1 = new JLabel();
		rules_panel = new JPanel();
		jScrollPane3 = new JScrollPane();
		rules_area = new JTextArea();
		markups_panel = new JPanel();
		jScrollPane4 = new JScrollPane();
		tips_panel = new JTextArea();

		topic_panel.setLayout(new AbsoluteLayout());

		category.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		topic_panel.add(category, new AbsoluteConstraints(91, 11, -1, -1));

		category_label.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		category_label.setText("Categoria:");
		topic_panel.add(category_label, new AbsoluteConstraints(10, 14, -1, -1));

		title_label.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		title_label.setText("Titolo:");
		topic_panel.add(title_label, new AbsoluteConstraints(10, 55, -1, -1));

		jTextField1.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		topic_panel.add(jTextField1, new AbsoluteConstraints(91, 52, 679, -1));

		textPreview_label.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		textPreview_label.setText("Preview testo");
		topic_panel.add(textPreview_label, new AbsoluteConstraints(10, 86, -1, -1));

		preview_textarea.setColumns(20);
		preview_textarea.setRows(5);
		jScrollPane1.setViewportView(preview_textarea);

		topic_panel.add(jScrollPane1, new AbsoluteConstraints(10, 299, 760, 151));

		jSeparator2.setBackground(new Color(0, 0, 0));
		topic_panel.add(jSeparator2, new AbsoluteConstraints(10, 257, 760, 10));

		editorPane.setContentType("text/html");
///////        ep.setText("html code");
		editorPane.setEnabled(false);

		jScrollPane2.setViewportView(editorPane);

		topic_panel.add(jScrollPane2, new AbsoluteConstraints(10, 111, 760, 135));

		notify_checkbox.setText("Notificami se rispondono");
		topic_panel.add(notify_checkbox, new AbsoluteConstraints(10, 450, -1, -1));

		post_button.setText("Posta");
		topic_panel.add(post_button, new AbsoluteConstraints(710, 450, -1, -1));

		preview_button.setText("Preview");
		topic_panel.add(preview_button, new AbsoluteConstraints(620, 450, -1, -1));

		textPreview_label1.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		textPreview_label1.setText("Testo");
		topic_panel.add(textPreview_label1, new AbsoluteConstraints(10, 271, -1, -1));

		newtopic_panel.add(topic_panel, new AbsoluteConstraints(0, 90, 780, 490));

		rules_panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0)), "Regole della Community",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 14))); // NOI18N

		jScrollPane3.setEnabled(false);
		jScrollPane3.setOpaque(false);

		rules_area.setColumns(20);
		rules_area.setRows(5);
		rules_area.setText(
				"Regole della community:\n1. Test larghezza frase per vedere come funziona.\n2. Test\n3. Test\n4. Test\n\nAltra roba qui.\n\n\n\nPiù giù per lunghezza.\n");
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

		newtopic_panel.add(rules_panel, new AbsoluteConstraints(800, 100, 260, 250));

		markups_panel.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0)),
						"Tips", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 14))); // NOI18N

		jScrollPane4.setEnabled(false);

		tips_panel.setColumns(20);
		tips_panel.setRows(5);
		tips_panel.setText(
				"Altro test blablabla\nasdasdasdasd\nasdasd\nasdasdassdasdassdasd\nasdasdasdasd\nasdadasdassdasd\nadadasdasdasdasd\nasdasdasdasd\nasdadsasdasd.");
		tips_panel.setWrapStyleWord(true);
		tips_panel.setEnabled(false);
		jScrollPane4.setViewportView(tips_panel);

		GroupLayout markups_panelLayout = new GroupLayout(markups_panel);
		markups_panel.setLayout(markups_panelLayout);
		markups_panelLayout.setHorizontalGroup(markups_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(markups_panelLayout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		markups_panelLayout.setVerticalGroup(markups_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(markups_panelLayout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		newtopic_panel.add(markups_panel, new AbsoluteConstraints(800, 360, 260, 210));

		add(newtopic_panel);

		// <Personalization> of GUI with Methods NOTWIST
		// ############################################

		/*
		 * category.setModel(this.loadModel());
		 * 
		 * post_button.addActionListener(e ->{ Date d = new Date(); Category cate = new
		 * DBCategory().getCategoryByName(category.getSelectedItem().toString()); String
		 * title = jTextField1.getText(); String desc = preview_textarea.getText();
		 * Discussion disc = new DiscussionImpl(0,this.actualUser.getId(), title,desc,
		 * cate, d); new DBDiscussionImpl().createDiscussion(disc, cate);
		 * JOptionPane.showMessageDialog(null, title + "\nPublished"); DefaultTableModel
		 * model = (DefaultTableModel)table.getModel(); model.addRow(new Object[]
		 * {title,0,0,this.actualUser.getUsername()}); table.setModel(model); dispose();
		 * 
		 * });
		 * 
		 * 
		 * // Sync with text PREVIEW and text TEXT editorPane.setEnabled(true);
		 * preview_textarea.addKeyListener(new KeyListener() {
		 * 
		 * @Override public void keyTyped(KeyEvent e) {}
		 * 
		 * @Override public void keyPressed(KeyEvent e) {}
		 * 
		 * @Override public void keyReleased(KeyEvent e) { TextProcessor processor =
		 * BBProcessorFactory.getInstance()
		 * .createFromResource(ConfigurationFactory.SAFE_HTML_CONFIGURATION_FILE);
		 * editorPane.setText(processor.process(preview_textarea.getText())); }
		 * 
		 * });
		 */

	}

//    
//    public void start(final User user) {
//    /* Create and display the form */
//    	java.awt.EventQueue.invokeLater(new Runnable() {
//    		public void run() {
//    			new newtopic_gui(user);
//    		}
//    	});
//        	
//    	System.out.print(actualUser + "AAAAA");
//    }
//    

	/*
	 * private DefaultComboBoxModel<String> loadModel() {
	 * DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
	 * for(Category c : new DBCategory().getNameOfAllTheCategories().get()) {
	 * model.addElement(c.getName()); } return model; }
	 */

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(newtopic_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(newtopic_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(newtopic_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(newtopic_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new newtopic_gui().setVisible(true);
//            }
//        });
//    }

	// Variables declaration - do not modify//GEN-BEGIN:variables

	private JComboBox<String> category;
	private JComboBox<String> category_filter;
	private JLabel category_label;

	private JPanel newtopic_panel;

	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;
	private JScrollPane jScrollPane4;

	private JSeparator jSeparator2;
	private JTextField jTextField1;
	private JPanel markups_panel;

	private JCheckBox notify_checkbox;
	private JButton post_button;
	private JButton preview_button;
	private JTextArea preview_textarea;
	private JEditorPane editorPane;

	private JTextArea rules_area;
	private JPanel rules_panel;
	private JLabel textPreview_label;
	private JLabel textPreview_label1;
	private JTextArea tips_panel;
	private JLabel title_label;
	private JPanel topic_panel;
	// End of variables declaration//GEN-END:variables
}
