package fr.mimifan.multigames.games.evadingButton;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EvadingButton {
	
	public static JFrame frame;

	public static JButton button;
	public static JLabel label,compliments;
	
	public static Random randomGenerator=new Random();
	public static int score = 0;

	public EvadingButton() {
		super();
		EvadingButtonFrame();
	}

	public static JFrame EvadingButtonFrame() {
		frame = new JFrame("BOUTON");
		frame.setSize(500, 250);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(buildContentPane());
		frame.setVisible(false);
		return frame;
	}
	
	public static JFrame getFrame() {
		return frame;
	}

	private static Container buildContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		label = new JLabel("Score: " + score);
		compliments = new JLabel("");
		compliments.setFont(new Font("Serif", Font.PLAIN, 25));
		compliments.setVisible(false);
		
		button = new JButton("Click Me!!");
		button.setBorderPainted(false);
		button.setBackground(Color.pink);
		button.setFocusPainted(false);
		button.addMouseMotionListener(new EvadingButtonListeners());
		
		panel.add(button);
		panel.add(label);
		panel.add(compliments);
		
		label.setBounds(2, 2, 70, 20);
		button.setBounds(200, 90, 90, 25);
		
		return panel;
	}	
}
