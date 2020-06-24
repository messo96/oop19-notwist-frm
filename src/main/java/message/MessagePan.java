package message;

import javax.swing.JPanel;

import model.base.User;


public class MessagePan extends JPanel {

	private static final long serialVersionUID = 1L;
	/**
     * Creates new MessagePan to hold messages and chat
     */
    public MessagePan(final User user) {
        initComponents(user);
    }

    private void initComponents(final User user) {
    	
    	message_panel = new JPanel();
    	
    	historymsg_panel = new HistoryMsg(user);
    	newmsg_panel = new NewMsg();
       
    	if(user.isModerator()) {
        message_panel.add(historymsg_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 670, 220));

        message_panel.add(newmsg_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 310, 220));              
        
        add(message_panel);      
    	}else {
    		
            message_panel.add(historymsg_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 670, 220));

            message_panel.add(newmsg_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 340, 310, 220));              
            
            add(message_panel);    
    	}
    }
     
    private JPanel message_panel;
    private HistoryMsg historymsg_panel;
    private NewMsg newmsg_panel;
    
}
