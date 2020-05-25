package table;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import notwist.base.Discussion;
import notwist.base.Share;
import notwist.database.DBDiscussionImpl;
import notwist.database.DBUserImpl;


public class Nofilter extends JPanel{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelDiscussion;
	private Share share;
	
	public Nofilter(final Share share) {
		this.share = share;
		drawComp();
	}
	
	private void drawComp(){
		
		table_panel = new JPanel();
        jTable1 = new javax.swing.JTable(); //Tabella discussioni
        jTextField2 = new javax.swing.JTextField();
        main_table = new javax.swing.JScrollPane();
        
        table_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)), "What's new", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        table_panel.setName(""); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modelDiscussion = new DefaultTableModel(new Object[] {"Titolo","Categoria","Like","Created By","Risposte"},0);
        jTable1.setModel(modelDiscussion);
        loadDiscussion();
        
        //Uso Share
        share = new Share(jTable1, modelDiscussion);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setAutoscrolls(false);
        jTable1.setEnabled(false);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setShowGrid(true);
        main_table.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(520);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(108);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(60);

        jTextField2.setText("Spazio per next - prev che non posso creare ora :C");
        jTextField2.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout table_panelLayout = new javax.swing.GroupLayout(table_panel);
        table_panel.setLayout(table_panelLayout);
        table_panelLayout.setHorizontalGroup(
            table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_panelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(table_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(main_table)
                .addContainerGap())
        );
        table_panelLayout.setVerticalGroup(
            table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_panelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(main_table, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        add(table_panel);
   }

    // Variables declaration - do not modify
    private JPanel table_panel;

    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JScrollPane main_table;

    // End of variables declaration
    
    private void loadDiscussion() {
        for(Discussion s : new DBDiscussionImpl().getAllDiscussion().get() ) {
        	modelDiscussion.addRow(new Object[] {s.getTitle(),s.getCategory().getName(),0,
					new DBUserImpl().getUserFromId(s.getIdUser()).get().getUsername(),0});
        }
    }
    
}
	

