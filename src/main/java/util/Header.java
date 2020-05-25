package util;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;


import main.Loader;
import newtopic.NewTopicPan;
import notwist.base.Category;
import notwist.base.Discussion;
import notwist.base.User;
import notwist.database.DBCategory;
import notwist.database.DBDiscussion;
import notwist.database.DBDiscussionImpl;
import notwist.database.DBUserImpl;
import topic_gui.Topic_gui;

public class Header extends JPanel{

	private static final long serialVersionUID = 1L;
//    private DBDiscussion discussion = new DBDiscussionImpl();
//	private User actualUser = null;
	private Loader loader;
	
	public Header() {
		
		drawComp();
	}
	
	private void drawComp() {
		
	      drag_panel = new JPanel();
	        commands_panel = new JPanel();
	        exit = new JLabel();
	        header_panel = new JPanel();
	        jSeparator1 = new JSeparator();
	        homepage_button = new JLabel();
	        category_filter = new JComboBox<>(); //Combobox per le categorie
	        profile_icon = new JLabel(); //TBA
	        bell_icon = new JLabel(); //TBA
	        new_discussion = new JButton(); 
	        search_field = new JTextField(); //Spazio filtro
	        search_button = new JButton();
	        body_panel = new JPanel();
	        main_table = new JScrollPane(); 
	        jTable1 = new JTable(); //Tabella discussioni
	        
	        jTextField2 = new JTextField(); //Non ha nome perchè indica lo spazio dove ci starà prev - next per la tabella (se lo mettiamo)
	        hottest_panel = new JPanel();
	        jTable2 = new JTable(); //Tabella per le discussioni con più likes
	        categorie_panel = new JPanel();
	        category_list = new JScrollPane();
	        jList1 = new JList<>(); //Lista categorie
	        random_button = new JButton();

	        
        homepage_button.setFont(new Font("Bauhaus 93", 0, 18)); // NOI18N
        homepage_button.setText("NOTWIST");

        category_filter.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        category_filter.setModel(new DefaultComboBoxModel<>(new String[] { "Generale", "Animali", "Film", "Musica", "Cose", "Altre cose", "Cose non cose" }));
        
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
        search_field.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				if(search_field.getText().equals("Search.."))
				search_field.setText("");
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(search_field.getText().equals(""))
					search_field.setText("Search..");
			}
        	
        });
        search_button.setText("Go");

        search_button.setPreferredSize(new Dimension(45, 25));
        search_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
              //  search_buttonActionPerformed(evt);
            }
        });

        GroupLayout header_panelLayout = new GroupLayout(header_panel);
        header_panel.setLayout(header_panelLayout);
        header_panelLayout.setHorizontalGroup(
            header_panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addGroup(header_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE))
            .addGroup(header_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homepage_button)
                .addGap(30, 30, 30)
                .addComponent(category_filter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(search_field, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search_button, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(new_discussion)
                .addGap(27, 27, 27)
                .addComponent(bell_icon, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profile_icon, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        header_panelLayout.setVerticalGroup(
            header_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, header_panelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(header_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(homepage_button)
                    .addComponent(category_filter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(profile_icon)
                    .addComponent(bell_icon)
                    .addComponent(search_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_button, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addComponent(new_discussion, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
        );

     

        add(header_panel);

	}
	
	
	
    
    private void new_discussionMouseClicked(MouseEvent evt) {
        CardLayout card = getRootPane()..getLayout();
        card.show(getParent(), "newtopic_panel");
    }
    
	
	
	
	/*
    private void search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_buttonActionPerformed
  	  //Button Search
      search_button.addActionListener(e ->{
      	if(search_field.getText().equals("") || search_field.getText().equals("Search.."))
      		jTable1.setModel(this.loadDiscussion());
      	else
         		jTable1.setModel(this.loadDiscussion(search_field.getText()));
      });
  }

    
    private DefaultTableModel loadDiscussion() {
    	DefaultTableModel tableDiscussion = new DefaultTableModel(new Object[] {"Titolo","Categoria","Like","Created By","Risposte"},0);
        for(Discussion s : discussion.getAllDiscussion().get() ) {
        	tableDiscussion.addRow(new Object[] {s.getTitle(),s.getCategory().getName(),0,
					new DBUserImpl().getUserFromId(s.getIdUser()).get().getUsername(),0});
        }
        return tableDiscussion;
    }
   
    private DefaultTableModel loadDiscussion(final String title) {
    	DefaultTableModel tableDiscussion = new DefaultTableModel(new Object[] {"Titolo","Categoria","Like","Created By","Risposte"},0);
        for(Discussion s : discussion.getAllDiscussion(title).get() ) {
        	tableDiscussion.addRow(new Object[] {s.getTitle(),s.getCategory().getName(),0,
					new DBUserImpl().getUserFromId(s.getIdUser()).get().getUsername(),0});
        }
        return tableDiscussion;
    }
    	 
    private DefaultTableModel loadDiscussion(final Category category) {
    	DefaultTableModel tableDiscussion = new DefaultTableModel(new Object[] {"Titolo","Categoria","Like","Created By","Risposte"},0);
        for(Discussion s : discussion.getAllDiscussion(category).get() ) {
        	tableDiscussion.addRow(new Object[] {s.getTitle(),s.getCategory().getName(),0,
        								new DBUserImpl().getUserFromId(s.getIdUser()).get().getUsername(),0});
        }
        return tableDiscussion;
    }
    */
	

    private javax.swing.JLabel bell_icon;
    private javax.swing.JPanel body_panel;
    private javax.swing.JPanel categorie_panel;
    private javax.swing.JComboBox<String> category_filter;
    private javax.swing.JScrollPane category_list;
    private javax.swing.JPanel commands_panel;
    private javax.swing.JPanel drag_panel;
    private javax.swing.JLabel exit;
    private javax.swing.JPanel header_panel;
    private javax.swing.JLabel homepage_button;
    private javax.swing.JPanel hottest_panel;
    private javax.swing.JList<String> jList1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JScrollPane main_table;
    private javax.swing.JButton new_discussion;
    private javax.swing.JLabel profile_icon;
    private javax.swing.JButton random_button;
    private javax.swing.JButton search_button;
    private javax.swing.JTextField search_field;
}


