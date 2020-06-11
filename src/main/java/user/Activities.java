package user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

public class Activities extends JPanel{
	
	private static final long serialVersionUID = 1L;
	/**
     * Shows the activies of a certain user
     */
    public Activities() {
        initComponents();
    }
    
    private void initComponents() {
    	
        jScrollPane1 = new JScrollPane();
        myactivities_panel = new JPanel();
        jScrollPane2 = new  JScrollPane();
        activity_area = new  JTextArea();
        jScrollPane3 = new  JScrollPane();
        activity_area1 = new  JTextArea();	
    	
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "My Activities", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane1.setPreferredSize(new Dimension(670, 190));
        
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setToolTipText("");
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        activity_area.setColumns(20);
        activity_area.setRows(5);
        activity_area.setText("Hai posto una questione in * chiamata *");
        jScrollPane2.setViewportView(activity_area);

        javax.swing.GroupLayout myactivities_panelLayout = new javax.swing.GroupLayout(myactivities_panel);
        myactivities_panel.setLayout(myactivities_panelLayout);
        myactivities_panelLayout.setHorizontalGroup(
            myactivities_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myactivities_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        myactivities_panelLayout.setVerticalGroup(
            myactivities_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myactivities_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(myactivities_panel);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 190));
    }
    private  JScrollPane jScrollPane1;

    private  JPanel myactivities_panel;
    private  JScrollPane jScrollPane2;
    private  JTextArea activity_area;
    private  JScrollPane jScrollPane3;
    private  JTextArea activity_area1;
}
