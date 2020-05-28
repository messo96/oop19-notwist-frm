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
import util.RulesPan;
import util.TipsPan;

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
		rules_panel = new RulesPan();
		markups_panel = new TipsPan();


		newtopic_panel.setLayout(new AbsoluteLayout());
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

		topic_panel.add(jScrollPane1, new AbsoluteConstraints(10, 299, 760, 140));

		jSeparator2.setBackground(new Color(0, 0, 0));
		topic_panel.add(jSeparator2, new AbsoluteConstraints(10, 257, 760, 10));

		editorPane.setContentType("text/html");
///////        ep.setText("html code");
		editorPane.setEnabled(false);

		jScrollPane2.setViewportView(editorPane);

		topic_panel.add(jScrollPane2, new AbsoluteConstraints(10, 111, 760, 135));

		notify_checkbox.setText("Notificami se rispondono");
		topic_panel.add(notify_checkbox, new AbsoluteConstraints(10, 450, -1, -1));

		preview_button.setText("Preview");
		topic_panel.add(preview_button, new AbsoluteConstraints(600, 450, -1, -1));
		
		post_button.setText("Posta");
		topic_panel.add(post_button, new AbsoluteConstraints(690, 450, -1, -1));

		textPreview_label1.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		textPreview_label1.setText("Testo");
		topic_panel.add(textPreview_label1, new AbsoluteConstraints(10, 271, -1, -1));

		newtopic_panel.add(topic_panel, new AbsoluteConstraints(0, 0, 780, 490));
	
		//Importing Rules Pan
		rules_panel = new RulesPan();
		newtopic_panel.add(rules_panel, new AbsoluteConstraints(800, 0, 260, 250));

		//Importing MarkupsPan
		markups_panel = new TipsPan();
		newtopic_panel.add(markups_panel, new AbsoluteConstraints(800, 260, 260, 210));

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


	// Variables declaration - do not modify

	private JComboBox<String> category;
	private JComboBox<String> category_filter;
	private JLabel category_label;

	private JPanel newtopic_panel;

	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;


	private JSeparator jSeparator2;
	private JTextField jTextField1;
	private TipsPan markups_panel;

	private JCheckBox notify_checkbox;
	private JButton post_button;
	private JButton preview_button;
	private JTextArea preview_textarea;
	private JEditorPane editorPane;

	private RulesPan rules_panel;
	private JLabel textPreview_label;
	private JLabel textPreview_label1;
	private JLabel title_label;
	private JPanel topic_panel;
	// End of variables declaration
}
