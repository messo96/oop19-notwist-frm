package view.topic;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import controller.database.CommentsImplDB;
import model.base.DiscussionImpl;
import model.base.User;
import rombo.new_class.CommentsImplement;
import view.topic.comment.AllComments;
import view.topic.comment.Newcomment;

public class TopicPan extends JPanel {
	
	//Fields.
	private static final long serialVersionUID = 1L;
	private CommentsImplDB dbcomment = new CommentsImplDB();

	/*Builder.*/
	public TopicPan(final DiscussionImpl disc, final User user) {

		initComponents(disc, user);
	}

	private void initComponents(final DiscussionImpl disc, final User user) {
		bodyScroll = new JScrollPane();
		topicPanel = new JPanel();

		topicPanel.setLayout(new AbsoluteLayout());

		// Scroll implement.
		bodyScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		bodyScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		bodyScroll.setPreferredSize(new Dimension(1080, 490));
		bodyScroll.getVerticalScrollBar().setUnitIncrement(16);

		topic = new Topic(disc, user);

		topicPanel.add(topic, new AbsoluteConstraints(0, 0, -1, -1));
		topic.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		newComment = new Newcomment(disc.getIdDiscussion(), user.getId());
		topicPanel.add(newComment, new AbsoluteConstraints(0, 300, -1, -1));
		List<CommentsImplement> list = dbcomment.getComments(disc.getIdDiscussion()).get();
		if (list.size() != 0) {
			comments = new AllComments(disc.getIdDiscussion(), list, user);
			topicPanel.add(comments, new AbsoluteConstraints(0, 440, -1, -1));
			comments.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		}
		bodyScroll.setViewportView(topicPanel);
		add(bodyScroll);

	}

	private JScrollPane bodyScroll;
	private Topic topic;
	private JPanel topicPanel;
	private Newcomment newComment;
	private AllComments comments;
}
