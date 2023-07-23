package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverPage implements ActionListener
{
	JFrame gameOverPage;
	JFrame previousGamePage;
	JPanel buttonsPanel;

	JButton playAgainButton;
	JButton quitButton;

	JLabel resultLabel;

	public GameOverPage(JFrame previousGamePage, char result)
	{
		this.previousGamePage = previousGamePage;

		gameOverPage = new JFrame("Game Over");
		gameOverPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameOverPage.setSize(400, 350);
		gameOverPage.setLayout(new BorderLayout());
		gameOverPage.setResizable(false);

		// Result label;
		resultLabel = new JLabel(getResultString(result));
		resultLabel.setFont(CosmeticManager.GAME_RESULT_FONT);
		resultLabel.setHorizontalAlignment(JLabel.CENTER);
		resultLabel.setOpaque(true);
		resultLabel.setForeground(Color.BLACK);
		resultLabel.setBackground(CosmeticManager.getDarkerShade(CosmeticManager.PRIMARY_COLOR, 20));

		// Panel for buttons
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		buttonsPanel.setBackground(CosmeticManager.PRIMARY_COLOR);

		// Play Again Button
		playAgainButton = new JButton("Play Again");
		playAgainButton.setPreferredSize(new Dimension(150, 50));
		playAgainButton.setBackground(CosmeticManager.PLAY_AGAIN_BUTTON_COLOR);
		playAgainButton.setFont(CosmeticManager.PRIMARY_FONT);
		playAgainButton.setFocusable(false);		
		playAgainButton.addActionListener(this);
		
		// Quit Button
		quitButton = new JButton("Quit Game");
		quitButton.setPreferredSize(new Dimension(150, 50));
		quitButton.setBackground(CosmeticManager.QUIT_BUTTON_COLOR);
		quitButton.setFont(CosmeticManager.PRIMARY_FONT);	
		quitButton.setFocusable(false);
		quitButton.addActionListener(this);

		// Adding all components
		buttonsPanel.add(playAgainButton);
		buttonsPanel.add(quitButton);

		gameOverPage.add(resultLabel, BorderLayout.NORTH);
		gameOverPage.add(buttonsPanel, BorderLayout.CENTER);

		gameOverPage.setVisible(true);
	}

	private String getResultString(char result)
	{
		if (result == LogicManager.X)
		{
			return "Winner: X";
		}
		else if (result == LogicManager.O)
		{
			return "Winner: O";
		}
		else
		{
			return "Tie";
		}
	} 

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == playAgainButton)
		{
			new GamePage();
		}
		previousGamePage.dispose();
		gameOverPage.dispose();
	}
}
