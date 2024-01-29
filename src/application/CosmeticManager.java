package application;

import java.awt.Color;
import java.awt.Font;


public class CosmeticManager 
{
	public static final Color PRIMARY_COLOR = new Color(132, 99, 200);

	public static final Color CLASSIC_WHITE = new Color(220, 220, 220);
	public static final Color START_BUTTON_COLOR = new Color(133, 196, 104);
	public static final Color PLAY_AGAIN_BUTTON_COLOR = new Color(133, 196, 104);
	public static final Color QUIT_BUTTON_COLOR = new Color(237, 128, 107);

	public static final Font PRIMARY_FONT = new Font("Courier", Font.BOLD, 16);
	public static final Font MENU_FONT = new Font("Courier", Font.BOLD, 14);
	public static final Font TILE_FONT = new Font("Helvetica", Font.BOLD, 120);
	public static final Font GAME_RESULT_FONT = new Font("Helvetica", Font.BOLD, 50);

	public static Color getDarkerShade(Color color, int increment)
	{
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();

		r -= increment;
		g -= increment;
		b -= increment;

		if (r < 0)
		{
			r = 0;
		}
		if (g < 0)
		{
			g = 0;
		}
		if (b < 0)
		{
			b = 0;
		}

		return new Color(r, g, b);
	}
}
