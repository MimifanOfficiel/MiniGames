package fr.mimifan.multigames.games.justePrix;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import fr.mimifan.multigames.frames.GameSelector;

public class JPkeyListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getSource() == JustePrix.prixField) {
			if(JustePrix.running) {
				if(event.getKeyCode() == KeyEvent.VK_ENTER){
					JustePrix.essais++;
					try {
						JustePrix.prix = Integer.valueOf(JustePrix.prixField.getText());
						if(JustePrix.justeprix > JustePrix.prix) {
							JustePrix.instruction.setText("Plus haut !");
							JustePrix.lasts.add(""+JustePrix.prix + "     ➚ ");
						} else if(JustePrix.justeprix < JustePrix.prix) {
							JustePrix.instruction.setText("Plus bas !");
							JustePrix.lasts.add(""+JustePrix.prix + "    ➘");
						} else if(JustePrix.prix == JustePrix.justeprix) {
							JustePrix.instruction.setText("Bravo ! Tu as trouvé en " + JustePrix.essais + " essais.");
							JustePrix.restart.setVisible(true);
							JustePrix.running = false;
						}
					} catch(NumberFormatException e) {
						System.out.println("Erreur prix");
					}
					JustePrix.updateHistory();
					JustePrix.prixField.setText("");
				} else if(event.getKeyCode() == KeyEvent.VK_P) {
					
				}
			}
		} else if(event.getSource() == JustePrix.frame) {
			if(event.getKeyCode() == KeyEvent.VK_ESCAPE) {
				JustePrix.getFrame().dispose();
				JFrame gameSelector = GameSelector.getFrame();
				gameSelector.setVisible(true);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
