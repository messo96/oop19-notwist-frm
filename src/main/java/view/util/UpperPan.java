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

	private static final long serialVersionUID = 1L;
	private final ImageIcon dark = new ImageIcon(this.getClass().getClassLoader().getResource("light.png"));
	private final ImageIcon light = new ImageIcon(this.getClass().getClassLoader().getResource("dark.png"));
	private final ImageIcon close = new ImageIcon(this.getClass().getClassLoader().getResource("close.png"));

	public UpperPan() {

		drawComp();
	}

	private void drawComp() {
		upper_panel = new JPanel();
		close_label = new JLabel();
		switch_label = new JLabel();

		// Draw upper menu panel
		upper_panel.setLayout(new AbsoluteLayout());

		// Switch "button"
		switch_label.setIcon(light);
		upper_panel.add(switch_label, new AbsoluteConstraints(330, 10, -1, -1));

		// Close "button"
		close_label.setIcon(close);
		upper_panel.add(close_label, new AbsoluteConstraints(380, 10, -1, -1));

		add(upper_panel);

		// Close method
		close_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				close_labelMouseClicked(evt);
			}
		});

		// Switch theme
		switch_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				switch_labelMouseClicked(evt);
			}
		});
	}

	// Close
	private void close_labelMouseClicked(MouseEvent evt) {
		System.exit(0);
	}

	// Switch
	private void switch_labelMouseClicked(MouseEvent evt) {

		if (light == switch_label.getIcon()) {
			switch_label.setIcon(dark);

			try {

				UIManager.setLookAndFeel(new FlatDarkLaf());
			} catch (Exception ex) {
				System.err.println("Failed to initialize LaF");
			}
			SwingUtilities.updateComponentTreeUI(getParent());

		} else {
			switch_label.setIcon(light);

			try {
				UIManager.setLookAndFeel(new FlatLightLaf());
			} catch (Exception ex) {
				System.err.println("Failed to initialize LaF");
			}
			SwingUtilities.updateComponentTreeUI(getParent());
		}
	}

	private JPanel upper_panel;
	private JLabel close_label;
	private JLabel switch_label;
}
