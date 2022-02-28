package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {
	
	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�߰� ��� ���� : ");
		double midTerm = sc.nextDouble();
		
		System.out.print("�⸻ ��� ���� : ");
		double finalTerm = sc.nextDouble();
		
		System.out.print("���� ���� : ");
		double homework = sc.nextDouble();
		
		System.out.print("�⼮ Ƚ�� : ");
		double attendance = sc.nextDouble();
		
		if(attendance <= 20 * (1- 0.3) ) { // 30% �̻� �Ἦ
			System.out.println("Fail [�⼮ Ƚ�� ���� (" + (int)attendance + "/20)]");
			
		} else {
			
			midTerm *= 0.2;
			finalTerm *= 0.3;
			homework *= 0.3;
			attendance *= 5 * 0.2;
			
			// �հ�
			double sum = midTerm + finalTerm + homework + attendance;
			
			System.out.printf("�߰� ��� ����(20) : %.1f\n", midTerm);
			System.out.printf("�⸻ ��� ����(30) : %.1f\n", finalTerm);
			System.out.printf("���� ����(30) : %.1f\n", homework);
			System.out.printf("�⼮ ����(20) : %.1f\n", attendance);
			System.out.printf("���� : %.1f\n", sum);
			
			if(sum >= 70.0) {
				System.out.println("PASS");
			}else {
				System.out.println("Fail [���� �̴�]");
			}
			
		}
		
		
		
		
	}
	
	
	
	
}
