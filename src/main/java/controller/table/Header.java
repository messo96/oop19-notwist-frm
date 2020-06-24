package controller.table;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import controller.database.CategoryImplDB;
import model.Loader;
import model.base.CategoryImpl;
import model.base.User;
import view.TableDiscussion;


public class Header extends JPanel {

	private static final long serialVersionUID = 1L;
	private CategoryImplDB dbcategory = new CategoryImplDB();
	private Loader loader;
	private CardLayout card;
	private JPanel parent;
	private DefaultTableModel model;
	private final ImageIcon Ihome = new ImageIcon(this.getClass().getClassLoader().getResource("img/Ihome.png"));
	private final ImageIcon Isearch = new ImageIcon(this.getClass().getClassLoader().getResource("img/Isearch.png"));
	private final ImageIcon Iprofile = new ImageIcon(this.getClass().getClassLoader().getResource("img/Iprofile.png"));
	private final ImageIcon Ipencil = new ImageIcon(
			this.getClass().getClassLoader().getResource("img/Ipencilsmaller.png"));

	public Header(TableDiscussion tableDiscussion, JPanel parent, User user) {
		this.parent = parent;
		this.card = (CardLayout) parent.getLayout();
		drawComp(tableDiscussion, user);
	}

	private void drawComp(TableDiscussion tableDiscussion, User user) {

		header_panel = new JPanel();
		homepage_button = new JLabel();
		addCatbtn = new JButton(); // Combobox per le categorie
		profile_icon = new JLabel(); // TBA
		new_discussion = new JButton();
		search_field = new JTextField(); // Spazio filtro
		search_button = new JButton();
		CatDialog = new JDialog();
		CatPan = new JPanel();
		catScroll = new JScrollPane();
		catTable = new JTable();
		newCat = new JTextField();
		addbtn = new JButton();

		CatDialog.setTitle("Lista Categorie");
		Image Ipen = Toolkit.getDefaultToolkit()
				.getImage(this.getClass().getClassLoader().getResource("img/Ipencilsmaller.png"));
		CatDialog.setIconImage(Ipen);

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
			if(!newCat.getText().isBlank() && !dbcategory.createCategory(newCat.getText()))
				JOptionPane.showMessageDialog(null, "Something goes wrong! :(");
			else {
				fillTable(catTable);
				newCat.setText("");
			}
		});
		
		addbtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				addbtnMouseClicked(evt);
			}

		});

		javax.swing.GroupLayout CatDialogLayout = new javax.swing.GroupLayout(CatPan);
		CatPan.setLayout(CatDialogLayout);
		CatDialogLayout.setHorizontalGroup(CatDialogLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(CatDialogLayout.createSequentialGroup().addGroup(CatDialogLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(CatDialogLayout.createSequentialGroup().addGap(26, 26, 26)
								.addComponent(newCat, javax.swing.GroupLayout.PREFERRED_SIZE, 163,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(addbtn))
						.addGroup(CatDialogLayout.createSequentialGroup().addGap(23, 23, 23).addComponent(catScroll,
								javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(22, Short.MAX_VALUE)));
		CatDialogLayout.setVerticalGroup(CatDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(CatDialogLayout.createSequentialGroup().addGap(26, 26, 26)
						.addComponent(catScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 245,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(CatDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(newCat, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(addbtn))
						.addContainerGap(20, Short.MAX_VALUE)));

		CatDialog.add(CatPan);

		homepage_button.setFont(new Font("Bauhaus 93", 0, 18)); // NOI18N
		homepage_button.setText("NOTWIST");
		homepage_button.setVerticalAlignment(SwingConstants.BOTTOM);

		homepage_button.setIcon(Ihome);

		homepage_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				homepage_buttonMouseClicked(evt);
			}
		});

			addCatbtn.setFont(new Font("Tahoma", 0, 14)); // NOI18N
			addCatbtn.setText("Aggiungi una categoria");
			if(!user.isModerator())
				addCatbtn.setVisible(false);
			addCatbtn.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					category_filterMouseClicked(evt);
				}
			});


		profile_icon.setIcon(Iprofile);

		new_discussion.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		new_discussion.setText("Crea una nuova discussione");
		new_discussion.setIcon(Ipencil);
		new_discussion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				new_discussionMouseClicked(evt);
			}
		});

		search_field.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		search_field.setText("Search..");
		search_field.setMargin(new Insets(2, 2, 2, 3));
		search_field.setPreferredSize(new Dimension(7, 25));
		search_field.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (search_field.getText().equals("Search.."))
					search_field.setText("");

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (search_field.getText().equals(""))
					search_field.setText("Search..");
			}

		});
		search_button.setText("Go");
		search_button.setIcon(Isearch);

		search_button.addActionListener(e -> {
			if (search_field.getText().equals("") || search_field.getText().equals("Search.."))
				tableDiscussion.refreshTableDiscussion();
			else
				tableDiscussion.refreshTableDiscussion(search_field.getText());
		});

		javax.swing.GroupLayout header_panelLayout = new javax.swing.GroupLayout(header_panel);
		header_panel.setLayout(header_panelLayout);
		header_panelLayout
				.setHorizontalGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(header_panelLayout.createSequentialGroup().addGap(10, 10, 10)
								.addComponent(homepage_button).addGap(25, 25, 25)
								.addComponent(addCatbtn, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(100, 100, 100)
								.addComponent(search_field, javax.swing.GroupLayout.PREFERRED_SIZE, 218,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(5, 5, 5)
								.addComponent(search_button, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(25, 25, 25).addComponent(new_discussion).addGap(50, 50, 50)

								.addComponent(profile_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(10, 10, 10)));
		header_panelLayout.setVerticalGroup(header_panelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(header_panelLayout.createSequentialGroup().addGap(45, 45, 45).addGroup(header_panelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(new_discussion, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(addCatbtn, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(profile_icon)
								.addComponent(search_field, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(homepage_button)))
						.addGap(16, 16, 16)));

		profile_icon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				profile_iconMouseClicked(evt);
			}
		});
		add(header_panel);

	}

	private void fillTable(JTable table) {
		model = new DefaultTableModel(new Object[] { "Nome" }, 0);
		model.getDataVector().removeAllElements();
		for (CategoryImpl c : dbcategory.getAll()) {
			model.addRow(new Object[] { c.getName() });
		}
		table.setModel(model);

	}

	private void new_discussionMouseClicked(MouseEvent evt) {
		card.show(parent, "newtopic_panel");
	}

	private void homepage_buttonMouseClicked(MouseEvent evt) {
		card.show(parent, "homepage_panel");
	}

	private void profile_iconMouseClicked(MouseEvent evt) {
		card.show(parent, "profile_panel");
	}

	private void addbtnMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub

	}

	private void category_filterMouseClicked(MouseEvent evt) {
		try {
			UIManager.getLookAndFeel();
			SwingUtilities.updateComponentTreeUI(CatDialog);
			CatDialog.getContentPane();
			CatDialog.setSize(400, 350);
			CatDialog.setResizable(false);
			CatDialog.pack();
			CatDialog.setLocationRelativeTo(getParent());
			CatDialog.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Failed to initialize LaF");
			ex.printStackTrace();
		}
	}

	private JButton addCatbtn;
	private JPanel header_panel;
	private JLabel homepage_button;
	private JButton new_discussion;
	private JLabel profile_icon;
	private JButton search_button;
	private JTextField search_field;

	private JDialog CatDialog;
	private JScrollPane catScroll;
	private JTable catTable;
	private JTextField newCat;
	private JButton addbtn;
	private JPanel CatPan;
}
