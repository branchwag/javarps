import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
//import java.util.Scanner;

public class RockPaperScissors extends JFrame{
	private JLabel resultLabel;
	private JLabel computerMoveLabel;
	private ImageIcon rockIcon;
	private ImageIcon paperIcon;
	private ImageIcon scissorsIcon;

	public RockPaperScissors() {
		setTitle("Rock Paper Scissors");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);

		rockIcon = new ImageIcon(new ImageIcon("rock.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		paperIcon = new ImageIcon(new ImageIcon("paper.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		scissorsIcon = new ImageIcon(new ImageIcon("scissors.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

		resultLabel = new JLabel("Choose your move!", SwingConstants.CENTER);
		resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
		resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		computerMoveLabel = new JLabel("Computer's move: ", SwingConstants.CENTER);
		computerMoveLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		computerMoveLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		infoPanel.add(Box.createVerticalStrut(20));
		infoPanel.add(resultLabel);
		infoPanel.add(Box.createVerticalStrut(10));
		infoPanel.add(computerMoveLabel);
		infoPanel.add(Box.createVerticalStrut(20));

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
		JButton rockButton = createMoveButton("Rock", rockIcon);
		JButton paperButton = createMoveButton("Paper", paperIcon);
		JButton scissorsButton = createMoveButton("Scissors", scissorsIcon);

		buttonPanel.add(rockButton);
		buttonPanel.add(paperButton);
		buttonPanel.add(scissorsButton);

		add(infoPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);

		pack();
		setSize(400, 300);
		setLocationRelativeTo(null);
	}

	private JButton createMoveButton(String move, ImageIcon icon) {
		JButton button = new JButton(move, icon);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.addActionListener(e -> playGame(move.toLowerCase().substring(0, 1)));
		return button;
	}

	private void playGame(String playerMove) {
		String[] rps = {"r", "p", "s"};
		String computerMove = rps[new Random().nextInt(rps.length)];

		computerMoveLabel.setText("Computer's move: " + getFullMove(computerMove));

		String result;

		if (playerMove.equals(computerMove)) {
			result = "It's a tie!";
		} else if ((playerMove.equals("r") && computerMove.equals("s")) || (playerMove.equals("p") && computerMove.equals("r")) || (playerMove.equals("s") && computerMove.equals("p"))) {
			result = "You win!";
		} else {
			result = "You lose!";
		}
		
		resultLabel.setText(result);
	}

	private String getFullMove(String move) {
		switch (move) {
			case "r": return "Rock";
			case "p": return "Paper";
			case "s": return "Scissors";
			default: return "";
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new RockPaperScissors().setVisible(true);
	});
	}
}
