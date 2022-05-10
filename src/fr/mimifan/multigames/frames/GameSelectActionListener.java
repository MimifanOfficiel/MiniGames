package fr.mimifan.multigames.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import fr.mimifan.multigames.games.evadingButton.EvadingButton;
import fr.mimifan.multigames.games.justePrix.JustePrix;
import fr.mimifan.multigames.games.snake.Snake;

public class GameSelectActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		JFrame gameSelector = GameSelector.getFrame();
		JFrame justePrix = JustePrix.getFrame();
		JFrame snake = Snake.SnakeFrame();
		JFrame evadingButton = EvadingButton.getFrame();
		if(source == GameSelector.justeprix) {
			gameSelector.setVisible(false);
			justePrix.setVisible(true);
		} else if(source == GameSelector.snake) {
			gameSelector.setVisible(false);
			try {
				Thread.sleep(500);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
			snake.setVisible(true);
		} else if(source == GameSelector.evadingButton) {
			gameSelector.setVisible(false);
			evadingButton.setVisible(true);
		} else if(source == GameSelector.tetris) {
			
		} else if(source == GameSelector.MiniCraft) {
			
		}
		
	}

}
