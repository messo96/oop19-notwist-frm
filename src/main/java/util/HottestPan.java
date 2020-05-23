package util;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import notwist.base.Category;
import notwist.base.Discussion;
import notwist.database.DBCategory;
import notwist.database.DBUserImpl;

public class HottestPan extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public HottestPan() {
		
		drawComp();
	}
	
	private void drawComp() {
	
    JComponent hottest_panel;
	hottest_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)), "Hottest Topics", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    hottest_panel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    JComponent jTable2;
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
    
}