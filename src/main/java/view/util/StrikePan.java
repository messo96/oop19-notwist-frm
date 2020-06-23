package view.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
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
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.database.StrikeImplDB;
import controller.database.UserImplDB;
import model.base.User;
import model.database.StrikeDB;
import model.database.StrikeDB;
import model.database.UserDB;
import model.database.Dao;

public class StrikePan extends JPanel {
	/*
	 * Create panel for the strike tab
	 */
	private static final long serialVersionUID = 1L;
	private UserImplDB dbuser = new UserImplDB();
	private StrikeImplDB dbstrike = new StrikeImplDB();
	private User user;
	private final Integer MAX_STRIKE = 3;

	public StrikePan() {
		draw();
	}

	private void draw() {

		strikedialog = new JDialog();
		usernamestrikable = new JTextField();
		nstrike = new JLabel();
		submitstrike = new JButton();
		jScrollPane4 = new JScrollPane();
		strikes_panel = new JPanel();
		strikes_table = new JTable();
		new_strike = new JButton();
		plus = new JButton();
		minus = new JButton();

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
			if (strike < MAX_STRIKE)
				nstrike.setText(String.valueOf(strike + 1));
		});
		minus.setText("-");
		minus.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		minus.addActionListener(e -> {
			Integer strike = Integer.parseInt(nstrike.getText());
			if (strike > 0)
				nstrike.setText(String.valueOf(strike - 1));
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

		strikes_panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0)), "Strikes",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 14))); // NOI18N

		model_strikes = new DefaultTableModel(new Object[] { "ID", "Username", "Strikes" }, 0);
		strikes_table.setModel(model_strikes);

		jScrollPane4.setViewportView(strikes_table);
		if (strikes_table.getColumnModel().getColumnCount() > 0) {
			strikes_table.getColumnModel().getColumn(0).setResizable(false);
			strikes_table.getColumnModel().getColumn(1).setResizable(false);
			strikes_table.getColumnModel().getColumn(2).setResizable(false);

		}
		strikes_table.setEnabled(true);
		strikes_table.setFocusable(true);
		strikes_table.setOpaque(false);
		strikes_table.getColumnModel().getColumn(0).setPreferredWidth(5);
		strikes_table.getColumnModel().getColumn(1).setPreferredWidth(90);
		strikes_table.getColumnModel().getColumn(2).setPreferredWidth(5);

		refreshTable();
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);
		strikes_table.getColumnModel().getColumn(1).setCellRenderer(center);
		new_strike.setText("Aggiungi o togli uno strike");
		new_strike.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				new_strikeMouseClicked(evt);
			}
		});

		GroupLayout strikes_panelLayout = new GroupLayout(strikes_panel);
		strikes_panel.setLayout(strikes_panelLayout);
		strikes_panelLayout.setHorizontalGroup(strikes_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(strikes_panelLayout.createSequentialGroup().addContainerGap()
						.addGroup(strikes_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(new_strike, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
								.addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addContainerGap()));
		strikes_panelLayout.setVerticalGroup(strikes_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(strikes_panelLayout.createSequentialGroup()
						.addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
						.addComponent(new_strike).addContainerGap()));

		add(strikes_panel);
	}

	private void refreshTable() {
		model_strikes.getDataVector().removeAllElements();
		for (User u : dbuser.getAll())
			model_strikes.addRow(new Object[] { u.getId(), u.getUsername(), dbstrike.getStrike(u.getId()) });
		strikes_table.setModel(model_strikes);
		strikes_table.revalidate();
	}

	private void new_strikeMouseClicked(MouseEvent evt) {
		if (strikes_table.getSelectionModel().isSelectionEmpty())
			JOptionPane.showMessageDialog(null, "You have to select a row in the table before");
		else {
			user = dbuser.getUser(
					Integer.parseInt(strikes_table.getModel().getValueAt(strikes_table.getSelectedRow(), 0).toString()))
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

	private JScrollPane jScrollPane4;
	private JButton new_strike;
	private JButton plus;
	private JButton minus;
	private JLabel nstrike;
	private JDialog strikedialog;
	private JPanel strikes_panel;
	private JTable strikes_table;
	private JButton submitstrike;
	private JTextField usernamestrikable;
	private DefaultTableModel model_strikes;
}
