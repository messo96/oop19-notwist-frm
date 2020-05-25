package util;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import main.Loader;
import notwist.base.Category;
import notwist.base.Discussion;
import notwist.base.Share;
import notwist.database.DBCategoryImpl;
import notwist.database.DBDiscussionImpl;
import notwist.database.DBUserImpl;


public class CategoryPan extends JPanel{

	private static final long serialVersionUID = 1L;
	private Loader loader = new Loader();
	private Share share;
	
	public CategoryPan(final Share share) {
		this.share = share;
		drawComp();
	}
	
	private void drawComp() {
		
		category_panel = new JPanel();
        category_list = new JScrollPane();
        jList = new javax.swing.JList<>();
	    category_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0, 0, 0)), "category", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 14))); // NOI18N
	    category_panel.setFont(new Font("Tahoma", 0, 14)); // NOI18N
	    
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        category_list.setViewportView(jList);   
        
	        jList.setFont(new Font("Tahoma", 0, 14)); // NOI18N

	        GroupLayout category_panelLayout = new GroupLayout(category_panel);
	        category_panel.setLayout(category_panelLayout);
	        category_panelLayout.setHorizontalGroup(
	            category_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(category_panelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(category_list,210, 210,Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        category_panelLayout.setVerticalGroup(
	            category_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(category_panelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(category_list, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
	                .addContainerGap())
	            
	          
	        );
	    
	        jList.setModel(new AbstractListModel<String>() {
	        	List<Category> list = new DBCategoryImpl().getCategories().get();
	        	public int getSize() { return list.size(); }
	            public String getElementAt(int i) { return list.get(i).getName(); }
	        });
	        
	        //Filter results of discussions by choosen category on list on the right
	        jList.addMouseListener(new MouseListener() {

	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		loader.start();
	        		new SwingWorker<String,Object>(){

	        			@Override
	        			protected String doInBackground() throws Exception {
	        			 	DefaultTableModel model = share.getModelDiscussion();
	        				model = loadDiscussion(new DBCategoryImpl().getCategoryByName(jList.getSelectedValue()), model);
	        				loader.end();
	        				return "";
	        			}
	 				
	        		}.execute();
	        	}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

	        });
	        


	        
	        add(category_panel);
	}
	
	
        
    private JPanel category_panel;
    private JScrollPane category_list;
    private JList<String> jList;

    
    private DefaultTableModel loadDiscussion(final Category title, DefaultTableModel model) {
    	model.getDataVector().removeAllElements();
    	revalidate();
        for(Discussion s : new DBDiscussionImpl().getAllDiscussion(title).get() ) {
        	model.addRow(new Object[] {s.getTitle(),s.getCategory().getName(),0,
					new DBUserImpl().getUserFromId(s.getIdUser()).get().getUsername(),0});
        }
        return model;
    }
}
