package user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

public class UserDiscussions extends JPanel{
	
	private static final long serialVersionUID = 1L;
	/**
     * Shows the activies of a certain user
     */
    public UserDiscussions() {
        initComponents();
    }
    
    private void initComponents() {
    	
        jPanel3 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        JButton btn = new JButton();
    

        reportDialog = new javax.swing.JDialog();
        containerDialog = new javax.swing.JPanel();
        titleDialog = new javax.swing.JTextField();
        deletebtn = new javax.swing.JButton();
        discussionScroll = new javax.swing.JScrollPane();
        discussionArea = new javax.swing.JEditorPane();
        username = new javax.swing.JTextField();
        ignorebtn = new javax.swing.JButton();
        nReport = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        
        
        reportDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        reportDialog.setTitle("Report Discussione");
        
        titleDialog.setText("Titolo");
   
        discussionScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        discussionScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        discussionScroll.setViewportView(discussionArea);

        discussionArea.setText("Discussione");
        
        jLabel1.setText("Creata da:");
        username.setText("username");
        jLabel2.setText("Numero report:");
        nReport.setText("numReport");
        
        deletebtn.setText("Cancella");
        ignorebtn.setText("Ignora");
        
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(containerDialog);
        containerDialog.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
        		jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(discussionScroll)
                    .addComponent(username)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(titleDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ignorebtn))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(deletebtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(nReport, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
        		jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(discussionScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ignorebtn)
                    .addComponent(deletebtn))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        reportDialog.add(containerDialog);
        
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Attività"));
        jPanel3.setAutoscrolls(true);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Titolo", "Report"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane13.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(450);
            jTable3.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	btnMouseClicked(evt);
            }
        });
        add(btn);
        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 650, 240));
   
    
    
    }
    private void btnMouseClicked(java.awt.event.MouseEvent evt) {
    	 try {
    		   
    		 reportDialog.getContentPane();         
    		 reportDialog.setSize(600, 500);
    		 reportDialog.pack();
    		 reportDialog.setLocationRelativeTo(getParent()); 
    		 reportDialog.setVisible(true);
     } catch (Exception ex) {
         ex.printStackTrace();
    }
    }

    private javax.swing.JPanel jPanel3;

    private javax.swing.JScrollPane jScrollPane13;

    private javax.swing.JTable jTable3;
    
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton ignorebtn;
    private javax.swing.JDialog reportDialog;
    private javax.swing.JEditorPane discussionArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel containerDialog;
    private javax.swing.JScrollPane discussionScroll;
    private javax.swing.JTextField titleDialog;
    private javax.swing.JTextField username;
    private javax.swing.JTextField nReport;

}
