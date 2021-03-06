package view.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import controller.table.Header;
import model.Loader;
import model.base.User;
import view.TableDiscussion;
import view.profile.Profile;
import view.topic.newtopic.NewTopicPan;
import view.util.UpperPan;

public class BuildAfterGui extends JFrame {
	
	//Fields.
	private static final long serialVersionUID = 1L;
	private TableDiscussion tableDiscussion;
	private User user;
	private Loader loader = Loader.getInstance();

	/*Builder.*/
	public BuildAfterGui(final User user) {
		this.user = user;
		this.tableDiscussion = new TableDiscussion(user);
		initComponents(tableDiscussion);

	}

	private void initComponents(final TableDiscussion tableDiscussion) {
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getClassLoader().getResource("img/icon.jpg"));    
        setIconImage(icon);   
		loader.start();
		bodyHolder = new JPanel(); // Holder for body.

		// JFrame properties.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setUndecorated(true);
		setResizable(false);
		getContentPane().setLayout(new AbsoluteLayout());

		
		// Get upper panel and add it to the main frame.
		upper_panel = new UpperPan();
		upper_panel.setVisible(true);

		getContentPane().add(upper_panel, new AbsoluteConstraints(670, 0, -1, 40));

		bodyHolder.setLayout(new CardLayout());
		// Add HolderPan with the homepage tables to card.
		holder_panel = new HolderPan(tableDiscussion, user);
		holder_panel.setVisible(true);
		bodyHolder.add(holder_panel, "homepage_panel");
		newtopic_panel = new NewTopicPan(user, tableDiscussion);
		newtopic_panel.setVisible(true);
		bodyHolder.add(newtopic_panel, "newtopic_panel");
		profile_panel = new Profile(user);
		profile_panel.setVisible(true);
		bodyHolder.add(profile_panel, "profile_panel");
		bodyHolder.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.BLACK));

		// Adding card.
		getContentPane().add(bodyHolder, new AbsoluteConstraints(0, 120, 1080, 490));

		header_panel = new Header(tableDiscussion, bodyHolder, user);
		header_panel.setVisible(true);

		getContentPane().add(header_panel, new AbsoluteConstraints(0, 20, 1080, -1));
		loader.end();
		pack();

		// Methods place.

		// Call Drag the frame.
		getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				FrameMouseDragged(evt);
			}
		});
		getContentPane().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				FrameMousePressed(evt);
			}
		});
	}

	// End method place.

	// Drag the frame.
	private int xy;
	private int xx;

	private void FrameMouseDragged(MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xx, y - xy);
	}

	private void FrameMousePressed(MouseEvent evt) {
		xx = evt.getX();
		xy = evt.getY();
	}

	public void start() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				setVisible(true);
			}
		});
	}

	
	private JPanel bodyHolder;
	private HolderPan holder_panel;
	private UpperPan upper_panel;
	private Header header_panel;
	private NewTopicPan newtopic_panel;
	private Profile profile_panel;

	
}