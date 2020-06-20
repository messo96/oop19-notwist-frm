package topic;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.Optional;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import controller.database.DBCommentsImpl;
import model.base.DiscussionImpl;
import model.base.User;
import rombo.new_class.CommentsImplement;

//In realtà ci sono gli altri import nascosti ma PER ORA non servono in quanto nello stesso package

public class TopicPan extends JPanel {
	private static final long serialVersionUID = 1L;
	private DBCommentsImpl dbcomment = new DBCommentsImpl();

	public TopicPan(DiscussionImpl disc, User user) {

		initComponents(disc, user);
	}

	private void initComponents(DiscussionImpl disc, User user) {
		jScrollPane1 = new JScrollPane();
		topic_panel = new JPanel();

		topic_panel.setLayout(new AbsoluteLayout());

		// We're scrolling here uuh
		jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		jScrollPane1.setPreferredSize(new Dimension(1080, 490));

		topic = new Topic(disc, user);

		topic_panel.add(topic, new AbsoluteConstraints(0, 0, -1, -1));
		topic.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		new_comment = new Newcomment(disc.getIdDiscussion(), user.getId());
		topic_panel.add(new_comment, new AbsoluteConstraints(0, 300, -1, -1));
		List<CommentsImplement> list = dbcomment.getComments(disc.getIdDiscussion()).get();
		if (list.size() != 0) {
			comments = new AllComments(disc.getIdDiscussion(), list, user);
			topic_panel.add(comments, new AbsoluteConstraints(0, 440, -1, -1));
			comments.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		}
		jScrollPane1.setViewportView(topic_panel);
		add(jScrollPane1);
		
	}

	private JScrollPane jScrollPane1;
	private Topic topic;
	private JPanel topic_panel;
	private Newcomment new_comment;
	private AllComments comments;
}
