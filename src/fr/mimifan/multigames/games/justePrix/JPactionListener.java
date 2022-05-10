package fr.mimifan.multigames.games.justePrix;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPactionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == JustePrix.restart) {
			JustePrix.prix = 0;
			JustePrix.essais = 0;
			JustePrix.justeprix = (int) JustePrix.randomGenerator.nextInt((Integer.valueOf(JustePrix.maxPrice) - 0) + 1) + 0;
			JustePrix.instruction.setText("Entrez un prix");
			JustePrix.lasts.removeAll(JustePrix.lasts);
			JustePrix.lastsprice.setText("");
			JustePrix.restart.setVisible(false);
			JustePrix.running = true;
		} else if(e.getSource() == JustePrix.jComboBox) {
			try {
				JustePrix.maxPrice = JustePrix.jComboBox.getItemAt(JustePrix.jComboBox.getSelectedIndex());
			} catch(NumberFormatException exception) {
				System.out.println("Erreur maxPrice");
			}
			
		}
	}

}
