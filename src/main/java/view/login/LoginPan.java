package view.login;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import javax.swing.SwingUtilities;
import javax.swing.BorderFactory;
import javax.swing.SwingWorker;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import controller.database.UserImplDB;
import model.base.User;

import view.gui.BuildAfterGui;
import view.gui.PreGui;

public class LoginPan extends JPanel implements PreGui {

	private static final long serialVersionUID = 1L;
	private UserImplDB dbuser = new UserImplDB();

	public LoginPan() {

		drawComp();
	}

	private void drawComp() {

		sep2 = new JSeparator();

		loginPanel = new JPanel();
		psswLabel = new JLabel();
		sep1 = new JSeparator();
		mailField = new JTextField();
		psswField = new JPasswordField();
		mailLabel = new JLabel();
		loginBtn = new JButton();
		signupLabel = new JEditorPane();

		// <------------Draw login panel------------------->
		loginPanel.setLayout(new AbsoluteLayout());

		// Mail section
		mailLabel.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		mailLabel.setText("Mail");
		mailLabel.setToolTipText("Utilizza una mail valida!");
		loginPanel.add(mailLabel, new AbsoluteConstraints(60, 80, -1, -1));

		mailField.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		loginPanel.add(mailField, new AbsoluteConstraints(60, 110, 290, 25));

		// Separator
		sep1.setBackground(new Color(0, 0, 0));
		sep1.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(194, 192, 192)));
		sep1.setMinimumSize(new Dimension(30, 20));
		sep1.setPreferredSize(new Dimension(30, 20));
		loginPanel.add(sep1, new AbsoluteConstraints(60, 140, 290, -1));

		// Password section
		psswLabel.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		psswLabel.setText("Password");
		psswLabel.setToolTipText("Utilizza una password sicura!");
		loginPanel.add(psswLabel, new AbsoluteConstraints(60, 170, -1, -1));

		// psswField.setBackground(new Color(242, 242, 242));

		psswField.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		loginPanel.add(psswField, new AbsoluteConstraints(60, 200, 290, 25));

		// Separator
		sep2.setBackground(new Color(0, 0, 0));
		sep2.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(194, 192, 192)));
		sep2.setMinimumSize(new Dimension(30, 20));
		sep2.setPreferredSize(new Dimension(30, 20));
		loginPanel.add(sep2, new AbsoluteConstraints(60, 230, 290, -1));

		// Login button
		loginBtn.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		loginBtn.setText("LOGIN");
		loginPanel.add(loginBtn, new AbsoluteConstraints(60, 270, 290, 60));

		// Loader after Login
		JLabel loader = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("img/loader_login.gif")));
		loader.setBounds(loginBtn.getBounds());
		loginPanel.add(loader, new AbsoluteConstraints(60, 270, 300, 60));

		// Link section
		signupLabel.setContentType("text/html");
		signupLabel.setOpaque(false);
		signupLabel.setText("Non hai un account? Registrati <font color =FF6347>qui </font>.");
		signupLabel.setToolTipText("Hai bisogno di un account per poter entrare");
		signupLabel.getCaret().setVisible(false);
		loginPanel.add(signupLabel, new AbsoluteConstraints(60, 350, -1, -1));

		signupLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent evt) {
				signupLinkMouseClicked(evt);
			}
		});

		add(loginPanel);

		// Change label color on focus
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

		// Login_button method
		this.loginBtn.addActionListener(e -> {
			loginBtn.setVisible(false);
			loader.setVisible(true);
			Window win = ((Window) SwingUtilities.getRoot(this));

			if (this.loginBtn.getActionListeners().length == 0) {
				throw new IllegalStateException();
			}
			 new SwingWorker<String, Object>() {

				@Override
				protected String doInBackground() throws Exception {
					if (getMail().isBlank() || getPassword().isBlank() || !getMail().contains("@")) {
						JOptionPane.showMessageDialog(null, "I campi sono obbligatori!");
					} else {
						Optional<User> user = getCredential();
						if (user.isPresent()) {
							JOptionPane.showMessageDialog(null, "Credenziali corrette, Benvenuto!");
							loader.setVisible(false);
							new BuildAfterGui(user.get()).start();
							win.dispose();
							return "Credenziali corrette";
						} else {
							JOptionPane.showMessageDialog(null, "Credenziali errate, riprovare! :(");
						}

					}
					loader.setVisible(false);
					loginBtn.setVisible(true);
					return "error";
				}

			}.execute();
		});
	}

	private void mailFieldFocusGained(final FocusEvent evt) {
		psswLabel.setForeground(new Color(0, 0, 0));
		mailLabel.setForeground(new Color(135, 175, 218));

	}

	private void psswFieldFocusGained(final FocusEvent evt) {
		mailLabel.setForeground(new Color(0, 0, 0));
		psswLabel.setForeground(new Color(135, 175, 218));
	}

	public final JButton getLogBtn() {
		return this.loginBtn;
	}

	@Override
	public final String getUsername() {
		//No need to get Username here
		return null;
	}

	@Override
	public final String getMail() {
		return this.mailField.getText();
	}

	@SuppressWarnings("deprecation")
	@Override
	public final String getPassword() {
		return this.psswField.getText(); //We need to get the text to pass it to the cripter
	}

	public final Optional<User> getCredential() {

		return dbuser.login(getMail(), getPassword());
	}

	private void signupLinkMouseClicked(final MouseEvent evt) {
		CardLayout card = (CardLayout) getParent().getLayout();
		card.show(getParent(), "register_panel");
	}

	private JLabel psswLabel;
	private JLabel mailLabel;
	private JButton loginBtn;
	private JEditorPane signupLabel;
	private JPanel loginPanel;
	private JSeparator sep1;
	private JSeparator sep2;
	private JTextField mailField;
	private JPasswordField psswField;

}
