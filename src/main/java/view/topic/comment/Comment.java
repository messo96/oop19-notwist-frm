package view.topic.comment;

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

import controller.database.LikeDislikeImplCommentsDB;
import controller.database.UserImplDB;
import controller.database.ILikeDislikeDB;
import model.base.User;
import rombo.new_class.CommentsImplement;

public class Comment extends JPanel {

	/**
	 * Creates a new comment
	 */

	private static final long serialVersionUID = 1L;
	private UserImplDB dbuser = new UserImplDB();
	private ILikeDislikeDB dblike = new LikeDislikeImplCommentsDB();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private User user;
	public Comment(final CommentsImplement com, User user) {
		initComponents(com);
		this.user = user;
	}

	@SuppressWarnings("unchecked")

	private void initComponents(final CommentsImplement com) {

		comment_panel = new JPanel();
		comment_part = new JPanel();
		n_likes = new JLabel();
		menu = new JButton();
		Icon yes = new ImageIcon(this.getClass().getClassLoader().getResource("img/like.png"));
		Icon no = new ImageIcon(this.getClass().getClassLoader().getResource("img/dislike.png"));
		like = new JButton(yes);
		dislike = new JButton(no);
		date_user = new JLabel();
		jScrollPane1 = new JScrollPane();
		comment_area = new JEditorPane();

		comment_panel.setLayout(new AbsoluteLayout());

		jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		// Comment area
		comment_area.setText(com.getComment());
		comment_area.setEditable(false);
		comment_area.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		jScrollPane1.setViewportView(comment_area);

		n_likes.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		n_likes.setText(String.valueOf(
				dblike.getLikes(com.getIDComment().get()) - dblike.getDislikes(com.getIDComment().get())));// Likes - dislikes
		n_likes.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		like.addActionListener(e ->{
			dblike.setLike(com.getIDComment().get(), user.getId());
			n_likes.setText(String.valueOf(
					dblike.getLikes(com.getIDComment().get()) - dblike.getDislikes(com.getIDComment().get())));// Likes - dislikes
			
		});
		
		dislike.addActionListener(e ->{
			dblike.setDislike(com.getIDComment().get(), user.getId());
			n_likes.setText(String.valueOf(
					dblike.getLikes(com.getIDComment().get()) - dblike.getDislikes(com.getIDComment().get())));// Likes - dislikes
			
		});
		
		
		menu.setText(".");
		menu.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		date_user.setFont(new Font("Tahoma", 0, 14)); // NOI18N

		// date_user.setText(this.discussion.getData() + "by " +
		// dbuser.getUser(discussion.getIdUser()).get().getUsername());
		date_user.setHorizontalAlignment(SwingConstants.RIGHT);

		date_user.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		date_user.setText(sdf.format(com.getData()) + " by " + dbuser.getUser(com.getIDUser()).get().getUsername());

		comment_area.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		jScrollPane1.setViewportView(comment_area);
		GroupLayout comment_partLayout = new GroupLayout(comment_part);

		comment_partLayout.setAutoCreateContainerGaps(true);
		comment_partLayout.setAutoCreateGaps(true);
		comment_part.setLayout(comment_partLayout);
		comment_partLayout.setHorizontalGroup(comment_partLayout.createSequentialGroup()
				.addGroup(comment_partLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)

						.addGroup(comment_partLayout.createSequentialGroup().addComponent(n_likes)
								.addComponent(like, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(dislike, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(date_user, GroupLayout.Alignment.TRAILING))
				.addComponent(menu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE));

		comment_partLayout.setVerticalGroup(comment_partLayout.createSequentialGroup()
				.addGroup(comment_partLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addComponent(menu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))

				.addGroup(comment_partLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(n_likes)
						.addComponent(like, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(dislike, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(date_user)));

		comment_panel.add(comment_part, new AbsoluteConstraints(0, 0, 1080, -1));

		add(comment_part);
	}

	private JPanel comment_part;
	private JButton menu;
	private JPanel comment_panel;
	private JButton like;
	private JButton dislike;
	private JLabel date_user;
	private JLabel n_likes;
	private JScrollPane jScrollPane1;
	private JEditorPane comment_area;

}