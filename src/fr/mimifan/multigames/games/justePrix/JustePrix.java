package fr.mimifan.multigames.games.justePrix;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JustePrix {
	
	static Random randomGenerator = new Random();
	static List<String> lasts = new ArrayList<>();
	
	public static JFrame frame;
	public static JTextField prixField;
	public static JLabel titre, lastpriceTitle, instruction;
	public static JTextArea lastsprice;
	public static JButton restart;
	
	public static boolean running = false;
	public static String[] maxPriceChoice = {"Maximum Price", "50", "100", "200", "400", "800", "1600"};
	public static String maxPrice = "" + 200;
	public static JComboBox<String> jComboBox;
	
	public static int justeprix = (int) randomGenerator.nextInt((Integer.valueOf(maxPrice) - 0) + 1) + 0;
	public static int prix = 0, essais = 0;
	
	public JustePrix() {
		super();
		JustePrixFrame();
	}
	
	public static JFrame JustePrixFrame(){
		frame = new JFrame("Juste Prix");
		frame.setSize(500, 250);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(buildContentPane());
		frame.addKeyListener(new JPkeyListener());
		return frame;
	}
	
	public static JFrame getFrame() {
		return frame;
	}

	public static Container buildContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(238, 238, 238));
		
		jComboBox = new JComboBox<>(maxPriceChoice);
		
		titre = new JLabel("Bienvenue au juste prix !");		
		
		prixField = new JTextField("");
		prixField.addKeyListener(new JPkeyListener());
		
		instruction = new JLabel("Entrez un prix", SwingConstants.CENTER);
		
		lastpriceTitle = new JLabel("Derniers essais :");
		
		lastsprice = new JTextArea("");
		lastsprice.setBackground(new Color(240, 240, 240));
		lastsprice.setBorder(BorderFactory.createLineBorder(Color.black));
		lastsprice.setEditable(false);
		
		restart = new JButton("Recommencer");
		restart.setBorderPainted(false);
		restart.setBackground(new Color(192, 204, 204));
		restart.setFocusPainted(false);
		restart.addActionListener(new JPactionListener());
		
		
		
		panel.add(instruction);
		panel.add(restart);
		panel.add(lastsprice);
		panel.add(prixField);
		panel.add(lastpriceTitle);
		
		lastsprice.setBounds(394, 20, 90, 498);
		lastpriceTitle.setBounds(392, 5, 100, 10);
		prixField.setBounds(170, 90, 100, 25);
		instruction.setBounds(120, 110, 200, 25);
		restart.setBounds(160, 140, 120, 25);
		
		restart.setVisible(false);
		running = true;
		return panel;
	}

	public static void updateHistory() {
		StringBuilder lastBuilder = new StringBuilder();
		for(int i=0 ; i < lasts.size() ; i++) {
			if(lasts.size() > 12) {
				String first = lasts.get(0);
				lastBuilder.delete(0, first.length() + 1);
				lasts.remove(0);
			}
			lastBuilder.append(lasts.get(i)+ "\n");
		}
		lastsprice.setText(lastBuilder.toString());
		return;
	}

}
