//Student 1 name: Neil Valin
//Student 2 name: Vishal Bhat

/**
 * The class <b>ComputerRandomPlayer</b> is the class that controls the computer's plays.
 *
 *
 */

import java.util.*;

public class ComputerRandomPlayer implements Player {
	//generate random position at an empty cell!!
	//call game.play(position)
	public void play(TicTacToeGame game ) {

		if (!(game.getGameState().equals(GameState.PLAYING))) {
			System.out.println("The Game is over.");
		}
		else {
			int boardLength = (game.getColumns()*game.getLines());
			int y;
			boolean t = true;

			while (t) {
				y = Utils.generator.nextInt(boardLength);
				if ((CellValue.X).equals(game.valueAt(y))||(CellValue.O).equals(game.valueAt(y))) {
					t = true;
				}
				else {
					t = false;
					game.play(y);
				}
			}
		}
	}
}
