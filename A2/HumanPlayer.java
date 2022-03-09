//Student 1 name: Neil Valin
//Student 2 name:Vishal Bhat
/**
 * The class <b>HumanPlayer</b> is the class that controls the human's plays.
 *
 *
 */

public class HumanPlayer implements Player {
	//read a position to play from the console and call
	// game.play(position): if the level was advanced after the call, then finish, otherwise repeat and get another position
	public void play(TicTacToeGame game) {
		if (!(game.getGameState().equals(GameState.PLAYING))) {
			System.out.println("The Game is over.");
		}
		else {
			int q = game.getLevel();
			String n = "";
			int boardLength = (game.getColumns()*game.getLines());
			if (q%2==0) {
				boolean valid = false;
				Integer x=1;
				while (valid==false) {
					System.out.print(CellValue.X+" to play: ");
					try {
						n = Utils.console.readLine();
						x = Integer.parseInt(n);
						if ((CellValue.X).equals(game.valueAt(x-1))||(CellValue.O).equals(game.valueAt(x-1))) {
							System.out.println("This cell has already been played.");
						}
						else {
							valid = true;
							game.play(x-1);
						}
					}
					catch (Exception e) {
						System.out.println("Enter a valid input.");
					}

				}
			}
			else {
				boolean valid = false;
				Integer x = 1;
				while (valid==false) {
					System.out.print(CellValue.O+" to play: ");
					try {
						n = Utils.console.readLine();
						x = Integer.parseInt(n);
						if ((CellValue.X).equals(game.valueAt(x-1))||(CellValue.O).equals(game.valueAt(x-1))) {
							System.out.println("This cell has already been played.");
						}
						else {
							valid = true;
							game.play(x-1);
						}
					}
					catch (Exception e) {
						System.out.println("Enter a valid input.");
					}

				}


			}
		}
	}
}
