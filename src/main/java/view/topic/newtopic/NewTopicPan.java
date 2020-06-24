/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.topic.newtopic;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.Iterator;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import controller.database.CategoryImplDB;
import controller.database.DiscussionImplDB;
import model.base.Category;
import model.base.CategoryImpl;
import model.base.User;

import view.TableDiscussion;
import view.util.RulesPan;
import view.util.TipsPan;

public class NewTopicPan extends JPanel {

	/**
	 * Creates new form Homepage_gui
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	private CategoryImplDB dbcategory = new CategoryImplDB();
	private DiscussionImplDB dbdiscussion = new DiscussionImplDB();

	// private JTable table;
	// public newtopic_gui(User user, JTable table)
	public NewTopicPan(final User user, final TableDiscussion table) {
		this.user = user;
		initComponents(table);
		// this.actualUser = user;
		// this.setVisible(true);
		// this.table = table;

	}

	private void initComponents(final TableDiscussion table) {

		newtopicPanel = new JPanel();
		topicPanel = new JPanel();
		category = new JComboBox<>();
		categoryLabel = new JLabel();
		titleLabel = new JLabel();
		title = new JTextField();
		textPreviewLabel = new JLabel();
		jScrollPane1 = new JScrollPane();
		descriptionTextArea = new JTextArea();
		jSeparator2 = new JSeparator();
		jScrollPane2 = new JScrollPane();
		previewEditorPane = new JEditorPane();
		postPutton = new JButton();
		textPreviewLabel1 = new JLabel();
		rulesPanel = new RulesPan();
		markupsPanel = new TipsPan();

		newtopicPanel.setLayout(new AbsoluteLayout());
		topicPanel.setLayout(new AbsoluteLayout());

		category.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		this.addItemsCategories();
		topicPanel.add(category, new AbsoluteConstraints(91, 11, -1, -1));

		categoryLabel.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		categoryLabel.setText("Categoria:");
		topicPanel.add(categoryLabel, new AbsoluteConstraints(10, 14, -1, -1));

		titleLabel.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		titleLabel.setText("Titolo:");
		topicPanel.add(titleLabel, new AbsoluteConstraints(10, 55, -1, -1));

		title.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		topicPanel.add(title, new AbsoluteConstraints(91, 52, 600, -1));

		textPreviewLabel.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		textPreviewLabel.setText("Preview testo");
		topicPanel.add(textPreviewLabel, new AbsoluteConstraints(10, 86, -1, -1));

		descriptionTextArea.setColumns(20);
		descriptionTextArea.setRows(5);
		jScrollPane1.setViewportView(descriptionTextArea);
		descriptionTextArea.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(final KeyEvent e) {
				//nothing
			}

			@Override
			public void keyPressed(final KeyEvent e) {
				//nothing
			}

			@Override
			public void keyReleased(final KeyEvent e) {
				previewEditorPane.setText(descriptionTextArea.getText());
			}

		});
		topicPanel.add(jScrollPane1, new AbsoluteConstraints(10, 299, 675, 140));

		jSeparator2.setBackground(new Color(0, 0, 0));
		topicPanel.add(jSeparator2, new AbsoluteConstraints(10, 257, 675, 10));

		previewEditorPane.setContentType("text/html");
		previewEditorPane.setEnabled(false);
		jScrollPane2.setViewportView(previewEditorPane);

		topicPanel.add(jScrollPane2, new AbsoluteConstraints(10, 111, 675, 135));


//		preview_button.setText("Preview");
//		topicPanel.add(preview_button, new AbsoluteConstraints(500, 450, -1, -1));

		postPutton.setText("Posta");
		postPutton.addActionListener(e -> {
			Category cat = dbcategory.getCategory(String.valueOf(category.getSelectedItem())).get();
			if (title.getText().isEmpty() && descriptionTextArea.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "You have to write something both in title and description");
			} else {
				dbdiscussion
				.createDiscussion(user.getId(), title.getText(), previewEditorPane.getText(), cat);
				JOptionPane.showMessageDialog(null, "Discussion successfully created");
				table.refreshTableDiscussion();
				CardLayout card = (CardLayout) getParent().getLayout();
				card.show(getParent(), "homepage_panel");
			}

		});
		topicPanel.add(postPutton, new AbsoluteConstraints(610, 450, -1, -1));

		textPreviewLabel1.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		textPreviewLabel1.setText("Testo");
		topicPanel.add(textPreviewLabel1, new AbsoluteConstraints(10, 271, -1, -1));

		newtopicPanel.add(topicPanel, new AbsoluteConstraints(0, 0, 700, 490));

		// Importing Rules Pan
		rulesPanel = new RulesPan();
		newtopicPanel.add(rulesPanel, new AbsoluteConstraints(720, 0, -1, 250));

		// Importing MarkupsPan
		markupsPanel = new TipsPan();
		newtopicPanel.add(markupsPanel, new AbsoluteConstraints(720, 260, -1, 210));

		add(newtopicPanel);

	}
	
	private void addItemsCategories() {
		Iterator<CategoryImpl> ite = dbcategory.getAll().iterator();
		while (ite.hasNext()) {
			category.addItem(ite.next().getName());
		}
	}

	// Variables declaration - do not modify
	private JComboBox<String> category;
	private JLabel categoryLabel;
	private JPanel newtopicPanel;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JSeparator jSeparator2;
	private JTextField title;
	private TipsPan markupsPanel;
	private JButton postPutton;
	private JTextArea descriptionTextArea;
	private JEditorPane previewEditorPane;
	private RulesPan rulesPanel;
	private JLabel textPreviewLabel;
	private JLabel textPreviewLabel1;
	private JLabel titleLabel;
	private JPanel topicPanel;
	// End of variables declaration
}
