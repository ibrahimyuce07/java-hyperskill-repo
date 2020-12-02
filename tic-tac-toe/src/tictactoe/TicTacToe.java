package tictactoe;

import java.util.Scanner;

public class TicTacToe {
	public static Scanner scanner = new Scanner(System.in);
	private static final int SIZE = 3;
	private static char[][] gameField;
	private static final char X = 'X';
	private static final char O = 'O';

	public static void main(String[] args) {

		char playerSymbol = X;

		initField();
		printField();
		while (true) {
			askTurn(playerSymbol);
			printField();
			if (isEndGame()) {
				break;
			} else {
				playerSymbol = (playerSymbol == X ? O : X);
			}
		}
	}

	public static void initField() {

		gameField = new char[SIZE][SIZE];

		for (int i = 0; i < SIZE * SIZE; i++) {
			gameField[i / SIZE][i % SIZE] = '_';
		}
	}

	public static void printField() {
		System.out.println("---------");
		for (int i = 0; i < SIZE; i++) {
			System.out.print("| ");
			for (int j = 0; j < SIZE; j++) {
				System.out.print(gameField[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.println("---------");
	}

	public static void askTurn(char symbol) {

		while (true) {
			int x;
			int y;
			System.out.print("Enter the coordinates: ");

			// check symbols without numbers
			while (true) {
				String turn = scanner.nextLine();
				if (!turn.matches("\\d\\s\\d")) {
					System.out.println("You should enter numbers!");
					System.out.print("Enter the coordinates: ");
				} else {
					x = Integer.parseInt(String.valueOf(turn.charAt(0))) - 1;
					y = Integer.parseInt(String.valueOf(turn.charAt(2))) - 1;
					break;
				}
			}

			// possible make turn
			if (x < 0 || x > SIZE - 1 || y < 0 || y > SIZE - 1) {
				System.out.println("Coordinates should be from 1 to 3!");
			} else if (gameField[x][y] == X || gameField[x][y] == O) {
				System.out.println("This cell is occupied! Choose another one!");
			} else {
				gameField[x][y] = symbol;
				break;
			}
		}
	}

	public static boolean isEndGame() {

		// check win & impossible win
		if (checkDiagWin(X) || checkDiagWin(O)) {
			return true;
		}

		if (checkRowColWin(X)) {
			System.out.println("X wins");
			return true;
		} else if (checkRowColWin(O)) {
			System.out.println("O wins");
			return true;
		}

		// check draw or not finished
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (gameField[i][j] == ' ' || gameField[i][j] == '_') {
					return false;
				}
			}
		}
		System.out.println("Draw");
		return true;
	}

	private static boolean checkDiagWin(char symbol) {
		boolean leftRightDiag = true;
		boolean rightLeftDiag = true;

		for (int i = 0; i < SIZE; i++) {
			leftRightDiag &= (gameField[i][i] == symbol);
			rightLeftDiag &= (gameField[SIZE - i - 1][i] == symbol);
		}

		if (leftRightDiag || rightLeftDiag) {
			System.out.println(symbol + " wins");
			return true;
		}
		return false;
	}

	private static boolean checkRowColWin(char symbol) {
		boolean cols, rows;

		for (int col = 0; col < SIZE; col++) {
			cols = true;
			rows = true;

			for (int row = 0; row < SIZE; row++) {
				cols &= (gameField[col][row] == symbol);
				rows &= (gameField[row][col] == symbol);
			}
			if (cols || rows) {
				return true;
			}
		}
		return false;
	}
}