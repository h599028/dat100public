package no.hvl.dat100.tictactoe;

public class GameController {

	private char[][] board;
	private char turn;

	public GameController() {
		turn = TicTacToe.X_PLAYER_CHR; // Player 'X' starts the game
		board = new char[TicTacToe.SIZE][TicTacToe.SIZE];
	}

	public char getTurn() {
		return turn;
	}

	public void nextTurn() {
		switch (turn) {
		case TicTacToe.X_PLAYER_CHR:
			turn = TicTacToe.O_PLAYER_CHR;
			break;
		case TicTacToe.O_PLAYER_CHR:
			turn = TicTacToe.X_PLAYER_CHR;
			break;
		}
	}

	// check board given that field (x,y) has been selected by player
	public char checkGameBoard(int x, int y, char player) {
		char winner = ' ';

		System.out.println("Updating Gameboard (" + x + "," + y + ") = " + player);
		board[y][x] = player;

		System.out.println("Checking Gameboard");

		if (checkGameBoardPlayer(TicTacToe.X_PLAYER_CHR)) {
			winner = TicTacToe.X_PLAYER_CHR;
		} else if (checkGameBoardPlayer(TicTacToe.O_PLAYER_CHR)) {
			winner = TicTacToe.O_PLAYER_CHR;
		}

		System.out.println("Winner = " + winner);

		return winner;
	}

	public boolean checkGameBoardPlayer(char player) {

		boolean gameover = false;

		// check all rows on the board (horizontal)
		int y = 0;
		while (!gameover && y < TicTacToe.SIZE) {

			gameover = checkHorizontal(y, player);
			y++;
		}

		// check all columns on the board (vertical)
		int x = 0;
		while (!gameover && x < TicTacToe.SIZE) {

			gameover = checkVertical(x, player);
			x++;
		}

		if (!gameover) {
			gameover = checkDiagonals(player);
		}

		return gameover;
	}

	private boolean checkHorizontal(int y, char player) {
		for (int i = 0; i < TicTacToe.SIZE; i++) {
			if (board[y][i] !=  player) {
				return false;
			}
		}

		return true;
	}

	private boolean checkVertical(int x, char player) {
		for (int i = 0; i < TicTacToe.SIZE; i++) {
			if (board[i][x] !=  player) {
				return false;
			}
		}

		return true;
	}

	private boolean checkDiagonals(char player) {

		boolean allequal_lr = true;
		boolean allequal_rl = true;
		
		for (int i = 0; i < TicTacToe.SIZE; i++) {
			if (board[i][i] != player) {
				allequal_lr = false;
			}
			
			if (board[TicTacToe.SIZE - 1 - i][i] != player) {
				allequal_rl = false;
			}
		}
		
		return allequal_lr || allequal_rl; 
	}

}
