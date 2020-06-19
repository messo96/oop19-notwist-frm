/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

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

    


		
		discussion_panel = new JPanel();
		discussion_part = new JPanel();
		jScrollPane1 = new JScrollPane();
		discussion_area = new JEditorPane();
		title_label = new JLabel();
		n_likes = new JLabel();
		Icon yes = new ImageIcon("img/like.png");
		Icon no = new ImageIcon("img/dislike.png");
		like = new JButton(yes);
		dislike = new JButton(no);
		menu = new JButton();
		date_user = new JLabel();

		discussion_panel.setLayout(new AbsoluteLayout());

		jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		discussion_area.setText("Yoyoyoyo");
		discussion_area.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		jScrollPane1.setViewportView(discussion_area);

		title_label.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		title_label.setText("yoyo");
	//	title_label.setText(discussion.getTitle());
		title_label.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		n_likes.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		n_likes.setText("L-D");
		n_likes.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));


	//	like.setText(String.valueOf(dblike.getLikes(this.discussion.getIdDiscussion())));



	//	dislike.setText(String.valueOf(dblike.getDislikes(this.discussion.getIdDiscussion())));


		menu.setText(".");
		menu.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		date_user.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		
		date_user.setText("super lungo per vedere come funziona la lunghezza miaomiao");
		//date_user.setText(this.discussion.getData() + "by " + dbuser.getUser(discussion.getIdUser()).get().getUsername());
		date_user.setHorizontalAlignment(SwingConstants.RIGHT);

		date_user.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		GroupLayout discussion_partLayout = new GroupLayout(discussion_part);

		discussion_partLayout.setAutoCreateContainerGaps(true);
		discussion_partLayout.setAutoCreateGaps(true);
		discussion_part.setLayout(discussion_partLayout);
		discussion_partLayout.setHorizontalGroup(discussion_partLayout.createSequentialGroup()
                .addGroup(discussion_partLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jScrollPane1,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
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
	private JLabel title_label;
	private JLabel date_user;
	private JPanel discussion_panel;
	private JPanel discussion_part;
	private JButton dislike;
	private JScrollPane jScrollPane1;
	private JButton like;
	private JButton menu;
	private JLabel n_likes;
}
