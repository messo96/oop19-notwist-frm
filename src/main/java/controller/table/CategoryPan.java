package controller.table;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;
import javax.swing.border.TitledBorder;

import controller.database.CategoryImplDB;
import model.Loader;
import model.base.CategoryImpl;
import model.database.CategoryDB;
import view.TableDiscussion;

public class CategoryPan extends JPanel {
	
	/**
	 * Creating a Panel for categories, it is going to filter the table.
	 */

	private static final long serialVersionUID = 1L;
	private Loader loader = Loader.getInstance();
	private CategoryImplDB dbcategory = new CategoryImplDB();
	private CategoryImpl cat;

	public CategoryPan(final TableDiscussion tableDiscussion) {
		drawComp(tableDiscussion);
	}

	private void drawComp(final TableDiscussion tableDiscussion) {

		categoryPanel = new JPanel();
		categoryList = new JScrollPane();
		jList = new JList<>();
		categoryPanel.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0, 0, 0)),
						"category", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 14))); // NOI18N
		categoryPanel.setFont(new Font("Tahoma", 0, 14)); // NOI18N

		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		categoryList.setViewportView(jList);

		jList.setFont(new Font("Tahoma", 0, 14)); // NOI18N

		GroupLayout categoryPanelLayout = new GroupLayout(categoryPanel);
		categoryPanel.setLayout(categoryPanelLayout);
		categoryPanelLayout.setHorizontalGroup(categoryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(categoryPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(categoryList, 210, 210, Short.MAX_VALUE).addContainerGap()));
		categoryPanelLayout.setVerticalGroup(categoryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(categoryPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(categoryList, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE).addContainerGap())

		);

		jList.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			List<CategoryImpl> list = new CategoryDB().read();

			public int getSize() {
				return list.size();
			}

			public String getElementAt(final int i) {
				return list.get(i).getName();
			}
		});

		// Filter results of discussions by choosen category on list on the right.
		jList.addMouseListener(new MouseAdapter() {

			public void mouseClicked(final MouseEvent e) {
				loader.start();
				new SwingWorker<String, Object>() {

					@Override
					protected String doInBackground() throws Exception {
						if (cat != null && jList.getSelectedValue().equals(cat.getName())) {
							tableDiscussion.refreshTableDiscussion();
							jList.clearSelection();
							cat = null;

						} else {
							cat = dbcategory.getCategory(jList.getSelectedValue()).get();
							tableDiscussion.refreshTableDiscussion(cat);

						}

						loader.end();

						return "";
					}

				}.execute();
			}
		});

		add(categoryPanel);
	}

	private JPanel categoryPanel;
	private JScrollPane categoryList;
	private JList<String> jList;

}
