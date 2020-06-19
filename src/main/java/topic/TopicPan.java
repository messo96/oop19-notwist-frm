package topic;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;


//In realtà ci sono gli altri import nascosti ma PER ORA non servono in quanto nello stesso package

public class TopicPan extends JPanel {
	private static final long serialVersionUID = 1L;

	public TopicPan() {
		
		initComponents();
	}

	private void initComponents() {
		jScrollPane1 = new JScrollPane();
		topic_panel= new JPanel();
	
		topic_panel.setLayout(new AbsoluteLayout());
	 
		//We're scrolling here uuh
		jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		jScrollPane1.setPreferredSize(new Dimension(1080,490));
	
		topic = new Topic();

		topic_panel.add(topic, new AbsoluteConstraints(0, 0, -1,-1));
		topic.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		new_comment = new Newcomment();
		topic_panel.add(new_comment, new AbsoluteConstraints(0,300,-1,-1));
	 
		comments = new AllComments();
		topic_panel.add(comments, new AbsoluteConstraints(0,440,-1,-1));
		comments.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		jScrollPane1.setViewportView(topic_panel);
		add(jScrollPane1);
		
	}
	
	private JScrollPane jScrollPane1;
	private Topic topic;
	private JPanel topic_panel;
	private Newcomment new_comment;
	private AllComments comments;
}
















