package view.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.database.StrikeImplDB;
import controller.database.UserImplDB;
import model.base.User;

public class StrikePan extends JPanel {
	/*
	 * Create panel for the strike tab
	 */
	private static final long serialVersionUID = 1L;
	private UserImplDB dbuser = new UserImplDB();
	private StrikeImplDB dbstrike = new StrikeImplDB();
	private User user;
	private final Integer MAX_STRIKE = 3; //max strikes for a user

	public StrikePan() {
		draw();
	}

	private void draw() {

		strikedialog = new JDialog();
		usernamestrikable = new JTextField();
		nstrike = new JLabel();
		submitstrike = new JButton();
		tableScroll = new JScrollPane();
		strikesPanel = new JPanel();
		strikesTable = new JTable();
		newStrike = new JButton();
		plus = new JButton();
		minus = new JButton();

		//Strike Dialog
		strikedialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		strikedialog.setTitle("Modifica uno strike");
		Image icon = Toolkit.getDefaultToolkit()
				.getImage(this.getClass().getClassLoader().getResource("img/skull2.png"));
		strikedialog.setIconImage(icon);
		usernamestrikable.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		usernamestrikable.setText("Nomeutente");

		nstrike.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		nstrike.setHorizontalAlignment(JTextField.CENTER);
		nstrike.setText("n");

		submitstrike.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		submitstrike.setText("Submit");
		submitstrike.addActionListener(e -> {
			dbstrike.setStrike(user.getId(), Integer.parseInt(nstrike.getText()));
			refreshTable();
		});

		plus.setText("+");
		plus.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		plus.addActionListener(e -> {
			Integer strike = Integer.parseInt(nstrike.getText());
			if (strike < MAX_STRIKE) {
				nstrike.setText(String.valueOf(strike + 1));
			}
		});
		minus.setText("-");
		minus.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		minus.addActionListener(e -> {
			Integer strike = Integer.parseInt(nstrike.getText());
			if (strike > 0) {
				nstrike.setText(String.valueOf(strike - 1));
			}
		});

		GroupLayout strikedialogLayout = new GroupLayout(strikedialog.getContentPane());
		strikedialog.getContentPane().setLayout(strikedialogLayout);
		strikedialogLayout.setHorizontalGroup(strikedialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(strikedialogLayout.createSequentialGroup()
						.addGroup(strikedialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addGroup(strikedialogLayout.createSequentialGroup().addGap(20, 20, 20)
										.addComponent(usernamestrikable, GroupLayout.PREFERRED_SIZE, 154,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(plus, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(nstrike, GroupLayout.PREFERRED_SIZE, 39,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(minus, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGap(10, 10, 10).addComponent(submitstrike).addGap(19, 19, 19)));
		strikedialogLayout.setVerticalGroup(strikedialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(strikedialogLayout.createSequentialGroup().addGap(25, 25, 25)
						.addGroup(strikedialogLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(usernamestrikable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(nstrike, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(submitstrike)
								.addComponent(plus, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(minus, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(19, Short.MAX_VALUE)));

		strikesPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(194, 192, 192)), "Strikes",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 14))); // NOI18N

		//Strike table
		modelStrikes = new DefaultTableModel(new Object[] { "ID", "Username", "Strikes" }, 0);
		strikesTable.setModel(modelStrikes);

		tableScroll.setViewportView(strikesTable);
		if (strikesTable.getColumnModel().getColumnCount() > 0) {
			strikesTable.getColumnModel().getColumn(0).setResizable(false);
			strikesTable.getColumnModel().getColumn(1).setResizable(false);
			strikesTable.getColumnModel().getColumn(2).setResizable(false);

		}
		strikesTable.setEnabled(true);
		strikesTable.setFocusable(true);
		strikesTable.setOpaque(false);
		strikesTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		strikesTable.getColumnModel().getColumn(1).setPreferredWidth(90);
		strikesTable.getColumnModel().getColumn(2).setPreferredWidth(5);
		strikesTable.getTableHeader().setReorderingAllowed(false);
		
		refreshTable();
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);
		strikesTable.getColumnModel().getColumn(1).setCellRenderer(center);
		newStrike.setText("Aggiungi o togli uno strike");
		newStrike.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent evt) {
				newStrikeMouseClicked(evt);
			}
		});

		GroupLayout strikesPanelLayout = new GroupLayout(strikesPanel);
		strikesPanel.setLayout(strikesPanelLayout);
		strikesPanelLayout.setHorizontalGroup(strikesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(strikesPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(strikesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(newStrike, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
								.addComponent(tableScroll, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addContainerGap()));
		strikesPanelLayout.setVerticalGroup(strikesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(strikesPanelLayout.createSequentialGroup()
						.addComponent(tableScroll, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
						.addComponent(newStrike).addContainerGap()));

		add(strikesPanel);
	}

	private void refreshTable() {
		modelStrikes.getDataVector().removeAllElements();
		for (User u : dbuser.getAll()) {
			modelStrikes.addRow(new Object[] { u.getId(), u.getUsername(), dbstrike.getStrike(u.getId()) });
		strikesTable.setModel(modelStrikes);
		strikesTable.revalidate();
		}
	}

	private void newStrikeMouseClicked(final MouseEvent evt) {
		if (strikesTable.getSelectionModel().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Seleziona una riga della tabella");
		} else {
			user = dbuser.getUser(
					Integer.parseInt(strikesTable.getModel().getValueAt(strikesTable.getSelectedRow(), 0).toString()))
					.get();
			usernamestrikable.setText(user.getUsername());
			nstrike.setText(dbstrike.getStrike(user.getId()).toString());
			try {
				strikedialog.getContentPane();
				strikedialog.setSize(400, 350);
				strikedialog.pack();
				strikedialog.setLocationRelativeTo(getParent());
				strikedialog.setVisible(true);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	private JScrollPane tableScroll;
	private JButton newStrike;
	private JButton plus;
	private JButton minus;
	private JLabel nstrike;
	private JDialog strikedialog;
	private JPanel strikesPanel;
	private JTable strikesTable;
	private JButton submitstrike;
	private JTextField usernamestrikable;
	private DefaultTableModel modelStrikes;
}
