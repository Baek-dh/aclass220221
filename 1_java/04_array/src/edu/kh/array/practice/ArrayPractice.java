package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

//	���̰� 9�� �迭�� ���� �� �Ҵ��ϰ�, 9���� 1������ ���� �ݺ����� �̿��Ͽ�
//	������� �迭�� �� �ε��� ��ҿ� �����ϰ� ����� ��
//	Ȧ�� ��° �ε��� ���� ���� ����ϼ���. (0 ��° �ε����� ¦���� ���
	public void practice2() {

		int[] arr = new int[9];

		// int num = 9;

		int sum = 0; // �հ�� ����

		for (int i = 0; i < arr.length; i++) {

			arr[i] = 9 - i;
			// arr[i] = num;
			// num--;

			if (i % 2 == 1) { // i �� Ȧ���� ���
				sum += arr[i];
			}

			System.out.print(arr[i] + " "); // ���
		}

		System.out.println("\nȦ�� ��° �ε��� �� : " + sum);

	}

//	���ڿ��� �Է� �޾� ���� �ϳ��ϳ��� �迭�� �ְ� 
//	�˻��� ���ڰ� ���ڿ��� �� �� �� �ִ���
//	������ �� ��° �ε����� ��ġ�ϴ��� �ε����� ����ϼ���

	public void practice5() {

		Scanner sc = new Scanner(System.in);

		System.out.print("���ڿ� : ");
		String input = sc.nextLine();

		System.out.print("���� : ");
		char ch = sc.next().charAt(0); // �Է� ���� ���ڿ����� 0�� �ε��� ���ڸ� ��ȯ
		// String -> char

		char[] arr = new char[input.length()]; // �Է� ���� ���ڿ� ���� ��ŭ�� �迭 ����

		int count = 0; // input�� ��ġ�ϴ� ch�� � �ִ��� ī��Ʈ�ϴ� ����

		System.out.print(input + "�� " + ch + "�� �����ϴ� ��ġ(�ε���) : ");

		for (int i = 0; i < arr.length; i++) {

			// �迭 ����
			arr[i] = input.charAt(i); // �Է� ���� ���ڿ����� i��° �ε��� ���ڸ� arr[i]�� ����

			// �˻� + ī��Ʈ
			if (arr[i] == ch) { // �˻� ����
				count++;
				System.out.print(i + " ");
			}
		}

		System.out.println("\n" + ch + "���� : " + count);

	}

//	�ֹε�Ϲ�ȣ ��ȣ�� �Է� �޾� char �迭�� ������ �� ����ϼ���.
//	��, char �迭 ���� �� ������ ��Ÿ���� ���� ���ĺ��� *�� �����ϼ���.

	public void practice7() {

		Scanner sc = new Scanner(System.in);

		System.out.print("�ֹε�Ϲ�ȣ(-����) : ");
		String input = sc.nextLine();

		char[] arr = new char[input.length()];

		for (int i = 0; i < arr.length; i++) {

			if (i <= 7) { // 7�� �ε��� ����(�������, - , ����)
				arr[i] = input.charAt(i);
			} else { // 8�� �ε��� �̻���ʹ� *
				arr[i] = '*';
			}

			System.out.print(arr[i]);
		}

	}

//	3�̻��� Ȧ���� �Է� �޾� �迭�� �߰������� 1���� 1�� �����Ͽ� ������������ ���� �ְ�,
//	�߰� ���ĺ��� �������� 1�� �����Ͽ� ������������ ���� �־� ����ϼ���.
//	��, �Է��� ������ Ȧ���� �ƴϰų� 3 �̸��� ��� ���ٽ� �Է��ϼ��䡱�� ����ϰ�
//	�ٽ� ������ �޵��� �ϼ���.

	public void practice8() {

		Scanner sc = new Scanner(System.in);

		while (true) { // 3 �̻��� ���� �Է� �� �� ���� ���� �ݺ�
						// -> 3 �̻��� �ԷµǸ� break������ ����

			System.out.print("���� : ");
			int input = sc.nextInt();

			if (input < 3 || input % 2 == 0) { // 3 �̸� �Ǵ� ¦���� ��� -> �ݺ�
				System.out.println("�ٽ� �Է��ϼ���.");
				// continue;
			} else {

				// �Է� ���� ���� ��ŭ�� ũ�⸦ ������ �迭 ����
				int[] arr = new int[input];

				int num = 0; // arr �迭�� ���Ե� ��

				for (int i = 0; i < arr.length; i++) {

					if (i <= arr.length / 2) { // �߰� ���� ���� -> ����
						arr[i] = ++num;

					} else { // �߰� ���� -> ����

						arr[i] = --num;
					}

					// ��� �� , �߰� (��, ������ ����)
					if (i == arr.length - 1) { // ������ ����
						System.out.print(arr[i]);

					} else {
						System.out.print(arr[i] + ", ");

					}

				}

				break; // while �ݺ� ����
			}
		}

	}

//	10���� ���� ������ �� �ִ� ������ �迭�� ���� �� �Ҵ��ϰ�
//	1~10 ������ ������ �߻����� �ߺ��� ���� ���� �迭�� �ʱ�ȭ�� �� ����ϼ���
	public void practice11() {

		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {

			// ���� ���� -> ���� (��, �ߺ� ����)
			arr[i] = (int) (Math.random() * 10 + 1); // 1~10 ���� ����

			// �ߺ� Ȯ�� �� i���� ���� ����
			// ���� �ݺ����� ���� �ε����� ���� �����

			for (int x = 0; x < i; x++) {

				if (arr[i] == arr[x]) {
					// ���� ������ ������ �ռ� ���Ե� ������ ���� ��� == �ߺ�

					i--; // i�� 1 ���� ��Ŵ
							// �ٱ��� for�� �ݺ� �� �ٽ� i�� 1 ����
							// -> -1 + 1 == 0 (���ڸ�)

					break; // �ߺ��� ã�ԵǸ� �� �̻� �˻��� �ʿ䰡 ����
				}
			}
		}

		// ���
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public void practice12() {
		// �ζ� ��ȣ ������

		// 1. 1 ~ 45 ���� �ߺ����� ���� ���� 6�� ����
		// 2. ������ ������ ������������ ����

		// 1) ���� 6���� ������ �迭 ���� �� �Ҵ�
		int[] lotto = new int[6];

		// 2) ������ �迭�� ó������ ������ ���� �����ϴ� for�� �ۼ�
		for (int i = 0; i < lotto.length; i++) {

			// 3) 1 ~ 45 ������ ���� ����
			int random = (int) (Math.random() * 45 + 1);
			// 0.0 <= x < 1.0
			// 0.0 <= x * 45 < 45.0
			// 1.0 <= x * 45 + 1 < 46.0
			// 1 <= (int)(x * 45 + 1) < 46

			// 4) ������ ������ ������� �迭 ��ҿ� ����
			lotto[i] = random;

			// 5) �ߺ� �˻縦 ���� for�� �ۼ�
			for (int x = 0; x < i; x++) {

				// 6) ���� ������ ������ ���� ����
				// �� �� ��ҿ� �ִ��� �˻�
				if (random == lotto[x]) {

					i--;
					// i�� 1�� ������ �� ���� ������ �ϳ� �����ȴ�
					// -> �ߺ� ���� �����Ƿ� ������ ���� �ϳ� �� �����ؾߵȴ�.
					// --> i�� �⺻������ 0~5���� 6ȸ �ݺ� ������
					// i���� ���������� 1 ���ҽ��� 7ȸ �ݺ� �Ǵ� ����� ����.

					break;
					// ���ʿ��� �ߺ� �����͸� �߰��ϸ�
					// ���� ���� ���� �ʿ䰡 ����
					// -> ȿ�� ����� ���ؼ� �˻��ϴ� for���� ����
				}

			}

		} // for�� ��

		// 7) �������� ����
		// -> ����, ����, ����, �� ���
		// --> �ڹٰ� ���� ����� �̸� ���� �����ϰ� ����
		// Arrays.sort(�迭��) : �迭 �� ������ ������������ ���ĵ�

		Arrays.sort(lotto);

		// ��� ���
		System.out.println(Arrays.toString(lotto));

	}
	
	
//	���ڿ��� �Է� �޾� ���ڿ��� � ���ڰ� ������ �迭�� �����ϰ�
//	������ ������ �Բ� ����ϼ���
	public void practice13() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ� : ");
		String input = sc.nextLine();
		
		char[] arr = new char[input.length()];
		
		int count = 0; // ī��Ʈ�� ����
		
		System.out.print("���ڿ��� �ִ� ���� : ");
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = input.charAt(i); // ���ڿ� -> char�迭�� �Ű� ���
			
			// �ߺ� �˻� + flag
			// application
			//�迭 : [a, p, p, l, i, c, a, t, i, o, n]
			//ȭ�� :  a, p, l, i, c, t, o, n
			//���� :  1  2  3  4  5  6  7  8
			
			boolean flag = true; // ��ȣ�� ����
			
			for(int x=0 ; x<i ; x++) { // �ߺ� �˻�� for��
				if( arr[i] == arr[x] ) {
					// ���� ���Ե� ���ڰ� �ռ� ���Ե� ���ڿ� ���ٸ� == �ߺ�
					flag = false; // ��ȣ�� ������ ���� false�� ����
					break; 
				}
			}
			
			if(flag) { // flag�� true�� ��� == �ߺ��� �����ٶ�� �ǹ�
				
				count++; // ī��Ʈ 1 ����
				
				if(i == 0) { // ù ������ ���
					System.out.print(arr[i]);
					
				}else { // ù ������ �ƴ� ���
					System.out.print(", " + arr[i]);
				}
				
			}
			
		} // �ٱ��� for�� ��
		
		System.out.println("\n���� ���� : " + count);
		
	}
	
	
	
	public void practice14() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�迭�� ũ�⸦ �Է��ϼ��� : ");
		int size = sc.nextInt();
		sc.nextLine();  // �Է� ���� ���� ���� ����
		
		
		String[] arr = new String[size]; // �迭 ���� �� �Ҵ�
		
		int start = 0; // while �� for���� �ʱ�Ŀ� ���� ����
		
		while(true) {
			
			for(int i=start ; i<arr.length ; i++) {
				
				System.out.print( (i+1) + "��° ���ڿ� : ");
				arr[i] = sc.nextLine();
			}
			
			
			System.out.print("�� ���� �Է��Ͻðڽ��ϱ�?(Y/N) : ");
			char input = sc.nextLine().charAt(0);
						// �Է� ���� ���ڿ� �� ���� �� ���� �ϳ��� ����
			
			if(input == 'Y' || input == 'y') { 
				
				start = arr.length;
				// �߰� �Է� �ޱ� ���� �߰� �迭 �κ��� ���� ��ġ
				
				System.out.print("�� �Է��ϰ� ���� ���� : ");
				int addSize = sc.nextInt();
				sc.nextLine(); // �Է� ���� ���� ���� ����
				
				// ������ ũ���� �迭�� �����Ͽ� arr �迭 ���� ����
				String[] copyArr = new String[ arr.length + addSize ];	
				
				for(int i=0 ; i<arr.length ; i++) { // ���� �迭 ũ�� ��ŭ�� �ݺ�
					
					copyArr[i] = arr[i]; // ���� �迭�� ���� �迭 ���� ���� �ε����� ����
				}
				
				// �迭 ���� ����
				arr = copyArr; // arr�� �����ϴ� �ּ� ����
							   // copyArr�� �ּ� ������ �ٲ㼭
							   // arr�� �����ϴ� �迭�� ũ�Ⱑ ������ �� ó�� ���̤���.
				
			} else { // y/n�� �Է� �ߴٴ� ��Ȳ�� ����
				
				break; // while �ݺ� ����
			}
			
		} // while ��
		
		System.out.println(Arrays.toString(arr));
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
