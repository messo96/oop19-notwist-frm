package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public final class Loader extends JWindow {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Loader instance = null;
	private static final Integer WIDTH = 200;
	private static final Integer HEIGHT = 300;

	private Loader() {
		this.setLayout(new BorderLayout());
		JLabel loader = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("img/loaderNotwist.gif")));
		this.add(loader, BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		loader.setOpaque(true);
		this.setBackground(new Color(0, 0, 0, 0));
		loader.setSize(new Dimension(WIDTH, HEIGHT));
		this.pack();
	}

	public void start() {
		this.setVisible(true);
	}

	public void end() {
		this.setVisible(false);
	}

	public static Loader getInstance() {
		if (instance == null) {
			instance = new Loader();
		}
		return instance;
	}

	public static void main(final String[] args) {
		Loader l = new Loader();
		l.start();
	}

}
