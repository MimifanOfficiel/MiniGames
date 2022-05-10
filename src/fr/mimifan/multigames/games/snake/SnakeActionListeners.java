package fr.mimifan.multigames.games.snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import fr.mimifan.multigames.frames.GameSelector;

public class SnakeActionListeners implements KeyListener, MouseListener {

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object source = e.getSource();
		if(source == SnakePanel.restart) {
			Snake.getFrame().dispose();
			JFrame newSnake = Snake.SnakeFrame();
			newSnake.setVisible(true);
		} else if(source == SnakePanel.changeGame) {
			Snake.getFrame().dispose();
			JFrame gameSelector = GameSelector.getFrame();
			gameSelector.setVisible(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object source = e.getSource();
		if(source == SnakePanel.restart) {
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object source = e.getSource();
		if(source == SnakePanel.restart) {
		}
	}

}
