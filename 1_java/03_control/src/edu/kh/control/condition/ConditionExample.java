package edu.kh.control.condition;

import java.util.Scanner;

public class ConditionExample {

	public void ex1() {
		
		// if��
		// - ���ǽ��� true �϶��� ���� �ڵ� ����
		/*
		 * [�ۼ���]
		 * if(���ǽ�){
		 * 		���ǽ��� true�� �� ������ �ڵ�
		 * }
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		// �Էµ� ������ ������� �˻�
		if(input > 0) {
			System.out.println("��� �Դϴ�.");
		}
		
		
		if( input <= 0 ) {
			System.out.println("����� �ƴϴ�.");
		}
	}
	
	
	public void ex2() {
		
		// if - else ��
		// - ���ǽ� ����� true�̸� if��, 
		//   false�̸� else ������ �����.
		
		/* if(���ǽ�){
		 * 		���ǽ��� true�� �� ������ �ڵ�
		 * } else {
		 * 		���ǽ��� false�� �� ������ �ڵ�
		 * }
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		// Ȧ¦ �˻�
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		if( input % 2 != 0 ) { 
			System.out.println("Ȧ�� �Դϴ�.");
			
		}else { // ¦�� �Ǵ� 0 �Է� �� ����
			
			// ** ��ø if�� **
			if(input == 0) {
				System.out.println("0 �Դϴ�.");
			}else {
				System.out.println("¦�� �Դϴ�.");
			}
			
		}
		
	}
	
	
	public void ex3() {
		
		// if - else if - else
		
		// ���, ����, 0 �Ǻ�
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		if(input > 0) { // input�� ����� ���
			System.out.println("��� �Դϴ�.");
		
		} else if(input < 0) { // input�� ������ ���
			// �ٷ� ���� �ִ� if���� �������� ���� ��� ����
			System.out.println("���� �Դϴ�.");
			
		} else {
			// ��� if, else if�� �������� ���� ��� ����
			System.out.println("0 �Դϴ�.");
			
		}
	}
	
	
	
	public void ex4() {
		
		// ��(month)�� �Է� �޾� �ش� �޿� �´� ���� ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�� �Է� : ");
		int month = sc.nextInt();
		
		String season; // �Ʒ� ���ǹ� ���� ����� ������ ���� ����
		
		// �� : 3,4,5
		if(month == 3 || month == 4 || month == 5) {
			season = "��";
			
		} else if( month >= 6 && month <= 8 ) {  // ���� : 6,7,8
			season = "����";
		
		} else if( month >= 9 && month <= 11 ) { // ���� // 9,10,11
			season = "����";
			
		} else if(month == 12 || month == 1 || month == 2) { // �ܿ� : 12, 1, 2
			season = "�ܿ�";
			
		} else { // if, else if�� ��� false�� ���
			season = "�ش��ϴ� ������ �����ϴ�.";
		}
		
		System.out.println(season);
	}
	
	
	
	public void ex5() {
		
		// ���̸� �Է� �޾�
		// 13�� ���ϸ� "��� �Դϴ�."
		// 13�� �ʰ� 19�� ���ϸ� : "û�ҳ� �Դϴ�."
		// 19�� �ʰ� �� : "���� �Դϴ�".  ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int age = sc.nextInt();
		
		if(age <= 13) {
			System.out.println("��� �Դϴ�.");
			
		}else if(age > 19) {
			System.out.println("���� �Դϴ�.");
			
		}else {
			System.out.println("û�ҳ� �Դϴ�");
			
		}
		
		
		
		/*if(age <= 13) {
			System.out.println("��� �Դϴ�.");
		
		}else if(age <= 19) {
			System.out.println("û�ҳ� �Դϴ�.");
			
		}else {
			System.out.println("���� �Դϴ�.");
		}*/
		
		
	}
	
	
	public void ex6() {
		
		// ����(100�� ����)�� �Է� �޾�
		// 90�� �̻� : A
		// 80�� �̻� 90�� �̸� : B
		// 70�� �̻� 80�� �̸� : C
		// 60�� �̻� 70�� �̸� : D
		// 60�� �̸� : F
		// 0�� �̸�, 100 �ʰ� : "�߸� �Է��ϼ̽��ϴ�"
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է�(0~100) : ");
		int score = sc.nextInt();
		
		String result;
		
		if(score < 0 || score > 100) {
			result = "�߸� �Է��ϼ̽��ϴ�.";
			
		} else if(score >= 90) {
			result = "A";
			
		} else if(score >= 80) {
			result = "B";
			
		} else if(score >= 70) {
			result = "C";
			
		} else if(score >= 60) {
			result = "D";
			
		} else {
			result = "F";
		}
		
		System.out.println(result);
	}
	
	
	public void ex7() {
		// ���̱ⱸ ž�� ���� �˻�
		
		// ���̰� 12�� �̻�, Ű 140.0cm �̻� �� ��쿡�� "ž�� ����"
		// ���̰� 12�̸��� ��� : "���� ������ �ƴմϴ�."
		// Ű�� 140.0cm �̸� : "���� Ű�� �ƴմϴ�."
		// ���̸� 0�� �̸�, 100�� �ʰ� �� : "�߸� �Է� �ϼ̽��ϴ�."
		
		Scanner sc  = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int age = sc.nextInt();
		
		//System.out.print("Ű �Է� : ");
		//double height = sc.nextDouble();
		
		String result;
		
		if(age < 0 || age > 100) {
			result = "�߸� �Է� �ϼ̽��ϴ�.";
			
		}else {
			System.out.print("Ű �Է� : ");
			double height = sc.nextDouble();
			
			if(age < 12) {
				result = "���� ������ �ƴմϴ�.";
				
			} else if(height < 140.0) {
				result = "���� Ű�� �ƴմϴ�.";
				
			} else {
				result = "ž�� ����";
			}
		}
		
		
		
		/*if(age < 0 || age > 100) {
			result = "�߸� �Է� �ϼ̽��ϴ�.";
			
		}else {
			
			if(age < 12) {
				result = "���� ������ �ƴմϴ�.";
			}else {
				
				if(height < 140.0) {
					result = "���� Ű�� �ƴմϴ�.";
				} else {
					result = "ž�� ����";
				}
			}
		}*/
		
		
		
		/*if(age < 0 || age > 100) {
			result = "�߸� �Է� �ϼ̽��ϴ�.";
			
		} else if(age < 12) {
			result = "���� ������ �ƴմϴ�.";
			
		} else if(height < 140.0) {
			result = "���� Ű�� �ƴմϴ�.";
			
		} else {
			result = "ž�� ����";
			
		}*/
		
		System.out.println(result);
	}
	
	
	public void ex8() {
		// ���̱ⱸ ž�� ���� �˻� ���α׷�
		// ���� - ���� : 12�� �̻�
		//     -  Ű : 140.0cm �̻�
		
		// ���̸� 0~100�� ���̷� �Է����� ���� ��� : "���̸� �߸� �Է� �ϼ̽��ϴ�."
		// Ű�� 0~250.0cm ���̷� �Է����� ���� ��� : "Ű�� �߸� �Է� �ϼ̽��ϴ�."
		// -> �Է��� ���� ���� �˻縦 �����Ͽ� �߸��� ��� ���α׷� ����
		
		// ���� O , Ű X : "���̴� �����ϳ�, Ű�� ����ġ ����";
		// ���� X , Ű O : "Ű�� �����ϳ�, ���̴� ����ġ ����";
		// ���� X , Ű X : "���̿� Ű ��� ����ġ ����";
		// ���� O , Ű O : "ž�� ����"
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int age = sc.nextInt();
		
		String result;
		
		if(age < 0 || age > 100) {
			result = "���̸� �߸� �Է� �ϼ̽��ϴ�.";
		
		} else {
			System.out.print("Ű �Է� : ");
			double height = sc.nextDouble();
			
			if(height < 0  || height > 250) {
				result = "Ű�� �߸� �Է� �ϼ̽��ϴ�.";
				
			} else {
				
				if(age < 12 && height >= 140.0) { // ���� X , Ű O
					result = "Ű�� �����ϳ�, ���̰� ����ġ ����";

				} else if(age >= 12 && height < 140.0) { // ���� O , Ű X
					result = "���̴� �����ϳ�, Ű�� ����ġ ����";
					
				} else if(age < 12 && height < 140.0) {
					result = "���̿� Ű ��� ����ġ ����";
				
				} else {
					result = "ž�� ����";
				}
			}
		}
		
		System.out.println(result);
		
	}
	
	
	
}
