/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.topic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import org.netbeans.lib.awtextra.AbsoluteLayout;

import controller.database.LikeDislikeImplDiscussionDB;
import controller.database.UserImplDB;
import controller.database.ILikeDislikeDB;
import model.base.Discussion;
import model.base.User;

public class Topic extends JPanel {

	/**
	 * Creates topic area
	 */

	private static final long serialVersionUID = 1L;
	private Discussion discussion = null;
	private User user;
	private ILikeDislikeDB dblike = new LikeDislikeImplDiscussionDB();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	public Topic(final Discussion disc, final User user) {
		this.user = user;
		this.discussion = disc;
		initComponents();

	}

	private void initComponents() {

		discussion_panel = new JPanel();
		discussionPart = new JPanel();
		jScrollPane1 = new JScrollPane();
		discussion_area = new JEditorPane();
		title_label = new JLabel();
		n_likes = new JLabel();
		Icon yes = new ImageIcon(this.getClass().getClassLoader().getResource("img/like.png"));
		Icon no = new ImageIcon(this.getClass().getClassLoader().getResource("img/dislike.png"));
		like = new JButton(yes);
		dislike = new JButton(no);
		menu = new JButton();
		date_user = new JLabel();

		discussion_panel.setLayout(new AbsoluteLayout());

		jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		discussion_area.setContentType("text/html");
		discussion_area.setText(discussion.getDescription());
		discussion_area.setEditable(false);
		discussion_area.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		jScrollPane1.setViewportView(discussion_area);

		title_label.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		title_label.setText(discussion.getTitle());
		title_label.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		n_likes.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		n_likes.setText(String.valueOf(
				dblike.getLikes(discussion.getIdDiscussion()) - dblike.getDislikes(discussion.getIdDiscussion())));
		n_likes.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		like.addActionListener(e -> {
			dblike.setLike(discussion.getIdDiscussion(), user.getId());
			n_likes.setText(String.valueOf(
					dblike.getLikes(discussion.getIdDiscussion()) - dblike.getDislikes(discussion.getIdDiscussion())));

		});
		dislike.addActionListener(e -> {
			dblike.setDislike(discussion.getIdDiscussion(), user.getId());
			n_likes.setText(String.valueOf(
					dblike.getLikes(discussion.getIdDiscussion()) - dblike.getDislikes(discussion.getIdDiscussion())));

		});

		menu.setText(".");
		menu.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		final JPopupMenu report = new JPopupMenu("Menu");
		report.add("Segnala");
		menu.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	report.show(menu, menu.getWidth()/2, menu.getHeight()/2);
            }
        } );
		
		
		
		date_user.setFont(new Font("Tahoma", 0, 14)); // NOI18N

		date_user.setText(sdf.format(discussion.getData()) + " by "
				+ new UserImplDB().getUser(discussion.getIdUser()).get().getUsername());
		date_user.setHorizontalAlignment(SwingConstants.RIGHT);

		date_user.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		GroupLayout discussionPartLayout = new GroupLayout(discussionPart);

		discussionPartLayout.setAutoCreateContainerGaps(true);
		discussionPartLayout.setAutoCreateGaps(true);
		discussionPart.setLayout(discussionPartLayout);
		discussionPartLayout.setHorizontalGroup(discussionPartLayout.createSequentialGroup()
				.addGroup(discussionPartLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)
						.addComponent(title_label)

						.addGroup(discussionPartLayout.createSequentialGroup().addComponent(n_likes)
								.addComponent(like, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(dislike, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))

						.addComponent(date_user, GroupLayout.Alignment.TRAILING))

				.addComponent(menu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE));

		discussionPartLayout.setVerticalGroup(discussionPartLayout.createSequentialGroup()
				.addGroup(discussionPartLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(title_label))

				.addGroup(discussionPartLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(menu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))

				.addGroup(
						discussionPartLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(n_likes)
								.addComponent(like, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(dislike, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(date_user)));

		discussion_panel.add(discussionPart, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 1080, -1));

		add(discussion_panel);
	}

	private JEditorPane discussion_area;
	private JLabel title_label;
	private JLabel date_user;
	private JPanel discussion_panel;
	private JPanel discussionPart;
	private JButton dislike;
	private JScrollPane jScrollPane1;
	private JButton like;
	private JButton menu;
	private JLabel n_likes;
}
