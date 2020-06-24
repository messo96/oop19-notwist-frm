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
	/*
	 * Random discussion when pressing the button.
	 */
	private static final long serialVersionUID = 1L;
	private DiscussionImplDB dbdiscussion = new DiscussionImplDB();
	private Loader loader;

	public RandomPan(final TableDiscussion tableDiscussion, final User user) {
		this.loader = Loader.getInstance();
		drawComp(tableDiscussion, user);
	}

	private void drawComp(final TableDiscussion tableDiscussion, final User user) {
		randomButton = new JButton("Scegli una discussione randomica!");
		buttonPanel = new JPanel();
		GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
		buttonPanel.setLayout(buttonPanelLayout);
		buttonPanelLayout.setHorizontalGroup(
				buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(randomButton,
						GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE));
		buttonPanelLayout
				.setVerticalGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(buttonPanelLayout.createSequentialGroup()
								.addComponent(randomButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGap(0, 6, Short.MAX_VALUE)));
		add(buttonPanel);

		randomButton.addActionListener(e -> {
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

	private JButton randomButton;
	private JPanel buttonPanel;
}
