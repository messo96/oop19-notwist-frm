package view.util;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LogoPan extends JPanel {

	private static final long serialVersionUID = 1L;

	/*Builder.*/
	public LogoPan() {

		drawComp();
	}
	
	private void drawComp() {

        logoPanel = new JPanel();
        logo = new JLabel();

        //Draw logoPanel, get the picture and fix the size to fit the panel itself.
        logoPanel.setBackground(new Color(67, 71, 91));
        logo.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("img/font_test_1.png"))); // NOI18N
        logo.setDoubleBuffered(true);
        logo.setFocusable(false);
        logo.setRequestFocusEnabled(false);
        logo.setVerifyInputWhenFocusTarget(false);

        GroupLayout logoPanelLayout = new GroupLayout(logoPanel);
        logoPanel.setLayout(logoPanelLayout);

        logoPanelLayout.setHorizontalGroup(
            logoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(logo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        logoPanelLayout.setVerticalGroup(
            logoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, logoPanelLayout.createSequentialGroup()
            		.addComponent(logo, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
            		.addGap(0, 0, Short.MAX_VALUE))
        );

        add(logoPanel);
	}

    private JLabel logo;
    private JPanel logoPanel;
}


