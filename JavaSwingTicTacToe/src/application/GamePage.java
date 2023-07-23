package application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePage implements ActionListener
{
	char gameResult;

	LogicManager logicManager;

	JFrame gamePage;
	JPanel menuBar;
	JPanel tilesPanel;

	JLabel turnLabel;

	JButton[] tiles;


	public GamePage()
	{
		gamePage = new JFrame();
		gamePage.setTitle("Tic Tac Toe");
		gamePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePage.setSize(600, 630);
		gamePage.setMinimumSize(new Dimension(600, 630));
		gamePage.setLayout(new BorderLayout());
		gamePage.setResizable(false);

		logicManager = new LogicManager();
		
		initializeMenuBar();
		intializeTiles();
		
		gamePage.setVisible(true);
	}
	
	private void initializeMenuBar()
	{
		menuBar = new JPanel();

		menuBar.setPreferredSize(new Dimension(600, 30));
		menuBar.setBackground(CosmeticManager.CLASSIC_WHITE);
		
		turnLabel = new JLabel();
		turnLabel.setFont(new Font("Courier", Font.PLAIN, 12));
		turnLabel.setHorizontalAlignment(JLabel.CENTER);		
		turnLabel.setVerticalAlignment(JLabel.CENTER);
		turnLabel.setFont(CosmeticManager.MENU_FONT);

		updateMenuBar();

		menuBar.add(turnLabel);
		
		gamePage.add(menuBar, BorderLayout.NORTH);
	}
	
	private void intializeTiles()
	{
		tilesPanel = new JPanel(new GridLayout(3, 3));
		tilesPanel.setPreferredSize(new Dimension(600, 600));
		
		tiles = new JButton[9];
		
		int i;
		for (i = 0; i < 9; i++)
		{
			tiles[i] = new JButton();
			tiles[i].setFocusable(false);
			tiles[i].addActionListener(this);
			tiles[i].setFont(CosmeticManager.TILE_FONT);
			tiles[i].setBackground(CosmeticManager.PRIMARY_COLOR);
			tiles[i].setBorder(BorderFactory.createLineBorder(CosmeticManager.getDarkerShade(CosmeticManager.PRIMARY_COLOR, 70), 2));

			tilesPanel.add(tiles[i]);
		}
		gamePage.add(tilesPanel, BorderLayout.CENTER);
	}
	
	private void updateMenuBar()
	{
		turnLabel.setText(String.format("%c's turn", logicManager.getTurn()));
	}

	private void disableTiles()
	{
		int i;
		for (i = 0; i < 9; i++)
		{
			tiles[i].setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		int i;
		for (i = 0; i < 9; i++)
		{
			if (e.getSource() == tiles[i])
			{
				// Update tile graphic and function
				tiles[i].setEnabled(false);
				tiles[i].setText(String.valueOf(logicManager.getTurn()));

				// Check for potential win
				gameResult = logicManager.onTurn(i);
				if (gameResult != LogicManager.EMPTY)
				{
					// Someone has won
					disableTiles();
					
					new GameOverPage(gamePage, gameResult);
				}
				
				// Update menu text
				updateMenuBar();
			}
		}
	}
}
