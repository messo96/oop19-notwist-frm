package topic;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JEditorPane;
import javax.swing.JPanel;


public class Newcomment extends JPanel{

	/**
     * Creates a new comment
     */

	private static final long serialVersionUID = 1L;

   
    public Newcomment() {
        initComponents();

    }

    @SuppressWarnings("unchecked")

    private void initComponents() {
    	space = new JPanel();
		new_comment = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		newcomment_area = new javax.swing.JEditorPane();
		post_it = new javax.swing.JButton();


		space.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		newcomment_area.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		jScrollPane2.setViewportView(newcomment_area);

		post_it.setText("Commenta");
		post_it.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		post_it.addActionListener(e -> {
			//dbcomments.createComment(user.getId(), discussion.getIdDiscussion(), newcomment_area.getText());
		});

		
		javax.swing.GroupLayout new_commentLayout = new javax.swing.GroupLayout(new_comment);
		
		new_commentLayout.setAutoCreateContainerGaps(true);
		new_commentLayout.setAutoCreateGaps(true);
		new_comment.setLayout(new_commentLayout);
		new_commentLayout.setHorizontalGroup(new_commentLayout.createSequentialGroup()
                .addGroup(new_commentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)                  
                        .addComponent(post_it, GroupLayout.Alignment.TRAILING)));
         

		new_commentLayout.setVerticalGroup(new_commentLayout.createSequentialGroup()

                .addGroup(new_commentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jScrollPane2,GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                .addGroup(new_commentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(post_it)));
		
		space.add(new_comment, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 1080, -1));
		add(space);

}


	private javax.swing.JScrollPane jScrollPane2;

private JPanel space;
	private javax.swing.JPanel new_comment;

	private JEditorPane newcomment_area;
	private javax.swing.JButton post_it;

}
