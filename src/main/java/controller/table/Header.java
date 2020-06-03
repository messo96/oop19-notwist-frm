package controller.table;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import main.Loader;
import model.database.DBDiscussion;
import model.database.DBDiscussionImpl;

public class Header extends JPanel {

	private static final long serialVersionUID = 1L;
	private DBDiscussion dbdiscussion = new DBDiscussionImpl();
//	private User actualUser = null;
	private Loader loader;
	private CardLayout card;
	private JPanel parent;

	public Header(TableDiscussion tableDiscussion, JPanel parent) {
		this.parent = parent;
		this.card = (CardLayout) parent.getLayout();
		drawComp(tableDiscussion);
	}

	private void drawComp(TableDiscussion tableDiscussion) {

		header_panel = new JPanel();
		jSeparator1 = new JSeparator();
		homepage_button = new JLabel();
		category_filter = new JButton(); // Combobox per le categorie
		profile_icon = new JLabel(); // TBA
		bell_icon = new JLabel(); // TBA
		new_discussion = new JButton();
		search_field = new JTextField(); // Spazio filtro
		search_button = new JButton();

		homepage_button.setFont(new Font("Bauhaus 93", 0, 18)); // NOI18N
		homepage_button.setText("NOTWIST");
		
        homepage_button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                homepage_buttonMouseClicked(evt);
            }
        });

		category_filter.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		category_filter.setText("Temporanea tabella");

		category_filter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				category_filterMouseClicked(evt);
			}
		});
		
		profile_icon.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		profile_icon.setText("P");
		profile_icon.setToolTipText("Futura icona profilo");

		bell_icon.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		bell_icon.setText("B");
		bell_icon.setToolTipText("Futura icona notifica");

		new_discussion.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		new_discussion.setText("Crea una nuova discussione");

		new_discussion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				new_discussionMouseClicked(evt);
			}
		});

		search_field.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		search_field.setText("Search..");
		search_field.setMargin(new Insets(2, 2, 2, 3));
		search_field.setPreferredSize(new Dimension(7, 25));
		search_field.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (search_field.getText().equals("Search.."))
					search_field.setText("");

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (search_field.getText().equals(""))
					search_field.setText("Search..");
			}

		});
		search_button.setText("Go");

		search_button.setPreferredSize(new Dimension(45, 25));
		search_button.addActionListener(e -> {
			if (search_field.getText().equals("") || search_field.getText().equals("Search.."))
				tableDiscussion.refreshTableDiscussion();
			else
				tableDiscussion.refreshTableDiscussion(search_field.getText());
		});

		GroupLayout header_panelLayout = new GroupLayout(header_panel);
		header_panel.setLayout(header_panelLayout);
		header_panelLayout.setHorizontalGroup(header_panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addGroup(header_panelLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
						.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE))
				.addGroup(header_panelLayout.createSequentialGroup().addContainerGap().addComponent(homepage_button)
						.addGap(30, 30, 30)
						.addComponent(category_filter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(search_field, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(search_button, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(39, 39, 39).addComponent(new_discussion).addGap(27, 27, 27)
						.addComponent(bell_icon, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(profile_icon, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		header_panelLayout.setVerticalGroup(header_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						header_panelLayout.createSequentialGroup().addGap(45, 45, 45)
								.addGroup(header_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(homepage_button)
										.addComponent(category_filter, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(profile_icon).addComponent(bell_icon)
										.addComponent(search_field, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(search_button, GroupLayout.PREFERRED_SIZE, 29,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(new_discussion, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jSeparator1,
										GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)));

		  profile_icon.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent evt) {
	                profile_iconMouseClicked(evt);
	            }
	        });
		  
		add(header_panel);

	}

	private void new_discussionMouseClicked(MouseEvent evt) {
		card.show(parent, "newtopic_panel");
	}
	private void homepage_buttonMouseClicked(MouseEvent evt) {
		card.show(parent, "homepage_panel");
	}
	private void profile_iconMouseClicked(MouseEvent evt) {
		card.show(parent, "profile_panel");
	}

	private void category_filterMouseClicked(MouseEvent evt) {
		card.show(parent, "topic_panel");
	}
	/*
	 * private void search_buttonActionPerformed(java.awt.event.ActionEvent evt)
	 * {//GEN-FIRST:event_search_buttonActionPerformed //Button Search
	 * search_button.addActionListener(e ->{ if(search_field.getText().equals("") ||
	 * search_field.getText().equals("Search.."))
	 * jTable1.setModel(this.loadDiscussion()); else
	 * jTable1.setModel(this.loadDiscussion(search_field.getText())); }); }
	 */

	private javax.swing.JLabel bell_icon;
	private javax.swing.JButton category_filter;
	private javax.swing.JPanel header_panel;
	private javax.swing.JLabel homepage_button;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JButton new_discussion;
	private javax.swing.JLabel profile_icon;
	private javax.swing.JButton search_button;
	private javax.swing.JTextField search_field;
}
