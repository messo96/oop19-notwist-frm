/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.topic;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;

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

import controller.database.LikeDislikeImplDiscussionDB;
import controller.database.UserImplDB;
import controller.database.ILikeDislikeDB;
import model.base.Discussion;
import model.base.User;

public class Topic extends JPanel {

	
	// Creates topic area.
	
	//Fields.
	private static final long serialVersionUID = 1L;
	private Discussion discussion = null;
	private User user;
	private ILikeDislikeDB dblike = new LikeDislikeImplDiscussionDB();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	/*Builder.*/
	public Topic(final Discussion disc, final User user) {
		this.user = user;
		this.discussion = disc;
		initComponents();

	}

	private void initComponents() {

		discussionPanel = new JPanel();
		discussionPart = new JPanel();
		jScrollPane1 = new JScrollPane();
		discussionArea = new JEditorPane();
		titleLabel = new JLabel();
		nLikes = new JLabel();
		Icon yes = new ImageIcon(this.getClass().getClassLoader().getResource("img/Ilike.png"));
		Icon no = new ImageIcon(this.getClass().getClassLoader().getResource("img/Idislike.png"));
		like = new JButton(yes);
		dislike = new JButton(no);
		dateUser = new JLabel();

		discussionPanel.setLayout(new AbsoluteLayout());

		jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		discussionArea.setContentType("text/html");
		discussionArea.setText(discussion.getDescription());
		discussionArea.setEditable(false);
		discussionArea.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		jScrollPane1.setViewportView(discussionArea);

		titleLabel.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		titleLabel.setText(discussion.getTitle());
		titleLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		nLikes.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		nLikes.setHorizontalAlignment(SwingConstants.CENTER);
		nLikes.setText(String.valueOf(
				dblike.getLikes(discussion.getIdDiscussion()) - dblike.getDislikes(discussion.getIdDiscussion())));
		nLikes.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		like.addActionListener(e -> {
			dblike.setLike(discussion.getIdDiscussion(), user.getId());
			nLikes.setText(String.valueOf(
					dblike.getLikes(discussion.getIdDiscussion()) - dblike.getDislikes(discussion.getIdDiscussion())));

		});
		dislike.addActionListener(e -> {
			dblike.setDislike(discussion.getIdDiscussion(), user.getId());
			nLikes.setText(String.valueOf(
					dblike.getLikes(discussion.getIdDiscussion()) - dblike.getDislikes(discussion.getIdDiscussion())));

		});

		dateUser.setFont(new Font("Tahoma", 0, 14)); // NOI18N

		dateUser.setText(sdf.format(discussion.getData()) + " by "
				+ new UserImplDB().getUser(discussion.getIdUser()).get().getUsername());
		dateUser.setHorizontalAlignment(SwingConstants.RIGHT);

		dateUser.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		GroupLayout discussionPartLayout = new GroupLayout(discussionPart);

		discussionPartLayout.setAutoCreateContainerGaps(true);
		discussionPartLayout.setAutoCreateGaps(true);
		discussionPart.setLayout(discussionPartLayout);
		discussionPartLayout.setHorizontalGroup(discussionPartLayout.createSequentialGroup()
				.addGroup(discussionPartLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)
						.addComponent(titleLabel)

						.addGroup(discussionPartLayout.createSequentialGroup()
								.addComponent(nLikes, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(like, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(dislike, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))

						.addComponent(dateUser, GroupLayout.Alignment.TRAILING))

			);

		discussionPartLayout.setVerticalGroup(discussionPartLayout.createSequentialGroup()
				.addGroup(discussionPartLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(titleLabel))

				.addGroup(discussionPartLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						)

				.addGroup(
						discussionPartLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(nLikes)
								.addComponent(like, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(dislike, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateUser)));

		discussionPanel.add(discussionPart, new AbsoluteConstraints(20, 0, 1080, -1));

		add(discussionPanel);
	}

	private JEditorPane discussionArea;
	private JLabel titleLabel;
	private JLabel dateUser;
	private JPanel discussionPanel;
	private JPanel discussionPart;
	private JButton dislike;
	private JScrollPane jScrollPane1;
	private JButton like;
	private JLabel nLikes;
}
