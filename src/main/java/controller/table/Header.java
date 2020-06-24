package controller.table;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import controller.database.CategoryImplDB;
import model.base.CategoryImpl;
import model.base.User;
import view.TableDiscussion;


public class Header extends JPanel {

	/*
	 * Building the Header with drawComp as Builder.
	 */
	private static final long serialVersionUID = 1L;
	private CategoryImplDB dbcategory = new CategoryImplDB();
	private CardLayout card;
	private JPanel parent;
	private DefaultTableModel model;
	private final ImageIcon iHome = new ImageIcon(this.getClass().getClassLoader().getResource("img/Ihome.png"));
	private final ImageIcon iSearch = new ImageIcon(this.getClass().getClassLoader().getResource("img/Isearch.png"));
	private final ImageIcon iProfile = new ImageIcon(this.getClass().getClassLoader().getResource("img/Iprofile.png"));
	private final ImageIcon iPencil = new ImageIcon(
			this.getClass().getClassLoader().getResource("img/Ipencilsmaller.png"));

	public Header(final TableDiscussion tableDiscussion, final JPanel parent, final User user) {
		this.parent = parent;
		this.card = (CardLayout) parent.getLayout();
		drawComp(tableDiscussion, user);
	}

	private void drawComp(final TableDiscussion tableDiscussion, final User user) {

		headerPanel = new JPanel();
		homepageButton = new JLabel();
		addCatbtn = new JButton(); // Add new category.
		profileIcon = new JLabel(); 
		newDiscussion = new JButton();
		searchField = new JTextField(); // Search area.
		searchButton = new JButton();
		catDialog = new JDialog();
		catPan = new JPanel();
		catScroll = new JScrollPane();
		catTable = new JTable();
		newCat = new JTextField();
		addbtn = new JButton();

		catDialog.setTitle("Lista Categorie");
		Image iPen = Toolkit.getDefaultToolkit()
				.getImage(this.getClass().getClassLoader().getResource("img/Ipencilsmaller.png"));
		catDialog.setIconImage(iPen);

		fillTable(catTable);

		catTable.getTableHeader().setResizingAllowed(false);
		catTable.getTableHeader().setReorderingAllowed(false);
		catScroll.setViewportView(catTable);
		if (catTable.getColumnModel().getColumnCount() > 0) {
			catTable.getColumnModel().getColumn(0).setResizable(false);
		}
		newCat.setText("");

		addbtn.setText("Aggiungi");

		addbtn.addActionListener(e -> {
			if (!newCat.getText().isBlank() && !dbcategory.createCategory(newCat.getText())) {
				JOptionPane.showMessageDialog(null, "Something goes wrong! :(");
			} else {
				fillTable(catTable);
				newCat.setText("");
			}
		});

		addbtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent evt) {
				addbtnMouseClicked(evt);
			}

		});

		GroupLayout catDialogLayout = new GroupLayout(catPan);
		catPan.setLayout(catDialogLayout);
		catDialogLayout.setHorizontalGroup(catDialogLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(catDialogLayout.createSequentialGroup().addGroup(catDialogLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(catDialogLayout.createSequentialGroup().addGap(26, 26, 26)
								.addComponent(newCat, GroupLayout.PREFERRED_SIZE, 163,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(addbtn))
						.addGroup(catDialogLayout.createSequentialGroup().addGap(23, 23, 23).addComponent(catScroll,
								GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(22, Short.MAX_VALUE)));
		catDialogLayout.setVerticalGroup(catDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(catDialogLayout.createSequentialGroup().addGap(26, 26, 26)
						.addComponent(catScroll, GroupLayout.PREFERRED_SIZE, 245,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(catDialogLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(newCat, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(addbtn))
						.addContainerGap(20, Short.MAX_VALUE)));

		catDialog.add(catPan);

		homepageButton.setFont(new Font("Bauhaus 93", 0, 18)); // NOI18N
		homepageButton.setText("NOTWIST");
		homepageButton.setVerticalAlignment(SwingConstants.BOTTOM);

		homepageButton.setIcon(iHome);

		homepageButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent evt) {
				homepageButtonMouseClicked(evt);
			}
		});

			addCatbtn.setFont(new Font("Tahoma", 0, 14)); // NOI18N
			addCatbtn.setText("Aggiungi una categoria");
			if (!user.isModerator()) {
				addCatbtn.setVisible(false);
			}
			addCatbtn.addMouseListener(new MouseAdapter() {
				public void mouseClicked(final MouseEvent evt) {
					categoryFilterMouseClicked(evt);
				}
			});


		profileIcon.setIcon(iProfile);

		newDiscussion.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		newDiscussion.setText("Crea una nuova discussione");
		newDiscussion.setIcon(iPencil);
		newDiscussion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent evt) {
				newDiscussionMouseClicked(evt);
			}
		});

		searchField.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		searchField.setText("Search..");
		searchField.setMargin(new Insets(2, 2, 2, 3));
		searchField.setPreferredSize(new Dimension(7, 25));
		searchField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(final FocusEvent e) {
				if (searchField.getText().equals("Search..")) {
					searchField.setText("");
				}
			}

			@Override
			public void focusLost(final FocusEvent e) {
				if (searchField.getText().equals("")) {
				searchField.setText("Search..");
				}
			}

		});
		searchButton.setText("Go");
		searchButton.setIcon(iSearch);

		searchButton.addActionListener(e -> {
			if (searchField.getText().equals("") || searchField.getText().equals("Search..")) {
				tableDiscussion.refreshTableDiscussion();
			} else {
				tableDiscussion.refreshTableDiscussion(searchField.getText());
			}
		});

		GroupLayout headerPanelLayout = new GroupLayout(headerPanel);
		headerPanel.setLayout(headerPanelLayout);
		headerPanelLayout
				.setHorizontalGroup(headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(headerPanelLayout.createSequentialGroup().addGap(10, 10, 10)
								.addComponent(homepageButton).addGap(25, 25, 25)
								.addComponent(addCatbtn, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(100, 100, 100)
								.addComponent(searchField, GroupLayout.PREFERRED_SIZE, 218,
										GroupLayout.PREFERRED_SIZE)
								.addGap(5, 5, 5)
								.addComponent(searchButton, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(25, 25, 25).
								addComponent(newDiscussion)
								.addGap(50, 50, 50)

								.addComponent(profileIcon, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addGap(10, 10, 10)));
		headerPanelLayout.setVerticalGroup(headerPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(headerPanelLayout.createSequentialGroup().addGap(45, 45, 45)
						.addGroup(headerPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(newDiscussion, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(headerPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(addCatbtn, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(profileIcon)
								.addComponent(searchField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 29,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(homepageButton)))
						.addGap(16, 16, 16)));

		profileIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent evt) {
				profileIconMouseClicked(evt);
			}
		});
		add(headerPanel);

	}

	private void fillTable(final JTable table) {
		model = new DefaultTableModel(new Object[] { "Nome" }, 0);
		model.getDataVector().removeAllElements();
		for (CategoryImpl c : dbcategory.getAll()) {
			model.addRow(new Object[] { c.getName() });
		}
		table.setModel(model);

	}

	private void newDiscussionMouseClicked(final MouseEvent evt) {
		card.show(parent, "newtopic_panel");
	}

	private void homepageButtonMouseClicked(final MouseEvent evt) {
		card.show(parent, "homepage_panel");
	}

	private void profileIconMouseClicked(final MouseEvent evt) {
		card.show(parent, "profile_panel");
	}

	private void addbtnMouseClicked(final MouseEvent evt) {
		// TODO Auto-generated method stub

	}

	private void categoryFilterMouseClicked(final MouseEvent evt) {
		try {
			UIManager.getLookAndFeel();
			SwingUtilities.updateComponentTreeUI(catDialog);
			catDialog.getContentPane();
			catDialog.setSize(400, 350);
			catDialog.setResizable(false);
			catDialog.pack();
			catDialog.setLocationRelativeTo(getParent());
			catDialog.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Failed to initialize LaF");
			ex.printStackTrace();
		}
	}

	private JButton addCatbtn;
	private JPanel headerPanel;
	private JLabel homepageButton;
	private JButton newDiscussion;
	private JLabel profileIcon;
	private JButton searchButton;
	private JTextField searchField;
	private JDialog catDialog;
	private JScrollPane catScroll;
	private JTable catTable;
	private JTextField newCat;
	private JButton addbtn;
	private JPanel catPan;
}
