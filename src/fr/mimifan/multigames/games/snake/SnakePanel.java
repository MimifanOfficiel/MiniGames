package fr.mimifan.multigames.games.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SnakePanel extends JPanel implements ActionListener {
	
	static final int width = 600, height = 600, UNIT_SIZE = 25, GAME_UNITS = (width*height)/25;
	static final int delay = 100;
	
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	
	int bodyparts = 6;
	int applesEaten;
	int appleX, appleY;
	
	char direction = 'R';
	public static boolean running = false;
	Timer timer;
	Random random;
	
	public static JLabel restart = new JLabel("Recommencer");
	public static JLabel changeGame = new JLabel("Changer de Jeu");
	
	public SnakePanel(){
		random = new Random();
		this.setPreferredSize(new Dimension(600, 600));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new keyAdapter());
		startGame();
	}
	
	public void startGame() {
		newApple();
		running = true;
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		if(running) {
			for(int i = 0; i < height/UNIT_SIZE ; i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, height);
				g.drawLine(0, i*UNIT_SIZE, width, i*UNIT_SIZE);
			}
			g.setColor(Color.red);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
			
			for(int i = 0; i < bodyparts; i++) {
				if(i == 0) {
					g.setColor(Color.green);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				} else {
					g.setColor(new Color(45, 180, 0));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}
			g.setColor(Color.red);
			g.setFont(new Font("Ink Free", Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: " + applesEaten, (600 - (metrics.stringWidth("Score: " + applesEaten)))/2, g.getFont().getSize());
		} else {
			gameOver(g);
		}
	}
	
	public void newApple() {
		appleX = random.nextInt((int)(width/UNIT_SIZE))*UNIT_SIZE;
		appleY = random.nextInt((int)(height/UNIT_SIZE))*UNIT_SIZE;
	}
	
	public void move() {
		for(int i = bodyparts; i>0;i-- ) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		switch(direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
	}
	
	public void checkApple() {
		if((x[0] == appleX) && y[0] == appleY) {
			bodyparts++;
			applesEaten++;
			newApple();
		}
	}

	public void checkCollisions() {
		for(int i = bodyparts; i>0 ; i--) {
			if((x[0] == x[i]) && (y[0] == y[i])){
				running = false;
			}
		}
		if(x[0] < 0) {
			running = false;
		}
		if(x[0] > width) {
			running = false;	
		}
		if(y[0] < 0) {
			running = false;
		}
		if(y[0] > height) {
			running = false;
		}
		if(!running) {
			timer.stop();
		}
	}
	
	public void gameOver(Graphics g) {
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 40));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Score: " + applesEaten, (600 - (metrics.stringWidth("Score: " + applesEaten)))/2, g.getFont().getSize());
		
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		g.drawString("Game Over", (600 - (metrics.stringWidth("Game Over")))/2 - 100, 250);
		
		restart.setLocation(100, 330);
		restart.setVisible(true);
		changeGame.setLocation(300, 330);
		changeGame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
		
	}
	
	public class keyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent event) {
			switch(event.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction != 'R') {
					direction = 'L';
					break;
				}
			case KeyEvent.VK_RIGHT:
				if(direction != 'L') {
					direction = 'R';
					break;
				}
			case KeyEvent.VK_DOWN:
				if(direction != 'U') {
					direction = 'D';
					break;
				}
			case KeyEvent.VK_UP:
				if(direction != 'D') {
					direction = 'U';
					break;
				}
				
			}
		}
	}

}
