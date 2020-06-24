package view.profile;

import javax.swing.JPanel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import model.base.User;
import user.UserDiscussions;
import user.Infos;
import view.util.StrikePan;

public class Profile extends JPanel {

	private static final long serialVersionUID = 1L;
	
	
	/**
     * Creates new Profile Panel.
     * @param user is the logged user
     */
    public Profile(final User user) {
        initComponents(user);
        
    }
 
    private void initComponents(final User user) {

    	//Part of moderator.
    	if (user.isModerator()) {

    	   	profilePanel = new JPanel();
            profilePanel.setLayout(new AbsoluteLayout());

            myinfosPanel = new Infos(user);
            profilePanel.add(myinfosPanel, new  AbsoluteConstraints(730, 0, -1, -1));

            strikePanel = new StrikePan();
            profilePanel.add(strikePanel, new  AbsoluteConstraints(730, 150, 310, 310));
           add(profilePanel);

    	 } else { //Part of normal user.

    	profilePanel = new  JPanel();
        profilePanel.setLayout(new  AbsoluteLayout());

        activitiesPanel = new UserDiscussions(user);
        profilePanel.add(activitiesPanel, new  AbsoluteConstraints(10, 0,  -1, -1));

        myinfosPanel = new Infos(user);
        profilePanel.add(myinfosPanel, new  AbsoluteConstraints(730, 0, -1, -1));

        add(profilePanel);
       }
    }

    
    private JPanel profilePanel;
    private UserDiscussions activitiesPanel;
    private Infos myinfosPanel;
    private StrikePan strikePanel;
    
}
