package application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartPage implements ActionListener
{
	JFrame startPage;
	JPanel buttonsPanel;
	JButton startButton;
	JButton quitButton;

	public StartPage()
	{
		startPage = new JFrame("Tic Tac Toe");
		startPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startPage.setSize(400, 250);
		startPage.setLayout(new BorderLayout());
		startPage.setResizable(false);

		// Panel for buttons
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		buttonsPanel.setBackground(CosmeticManager.PRIMARY_COLOR);

		// Start Button 
		startButton = new JButton("Start Game");
		startButton.setPreferredSize(new Dimension(150, 50));
		startButton.setBackground(CosmeticManager.START_BUTTON_COLOR);
		startButton.setFocusable(false);		
		startButton.setFont(CosmeticManager.PRIMARY_FONT);
		startButton.addActionListener(this);
		
		// Quit Button
		quitButton = new JButton("Quit Game");
		quitButton.setPreferredSize(new Dimension(150, 50));
		quitButton.setBackground(CosmeticManager.QUIT_BUTTON_COLOR);
		quitButton.setFocusable(false);
		quitButton.setFont(CosmeticManager.PRIMARY_FONT);
		quitButton.addActionListener(this);

		// Adding all components
		buttonsPanel.add(startButton);
		buttonsPanel.add(quitButton);

		startPage.add(buttonsPanel);
		
		startPage.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == startButton)
		{
			new GamePage();
		}
		startPage.dispose();
	}
}
