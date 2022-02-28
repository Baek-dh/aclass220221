package edu.kh.control.practice;

import java.util.Scanner;

public class LoopPractice {
	/*
	������ ���� ���� ������ �����ϼ���.
	ex.
	���� �Է� : 4
	   *
	  **
	 ***
	****
	*/
	
	public void practice9() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		for(int x = 1 ; x <= input ; x++) {
			
			// 1) for�� �ϳ� �� �ۼ�
			// * 1�� ��� ���� ���� 3�� 
			// * 2�� ��� ���� ���� 2�� 
			// * 3�� ��� ���� ���� 1�� 
			// * 4�� ��� ���� ���� 0�� 
			
			// y == 4 3 2 1
			/*
			for(int y = input - x ; y >= 1 ; y--) {
				System.out.print(" ");
			}
			
			for(int i = 1 ; i <= x ; i++) {
				System.out.print("*");
			}
			*/
			
			// 2) for + if else
			for(int i = 1 ; i <= input ; i++) {
				
				if(i <= input - x) {
					System.out.print(" ");
					
				}else {
					System.out.print("*");
					
				}
			}
			System.out.println(); // �� �ٲ�
		}
	}
	
	
	/*
	������ ���� ���� ������ �����ϼ���.
	ex.
	���� �Է� : 3
	*
	**
	***
	**
	*
	*/
	
	public void practice10() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		// ���� �ﰢ��
		for(int x = 1 ; x <= input ; x++) {
			
			for(int i = 1 ; i <= x ; i++) {
				System.out.print("*");
			}
			System.out.println(); // �ٹٲ�
		}
		
		// �Ʒ��� �ﰢ��
		for(int y = input - 1 ; y >= 1 ; y--) {
			
			for(int i = 1 ; i <= y ; i++) {
				System.out.print("*");
			}
			System.out.println(); // �ٹٲ�
			
		}
		
	}
	
	
	/*
	������ ���� ���� ������ �����ϼ���.
	ex.
	���� �Է� : 4
	   *
	  ***
	 *****
	*******
	*/
	
	public void practice11() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		
		for(int x = 1 ; x <= input ; x++) { // �Է� ���� input ��ŭ �� ���
			
			// ���� ��� for��
			for(int i = input - x ; i >= 1 ; i--) {
				System.out.print(" ");
			}
			
			
			// * ��� for��
			// -> 1,3,5,7,9
			for(int i = 1 ; i <= x * 2 - 1 ; i++) {
				System.out.print("*");
			}
			
			System.out.println(); // �� �ٲ�
			
		}
		
	}
	
	
	/* 
	������ ���� ���� ������ �����ϼ���.
	ex.
	���� �Է� : 5
	*****
	*   *
	*   *
	*   *
	*****
	
	*/
	
	public void practice12() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();	
		
		// row : �� (��)
		// col(column) : �� (ĭ)
		
		for(int row = 1 ; row <= input ; row++) {
			
			for(int col = 1 ; col <= input ; col++) {
				// row �Ǵ� col�� 1 �Ǵ� input�� ��� * ���
				// == �׵θ�
				if(row == 1 || row == input || col == 1 || col == input) {
					System.out.print("*");
				
				} else { // ����
					System.out.print(" ");
				}
			}
			
			System.out.println();
		}
	}
	
	
	
	public void practice13() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ڿ����� �ϳ� �Է��ϼ��� : ");
		int input = sc.nextInt();	
		
		int count = 0; // 2�� 3�� ������� ������ ���� ���� ����
		
		for(int i = 1 ; i <= input ; i++) {
			
			// i�� 2�� ��� �Ǵ� 3�� ���
			if( i % 2 == 0  ||  i % 3 == 0) {
				System.out.print(i + " ");
				
				
				// 2�� 3�� ������� ���
				if( i % 2 == 0 && i % 3 == 0) {
					count++; // count 1 ����
				}
			}
		}
		
		System.out.println("\ncount : " + count);
		
		
	}
	
	
	
	
	
	
}
