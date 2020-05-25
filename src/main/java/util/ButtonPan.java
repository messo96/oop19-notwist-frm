package util;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPan extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public ButtonPan() {
		
		drawComp();
	}
	
	private void drawComp() {
		random_button = new JButton();
		button_panel = new JPanel();
	       random_button.setLabel("Scegli una discussione randomica!");

	        GroupLayout button_panelLayout = new GroupLayout(button_panel);
	        button_panel.setLayout(button_panelLayout);
	        button_panelLayout.setHorizontalGroup(
	            button_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(random_button, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
	        );
	        button_panelLayout.setVerticalGroup(
	            button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(button_panelLayout.createSequentialGroup()
	                .addComponent(random_button, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                .addGap(0, 6, Short.MAX_VALUE))
	        );
	        add(button_panel);
	}
	private JButton random_button;
	private JPanel button_panel;
}
