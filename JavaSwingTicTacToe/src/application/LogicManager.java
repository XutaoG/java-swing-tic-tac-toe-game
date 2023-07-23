package application;

public class LogicManager
{
	public static final char X = 'X';
	public static final char O = 'O';
	public static final char EMPTY = ' ';
	public static final char TIE = 'T';

	char turn;

	char[] tiles;

	public LogicManager()
	{
		turn = X;
		tiles = new char[9];

		// Intialize tiles
		int i;
		for (i = 0; i < tiles.length; i++)
		{
			tiles[i] = EMPTY;
		}
	}

	public char onTurn(int tileNumber)
	{
		char result;

		tiles[tileNumber] = turn;
		result = checkForVictory();
		if (result == EMPTY)
		{
			if (turn == X)
			{
				turn = O;
			}
			else
			{
				turn = X;
			}
		}
		
		return result;
	}

	public char getTurn()
	{
		return turn;
	}

	private char checkForRows()
	{
		char potentialVictor;
		char victor = EMPTY;

		int i;
		for (i = 0; i < tiles.length; i += 3)
		{
			potentialVictor = tiles[i];
			if (potentialVictor == EMPTY)
			{
				continue;
			}

			if (tiles[i + 1] == potentialVictor && tiles[i + 2] == potentialVictor)
			{
				victor = potentialVictor;
			}
		}
		return victor;
	}

	private char checkForColumns()
	{
		char potentialVictor;
		char victor = EMPTY;

		int i;
		for (i = 0; i < 3; i++)
		{
			potentialVictor = tiles[i];
			if (potentialVictor == EMPTY)
			{
				continue;
			}

			if (tiles[i + 3] == potentialVictor && tiles[i + 6] == potentialVictor)
			{
				victor = potentialVictor;
			}
		}
		return victor;
	}

	private char checkForDiagonals()
	{
		char potentialVictor;

		potentialVictor = tiles[0];

		if (potentialVictor != EMPTY && tiles[4] == potentialVictor && tiles[8] == potentialVictor)
		{
			return potentialVictor;
		}

		potentialVictor = tiles[2];

		if (potentialVictor != EMPTY && tiles[4] == potentialVictor && tiles[6] == potentialVictor)
		{
			return potentialVictor;
		}
		return EMPTY;
	}

	private boolean checkForTie()
	{
		int i;
		for (i = 0; i < tiles.length; i++)
		{
			if (tiles[i] == EMPTY)
			{
				return false;
			}
		}
		return true;
	}

	private char checkForVictory()
	{
		char rowResult = checkForRows();
		if (rowResult != EMPTY)
		{
			return rowResult;
		}
		
		char columnResult = checkForColumns();
		if (columnResult != EMPTY)
		{
			return columnResult;
		}

		char diagonalResult = checkForDiagonals();
		if (diagonalResult != EMPTY)
		{
			return diagonalResult;
		}

		if (checkForTie())
		{
			return TIE;
		}
		return EMPTY;
	}
}
