package edu.kh.test;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("���� ���� �� �� �Ѱ��� �Է��ϼ���: ");

			String input = sc.nextLine();
			System.out.printf("����� %s �� �½��ϴ�\n", input);

			String result = "";

			int random = (int) (Math.random() * 3 + 1);

			switch (random) {
			case 1:
				result = "����";
				break;
			case 2:
				result = "����";
				break;
			case 3:
				result = "��";
				break;

			}
			System.out.printf("��ǻ�ʹ� %s �� �½��ϴ�\n", result);

			boolean b1 = input.equals("����") && result.equals("��");
			boolean b2 = input.equals("��") && result.equals("����");
			boolean b3 = input.equals("����") && result.equals("����");

			System.out.println(input + " / " + result);
			System.out.println(b1);
			System.out.println(b2);
			System.out.println(b3);
			
			if (input.equals(result)) {
				System.out.println("�����ϴ�");
				System.out.println(1);
			}

			else if (b1 = true) {
				System.out.println("�̰���ϴ�");
				System.out.println(2);
				break;
			} else if (b2 = true) {
				System.out.println("�̰���ϴ�");
				System.out.println(3);
				break;
			} else if (b3 = true) {
				System.out.println("�̰���ϴ�");
				System.out.println(4);
				break;

			} else {
				System.out.println("�����ϴ�");
				System.out.println(5);
				break;
			}

		}

	}

}
