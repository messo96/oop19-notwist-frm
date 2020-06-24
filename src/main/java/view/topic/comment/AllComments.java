package view.topic.comment;

import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import controller.database.CommentsImplDB;
import model.base.Comments;
import model.base.User;
import rombo.new_class.CommentsImplement;

public class AllComments extends JPanel {

	
	// JPanel to handle all comments.
	
	//Fields.
	private static final long serialVersionUID = 1L;
	private User user;
	private GroupLayout.ParallelGroup parallel;
	private GroupLayout.SequentialGroup sequential;
	private List<CommentsImplement> list;
	
	/*Build*/
	public AllComments(final Integer idDiscussion, final List<CommentsImplement> list, final User user) {
		this.user = user;
		this.list = list;
		initComponents(idDiscussion);

	}

	private void initComponents(final Integer idDiscussion) {

    	panel = new JPanel();
    	history = new JPanel();

    	panel.setLayout(new AbsoluteLayout());

    	GroupLayout historyLayout = new GroupLayout(history);

    	//Calling same instance to check the print.
    	history.setLayout(historyLayout);
    	parallel = historyLayout.createParallelGroup();
    	historyLayout.setHorizontalGroup(historyLayout.createSequentialGroup().addGroup(parallel));
    	sequential = historyLayout.createSequentialGroup();
    	historyLayout.setVerticalGroup(sequential);

    		for (CommentsImplement c : list) {
            	comment = new Comment(c, user);
            	parallel.addGroup(historyLayout.createSequentialGroup().addComponent(comment));
            	sequential.addGroup(historyLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(comment));
        	}

    	panel.add(history, new AbsoluteConstraints(0, 0, 1080, -1));
    	add(panel);

    }

	private JPanel panel;
	private JPanel history;
	private Comment comment;

}
