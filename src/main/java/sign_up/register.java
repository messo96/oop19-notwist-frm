/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sign_up;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import emily.notwist.master_gui;
import notwist.database.DBUser;
import notwist.database.DBUserImpl;

/**
 *
 * @author emily
 */
public class register extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form master_gui1
     */
    public register() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

    	jDialog1 = new javax.swing.JDialog();
    	jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        Padre = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        mail_field = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        pssw_field = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        username_field1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        jLabel9.setText("Informativa Privacy");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("blablabla \nrobaprivacycontrattibananecaramello\nblablabla");
        jTextArea1.setEditable(false);
        jScrollPane1.setViewportView(jTextArea1);
        jDialog1.setUndecorated(true);

        jButton2.setText("Ok, ho letto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(80, 24, 24));
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Padre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Password");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 245));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 290, -1));

        mail_field.setBackground(new java.awt.Color(250, 250, 250));
        mail_field.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mail_field.setActionCommand("<Not Set>");
        mail_field.setBorder(null);
        mail_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mail_fieldFocusGained(evt);
            }
        });
        mail_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mail_fieldActionPerformed(evt);
            }
        });
        jPanel2.add(mail_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 270, 20));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 245));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 290, -1));

        pssw_field.setBackground(new java.awt.Color(250, 250, 250));
        pssw_field.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pssw_field.setBorder(null);
        pssw_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pssw_fieldFocusGained(evt);
            }
        });
        jPanel2.add(pssw_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 270, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Username");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("REGISTER");
      
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 300, 60));
        

        jLabel2.setText("Hai già un account? Loggati");
        jLabel2.setToolTipText("");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, -1, -1));

        jLabel5.setText(".");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, -1, -1));

        jLabel4.setForeground(new java.awt.Color(250, 0, 0));
        jLabel4.setText("qui");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, -1, -1));
        
       

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Mail");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 245));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 290, -1));

        username_field1.setBackground(new java.awt.Color(250, 250, 250));
        username_field1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        username_field1.setActionCommand("<Not Set>");
        username_field1.setBorder(null);
        username_field1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                username_field1FocusGained(evt);
            }
        });
        username_field1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_field1ActionPerformed(evt);
            }
        });
        jPanel2.add(username_field1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 270, 20));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jCheckBox1.setText("Accetto i termini blabla");
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        jButton3.setText("informativa");
        jButton3.setForeground(new java.awt.Color(250, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 10));
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        
        
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 327, -1, -1));

        Padre.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 420, 470));

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 0, 0));
        jLabel6.setText("X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 10, 10, -1));

        Padre.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 420, 40));

        jPanel1.setBackground(new java.awt.Color(67, 71, 91));

        jLabel7.setIcon(new javax.swing.ImageIcon("src/main/java/emily/notwist/font_test_1.png")); // NOI18N
        jLabel7.setDoubleBuffered(true);
        jLabel7.setFocusable(false);
        jLabel7.setRequestFocusEnabled(false);
        jLabel7.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Padre.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(Padre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        Padre.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PadreMouseDragged(evt);
            }
        });
        Padre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PadreMousePressed(evt);
            }
        });
        pack();
        

        //<Personalization> of GUI with Methods NOTWIST
        //############################################
        
        //Label link to login GUI
        jLabel4.addMouseListener( new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new master_gui().start();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}  
			
        });
        
        //Button that create new User from DBUserImpl
        //isModerator to default false
        jButton1.addActionListener(e ->{
        	if(new DBUserImpl().register(this.getUsername(), this.getPassword(), this.getEmail(), false)) {
        		JOptionPane.showMessageDialog(null, "Account created succesfully! :) ");
        		super.dispose();
        	}
        		
        	else
        		JOptionPane.showMessageDialog(null, "Error, something goes wrong!:(\nRetry ");
        		
        });
        
        
        
    }// </editor-fold>//GEN-END:initComponents

		


    private void mail_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mail_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mail_fieldActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    int xy;
    int xx;
    private void PadreMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel2MouseDragged
    private void PadreMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN END;

    private void mail_fieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mail_fieldFocusGained
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setForeground(new java.awt.Color(0, 150, 0));
    }//GEN-LAST:event_mail_fieldFocusGained

    private void pssw_fieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pssw_fieldFocusGained
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(0, 150, 0));
    }//GEN-LAST:event_pssw_fieldFocusGained

    private void username_field1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_username_field1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_username_field1FocusGained

    private void username_field1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_field1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_field1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    	jDialog1.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
   
            jDialog1.getContentPane();         
            jDialog1.setSize(400, 350);
        
            jDialog1.pack();
            jDialog1.setLocationRelativeTo(Padre); 
        jDialog1.setVisible(true);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    }//GEN-LAST:event_jButton3ActionPerformed


    public String getUsername() {
    	return username_field1.getText();
    }
    
    public String getEmail() {
    	return mail_field.getText();
    }
    
   /*
    * MODIFICARE ?? getPassword() RESTITUISCE UN CHAR[]
    */
    public String getPassword() {
    	return pssw_field.getText();
    }
    
    
    public void start() {
    	 /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
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
//            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new register().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Padre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField mail_field;
    private javax.swing.JPasswordField pssw_field;
    private javax.swing.JTextField username_field1;
    // End of variables declaration//GEN-END:variables
}
