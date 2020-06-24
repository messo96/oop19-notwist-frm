package view.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class UpperPan extends JPanel {
	/*
	 * Creating Close JFrame menu, with icons and theme swap.
	 */
	private static final long serialVersionUID = 1L;
	private final ImageIcon dark = new ImageIcon(this.getClass().getClassLoader().getResource("img/light.png"));
	private final ImageIcon light = new ImageIcon(this.getClass().getClassLoader().getResource("img/dark.png"));
	private final ImageIcon close = new ImageIcon(this.getClass().getClassLoader().getResource("img/close.png"));

	public UpperPan() {

		drawComp();
	}

	private void drawComp() {
		upperPanel = new JPanel();
		closeLabel = new JLabel();
		switchLabel = new JLabel();

		// Setting upper menu layout
		upperPanel.setLayout(new AbsoluteLayout());

		// Switch "button"
		switchLabel.setIcon(light);
		upperPanel.add(switchLabel, new AbsoluteConstraints(330, 10, -1, -1));

		// Close "button"
		closeLabel.setIcon(close);
		upperPanel.add(closeLabel, new AbsoluteConstraints(380, 10, -1, -1));

		add(upperPanel);

		// Close method
		closeLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent evt) {
				closeLabelMouseClicked(evt);
			}
		});

		// Switch theme
		switchLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent evt) {
				switchLabelMouseClicked(evt);
			}
		});
	}

	// Close
	private void closeLabelMouseClicked(final MouseEvent evt) {
		System.exit(0);
	}

	// Switch method between light and dark
	private void switchLabelMouseClicked(final MouseEvent evt) {

		if (light == switchLabel.getIcon()) {
			switchLabel.setIcon(dark);

			try {

				UIManager.setLookAndFeel(new FlatDarkLaf());
			} catch (Exception ex) {
				System.err.println("Failed to initialize LaF");
			}
			SwingUtilities.updateComponentTreeUI(getParent());

		} else {
			switchLabel.setIcon(light);

			try {
				UIManager.setLookAndFeel(new FlatLightLaf());
			} catch (Exception ex) {
				System.err.println("Failed to initialize LaF");
			}
			SwingUtilities.updateComponentTreeUI(getParent());
		}
	}

	private JPanel upperPanel;
	private JLabel closeLabel;
	private JLabel switchLabel;
}
