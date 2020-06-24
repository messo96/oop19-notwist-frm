package user;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import model.base.User;

public class Infos extends JPanel {
	

	private static final long serialVersionUID = 1L;
	/*
	 * Creating the infos panel, displaying mail and user; 
	 * From the database side it is possible to change these variables, 
	 * but it's not implemented.
	 */
	public Infos(final User user) {

		drawComps(user);
	}
	
	private void drawComps(final User user) {
        myinfosPanel = new JPanel();
        name = new JLabel();
        mail = new JLabel();

        myinfosPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0)), "My Infos", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 14))); // NOI18N

        name.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        name.setText("Name:" + user.getUsername());
        name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));

        mail.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        mail.setText("Email: " + user.getEmail());
        mail.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));

        GroupLayout myinfosPanelLayout = new GroupLayout(myinfosPanel);
        myinfosPanel.setLayout(myinfosPanelLayout);
        myinfosPanelLayout.setHorizontalGroup(
            myinfosPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(myinfosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myinfosPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(name, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                    .addComponent(mail, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        myinfosPanelLayout.setVerticalGroup(
            myinfosPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(myinfosPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(mail)
                .addGap(18, 18, 18)
                .addComponent(name)
                .addContainerGap(21, Short.MAX_VALUE))
        );

		add(myinfosPanel);

	}
	
    private JLabel mail;

    private JPanel myinfosPanel;
    private JLabel name;

}
