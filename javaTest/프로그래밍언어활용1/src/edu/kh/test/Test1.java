package edu.kh.test;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("가위 바위 보 중 한개를 입력하세요: ");

			String input = sc.nextLine();
			System.out.printf("당신은 %s 를 냈습니다\n", input);

			String result = "";

			int random = (int) (Math.random() * 3 + 1);

			switch (random) {
			case 1:
				result = "가위";
				break;
			case 2:
				result = "바위";
				break;
			case 3:
				result = "보";
				break;

			}
			System.out.printf("컴퓨터는 %s 를 냈습니다\n", result);

			boolean b1 = input.equals("가위") && result.equals("보");
			boolean b2 = input.equals("보") && result.equals("바위");
			boolean b3 = input.equals("바위") && result.equals("가위");

			System.out.println(input + " / " + result);
			System.out.println(b1);
			System.out.println(b2);
			System.out.println(b3);
			
			if (input.equals(result)) {
				System.out.println("비겼습니다");
				System.out.println(1);
			}

			else if (b1 = true) {
				System.out.println("이겼습니다");
				System.out.println(2);
				break;
			} else if (b2 = true) {
				System.out.println("이겼습니다");
				System.out.println(3);
				break;
			} else if (b3 = true) {
				System.out.println("이겼습니다");
				System.out.println(4);
				break;

			} else {
				System.out.println("졌습니다");
				System.out.println(5);
				break;
			}

		}

	}

}
