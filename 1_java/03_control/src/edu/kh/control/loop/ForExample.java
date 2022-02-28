package edu.kh.control.loop;

import java.util.Scanner;

public class ForExample {

	/* for ��
	 * - ���� ������ �ִ�(Ƚ���� �����Ǿ� �ִ�) �ݺ���
	 * 
	 * [�ۼ���]
	 * 
	 * for(�ʱ�� ; ���ǽ� ; ������) {
	 * 
	 * 		�ݺ� ������ �ڵ�
	 * }
	 * 
	 * - �ʱ�� : for���� �����ϴ� �뵵�� ���� ����
	 * 
	 * - ���ǽ� : for���� �ݺ� ���θ� �����ϴ� ��. (���� �ݺ� ������?)
	 * 			  ���� �ʱ�Ŀ� ���� ������ �̿��Ͽ� ���ǽ��� �ۼ���.
	 * 
	 * - ������ : �ʱ�Ŀ� ���� ������
	 * 			  for���� ���� �� ���� ���� �Ǵ� ���� ����
	 * 			  ���ǽ��� ����� ���ϰ� �ϴ� ��.
	 * */
	
	public void ex1() {
		// for�� ���� ����1
		// - 1~10 ����ϱ�
		// --> 1���� 10���� 1�� �����ϸ� ���
		
		// * �ݺ����� ���ǽ��� true�� ���� �ݺ�
		
		// �ؼ� ����
		// 1, 2, 3, 4, 5 ���� ��-> 5~7 �ݺ�
		
		for(int i = 1 ; i <= 10  ; i++ ) {
		// 1)�ʱ�� ;  2),5)���ǽ� ; 4),7)������
			
			// 3),6) �ݺ� ������ �ڵ�
			System.out.println(i);
		}
		
	}
	
	
	public void ex2() {
		// for ���� ����2
		
		// - 3���� 7���� 1�� �����ϸ� ���
		//			-> i�� ���� 7 �����϶� true�� �Ǵ� ���ǽ�
		
		// 3 4 5 6 7
		
		for( int i = 3 ; i <= 7 ; i++ ) {
			System.out.println(i + "���");
		}
		
	}
	
	
	public void ex3() {
		
		// 2 ���� 15 ���� 1�� �����ϸ� ���
		for(int i = 2 ; i <= 15 ; i++) {
			System.out.println( i + "���");
		}
		
	}
			
	
	public void ex4() {
		// 1 ���� �Է� ���� �� ���� 1�� �����ϸ� ���
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�� ��ȣ : " );
		int input = sc.nextInt();
		
		for(int i = 1 ; i <= input ; i++) {
			System.out.println(i + "���");
		}
		
	}
	
	
	public void ex5() {
		// 						    v
		// 1 ���� �Է� ���� �� ���� 2�� �����ϸ� ���
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�� ��ȣ : ");
		int input = sc.nextInt();
		
		for(int i = 1 ; i <= input ;  i += 2  ) {
										// i�� ���� i�� + 2�� ����
			System.out.println(i + "���");
			
		}
	}
	
	
	public void ex6() {
		
		// 1.0���� �Է� ���� �Ǽ� ���� 0.5�� �����ϸ� ���
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Ǽ� : ");
		double input = sc.nextDouble();
		
		for(double i = 1.0 ; i <= input ; i += 0.5) {
			System.out.println(i + "���");
		}
		
	}
	
	public void ex7() {
		
		// ���� ���ĺ� A ���� Z ���� �� �ٷ� ���
		
		// * char �ڷ����� ������ ������ �����δ� ����(����ǥ ��ȣ)�� �����Ѵ�
		
		
		for(int i = 'A' ; i <= 'Z' ; i++) {
			System.out.print( (char)i ); // ���� ����ȯ
		}
		
		System.out.println("\n-------------------------");
		
		
		for(char i = 'A' ; i <= 'Z' ; i++) {
			System.out.print(i);
		}
	}
	
	
	public void ex8() {
		
		// 10���� 1���� 1�� �����ϸ� ���
		
		for(int i = 10 ; i >= 1 ; i--) {
			System.out.println(i);
		}
		
	}
	
	
	public void ex9() {
		
		// for�� ���� 1 : �ݺ����� �̿��� ���� ����
		
		// 1���� 10���� ��� ������ �� ���ϱ�
		// for + ���� + ������
		
		int sum = 0; // �ݺ��Ǿ� �����Ǵ� i���� �հ踦 ������ ����
					 // 0���� �����ϴ� ���� : �ƹ��͵� ������ ��������
					 //  					  ��Ȯ�� ����� ������ �� �ֱ� ������
		for(int i = 1 ; i <= 10 ; i++) {

			//sum = sum + i;
			sum += i;
		}

		System.out.println("�հ� : " + sum);
		
	}
	
	
	public void ex10() {
		
		// for�� ���� 2 : ���� 5���� �Է� �޾Ƽ� �հ� ���ϱ�
		
		// ex)
		// �Է� 1 : 10
		// �Է� 2 : 20
		// �Է� 3 : 30
		// �Է� 4 : 40
		// �Է� 5 : 50
		// �հ� : 150
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0; // for�� �ۿ� �����ϴ� ������
					 // �Ʒ� for���� ������ ��� ����
		
		for(int i = 1 ; i <= 5 ; i++) {
			System.out.print("�Է� " + i + "  : ");
			int input = sc.nextInt();
			
			sum += input; // sum�� �Է� ���� input ���� ����
			
			//System.out.println(input); 
			// {} �ȿ��� ������ ������ {} �ۿ����� ����� �� ����
			// -> {} ������ ������ ������� ������
		}
		
		System.out.println("�հ� : " + sum);
		
		// System.out.println(input); ����
		
	}
	
	
	
	public void ex11() {
		
		// ������ �� �� �Է� ������ ���� �Է� �ް�
		// �Էµ� ������ �հ踦 ���
		
		// ex)
		// �Է� ���� ������ ���� : 3
		// �Է� 1 : 10
		// �Է� 2 : 20
		// �Է� 3 : 30
		// �հ� : 60
		
		// ex)
		// �Է� ���� ������ ���� : 2
		// �Է� 1 : 10
		// �Է� 2 : 20
		// �հ� : 30
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�Է� ���� ������ ���� : ");
		int num = sc.nextInt();
		
		int sum = 0;

		for(int i = 1 ; i <= num ; i++) {
			
			System.out.print("�Է�" + i + " : ");
			int input = sc.nextInt();
			
			sum += input;
		}
		
		System.out.println("�հ� : " + sum);
		
	}
	
	
	public void ex12() {
		
		// 1 ���� 20 ���� 1�� �����ϸ鼭 ���
		// ��, 5�� ����� () �� �ٿ��� ���
		// ex) 1 2 3 4 (5) 6 7 8 9 (10) 11 ...
		
		for(int i = 1 ; i <= 20 ; i++) {
			
			if(i % 5 == 0) { // i�� 5�� ����� ���
				
				System.out.print( "("+i+") " );
				
			} else { // i�� 5�� ����� �ƴ� ���
				
				System.out.print(i + " ");
			}
			
		}
		
	}
	
	
	public void ex13() {
		
		// 1 ���� 20���� 1�� �����ϸ鼭 ���
		// ��, �Է� ���� ���� ����� () ǥ��
		
		// ex)
		// ��ȣ�� ǥ���� ��� : 3
		// 1 2 (3) 4 5 (6) ...
		
		// ��ȣ�� ǥ���� ��� : 4
		// 1 2 3 (4) 5 6 7 (8) 9 ...
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��ȣ�� ǥ���� ��� : ");
		int num = sc.nextInt();
		
		for(int i = 1 ; i <= 20 ; i++) {
			
			if( i % num == 0) { // i �� num�� ����� ���� ����� ���
				
				System.out.print("("+i+") ");
				
			}else { // i �� num�� ����� ���� ����� �ƴ� ���
				
				System.out.print(i + " ");
			}
		}
	}
	
	
	public void ex14() {
		
		// [������ ���]
		// 2 ~ 9 ���� ���� �ϳ� �Է� �޾�
		// �ش� ���� ���
		// ��, �Է� ���� ���� 2 ~ 9 ���� ���ڰ� �ƴϸ� "�߸� �Է� �ϼ̽��ϴ�" ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�� �Է� : ");
		int dan = sc.nextInt();
		
		if( dan >= 2 && dan <= 9 ) { // dan�� 2 ~ 9 ������ ���
			 
			for(int i = 1 ; i <= 9 ; i++) {
				System.out.printf("%d X %d = %d\n", dan, i, dan * i );
			}
			
		} else { // dan�� 2 ~ 9 ���̰� �ƴ� ���
			System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
		}
	}
	
	
	public void ex15() {
		
		// [19�� ��±�]
		// 2 ~ 19�� ���� ���� �Է� �޾Ƽ� x 1 ~ x 19���� ���
		// ��, 2 ~ 19 ���� ���� �Էµ��� ������ "�߸� �Է� �ϼ̽��ϴ�." ���
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�� �Է� : ");
		int dan = sc.nextInt();
		
		if(dan >= 2 && dan <= 19) {

			for(int i = 1 ; i <= 19 ; i++) {
				
				System.out.printf("%2d X %2d = %3d\n", dan, i, dan*i);
			}
			
		} else {
			System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
		}
		
	}
	
	
	
	// *** ��ø �ݺ���
	public void ex16() {
		// ������ ��� ����ϱ�
		
		for(int dan = 2 ; dan <= 9 ; dan++) { // 2 ~ 9 �� ���� ���ʴ�� ����
			
			// ���� for���� �ݺ��ϸ鼭 �ϳ��� ���� �� �ٷ� ���
			for(int num = 1 ; num <= 9 ; num++) { // �� �ܿ� ������ �� 1~9 ���� ���ʴ�� ����
				
				System.out.printf("%2d X %2d = %2d  ", dan, num, dan * num);
			}
			
			// �ϳ��� �� ����� ������ �� �ٹٲ�
			
			System.out.println(); // �ƹ� ���� ���� println() == �ٹٲ�
		}
		
	}
	
	
	public void ex17() {
		
		// ������ ���� ���
		
		// 9�� -> 2�� ���� ������
		// �������� ���� 1 -> 9���� ������  
		 
		for(int dan = 9 ; dan >= 2 ; dan--) { // ��  9 -> 2 ��
			
			for(int num = 1 ; num <= 9 ; num++) { // �� 1 -> 9 ��
				System.out.printf("%d X %d = %2d  ", dan, num, dan * num);
			} // �� ���� ��� ����
			
			System.out.println(); // �ٹٲ�
			
		}
		
	}
	
	
	public void ex18() {
		
		// 2�� for���� �̿��ؼ� ���� ����� ����Ͻÿ�

		// 12345
		// 12345
		// 12345
		// 12345
		// 12345
		
		for(int x = 1 ; x <= 5 ; x++) { // 5���� �ݺ��ϴ� for�� 
			for(int i = 1 ; i <= 5 ; i++) { // 12345 �� �� ����ϴ� for��
				System.out.print(i);
			}
			
			System.out.println(); // �ٹٲ�
		}
		
		
		System.out.println("-----------------------------");
		
		// 54321
		// 54321
		// 54321
		
		for(int x = 1 ; x <= 3 ; x++) {
			
			for(int i = 5 ; i >= 1 ; i--) {
				System.out.print(i);
			}
			System.out.println(); // �ٹٲ�
		}
	}
	
	
	public void ex19() {
		
		// 2�� for���� �̿��Ͽ� ���� ����� ����Ͻÿ�.
		
		// 1
		// 12
		// 123
		// 1234
		
		for(int x = 1 ; x <= 4 ; x++) { // �� �ݺ�
			
			for(int i = 1 ; i <= x ; i++) { // ��� �ݺ�
				System.out.print(i);
			}
			System.out.println();
			
		}
		
		// x�� 1�� �� i == 1
		// x�� 2�� �� i == 1, 2
		// x�� 3�� �� i == 1, 2, 3
		// x�� 4�� �� i == 1, 2, 3, 4
		
		System.out.println("------------------------");
		
		// 4321
		// 321
		// 21
		// 1
		
		for(int x = 4 ; x >= 1 ; x--) { // �� �ݺ�
			
			for(int i = x ; i >= 1 ; i--) { // ���� ���
				System.out.print(i);
			}
			
			System.out.println();
		}
		
		// x�� 4�϶� 4 3 2 1 
		// x�� 3�϶� 3 2 1 
		// x�� 2�϶� 2 1 
		// x�� 1�϶� 1 

	}
	
	public void ex20() {
		
		// count (���� ����)
		
		// 1���� 20���� 1�� �����ϸ鼭 
		// 3�� ����� �� ���� ���
		
		// 3 6 9 12 15 18 : 6��
		
		int count = 0; // 3�� ����� ������ ���� ���� ����
		int sum = 0; // 3�� ����� �հ踦 ���ϱ� ���� ����
		
		for(int i = 1 ; i <= 20 ; i++) {
			
			if(i % 3 == 0) { // 3�� ���
				System.out.print(i + " ");
				count++; // if���� ������ �� ���� 1�� ����
				sum += i; // 3�� ��� ����
			}
		}
		
		System.out.println(": "+count+"��");
		System.out.println("3�� ��� �հ� : " + sum);
		
	}
	
	
	public void ex21() {
		
		// 2�� for���� count�� �̿��ؼ� �Ʒ� ��� ����ϱ�
		
		//  1  2  3  4
		//  5  6  7  8
		//  9 10 11 12
		
		int count = 1;
		
		for(int x = 1 ; x <= 3 ; x++) { // 3��
			
			for(int i = 1 ; i <= 4 ; i++) { // 4ĭ
				System.out.printf("%3d", count);
				count++;
			}
			
			System.out.println(); // �ٹٲ�
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
