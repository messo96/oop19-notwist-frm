package view.topic.comment;

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

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import controller.database.LikeDislikeImplCommentsDB;
import controller.database.UserImplDB;
import controller.database.ILikeDislikeDB;
import model.base.User;
import rombo.new_class.CommentsImplement;

public class Comment extends JPanel {

	/**
	 * Creates a new comment.
	 */

	private static final long serialVersionUID = 1L;
	private UserImplDB dbuser = new UserImplDB();
	private ILikeDislikeDB dblike = new LikeDislikeImplCommentsDB();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private User user;

	public Comment(final CommentsImplement com, final User user) {
		initComponents(com);
		this.user = user;
	}

	@SuppressWarnings("unchecked")

	private void initComponents(final CommentsImplement com) {

		commentPanel = new JPanel();
		commentPart = new JPanel();
		nLikes = new JLabel();
		menu = new JButton();
		Icon yes = new ImageIcon(this.getClass().getClassLoader().getResource("img/like.png"));
		Icon no = new ImageIcon(this.getClass().getClassLoader().getResource("img/dislike.png"));
		like = new JButton(yes);
		dislike = new JButton(no);
		dateUser = new JLabel();
		jScrollPane1 = new JScrollPane();
		commentArea = new JEditorPane();

		commentPanel.setLayout(new AbsoluteLayout());

		jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		// Comment area
		commentArea.setText(com.getComment());
		commentArea.setEditable(false);
		commentArea.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		jScrollPane1.setViewportView(commentArea);

		nLikes.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		nLikes.setText(String
				.valueOf(dblike.getLikes(com.getIDComment().get()) - dblike.getDislikes(com.getIDComment().get()))); // Likes
																													// -
																													// dislikes
		nLikes.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		like.addActionListener(e -> {
			dblike.setLike(com.getIDComment().get(), user.getId());
			nLikes.setText(String
					.valueOf(dblike.getLikes(com.getIDComment().get()) - dblike.getDislikes(com.getIDComment().get()))); // Likes
																														// -
																														// dislikes

		});

		dislike.addActionListener(e -> {
			dblike.setDislike(com.getIDComment().get(), user.getId());
			nLikes.setText(String
					.valueOf(dblike.getLikes(com.getIDComment().get()) - dblike.getDislikes(com.getIDComment().get()))); // Likes
																														// -
																														// dislikes

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
		

		dateUser.setFont(new Font("Tahoma", 0, 14)); // NOI18N

		// date_user.setText(this.discussion.getData() + "by " +
		// dbuser.getUser(discussion.getIdUser()).get().getUsername());
		dateUser.setHorizontalAlignment(SwingConstants.RIGHT);

		dateUser.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		dateUser.setText(sdf.format(com.getData()) + " by " + dbuser.getUser(com.getIDUser()).get().getUsername());

		commentArea.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		jScrollPane1.setViewportView(commentArea);
		GroupLayout commentPartLayout = new GroupLayout(commentPart);

		commentPartLayout.setAutoCreateContainerGaps(true);
		commentPartLayout.setAutoCreateGaps(true);
		commentPart.setLayout(commentPartLayout);
		commentPartLayout.setHorizontalGroup(commentPartLayout.createSequentialGroup()
				.addGroup(commentPartLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)

						.addGroup(commentPartLayout.createSequentialGroup().addComponent(nLikes)
								.addComponent(like, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(dislike, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(dateUser, GroupLayout.Alignment.TRAILING))
				.addComponent(menu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE));

		commentPartLayout.setVerticalGroup(commentPartLayout.createSequentialGroup()
				.addGroup(commentPartLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addComponent(menu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))

				.addGroup(commentPartLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(nLikes)
						.addComponent(like, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(dislike, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateUser)));

		commentPanel.add(commentPart, new AbsoluteConstraints(0, 0, 1080, -1));

		add(commentPart);
	}

	private JPanel commentPart;
	private JButton menu;
	private JPanel commentPanel;
	private JButton like;
	private JButton dislike;
	private JLabel dateUser;
	private JLabel nLikes;
	private JScrollPane jScrollPane1;
	private JEditorPane commentArea;

}
