package edu.kh.test;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// �̱�ų� �� �� ���� ���� �ݺ�
		while(true) {
			
			System.out.print("���� ���� �� �� �� ���� �Է��ϼ��� : ");
			
			String input = sc.next(); // ����� �Է�
			
			// ������ �߻����� �����ϰ� ���� ���� �� �� �����Ѵ�.
			int random = (int)(Math.random() * 3 + 1);
			
			String com = null; 
			
			switch(random) {
			case 1 : com = "����"; break;
			case 2 : com = "����";break;
			case 3 : com = "��";break;
			}
			
			System.out.println("����� " + input + "�� �½��ϴ�.");
			System.out.println("��ǻ�ʹ� " + com + "�� �½��ϴ�.");
			
			
			// ����� ��� -> �ݺ�
			if( input.equals(com)  ) {
				// 	String �� �� == ��� ����?X �׷��� ���?.....
				System.out.println("�����ϴ�. �ٽ� �����մϴ�.");
		
			} else {
				// �̱�ų� ���� -> �ݺ� ����
				
				// ����ڰ� �̱� �� �ִ� ���
				boolean win1 = input.equals("����") && com.equals("��");
				boolean win2 = input.equals("����") && com.equals("����");
				boolean win3 = input.equals("��") && com.equals("����");
				
				if(win1 || win2 || win3 ) {
					System.out.println("����� �̰���ϴ�!");
				}else {
					System.out.println("����� �����ϴ�");
				}
				
				break; // �ݺ� ����
			}
		}
	}
}
