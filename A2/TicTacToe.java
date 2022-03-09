    //Student 1 name: Neil Valin
//Student 2 name: Vishal Bhat

/**
 * The class <b>TicTacToe</b> is the class that implements the actual Tic Tac
 * Toe game, where it
 * controls the human and computer activity and prints the result of the game at
 * the end. It also
 * asks the player if he/she wants to continue playing once this game is over.
 *
 *
 */

public class TicTacToe {

    /**
     * <b>main</b> of the application. Creates the instance of GameController
     * and starts the game. If two parameters line and column
     * are passed, they are used.
     * Otherwise, a default value is used. Defaults values are also
     * used if the paramters are too small (less than 2).
     *
     * @param args
     *             command line parameters
     */
    public static void main(String[] args) {
        StudentInfo.display();


		//default values used if args are not there:
        int lines = 3;
        int columns = 3;
        int win = 3;

        //change lines, columns and win based on the args values
        if (args.length >= 3) {
            lines = Integer.parseInt(args[0]);
            columns = Integer.parseInt(args[1]);
            win = Integer.parseInt(args[2]);
            if ( win >columns && win >lines) {
                System.out.println("Size of win to high, going with default");
                win = 3;
            }
        }
        else if (args.length ==2) {
            lines = Integer.parseInt(args[0]);
            columns = Integer.parseInt(args[1]);
        }

		//define an array (say p) of two players (use interface playe for the refernce)
		// The first playe is an object of type HumanPlayer and
		// the second player is an object of type  ComputerRandomPlayer()
        HumanPlayer h = new HumanPlayer();
        ComputerRandomPlayer c = new ComputerRandomPlayer();
        Player[] p = {h, c};
		//choose player randomly (p[0] or p[1])
        int start = Utils.generator.nextInt(2);
        boolean q = p[start]==c;
		// create a refernce to an object of type TicTacToeGame
        TicTacToeGame game;

		// loop until the input is not 'y'
		do {
		     // create object for TicTacToeGame
		     // for loop that prints who's turn it is, the board, and who is to play, until
                // the game ends

            game = new TicTacToeGame(lines, columns, win);
System.out.println(game.getSizeWin());
            while(game.getGameState()==GameState.PLAYING) {

                // your code here
                if (q==true) {
                    System.out.println("Player 2's turn: ");
                    c.play(game);
                    System.out.println("Player 1's turn");
                    System.out.println(game);
                    h.play(game);
                }
                else {
                    System.out.println("Player 1's turn: ");
                    System.out.println(game);
                    h.play(game);
                    System.out.println("Player 2's turn: ");
                    c.play(game);
                }
        		System.out.println(game);


                }
                if (q==true) {
                    q = false;
                }
                else {
                    q = true;
                }
            System.out.println(game.getGameState());
            System.out.println("Play again? (enter Y)");
		     // prints result of game and ask if you want to play again
		}while(Utils.console.readLine().compareToIgnoreCase("y") == 0);


    }
}
