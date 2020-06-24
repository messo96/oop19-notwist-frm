package view.signup;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import controller.database.UserImplDB;
import view.gui.PreGui;

public class RegisterPan extends JPanel implements PreGui {
	
	//Fields.
	private static final long serialVersionUID = 1L;
	private UserImplDB dbuser = new UserImplDB();

	/*Builder.*/
	public RegisterPan() {

		drawComp();
	}

	private void drawComp() {
		registerLabel = new JEditorPane();
		termsDialog = new JDialog();
		termsPanel = new JPanel();
		termsTitle = new JLabel();
		termsScroll = new JScrollPane();
		termsText = new JEditorPane("text/html", "");
		termsAccept = new JButton();
		registerPanel = new JPanel();
		psswLabel = new JLabel();
		mailField = new JTextField();
		sep2 = new JSeparator();
		sep1 = new JSeparator();
		psswField = new JPasswordField();
		userLabel = new JLabel();
		signupBtn = new JButton();
		mailLabel = new JLabel();
		sep3 = new JSeparator();
		usernameField = new JTextField();
		termsCheck = new JCheckBox();
		termsButton = new JButton();

		// Draw register panel place.

		// Dialog.
		termsTitle.setText("Informativa Privacy:");
		termsTitle.setFont(new Font("Tahoma", 0, 18));
		importTerms();
		termsText.setEditable(false);
		termsText.setOpaque(false);
		termsScroll.setViewportView(termsText);

		termsAccept.setText("Ok, ho letto!");
		termsAccept.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent evt) {
				termsAcceptActionPerformed(evt);
			}
		});

		GroupLayout termsPanelLayout = new GroupLayout(termsPanel);
		termsPanel.setLayout(termsPanelLayout);
		termsPanelLayout.setHorizontalGroup(termsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(termsPanelLayout.createSequentialGroup().addGap(42, 42, 42)
						.addGroup(termsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(termsScroll, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE)
								.addComponent(termsTitle).addComponent(termsAccept, GroupLayout.Alignment.TRAILING))
						.addContainerGap(49, Short.MAX_VALUE)));
		termsPanelLayout.setVerticalGroup(termsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(termsPanelLayout.createSequentialGroup().addGap(29, 29, 29).addComponent(termsTitle)
						.addGap(18, 18, 18)
						.addComponent(termsScroll, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(termsAccept)
						.addContainerGap(23, Short.MAX_VALUE)));

		GroupLayout termsDialogLayout = new GroupLayout(termsDialog.getContentPane());
		termsDialog.getContentPane().setLayout(termsDialogLayout);
		termsDialogLayout.setHorizontalGroup(termsDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(termsPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		termsDialogLayout.setVerticalGroup(termsDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(termsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		// Setting panel.
		registerPanel.setLayout(new AbsoluteLayout());

		// Username.
		userLabel.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		userLabel.setText("Username");
		registerPanel.add(userLabel, new AbsoluteConstraints(53, 80, -1, -1));

		usernameField.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		usernameField.setActionCommand("<Not Set>");
		usernameField.addFocusListener(new FocusAdapter() {
			public void focusGained(final FocusEvent evt) {
				usernameFieldFocusGained(evt);
			}
		});

		registerPanel.add(usernameField, new AbsoluteConstraints(53, 110, 290, 25));

		// Separator.
		sep1.setBackground(new Color(0, 0, 0));
		sep1.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(194, 192, 192)));
		sep1.setMinimumSize(new Dimension(30, 20));
		sep1.setPreferredSize(new Dimension(30, 20));
		sep1.setBackground(new Color(255, 255, 255));
		registerPanel.add(sep1, new AbsoluteConstraints(53, 140, 290, -1));

		// Mail.

		mailLabel.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		mailLabel.setText("Mail");
		registerPanel.add(mailLabel, new AbsoluteConstraints(53, 170, -1, -1));

		mailField.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		mailField.addFocusListener(new FocusAdapter() {
			public void focusGained(final FocusEvent evt) {
				mailFieldFocusGained(evt);
			}
		});
		registerPanel.add(mailField, new AbsoluteConstraints(53, 200, 290, 25));

		// Separator.
		sep2.setBackground(new Color(0, 0, 0));
		sep2.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(194, 192, 192)));
		sep2.setMinimumSize(new Dimension(30, 20));
		sep2.setPreferredSize(new Dimension(30, 20));
		sep2.setBackground(new Color(255, 255, 255));
		registerPanel.add(sep2, new AbsoluteConstraints(53, 230, 290, -1));

		// Password.
		psswLabel.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		psswLabel.setText("Password");
		registerPanel.add(psswLabel, new AbsoluteConstraints(53, 260, -1, -1));

		psswField.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		psswField.addFocusListener(new FocusAdapter() {
			public void focusGained(final FocusEvent evt) {
				psswFieldFocusGained(evt);
			}
		});
		registerPanel.add(psswField, new AbsoluteConstraints(53, 290, 290, 25));

		// Separator.

		sep3.setBackground(new Color(0, 0, 0));
		sep3.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(194, 192, 192)));
		sep3.setMinimumSize(new Dimension(30, 20));
		sep3.setPreferredSize(new Dimension(30, 20));
		sep3.setBackground(new Color(255, 255, 255));
		registerPanel.add(sep3, new AbsoluteConstraints(53, 320, 290, -1));

		signupBtn.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		signupBtn.setText("REGISTER");

		registerPanel.add(signupBtn, new AbsoluteConstraints(53, 360, 290, 60));

		// Informative.
		termsCheck.setFont(new Font("Tahoma", 0, 10)); // NOI18N
		termsCheck.setText("Accetto i termini e le condizioni.");
		registerPanel.add(termsCheck, new AbsoluteConstraints(53, 330, -1, -1));

		termsButton.setText("Informativa");
		termsButton.setForeground(new Color(255, 99, 71));
		termsButton.setFont(new Font("Tahoma", 0, 10));
		termsButton.setBorderPainted(false);
		termsButton.setContentAreaFilled(false);

		termsButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent evt) {
				termsButtonActionPerformed(evt);
			}
		});
		registerPanel.add(termsButton, new AbsoluteConstraints(220, 330, -1, -1));

		// Info.
		registerLabel.setContentType("text/html");
		registerLabel.setOpaque(false);
		registerLabel.setText("Hai già un account? Loggati <font color =FF6347>qui </font>.");
		registerLabel.getCaret().setVisible(false);
		registerLabel.setToolTipText("Se hai già un account, passa al login.");
		registerPanel.add(registerLabel, new AbsoluteConstraints(53, 440, -1, -1));

		add(registerPanel);

		registerLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent evt) {
				loginLinkMouseClicked(evt);
			}
		});

		mailField.addFocusListener(new FocusAdapter() {
			public void focusGained(final FocusEvent evt) {
				mailFieldFocusGained(evt);
			}
		});

		psswField.addFocusListener(new FocusAdapter() {
			public void focusGained(final FocusEvent evt) {
				psswFieldFocusGained(evt);
			}
		});

		usernameField.addFocusListener(new FocusAdapter() {
			public void focusGained(final FocusEvent evt) {
				usernameFieldFocusGained(evt);
			}
		});

		// Register method.
		signupBtn.addActionListener(e -> {
			if (!termsCheck.isSelected()) {
				JOptionPane.showMessageDialog(null, "Accetta i termini e condizioni!");
			} else if (this.getMail().isBlank() || !this.getMail().contains("@")) {
				JOptionPane.showMessageDialog(null, "La mail dev'essere valida!");
			} else if (this.getUsername().isBlank() || this.getPassword().isBlank()
					|| !dbuser.register(this.getUsername(), this.getPassword(), this.getMail(), false)) {
				JOptionPane.showMessageDialog(null, "Devi riempire tutti i campi.");
			} else {
				JOptionPane.showMessageDialog(null, "Account creato correttamente! ");
				CardLayout card = (CardLayout) getParent().getLayout();
				card.show(getParent(), "login");
			}

		});
	}

	private void termsAcceptActionPerformed(final ActionEvent evt) {

		termsDialog.dispose();
	}

	private void termsButtonActionPerformed(final ActionEvent evt) {
		try {
			UIManager.getLookAndFeel();
			SwingUtilities.updateComponentTreeUI(termsDialog);
			termsDialog.getContentPane();
			termsDialog.setSize(650, 450);
			termsDialog.pack();
			termsDialog.setLocationRelativeTo(getParent());
			termsDialog.setVisible(true);
			Image icon = Toolkit.getDefaultToolkit().getImage("img/icon.jpg");
			termsDialog.setIconImage(icon);

		} catch (Exception ex) {
			System.err.println("Failed to initialize LaF");
			ex.printStackTrace();
		}
	}

	@Override
	public final String getUsername() {
		return usernameField.getText();
	}

	@Override
	public final String getMail() {
		return mailField.getText();
	}

	@Override
	public final String getPassword() {
		//this method is deprecated, but this is the only strategy to pass the string.
		return psswField.getText();
	}

	private void importTerms() {
		BufferedReader buf;
		InputStreamReader in = new InputStreamReader(this.getClass().getResourceAsStream("/docs/Terms.txt"));
		try {
			buf = new BufferedReader(in);
			termsText.read(buf, null);
		} catch (IOException e) {
			System.out.println("Terms.txt non trovato! ");
			e.printStackTrace();
		}
	}

	// Focus.
	private void mailFieldFocusGained(final FocusEvent evt) {
		psswLabel.setForeground(new Color(0, 0, 0));
		mailLabel.setForeground(new Color(135, 175, 218));
		userLabel.setForeground(new Color(0, 0, 0));
	}

	private void psswFieldFocusGained(final FocusEvent evt) {
		psswLabel.setForeground(new Color(135, 175, 218));
		mailLabel.setForeground(new Color(0, 0, 0));
		userLabel.setForeground(new Color(0, 0, 0));
	}

	private void usernameFieldFocusGained(final FocusEvent evt) {
		psswLabel.setForeground(new Color(0, 0, 0));
		mailLabel.setForeground(new Color(0, 0, 0));
		userLabel.setForeground(new Color(135, 175, 218));
	}

	private void loginLinkMouseClicked(final MouseEvent evt) {
		CardLayout card = (CardLayout) getParent().getLayout();
		card.show(getParent(), "login");
	}

	private JCheckBox termsCheck;
	private JDialog termsDialog;
	private JLabel psswLabel;
	private JLabel userLabel;
	private JButton signupBtn;
	private JPanel registerPanel;
	private JTextField mailField;
	private JPasswordField psswField;
	private JTextField usernameField;
	private JEditorPane registerLabel;
	private JLabel mailLabel;
	private JLabel termsTitle;
	private JPanel termsPanel;
	private JScrollPane termsScroll;
	private JSeparator sep2;
	private JSeparator sep3;
	private JEditorPane termsText;
	private JButton termsAccept;
	private JButton termsButton;
	private JSeparator sep1;

	
}
