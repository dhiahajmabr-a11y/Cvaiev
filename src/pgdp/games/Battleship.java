package pgdp.games;

import static pgdp.PinguLib.*;

public class Battleship {

	private static final String WELCOME_MESSAGE = "Welcome to Battleships";
	private static final String PLAY_MESSAGE = "Let's start the game!";
	private static final String WIN_MESSAGE = "Congrats! You won!";
	private static final String LOSE_MESSAGE = "Too bad, you lost!";

	private static final String PRINT_FIRST_LINE = "Your Board:\t\t\tAI Board:";
	private static final String PRINT_SECOND_LINE = "+ a b c d e f g h\t\t+ a b c d e f g h";
	private static final String TABS = "\t\t";

	private static final String PLAYER_BOAT = " ■";
	private static final String BOAT_MISSED = " o";
	private static final String BOAT_HIT = " x";
	private static final String WATER = "  ";

    public static final int EMPTY = 0;
    public static final int BOAT = 1;
    public static final int MISSED = 2;
    public static final int HIT = 3;

	private Player player;
	private AI ai;

	public Battleship(Player player, AI ai) {
		this.player = player;
		this.ai = ai;
	}

	public static void main(String[] args) {
		new Battleship(new Player(), new AI()).game();
	}

	/**
	 * Runs the whole game.
	 */
	public void game() {
		// TODO 7
		System.out.println(WELCOME_MESSAGE);
		int[][] emptyBoard = new int[8][8];
		printBoard(emptyBoard, emptyBoard);

		player.generatePlayerBoard();

		System.out.println(PLAY_MESSAGE);

		int[][] playerBoard = player.getBoard();
		int[][] aiBoard = ai.getBoard();

		boolean playerTurn = true;

		while (hasShipsLeft(playerBoard) && hasShipsLeft(aiBoard)) {

			if (playerTurn) {
				boolean hit = player.play(aiBoard);

				printBoard(playerBoard, aiBoard);

				if (!hasShipsLeft(aiBoard)) {
					break;
				}

				if (!hit) {
					playerTurn = false;
				}

			} else {
				boolean hit = ai.play(playerBoard);

				printBoard(playerBoard, aiBoard);

				if (!hasShipsLeft(playerBoard)) {
					break;
				}

				if (!hit) {
					playerTurn = true;
				}
			}
		}
		if (!hasShipsLeft(aiBoard)) {
			System.out.println(WIN_MESSAGE);
		} else {
			System.out.println(LOSE_MESSAGE);
		}
	}

	/**
	 * Checks if there are any ships left.
	 * 
	 * @param board
	 * @return true if at least one ship exists (partially)
	 */
	public boolean hasShipsLeft(int[][] board) {
		// TODO 2
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 1 ){
					return true;
				}
			}
		}
		return false;
	}




	/**
	 * Prints both boards to the console
	 * 
	 * @param playerBoard
	 * @param aiBoard
	 */


	public static void printBoard(int[][] playerBoard, int[][] aiBoard) {
		System.out.println("Your Board:\t\t\tAI Board:");
		System.out.println("+ a b c d e f g h\t\t+ a b c d e f g h");

		for (int row = 0; row < 8; row++) {
			System.out.print((row + 1));

			for (int col = 0; col < 8; col++) {
				System.out.print(fieldToString(playerBoard[row][col],true));
				if(playerBoard[row][col] == 1){
				}
			}
			System.out.print("\t\t");
			System.out.print((row + 1));

			for (int col = 0; col < 8; col++) {
				System.out.print(fieldToString(aiBoard[row][col],false));
				if(playerBoard[row][col] == 1){
				}
			}
			System.out.println();
		}
	}

	private static String fieldToString(int value, boolean isPlayer) {
		switch (value) {
			case 0:
				return "  ";
			case 1:
				return isPlayer ? " ■" : "  ";
			case 2:
				return " o";
			case 3:
				return " x";
			default:
				return "  ";
		}
	}




	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public AI getAi() {
		return ai;
	}

	public void setAi(AI ai) {
		this.ai = ai;
	}
}
