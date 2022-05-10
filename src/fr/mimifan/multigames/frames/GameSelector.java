package fr.mimifan.multigames.frames;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameSelector {

	public static JButton justeprix, tetris, evadingButton, MiniCraft, snake;
	
	public static JFrame frame;
	
	public GameSelector() {
		super();
		gameSelectorFrame();
	}
	
	public static JFrame gameSelectorFrame() {
		frame = new JFrame("Minigames");
		frame.setSize(500, 250);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(buildContentPane());
		return frame;
	}
	
	public static JFrame getFrame() {
		return frame;
	}

	public static Container buildContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		justeprix = new JButton("Juste Prix");
		justeprix.addActionListener(new GameSelectActionListener());
		
		snake = new JButton("Snake");
		snake.addActionListener(new GameSelectActionListener());
		
		evadingButton = new JButton("Evading Button");
		evadingButton.addActionListener(new GameSelectActionListener());
		
		tetris = new JButton("Tetris");
		tetris.addActionListener(new GameSelectActionListener());
		
		MiniCraft = new JButton("MiniCraft");
		MiniCraft.addActionListener(new GameSelectActionListener());
		
		panel.add(justeprix);
		panel.add(snake);
		panel.add(evadingButton);
		panel.add(tetris);
		panel.add(MiniCraft);
		
		justeprix.setBounds(5, 5, 100, 20);
		snake.setBounds(120, 5, 100, 20);
		evadingButton.setBounds(240, 5, 120, 20);
		tetris.setBounds(380, 5, 100, 20);
		MiniCraft.setBounds(5, 45, 100, 20);
		
		return panel;
	}
	
}
