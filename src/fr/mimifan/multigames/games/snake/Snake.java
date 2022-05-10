package fr.mimifan.multigames.games.snake;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snake {
	
	public static JFrame frame;
	
	public Snake() {
		super();
		SnakeFrame();
	}

	public static JFrame SnakeFrame() {
		frame = new JFrame("Snake");
		frame.setResizable(false);
		frame.setContentPane(buildContentPane());
		frame.add(new SnakePanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		return frame;
	}
	
	public static JFrame getFrame() {
		return frame;
	}
	
	public static Container buildContentPane() {
		JPanel panel = new JPanel();
		
		panel.add(SnakePanel.restart);
		panel.add(SnakePanel.changeGame);
		panel.setBackground(Color.black);
		
		SnakePanel.restart.setBounds(100, 100, 90, 100);
		SnakePanel.restart.setFont(new Font("Ink Free", Font.BOLD, 25));
		SnakePanel.restart.setForeground(Color.red);
		SnakePanel.restart.setBackground(Color.black);
		SnakePanel.restart.addMouseListener(new SnakeActionListeners());
		SnakePanel.restart.setVisible(false);
		
		SnakePanel.changeGame.setBounds(220, 100, 90, 100);
		SnakePanel.changeGame.setFont(new Font("Ink Free", Font.BOLD, 25));
		SnakePanel.changeGame.setForeground(Color.red);
		SnakePanel.changeGame.setBackground(Color.black);
		SnakePanel.changeGame.addMouseListener(new SnakeActionListeners());
		SnakePanel.changeGame.setVisible(false);
		
		return panel;
	}

	
}
