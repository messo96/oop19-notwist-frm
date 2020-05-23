package util;

import java.awt.Container;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import newtopic.newtopic_gui;
import notwist.base.Category;
import notwist.base.Discussion;
import notwist.database.DBCategory;
import notwist.database.DBDiscussionImpl;
import notwist.database.DBUserImpl;
import topic_gui.Topic_gui;
import main.Loader;
import notwist.base.User;
import notwist.database.DBDiscussion;
import util.Header;
import util.UpperPan;
import main.Loader;

public class CategoryPan extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public CategoryPan() {
		
		drawComp();
	}
	
	private void drawComp() {
    	
        category_panel = new javax.swing.JPanel();
        category_list = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>(); //Lista categorie



        category_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)), "Categorie", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        category_panel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jList1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
     
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        category_list.setViewportView(jList1);

        
        javax.swing.GroupLayout category_panelLayout = new javax.swing.GroupLayout(category_panel);
        category_panel.setLayout(category_panelLayout);
        category_panelLayout.setHorizontalGroup(
            category_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(category_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(category_list, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );
        category_panelLayout.setVerticalGroup(
            category_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(category_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(category_list, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(category_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 290, 240, 200));

      

        
        //<Personalization> of GUI with Methods NOTWIST
        //############################################
        
  
        
        /*      //List of category on the right
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
    	   
       });*/
	}
       
       


    

    // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JPanel category_panel;

    private javax.swing.JScrollPane category_list;


    private javax.swing.JList<String> jList1;


    // End of variables declaration//GEN-END:variables
}
