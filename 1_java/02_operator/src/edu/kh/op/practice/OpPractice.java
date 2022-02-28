package edu.kh.op.practice;

import java.util.Scanner;

public class OpPractice {

	// �ǽ����� 1
	// ��� ����� ������ ���� ������������ �Ѵ�. 
	// �ο� ���� ���� ������ Ű����� �Է� �ް�
	// 1�δ� �����ϰ� �������� ���� ������ �����ְ� ���� ������ ������ ����ϼ���.
	/*
	[����ȭ��]
	�ο� �� : 29
	���� ���� : 100

	1�δ� ���� ���� : 3
	���� ���� ���� : 13
	 */
	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ο� �� : ");
		int input = sc.nextInt();
		
		System.out.print("���� ���� : ");
		int candy = sc.nextInt();
		
		System.out.println("1�δ� ���� ���� : "  +  candy / input  );
		System.out.println("���� ���� ���� : "   +  candy % input  );
		
	}
	
	// �ǽ����� 2
	// Ű����� �Է� ���� ������ ������ ����ϰ� ����� ���� ���� ȭ�鿡 ����Ͽ� Ȯ���ϼ���.
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸� : ");
		String name = sc.next();
		
		System.out.print("�г�(����) : ");
		int grade = sc.nextInt();
		
		System.out.print("��(����) : ");
		int classRoom = sc.nextInt();
		
		System.out.print("��ȣ(����) : ");
		int number = sc.nextInt();
		
		System.out.print("����(���л�/���л�) : ");
		String gender = sc.next();
		
		System.out.print("����(�Ҽ��� �Ʒ� ��° �ڸ�����) : ");
		double score = sc.nextDouble();
		
		// 3�г� 4�� 15�� ȫ�浿 ���л��� ������ 85.75�� �Դϴ�.
		System.out.printf("%d�г� %d�� %d�� %s %s�� ������ %.2f�� �Դϴ�.\n", 
						 grade, classRoom, number, name, gender, score);
		
	}
	
	// �ǽ����� 3
	// ������ �ϳ� �Է� �޾� ¦��/Ȧ���� �����ϼ���.
	// (0�� ¦���� ����մϴ�.)
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		String result = input % 2 == 0 ? "¦��" : "Ȧ��";
		
		System.out.println(result + " �Դϴ�.");
		
	}
	
	
	// �ǽ����� 4
	//����, ����, ���п� ���� ������ Ű���带 �̿��� ������ �Է� �ް�, 
	//�� ���� ���� �հ�(����+����+����)�� ���(�հ�/3.0)�� ���ϼ���.
	//�� ������ ������ ����� ������ �հ� ���θ� ó���ϴµ� 
	//�� ���� ������ ���� 40�� �̻��̸鼭 ����� 60�� �̻��� �� �հ�, 
	// �ƴ϶�� ���հ��� ����ϼ���.
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int kor = sc.nextInt();
		
		System.out.print("���� : ");
		int eng = sc.nextInt();
		
		System.out.print("���� : ");
		int math = sc.nextInt();
		
		int sum = kor + eng + math; // �հ�
		double avg = sum / 3.0; // ���
		
		System.out.println("�հ� : " + sum);
		System.out.printf("��� : %.1f\n", avg);
		
		boolean result = (kor >= 40) && (eng >= 40) && (math >= 40) && (avg >= 60);
		
		System.out.println(   result ? "�հ�" : "���հ�" );
						//    ���ǽ� ?  ��1  : ��2
	}
	
	
	
	
	
}
