//Student 1 name: Neil Valin
//Student 2 name: Vishal Bhat
/**
 * The class <b>TicTacToeGame</b> is the class that implements the Tic Tac Toe
 * Game. It contains the grid and tracks its progress. It automatically maintain
 * the current state of the game as players are making moves.
 *
 *
 */
public class TicTacToeGame {
	/**
	 * The board of the game, stored as a one dimension array.
	 */
	private CellValue[] board;

	/**
	 * level records the number of rounds that have been played so far.
	 */
	private int level;

	/**
	 * gameState records the current state of the game
	 */
	private GameState gameState;

	/**
	 * lines is the number of lines in the grid
	 */
	private int lines;

	/**
	 * columns is the number of columns in the grid
	 */
	private int columns;

	/**
	 * sizeWin is the number of cell of the same type that must be aligned to win
	 * the game
	 */
	private int sizeWin;

	/**
	 * default constructor, for a game of 3x3, which must align 3 cells
	 */
	public TicTacToeGame() {
		// Your Code Here
		this.lines = 3;
	  this.columns = 3;
	  this.sizeWin = 3;
	  this.gameState = GameState.PLAYING;
	  this.board = new CellValue[9];
	  for (int i  =0; i<this.board.length; i++){
	 	 board[i] = CellValue.EMPTY;
	  }
	}

	/**
	 * constructor allowing to specify the number of lines and the number of columns
	 * for the game. 3 cells must be aligned.
	 *
	 * @param lines   the number of lines in the game
	 * @param columns the number of columns in the game
	 */
	public TicTacToeGame(int lines, int columns) {
		// Your Code Here
	  this.lines = lines;
	  this.columns = columns;
	  this.sizeWin =3;
	  this.gameState = GameState.PLAYING;
	  board = new CellValue[this.lines*this.columns];
	  for (int i  =0; i<this.board.length; i++){
	 	 	board[i] = CellValue.EMPTY;
	  }

	}

	/**
	 * constructor allowing to specify the number of lines and the number of columns
	 * for the game, as well as the number of cells that must be aligned to win.
	 *
	 * @param lines   the number of lines in the game
	 * @param columns the number of columns in the game
	 * @param sizeWin the number of cells that must be aligned to win.
	 */
	public TicTacToeGame(int lines, int columns, int sizeWin) {
		// Your Code Here
		this.columns = columns;
		this.lines = lines;
		this.sizeWin = sizeWin;
		this.gameState = GameState.PLAYING;
		//Intiialize and fill the game board
		this.board = new CellValue[this.columns*this.lines];
		for (int i  =0; i<this.board.length; i++){
		 board[i] = CellValue.EMPTY;
		}
	}


	/**
	 * getter for the variable lines
	 *
	 * @return the value of lines
	 */
	public int getLines() {
		// Your Code Here
		return lines;
	}

	/**
	 * getter for the variable columns
	 *
	 * @return the value of columns
	 */
	public int getColumns() {
		// Your Code Here
		return columns;
	}

	/**
	 * getter for the variable level
	 *
	 * @return the value of level
	 */
	public int getLevel() {
		// Your Code Here
		return level;
	}

	/**
	 * getter for the variable sizeWin
	 *
	 * @return the value of sizeWin
	 */
	public int getSizeWin() {
		// Your Code Here
		return sizeWin;
	}

	/**
	 * getter for the variable gameState
	 *
	 * @return the value of gameState
	 */
	public GameState getGameState() {
		// Your Code Here
		return gameState;
	}

	/**
	 * returns the cellValue that is expected next, in other word, which player (X
	 * or O) should play next. This method does not modify the state of the game.
	 *
	 * @return the value of the enum CellValue corresponding to the next expected
	 *         value.
	 */
	public CellValue nextCellValue() {
		// Your Code Here
		if (level %2==0) {
			return CellValue.X;
		}
		else {
			return CellValue.O;
		}
	}

	/**
	 * returns the value of the cell at index i. If the index is invalid, an error
	 * message is printed out. The behavior is then unspecified
	 *
	 * @param i the index of the cell in the array board
	 * @return the value at index i in the variable board.
	 */
	public CellValue valueAt(int i) {
		// Your Code Here
		try {
			CellValue x = board[i];
			return x;
		}
		catch (Exception e) {
			System.out.println("Error: Input is Invalid");
			return null;
		}
	}

   /**
	* This method is called by the next player to play at the cell  at index i.
	* If the index is invalid, an error message is printed out. The behaviour is then unspecified
	* If the chosen cell is not empty, an error message is printed out. The behaviour is then unspecified
	* If the move is valide, the board is updated, as well as the state of the game.
	* To faciliate testing, it is acceptable to keep playing after a game is already won.
	* If that is the case, the a message should be printed out and the move recorded.
	* The winner of the game is the player who won first
   	* @param i
    *  the index of the cell in the array board that has been selected by the next player
  	*/
	public void play(int i) {

		// your code here
		//check for invalid values or non-empty cells and print the corrosponding msg
		// otherwise, place x or o in the index i, then
		//if the game state is still PLAYING, then check if the current move change the state
		try{
      		if (board[i]==(CellValue.EMPTY)){
      			if (gameState.equals(GameState.XWIN) || gameState.equals(GameState.OWIN)) {
        			System.out.println("Game already finished");
        			if (level%2==0){
         				board[i] = CellValue.X;
						if (this.getSizeWin()!=3){
						setGameState(i);
						}
						else {
							setGameState2(i);
						}

          			}
            		else{
              			board[i] = CellValue.O;
						if (this.getSizeWin()!=3){
						setGameState(i);
						}
						else {
							setGameState2(i);
						}
          			}
        		}
        		else{
          			if (level%2==0){
            			board[i] = CellValue.X;
						if (this.getSizeWin()!=3){
						setGameState(i);
						}
						else {
							setGameState2(i);
						}

          			}
          			else{
            			board[i] = CellValue.O;
						if (this.getSizeWin()!=3){
						setGameState(i);
						}
						else {
							setGameState2(i);
						}

          			}
        		}
      		}
      		else{
        		System.out.println("Please choose an empty cell(1-"+board.length+").");
      		}
    	}
    	catch(IndexOutOfBoundsException e) {
      		System.out.println("Please enter a existing cell(1-"+board.length+").");//Cell that doesn't exist
    	}

	}


   /**
	* A helper method which updates the gameState variable
	* correctly after the cell at index i was just set.
	* The method assumes that prior to setting the cell
	* at index i, the gameState variable was correctly set.
	* it also assumes that it is only called if the game was
	* not already finished when the cell at index i was played
	* (the the game was playing). Therefore, it only needs to
	* check if playing at index i has concluded the game
	******************************
	*So check if the required number of sizeWin cells are formed to win.
	******************************
    *  the index of the cell in the array board that has just
    * been set
  	*/
	/*
	private void setGameState(int index){
		// your code here



	}
	*/
	private void setGameState(int i){ //changed index to i
		 	//i=i-1;
			int n=sizeWin;
		 	int a = i+1;
		 	int b = a%columns;
		 	level++;
		 	//int n = 4; //win req

		 	//javac TicTacToe.java
		 	//System.out.println("level: " + level + " board length: " + board.length);
		if (level == board.length) {
				gameState = GameState.DRAW;
			}
        if (board[i].equals(CellValue.O)) {
        		if (b==0) {
        			b=columns;
        		}
       		//LEFT TO RIGHT: FOR LOOP MOVES RIGHT TO LEFT
        	//Things to consider: the second condition for the initial if statement only needs to be true if x>0
			for(int x = 0; x<n; x++) {
				try {
        			for(int y = 1; y<n; y++) {
        				if (board[i-x].equals(board[i+y-x])&&board[i-x].equals(CellValue.O)) {
							if (y==(n-1)) {
                				gameState = GameState.OWIN;
							}
        				}
						else {
							y=n;
						}
        			}
				}
				catch (ArrayIndexOutOfBoundsException e) {

				}

        	}
			//DOWN TO UP: FOR LOOP MOVES UP TO DOWN
			for(int x = 0; x<n; x++) {
        		try {
        			for(int y = 1; y<n; y++) {
        				if (board[i+(x*columns)].equals(board[i-columns*y+(x*columns)])&&board[i+(x*columns)].equals(CellValue.O)) {
							if (y==(n-1)) {
								gameState = GameState.OWIN;
							}
        				}
						else {
							y=n;
						}
        			}

                }
				catch (ArrayIndexOutOfBoundsException e) {

				}
        	}

        	//DOWNLEFT TO UPRIGHT: FOR LOOP MOVES UPRIGHT TO DOWNLEFT
			for(int x = 0; x<n; x++) {
				try {
					for(int y = 1; y<n; y++) {
						//if doesn't work: (board[i-(x*columns)-x].equals(board[i-columns*y-(x*columns)-x])&&board[i-(x*columns)-x].equals(CellValue.O))
						//board[i-x].equals(board[i+y-x])&&board[i-x].equals(CellValue.O)
						//board[i+(x*columns)].equals(board[i-columns*y+(x*columns)])&&board[i+(x*columns)].equals(CellValue.O)
						if (board[i-x+(x*columns)].equals(board[i+y-x-(columns*y)+(x*columns)])&&board[i-x+(x*columns)].equals(CellValue.O)) {
							if (y==(n-1)) {
								gameState = GameState.OWIN;
							}
						} else {
							y=n;
						}
					}
				}
				catch (ArrayIndexOutOfBoundsException e) {
				}
			}
        	//for(int x = 0; x<n; x++) {
        	//	if ( b+(n-1)-x <= columns && (b-n+1-x) > 0   &&  (a-columns*(n-1)+columns*x) > 0 && (a+columns*(n-1)+x+columns*x) <= board.length ) {
        	//		for(int y = 1; y<n; y++) {
        	//			if (board[i-(x*columns)-x].equals(board[i-columns*y-(x*columns)-x])) {
            //    			gameState = GameState.OWIN;
        	//			}
        	//		}

            //    }
        	//}
        	//DOWNRIGHT To UPLEFT: FOR LOOP MOVES UPLEFT TO DOWNRIGHT
			for(int x = 0; x<n; x++) {
        		try {
        			for(int y = 1; y<n; y++) {
        				//board[i-x+(x*columns)].equals(board[i+y-x-columns*y+(x*columns)])&&board[i-x+(x*columns)].equals(CellValue.O)
        				if (board[i+x+(x*columns)].equals(board[i-y+x-columns*y+(x*columns)]) && board[i+x+(x*columns)].equals(CellValue.O)) {
							if (y==(n-1)) {
								gameState = GameState.OWIN;
							}
        				}
						else {
							y=n;
						}
        			}
                }
				catch (ArrayIndexOutOfBoundsException e) {

				}
        	}
        	//UPLEFT TO DOWNRIGHT: FOR LOOP MOVES DOWNRIGHT TO UPLEFT
        	//for(int x = 0; x<n; x++) {
        	//	if ( b+(n-1)-x <= columns && (b-n+1-x) > 0 && (a-columns*(n-1+x)) > 0 && (a+columns*(n-1)+x) <= board.length) {
        	//		for(int y = 1; y<n; y++) {
        	//			if (board[i+(x*columns)].equals(board[i+columns*y+(x*columns)])) {
            //    			gameState = GameState.OWIN;
        	//			}
        	//		}
            //    }
        	//}

		}
		else if (board[i].equals(CellValue.X)) {
			if (b==0) {
				b=columns;
			}
			//LEFT TO RIGHT: FOR LOOP MOVES RIGHT TO LEFT
			for(int x = 0; x<n; x++) {
				try {
        			for(int y = 1; y<n; y++) {
        				if (board[i-x].equals(board[i+y-x])&&board[i-x].equals(CellValue.X)) {
							if (y==(n-1)) {
                				gameState = GameState.XWIN;
							}
        				}
						else {
							y=n;
						}
        			}
				}
				catch (ArrayIndexOutOfBoundsException e) {

				}

        	}

		//DOWN TO UP: FOR LOOP MOVES UP TO DOWN
		for(int x = 0; x<n; x++) {
			try {
				for(int y = 1; y<n; y++) {
					if (board[i+(x*columns)].equals(board[i-columns*y-(x*columns)])&&board[i+(x*columns)].equals(CellValue.X)) {
						if (y==(n-1)) {
							gameState = GameState.XWIN;
						}
					}
					else {
						y=n;
					}
				}

			}
			catch (ArrayIndexOutOfBoundsException e) {

			}
		}

		//DOWNLEFT TO UPRIGHT: FOR LOOP MOVES UPRIGHT TO DOWNLEFT
		for(int x = 0; x<n; x++) {
			try {
				for(int y = 1; y<n; y++) {
					if (board[i-x+(x*columns)].equals(board[i+y-x-columns*y+(x*columns)])&&board[i-x+(x*columns)].equals(CellValue.X)) {
						if (y==(n-1)) {
							gameState = GameState.XWIN;
						}
					}
					else {
						y=n;
					}
				}
			}
			catch (ArrayIndexOutOfBoundsException e) {

			}
		}

		//UPLEFT TO DOWNRIGHT: FOR LOOP MOVES DOWNRIGHT TO UPLEFT
		for(int x = 0; x<n; x++) {
			try {
				for(int y = 1; y<n; y++) {
					if (board[i+x+(x*columns)].equals(board[i-y+x-columns*y+(x*columns)]) && board[i+x+(x*columns)].equals(CellValue.X)) {
						if (y==(n-1)) {
							gameState = GameState.XWIN;
						}
					}
					else {
						y=n;
					}
				}
			}
			catch (ArrayIndexOutOfBoundsException e) {

			}
		}

		}
	}
	private void setGameState2(int i){ //changed index to i
	//i=i-1;
	int a = i+1;
	int b = a%columns;
	level++;
	//javac TicTacToe.java
	if (level == board.length) {
			gameState = GameState.DRAW;
		}
			if (board[i].equals(CellValue.O)) {
				if (b==0) {
					b=columns;

				}
				//((a+columns*2) <= board.length) + ((a-columns*2) > 0) +

				//System.out.println("Sups"+ board[i]+""+board[i+1]+""+board[i+2]+""+board[i-1]+""+board[i-2]+""+board[i+columns]+""+board[i+2*columns]+""+board[i-columns]+""+board[i-2*columns]);

				   if (b+2 <= columns && board[i].equals(board[i+1]) && board[i].equals(board[i+2])) { //left to right
						   gameState = GameState.OWIN;
				   }
				   else if (b-2 > 0 && board[i].equals(board[i-1]) && board[i].equals(board[i-2])){ //right to left
						   gameState = GameState.OWIN;
				   }
				   else if ((a+columns*2) <= board.length && board[i].equals(board[i+columns]) && board[i].equals(board[i+2*columns])){ //up to down

						   gameState = GameState.OWIN;
				   }
				   else if ((a-columns*2) > 0 && board[i].equals(board[i-columns]) && board[i].equals(board[i-2*columns])){ //down to up
						   gameState = GameState.OWIN;
				   }
				   else if (b+2 <= columns && (a-columns*2) > 0 && board[i].equals(board[i-columns+1]) && board[i].equals(board[i-columns*2+2])){ //downleft to upright
						   gameState = GameState.OWIN;
				   }
				   else if (b-2 > 0 && (i+columns*2) <= board.length && board[i].equals(board[i+columns-1]) && board[i].equals(board[i+columns*2-2])){ //upright to downleft
						   gameState = GameState.OWIN;
				   }
				   else if (b-2 > 0 && (i-columns*2) > 0 && board[i].equals(board[i-columns-1]) && board[i].equals(board[i-columns*2-2])){ //downright to upleft
						   gameState = GameState.OWIN;
				   }
				   else if (b+2 <= columns && (i+columns*2) <= board.length && board[i].equals(board[i+columns+1]) && board[i].equals(board[i+columns*2+2])){ //upleft to downright
						   gameState = GameState.OWIN;
				   }
				   else if (b+1 <= columns && (a%columns)-1 > 0 && board[i].equals(board[i+1]) && board[i].equals(board[i-1])) { //right and left
					   gameState = GameState.OWIN;
				   }
				   else if ((a+columns) <= board.length && (a-columns) > 0  && board[i].equals(board[i+columns]) && board[i].equals(board[i-columns])){ //up and down
					   gameState = GameState.OWIN;
				   }
				   else if (b+1 <= columns && (a%columns)-1 > 0 && (a+columns) <= board.length && (a-columns) > 0  && board[i].equals(board[i+columns-1]) && board[i].equals(board[i-columns+1])){ //upright and downleft
					   gameState = GameState.OWIN;
				   }
				   else if (b+1 <= columns && (a%columns)-1 > 0 && (a+columns) <= board.length && (a-columns) > 0  && board[i].equals(board[i+columns+1]) && board[i].equals(board[i-columns-1])){ //upleft and downright
					   gameState = GameState.OWIN;
				   }
				   else if (level == board.length) {
						gameState = GameState.DRAW;
					}

			}
			else if (board[i].equals(CellValue.X)) {
				if (b==0) {
					b=columns;

				}
				//((a+columns*2) <= board.length) + ((a-columns*2) > 0) +
				//System.out.println("O:"+ board[i] + a + (b+2 <= columns) + (b-2 > 0) +  (board[i]) + (board[i-columns+1]) + (board[i-columns*2+2])+i + (b-2 > 0) + (i-columns*2) );
				//System.out.println("Sups"+ board[i]+""+board[i+1]+""+board[i+2]+""+board[i-1]+""+board[i-2]+""+board[i+columns]+""+board[i+2*columns]+""+board[i-columns]+""+board[i-2*columns]);


				   if (b+2 <= columns && board[i].equals(board[i+1]) && board[i].equals(board[i+2])) { //left to right
						   gameState = GameState.XWIN;
				   }
				   else if (b-2 > 0 && board[i].equals(board[i-1]) && board[i].equals(board[i-2])){ //right to left
						   gameState = GameState.XWIN;
				   }
				   else if ((a+columns*2) <= board.length && board[i].equals(board[i+columns]) && board[i].equals(board[i+2*columns])){ //up to down

						   gameState = GameState.XWIN;
				   }
				   else if ((a-columns*2) > 0 && board[i].equals(board[i-columns]) && board[i].equals(board[i-2*columns])){ //down to up
						   gameState = GameState.XWIN;
				   }
				   else if (b+2 <= columns && (a-columns*2) > 0 && board[i].equals(board[i-columns+1]) && board[i].equals(board[i-columns*2+2])){ //downleft to upright
						   gameState = GameState.XWIN;
				   }
				   else if (b-2 > 0 && (a+columns*2) <= board.length && board[i].equals(board[i+columns-1]) && board[i].equals(board[i+columns*2-2])){ //upright to downleft
						   gameState = GameState.XWIN;
				   }
				   else if (b-2 > 0 && (a-columns*2) > 0 && board[i].equals(board[i-columns-1]) && board[i].equals(board[i-columns*2-2])){ //downright to upleft
						   gameState = GameState.XWIN;
				   }
				   else if (b+2 <= columns && (a+columns*2) <= board.length && board[i].equals(board[i+columns+1]) && board[i].equals(board[i+columns*2+2])){ //upleft to downright
						   gameState = GameState.XWIN;
				   }
				   else if (b+1 <= columns && (a%columns)-1 > 0 && board[i].equals(board[i+1]) && board[i].equals(board[i-1])) { //right and left
					   gameState = GameState.XWIN;
				   }
				   else if ((a+columns) <= board.length && (a-columns) > 0  && board[i].equals(board[i+columns]) && board[i].equals(board[i-columns])){ //up and down
					   gameState = GameState.XWIN;
				   }
				   else if (b+1 <= columns && (a%columns)-1 > 0 && (a+columns) <= board.length && (a-columns) > 0  && board[i].equals(board[i+columns-1]) && board[i].equals(board[i-columns+1])){ //upright and downleft
					   gameState = GameState.XWIN;
				   }
				   else if (b+1 <= columns && (a%columns)-1 > 0 && (a+columns) <= board.length && (a-columns) > 0  && board[i].equals(board[i+columns+1]) && board[i].equals(board[i-columns-1])){ //upleft and downright
					   gameState = GameState.XWIN;
				   }
				   else if (level == board.length) {
						gameState = GameState.DRAW;
					}


	}
   }

	final String NEW_LINE = System.getProperty("line.separator");
	// returns the OS dependent line separator

   /**
	* Returns a String representation of the game matching
	* the example provided in the assignment's description
	*
   	* @return
    *  String representation of the game
  	*/

	public String toString(){
		// your code here
		// use NEW_LINE defined above rather than \n
		String gameBoard;
		gameBoard=""+NEW_LINE;
		int j = 0;
		for (int i = 1;i<=lines; i++){
			int k = 1;
			while (k<=columns) {
				if (k == columns) {
					if (board[j].equals(CellValue.EMPTY)){
						gameBoard += "   ";
							j++;
							k++;
					}
					else if (board[j].equals(CellValue.X)){
						gameBoard += " X ";
						j++;
						k++;
					}
					else if (board[j].equals(CellValue.O)){
						gameBoard += " O ";
						j++;
						k++;

					}
				}
				else {
					if (board[j].equals(CellValue.EMPTY)){
						gameBoard += "   ";
						j++;
						k++;
					}
					else if (board[j].equals(CellValue.X)){
						gameBoard += " X ";
						j++;
						k++;
					}
					else if (board[j].equals(CellValue.O)){
						gameBoard += " O ";
						j++;
						k++;
					}
					gameBoard += "|";


				}
			 	}
			 gameBoard+=NEW_LINE;
			 if (i!=lines) {
					 for (int y = 0; y < columns; y++) {
							 gameBoard += "----";
					 }
			 }
			 gameBoard+=NEW_LINE;

		}
		return gameBoard;
	}
}
