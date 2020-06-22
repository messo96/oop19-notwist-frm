package controller.table;

import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingWorker;

import controller.database.DiscussionImplDB;
import model.Loader;
import model.base.DiscussionImpl;
import model.base.User;

import view.TableDiscussion;
import view.topic.TopicPan;

public class RandomPan extends JPanel {

	private static final long serialVersionUID = 1L;
	private DiscussionImplDB dbdiscussion = new DiscussionImplDB();
	private Loader loader;

	public RandomPan(TableDiscussion tableDiscussion, User user) {
		this.loader = Loader.getInstance();
		drawComp(tableDiscussion, user);
	}

	private void drawComp(TableDiscussion tableDiscussion, User user) {
		random_button = new JButton("Scegli una discussione randomica!");
		button_panel = new JPanel();
		GroupLayout button_panelLayout = new GroupLayout(button_panel);
		button_panel.setLayout(button_panelLayout);
		button_panelLayout.setHorizontalGroup(
				button_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(random_button,
						GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE));
		button_panelLayout
				.setVerticalGroup(button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(button_panelLayout.createSequentialGroup()
								.addComponent(random_button, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGap(0, 6, Short.MAX_VALUE)));
		add(button_panel);

		random_button.addActionListener(e -> {
			loader.start();
			new SwingWorker<String, Object>() {

				@Override
				protected String doInBackground() throws Exception {
					JTable table = tableDiscussion.getTableDiscussion();
					Random rand = new Random();
					Integer r = rand.nextInt(table.getRowCount());

					DiscussionImpl disc = dbdiscussion
							.getDiscussion(Integer.parseInt(table.getModel().getValueAt(r, 6).toString())).get();
					JFrame fr = new JFrame();
					fr.setContentPane(new TopicPan(disc, user));
					fr.pack();
					fr.setVisible(true);
					loader.end();
					return "";
				}
			}.execute();

		});

	}

	private JButton random_button;
	private JPanel button_panel;
}
