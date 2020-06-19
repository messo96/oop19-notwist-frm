package topic;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class AllComments extends JPanel {

	/**
	 * JPanel to handle all comments
	 */
	private static final long serialVersionUID = 1L;

	public AllComments() {
		initComponents();

	}
    private void initComponents() {
    	
    	panel = new JPanel();
    	history = new JPanel();
    	
    	panel.setLayout(new AbsoluteLayout());

    	GroupLayout historyLayout = new GroupLayout(history);

    	//Calling same instance to check the print
    	comment = new Comment();
    	comment2 = new Comment();
    	comment3 = new Comment();
    	
    	historyLayout.setAutoCreateContainerGaps(true);
    	historyLayout.setAutoCreateGaps(true);
		history.setLayout(historyLayout);
		historyLayout.setHorizontalGroup(historyLayout.createSequentialGroup()
                .addGroup(historyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(comment)
                        .addComponent(comment2)
                        .addComponent(comment3)));
		
		historyLayout.setVerticalGroup(historyLayout.createSequentialGroup()
                        .addComponent(comment)
                        .addComponent(comment2)
                        .addComponent(comment3));
    	
    	panel.add(history, new AbsoluteConstraints(0, 0, 1080, -1));
    	add(panel);

    }


 private JPanel panel;
 private JPanel history;
 private Comment comment;
 private Comment comment2;
 private Comment comment3;
 }


















































/*package topic;

import javax.swing.JEditorPane;
import javax.swing.JPanel;

public class AllComments extends JPanel{
	
	private static final long serialVersionUDI = 1L;
	
	public AllComments() {
		draw();
		
	}
	
	private void draw() {
				
		body_panel = new javax.swing.JPanel();
		jScrollPane7 = new javax.swing.JScrollPane();
		discussion_panel = new javax.swing.JPanel();
		jSeparator2 = new javax.swing.JSeparator();
		discussion_part = new javax.swing.JPanel();

		new_comment = new javax.swing.JPanel();

		jScrollPane5 = new javax.swing.JScrollPane();

		jScrollPane6 = new javax.swing.JScrollPane();

		
		javax.swing.GroupLayout discussion_panelLayout = new javax.swing.GroupLayout(discussion_panel);
		discussion_panel.setLayout(discussion_panelLayout);
		discussion_panelLayout.setHorizontalGroup(discussion_panelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(discussion_panelLayout.createSequentialGroup().addContainerGap()
						.addGroup(discussion_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(discussion_part, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1080,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(new_comment, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 919,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(discussion_panelLayout.createSequentialGroup().addGap(9, 9, 9).addComponent(
										jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 919,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		discussion_panelLayout
				.setVerticalGroup(discussion_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(discussion_panelLayout.createSequentialGroup().addContainerGap()
								.addComponent(discussion_part, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(new_comment, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 262,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 258,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));

		jScrollPane7.setViewportView(discussion_panel);

		body_panel.add(jScrollPane7);
		
	}
	

	private javax.swing.JPanel body_panel;

	private javax.swing.JPanel discussion_panel;
	private javax.swing.JPanel discussion_part;

	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JScrollPane jScrollPane6;
	private javax.swing.JScrollPane jScrollPane7;

	private javax.swing.JSeparator jSeparator2;

	private javax.swing.JPanel new_comment;


}*/
