package util;



import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;


public class CategoryPan extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public CategoryPan() {
		
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
	            String[] strings = { "Generale", "Ho scordato", "Quali Sono", "Le category", "Un paio di esempi", "Per vedere", "Quanto in basso", "Riesco", "Ad", "Andare" };
	            public int getSize() { return strings.length; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        


	        
	        add(category_panel);
	}
        
    private JPanel category_panel;
    private JScrollPane category_list;
    private JList<String> jList;

}
