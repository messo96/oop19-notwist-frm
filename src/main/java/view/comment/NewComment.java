package view.comment;

import javax.swing.JPanel;

public class NewComment extends JPanel {
	private static final long serialVersionUID = 1L;

	
	// Creates new Profile Panel
	
	/*Builder.*/
	public NewComment() {
		initComponents();
	}

	private void initComponents() {
		newpost = new javax.swing.JPanel();
		post_it = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		newcomment_area = new javax.swing.JTextArea();

		newcomment_area.setColumns(20);
		newcomment_area.setRows(5);
		newcomment_area.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		jScrollPane2.setViewportView(newcomment_area);

		javax.swing.GroupLayout newpostLayout = new javax.swing.GroupLayout(newpost);
		newpost.setLayout(newpostLayout);
		newpostLayout.setHorizontalGroup(newpostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(newpostLayout.createSequentialGroup().addContainerGap()
						.addGroup(newpostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(post_it, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 740,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(48, Short.MAX_VALUE)));
		newpostLayout
				.setVerticalGroup(
						newpostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(newpostLayout.createSequentialGroup().addGap(20, 20, 20)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(post_it, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(16, Short.MAX_VALUE)));

		add(newpost, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 800, 190));

	}

	

	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea newcomment_area;
	private javax.swing.JPanel newpost;
	private javax.swing.JButton post_it;

}
