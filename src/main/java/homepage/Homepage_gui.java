/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homepage;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingWorker;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import main.Loader;
import newtopic.newtopic_gui;
import notwist.base.Category;
import notwist.base.Discussion;
import notwist.base.User;
import notwist.database.DBCategory;
import notwist.database.DBDiscussion;
import notwist.database.DBDiscussionImpl;
import notwist.database.DBUserImpl;
import topic_gui.Topic_gui;

/**
 *
 * @author emily
 */


public class Homepage_gui extends javax.swing.JFrame {
    
	 /**
     * Creates new form Homepage_gui
     */


    private DBDiscussion discussion = new DBDiscussionImpl();
	private User actualUser = null;
	private Loader loader;
	
	
	  public Homepage_gui(User user) {
	      initComponents();
		  this.actualUser = user;
		  this.loader = new Loader();
		  this.setVisible(true);
		  //Minimize
//	        this.setState(Frame.ICONIFIED);
//	        this.setExtendedState(JFrame.ICONIFIED);
	        
		  this.pack();
    }

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

    	
    	
        drag_panel = new javax.swing.JPanel();
        commands_panel = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        header_panel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        homepage_button = new javax.swing.JLabel();
        category_filter = new javax.swing.JComboBox<>(); //Combobox per le categorie
        profile_icon = new javax.swing.JLabel(); //TBA
        bell_icon = new javax.swing.JLabel(); //TBA
        new_discussion = new javax.swing.JButton(); 
        search_field = new javax.swing.JTextField(); //Spazio filtro
        search_button = new javax.swing.JButton();
        body_panel = new javax.swing.JPanel();
        main_table = new javax.swing.JScrollPane(); 
        jTable1 = new javax.swing.JTable() {
        	public boolean editCellAt(int row, int column, java.util.EventObject e) {
        		return false;
        	}
        }; //Tabella discussioni
        
        jTextField2 = new javax.swing.JTextField(); //Non ha nome perchè indica lo spazio dove ci starà prev - next per la tabella (se lo mettiamo)
        hottest_panel = new javax.swing.JPanel();
        jTable2 = new javax.swing.JTable(); //Tabella per le discussioni con più likes
        categorie_panel = new javax.swing.JPanel();
        category_list = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>(); //Lista categorie
        random_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        drag_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(0, 150, 0));
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout commands_panelLayout = new javax.swing.GroupLayout(commands_panel);
        commands_panel.setLayout(commands_panelLayout);
        commands_panelLayout.setHorizontalGroup(
            commands_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commands_panelLayout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .addComponent(exit)
                .addGap(19, 19, 19))
        );
        commands_panelLayout.setVerticalGroup(
            commands_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commands_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        drag_panel.add(commands_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 260, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jSeparator1.setMinimumSize(new java.awt.Dimension(50, 20));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 20));

        homepage_button.setFont(new java.awt.Font("Bauhaus 93", 0, 18)); // NOI18N
        homepage_button.setText("NOTWIST");

        category_filter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        category_filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Generale", "Animali", "Film", "Musica", "Cose", "Altre cose", "Cose non cose" }));

        profile_icon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        profile_icon.setText("P");
        profile_icon.setToolTipText("Futura icona profilo");

        bell_icon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bell_icon.setText("B");
        bell_icon.setToolTipText("Futura icona notifica");

        new_discussion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        new_discussion.setText("Crea una nuova discussione");

        search_field.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search_field.setText("Search..");
        search_field.setMargin(new java.awt.Insets(2, 2, 2, 3));
        search_field.setMinimumSize(new java.awt.Dimension(7, 23));
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
        search_button.setMaximumSize(new java.awt.Dimension(45, 25));
        search_button.setMinimumSize(new java.awt.Dimension(45, 25));
        search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout header_panelLayout = new javax.swing.GroupLayout(header_panel);
        header_panel.setLayout(header_panelLayout);
        header_panelLayout.setHorizontalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(header_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(header_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homepage_button)
                .addGap(30, 30, 30)
                .addComponent(category_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(search_field, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(new_discussion)
                .addGap(27, 27, 27)
                .addComponent(bell_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profile_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        header_panelLayout.setVerticalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_panelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homepage_button)
                    .addComponent(category_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profile_icon)
                    .addComponent(bell_icon)
                    .addComponent(search_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(new_discussion, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        drag_panel.add(header_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 90));

        body_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)), "What's new", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        body_panel.setName(""); // NOI18N
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        //Table of discussion in center of the Homepage
      
        
        
        jTable1.setModel(this.loadDiscussion());
       
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setAutoscrolls(false);
        jTable1.setEnabled(true);
        jTable1.setCellSelectionEnabled(false);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setShowGrid(true);
        jTable1.setRequestFocusEnabled(true);
        jTable1.setFocusable(true);
        jTable1.setAutoCreateColumnsFromModel(false);
       
        main_table.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(400);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);

        }
        
        jTextField2.setText("Spazio per next - prev che non posso creare ora :C");
        jTextField2.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout body_panelLayout = new javax.swing.GroupLayout(body_panel);
        body_panel.setLayout(body_panelLayout);
        body_panelLayout.setHorizontalGroup(
            body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(main_table)
                .addContainerGap())
            .addGroup(body_panelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        body_panelLayout.setVerticalGroup(
            body_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(main_table, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        drag_panel.add(body_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 780, 440));

        hottest_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)), "Hottest Topics", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        hottest_panel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"test1"},
                {"test2"},
                {"test3"},
                {"test4"},
                {"test5"}
            },
            new String [] {
                "Title "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable2.setAutoscrolls(false);
        jTable2.setColumnSelectionAllowed(false);
        jTable2.setEnabled(false);
        jTable2.setRowHeight(25);
        jTable2.getTableHeader().setReorderingAllowed(false);

        javax.swing.GroupLayout hottest_panelLayout = new javax.swing.GroupLayout(hottest_panel);
        hottest_panel.setLayout(hottest_panelLayout);
        hottest_panelLayout.setHorizontalGroup(
            hottest_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hottest_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTable2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );
        hottest_panelLayout.setVerticalGroup(
            hottest_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hottest_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTable2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );

        drag_panel.add(hottest_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, 240, 160));

        categorie_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)), "Categorie", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        categorie_panel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jList1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
     
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        category_list.setViewportView(jList1);

        
        javax.swing.GroupLayout categorie_panelLayout = new javax.swing.GroupLayout(categorie_panel);
        categorie_panel.setLayout(categorie_panelLayout);
        categorie_panelLayout.setHorizontalGroup(
            categorie_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categorie_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(category_list, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );
        categorie_panelLayout.setVerticalGroup(
            categorie_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categorie_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(category_list, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );

        drag_panel.add(categorie_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 290, 240, 200));

        random_button.setLabel("Scegli una discussione randomica!");
        drag_panel.add(random_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 513, 240, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(drag_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(drag_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        drag_panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
            	drag_panelMouseDragged(evt);
            }
        });
        drag_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	drag_panelMousePressed(evt);
            }
        });
        
       
        
        pack();
        
        //<Personalization> of GUI with Methods NOTWIST
        //############################################
        
        
        //Random Discussion 
        
        random_button.addActionListener(e ->{
        	loader.start();
        	new SwingWorker<String,Object>(){

				@Override
				protected String doInBackground() throws Exception {
					Random rand = new Random();
	        		Discussion disc = new DBDiscussionImpl().
								getDiscussionFromTitle(jTable1.getValueAt(rand.nextInt(jTable1.getRowCount()), 0).toString()).get();
	        		new Topic_gui(disc,actualUser).start();
	        		loader.end();	
	        	return "";
				}
        	}.execute();
        		
        });
        
        //List of category on the right
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
        	
        	        	DBCategory cat = new DBCategory();
        	        	List<Category> list = cat.getCategories().get();
        	        	public int getSize() { return list.size();}
        	            public String getElementAt(int i) { return list.get(i).getName();}
        	        });
        
        
        //Filter results of discussions by choosen category on list on the right
       jList1.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			loader.start();
			new SwingWorker<String,Object>(){

				@Override
				protected String doInBackground() throws Exception {
					jTable1.setModel(loadDiscussion(new DBCategory().getCategoryByName(jList1.getSelectedValue())));
					loader.end();
					return "";
				}
				
			}.execute();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
    	   
       });
       
       
        //When click on a discussion, open new Window
        jTable1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				loader.start();
				new SwingWorker<String,Object>(){

					@Override
					protected String doInBackground() throws Exception {
						Discussion disc = new DBDiscussionImpl().getDiscussionFromTitle(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()).get();
						new Topic_gui(disc,actualUser).start();
						jTable1.setFocusable(false);
						jTable1.setFocusable(true);
						loader.end();
						return "";
					}
				}.execute();
				
			}
			@Override
			public void focusLost(FocusEvent e) {}
        	
        });
        
        //Button create new discussion
        new_discussion.addActionListener(e ->{
      	java.awt.EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			new newtopic_gui(actualUser,jTable1);
    		}
    	});
        
        });
        
    }// </editor-fold>//GEN-END:initComponents
    

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
       System.exit(1);
    }//GEN-LAST:event_exitMouseClicked

    private void search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_buttonActionPerformed
    	  //Button Search
        search_button.addActionListener(e ->{
        	if(search_field.getText().equals("") || search_field.getText().equals("Search.."))
        		jTable1.setModel(this.loadDiscussion());
        	else
           		jTable1.setModel(this.loadDiscussion(search_field.getText()));
        });
    }
    
    int xy;
    int xx;
    private void drag_panelMouseDragged(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }                                    
    private void drag_panelMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }
    
    //GEN-LAST:event_search_buttonActionPerformed

    

  
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
    
    
//   public static void main(String args[]) {
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
//            java.util.logging.Logger.getLogger(Homepage_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Homepage_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Homepage_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Homepage_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Homepage_gui().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    // End of variables declaration//GEN-END:variables
}
