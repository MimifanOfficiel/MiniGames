package fr.mimifan.multigames;
import javax.swing.JFrame;

import fr.mimifan.multigames.frames.GameSelector;
import fr.mimifan.multigames.games.evadingButton.EvadingButton;
import fr.mimifan.multigames.games.justePrix.JustePrix;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		JFrame gameSelector = GameSelector.gameSelectorFrame();
		JFrame justePrix = JustePrix.JustePrixFrame();
		JFrame evadingButton = EvadingButton.EvadingButtonFrame();
		gameSelector.setVisible(true);
	}

}
