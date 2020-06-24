package view.topic.comment;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import controller.database.CommentsImplDB;

public class Newcomment extends JPanel {

	/**
	 * Creates a new comment
	 */

	private static final long serialVersionUID = 1L;
	private Integer idDiscussion;
	private Integer idUser;

	private CommentsImplDB dbcomment = new CommentsImplDB();

	public Newcomment(final Integer idDiscussion, final Integer idUser) {
		this.idDiscussion = idDiscussion;
		this.idUser = idUser;
		initComponents();

	}

	private void initComponents() {
		space = new JPanel();
		newComment = new JPanel();
		jScrollPane2 = new  JScrollPane();
		newcommentArea = new  JEditorPane();
		postIt = new  JButton();

		space.setLayout(new  AbsoluteLayout());

		newcommentArea.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		jScrollPane2.setViewportView(newcommentArea);

		postIt.setText("Commenta");
		postIt.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		postIt.addActionListener(e -> {
			if (dbcomment.createComment(idDiscussion, idUser, newcommentArea.getText())) {
				JOptionPane.showMessageDialog(null, "Comment create successfully");
			} else {
				JOptionPane.showMessageDialog(null, "Error");
			}
		});

		 GroupLayout newCommentLayout = new  GroupLayout(newComment);

		newCommentLayout.setAutoCreateContainerGaps(true);
		newCommentLayout.setAutoCreateGaps(true);
		newComment.setLayout(newCommentLayout);
		newCommentLayout.setHorizontalGroup(newCommentLayout.createSequentialGroup()
				.addGroup(newCommentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)
						.addComponent(postIt, GroupLayout.Alignment.TRAILING)));

		newCommentLayout.setVerticalGroup(newCommentLayout.createSequentialGroup()

				.addGroup(newCommentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
				.addGroup(newCommentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(postIt)));

		space.add(newComment, new  AbsoluteConstraints(20, 0, 1080, -1));
		add(space);

	}

	private  JScrollPane jScrollPane2;
	private JPanel space;
	private  JPanel newComment;
	private JEditorPane newcommentArea;
	private  JButton postIt;

}
