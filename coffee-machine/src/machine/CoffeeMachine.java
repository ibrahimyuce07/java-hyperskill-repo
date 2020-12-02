package machine;

import java.util.Scanner;

public class CoffeeMachine {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int water = 400;
		int milk = 540;
		int cbean = 120;
		int cups = 9;
		int money = 550;
		boolean status = true;

		while (status) {
			System.out.println("Write action (buy, fill, take, remaining, exit):");
			String resp = sc.nextLine();

			switch (resp) {
			case "buy":
				System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
				String resp1 = sc.nextLine();
				if (resp1.equals("1")) {

					if (water < 250) {
						System.out.println("Sorry, not enough water!");
					} else if (cbean < 16) {
						System.out.println("Sorry, not enough beans!");
					} else if (cups < 1) {
						System.out.println("Sorry, not enough cups!");
					}

					else {
						System.out.println("I have enough resources, making you a coffee!");
						water -= 250;
						cbean -= 16;
						cups -= 1;
						money += 4;
					}

				} else if (resp1.equals("2")) {

					if (water < 350) {
						System.out.println("Sorry, not enough water!");
					} else if (milk < 75) {
						System.out.println("Sorry, not enough milk!");
					} else if (cbean < 20) {
						System.out.println("Sorry, not enough beans!");
					} else if (cups < 1) {
						System.out.println("Sorry, not enough cups!");
					}

					else {
						System.out.println("I have enough resources, making you a coffee!");
						water -= 350;
						milk -= 75;
						cbean -= 20;
						cups -= 1;
						money += 7;
					}

				}

				else if (resp1.equals("3")) {

					if (water < 200) {
						System.out.println("Sorry, not enough water!");
					} else if (milk < 100) {
						System.out.println("Sorry, not enough milk!");
					} else if (cbean < 12) {
						System.out.println("Sorry, not enough beans!");
					} else if (cups < 1) {
						System.out.println("Sorry, not enough cups!");
					}

					else {
						System.out.println("I have enough resources, making you a coffee!");
						water -= 200;
						milk -= 100;
						cbean -= 12;
						cups -= 1;
						money += 6;
					}

				}
				continue;
			case "fill":
				System.out.println("Write how many ml of water do you want to add:");
				int addwater = sc.nextInt();
				System.out.println("Write how many ml of milk do you want to add:");
				int addmilk = sc.nextInt();
				System.out.println("Write how many grams of coffee beans do you want to add:");
				int addbean = sc.nextInt();
				System.out.println("Write how many disposable cups of coffee do you want to add:");
				int addcups = sc.nextInt();
				water += addwater;
				milk += addmilk;
				cbean += addbean;
				cups += addcups;

				continue;
			case "take":
				System.out.println("I gave you $" + money);
				money = 0;

				continue;
			case "remaining":
				System.out.printf("The coffee machine has:\r\n" + "%d of water\r\n" + "%d of milk\r\n"
						+ "%d of coffee beans\r\n" + "%d of disposable cups\r\n" + "%d of money\n", water, milk, cbean,
						cups, money);
				continue;
			case "exit":
				status = false;
				return;

			default:
				break;
			}
			
		}
		sc.close();
	}

}