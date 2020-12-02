package bot;

import java.util.Scanner;

public class SimpleBot {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String botName = "V";
		String birthYear = "1.11.2020";

		System.out.printf("Hello! My name is %s.\n", botName);
		System.out.printf("I was created in %s.\n", birthYear);
		System.out.println("Please, remind me your name.");
		String name = scanner.nextLine();
		System.out.printf("What a great name you have, %s! \n", name);
		System.out.println("Let me guess your age.");
		System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
		int div3 = scanner.nextInt();
		int div5 = scanner.nextInt();
		int div7 = scanner.nextInt();
		int age = (div3 * 70 + div5 * 21 + div7 * 15) % 105;
		System.out.printf("Your age is %d; that's a good time to start programming!\n", age);
		System.out.println("Now I will prove to you that I can count to any number you want.");
		int counter = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i <= counter; i++) {
			System.out.println(i + "!");
		}
		test();

		scanner.close();
	}

	static void test() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Let's test your programming knowledge.");
		String question = "Why do we use methods?\r\n" + "1. To repeat a statement multiple times.\r\n"
				+ "2. To decompose a program into several small subroutines.\r\n"
				+ "3. To determine the execution time of a program.\r\n"
				+ "4. To interrupt the execution of a program.";
		System.out.println(question);
		String answer = scanner.nextLine();
		if (answer.equals("1")) {
			end();
		} else {
			System.out.println("Please, try again.");
		}
		scanner.close();
	}

	static void end() {
		System.out.println("Congratulations, have a nice day!");
	}
}
