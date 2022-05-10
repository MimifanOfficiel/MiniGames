package fr.mimifan.multigames.games.evadingButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class EvadingButtonListeners implements ActionListener, MouseMotionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
	@Override
    public void mouseMoved(MouseEvent e) {
		int minX = 0;
		int maxX = 450;
		int minY = 0;
		int maxY = 175;
		if(e.getSource() == EvadingButton.button) {
			double x = EvadingButton.button.getLocation().getX();
			double y = EvadingButton.button.getLocation().getY();
			int newX = (int) EvadingButton.randomGenerator.nextInt((maxX - minX) + 1) + minX;
			int newY = (int) EvadingButton.randomGenerator.nextInt((maxY - minY) + 1) + minY;
			if(newX == x || newY == y) {
				System.out.println("Mêmes Values");
				return;
			}
			EvadingButton.score++;
			EvadingButton.label.setText("Score: " + EvadingButton.score);
			if(EvadingButton.score == 50) {
				EvadingButton.compliments.setBounds(200, 90, 90, 25);
				showCompliment("Pas mal");
			} else if(EvadingButton.score == 100) {
				EvadingButton.compliments.setBounds(150, 90, 200, 50);
				showCompliment("T'en as pas marre ?");
			} else if(EvadingButton.score == 150) {
				EvadingButton.compliments.setBounds(150, 70, 400, 50);
				showCompliment("Sinon t'as pas une vie ?");
			} else if(EvadingButton.score == 200) {
				EvadingButton.compliments.setBounds(25, 70, 450, 50);
				showCompliment("Tu t'emmerdes pas au bout d'un moment ?");
			}
			EvadingButton.button.setLocation(newX, newY);
		}
    }
	
	public void showCompliment(String message) {
		EvadingButton.compliments.setText(message);
		EvadingButton.button.setVisible(false);
		EvadingButton.compliments.setVisible(true);
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	EvadingButton.compliments.setVisible(false);
		            	EvadingButton.button.setVisible(true);
		            }
		        }, 
		        5000 
		);
	}
	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
