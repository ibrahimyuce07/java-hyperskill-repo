package cinema;

import java.util.Scanner;

public class Cinema {
	static String[][] salon;
	static int rows = 0;
	static int seats = 0;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String input;
		System.out.println("Enter the number of rows:");
		input = sc.nextLine();
		rows = Integer.parseInt(input);
		System.out.println("Enter the number of seats in each row:");
		input = sc.nextLine();
		seats = Integer.parseInt(input);
		salonSize();
		salonPattern();
		ticketPrice();
	}

	public static void salonSize() {
		salon = new String[rows][seats];
		for (int y = 0; y < salon.length; y++) {
			for (int x = 0; x < salon[y].length; x++) {
				salon[y][x] = "S";
			}
		}
	}

	public static void salonPattern() {
		System.out.println();
		System.out.println("Cinema:");
		System.out.print(" ");
		for (int i = 1; i <= seats; i++) {
			System.out.print(" " + i);
		}
		System.out.println();
		for (int y = 0; y < salon.length; y++) {
			System.out.print(y + 1);
			for (int x = 0; x < salon[y].length; x++) {
				System.out.print(" " + salon[y][x]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void ticketPrice() {
		String input = "";
		System.out.println("Enter a row number:");
		input = sc.nextLine();
		int rowsBuy = Integer.parseInt(input);
		System.out.println("Enter a seat number in that row:");
		input = sc.nextLine();
		int seatsBuy = Integer.parseInt(input);
		if (seats * rows <= 60) {
			System.out.println("Ticket price: $10");
		} else {
			System.out.println("Ticket price: $" + (rowsBuy <= rows / 2 ? "10" : "8"));
		}
		salon[rowsBuy - 1][seatsBuy - 1] = "B";
		salonPattern();
	}

	public static void totalIncome() {
		if (seats * rows <= 60) {
			System.out.println("Total income:\n" + "$" + seats * rows * 10);
		} else {
			System.out.println("Total income:\n" + "$"
					+ (rows % 2 == 0 ? seats * rows * 9 : seats * (rows / 2) * 10 + seats * (1 + rows / 2) * 8));
		}
	}
}