package topic;


import java.awt.Color;

import javax.swing.JPanel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;


import topic.Topic;


public class TopicPan extends JPanel {
	private static final long serialVersionUID = 1L;

	public TopicPan() {
		initComponents();

	}

	private void initComponents() {

	topic_panel= new JPanel();
	 topic = new Topic();
	 topic_panel.add(topic, new AbsoluteConstraints(0, 0, -1,-1));
	 topic_panel.setBackground(new Color(12,15,163));

	add(topic_panel);
		
	}
	private  Topic topic;
	private JPanel topic_panel;

}

















