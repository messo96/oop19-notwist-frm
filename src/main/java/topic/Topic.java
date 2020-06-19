/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.netbeans.lib.awtextra.AbsoluteConstraints;

import controller.database.DBLikeDislikeImpl;
import controller.database.DBUserImpl;
import model.base.Discussion;
import model.database.DBLikeDislike;


/**
 *
 * @author emily
 */
public class Topic extends JPanel{

	/**
     * Creates topic area
     */

	private static final long serialVersionUID = 1L;
	//private DBUserImpl dbuser = new DBUserImpl();
//	private Discussion discussion = null;
//	private DBLikeDislikeImpl dblike = new DBLikeDislikeImpl();
   
    public Topic() {
        initComponents();

    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

    


		
		discussion_panel = new javax.swing.JPanel();
		discussion_part = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		discussion_area = new javax.swing.JEditorPane();
		title_label = new javax.swing.JLabel();
		n_likes = new javax.swing.JLabel();
		Icon yes = new ImageIcon("img/like.png");
		Icon no = new ImageIcon("img/dislike.png");
		like = new javax.swing.JButton(yes);
		dislike = new javax.swing.JButton(no);
		menu = new javax.swing.JButton();
		date_user = new javax.swing.JLabel();

	//	discussion_panel.setPreferredSize(new java.awt.Dimension(450, 231));
		discussion_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
	//	discussion_part.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		discussion_area.setText("Yoyoyoyo");
		discussion_area.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		jScrollPane1.setViewportView(discussion_area);

		title_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		title_label.setText("yoyo");
	//	title_label.setText(discussion.getTitle());
		title_label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		n_likes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		n_likes.setText("L-D");
		n_likes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));


	//	like.setText(String.valueOf(dblike.getLikes(this.discussion.getIdDiscussion())));



	//	dislike.setText(String.valueOf(dblike.getDislikes(this.discussion.getIdDiscussion())));


		menu.setText(".");
		menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		date_user.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		
		date_user.setText("super lungo per vedere come funziona la lunghezza miaomiao");
		//date_user.setText(this.discussion.getData() + "by " + dbuser.getUser(discussion.getIdUser()).get().getUsername());
		date_user.setHorizontalAlignment(SwingConstants.RIGHT);

		date_user.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		javax.swing.GroupLayout discussion_partLayout = new javax.swing.GroupLayout(discussion_part);

		discussion_partLayout.setAutoCreateContainerGaps(true);
		discussion_partLayout.setAutoCreateGaps(true);
		discussion_part.setLayout(discussion_partLayout);
		discussion_partLayout.setHorizontalGroup(discussion_partLayout.createSequentialGroup()
                .addGroup(discussion_partLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(discussion_area, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)
                        .addComponent(title_label)
                 
                        .addGroup(discussion_partLayout.createSequentialGroup()
                        		
                        	    .addComponent(n_likes)
                                .addComponent(like,GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addComponent(dislike,GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                    
                        .addComponent(date_user, GroupLayout.Alignment.TRAILING))
         

                .addComponent(menu,GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE));

		discussion_partLayout.setVerticalGroup(discussion_partLayout.createSequentialGroup()
                .addGroup(discussion_partLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(title_label))
                .addGroup(discussion_partLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(discussion_area,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(menu,GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGroup(discussion_partLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(n_likes)
                        .addComponent(like,GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                        .addComponent(dislike,GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                        .addComponent(date_user)));

		discussion_panel.add(discussion_part, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 1080, -1));

    	add(discussion_panel);
    	
    	
    	
  
    } 

	private JEditorPane discussion_area;

	private javax.swing.JLabel title_label;

	private javax.swing.JLabel date_user;
	private javax.swing.JPanel discussion_panel;
	private javax.swing.JPanel discussion_part;
	private javax.swing.JButton dislike;

	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton like;
	private javax.swing.JButton menu;
	private javax.swing.JLabel n_likes;

    



}
