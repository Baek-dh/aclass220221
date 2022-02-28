package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {
	
	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 : ");
		double midTerm = sc.nextDouble();
		
		System.out.print("기말 고사 점수 : ");
		double finalTerm = sc.nextDouble();
		
		System.out.print("과제 점수 : ");
		double homework = sc.nextDouble();
		
		System.out.print("출석 횟수 : ");
		double attendance = sc.nextDouble();
		
		if(attendance <= 20 * (1- 0.3) ) { // 30% 이상 결석
			System.out.println("Fail [출석 횟수 부족 (" + (int)attendance + "/20)]");
			
		} else {
			
			midTerm *= 0.2;
			finalTerm *= 0.3;
			homework *= 0.3;
			attendance *= 5 * 0.2;
			
			// 합계
			double sum = midTerm + finalTerm + homework + attendance;
			
			System.out.printf("중간 고사 점수(20) : %.1f\n", midTerm);
			System.out.printf("기말 고사 점수(30) : %.1f\n", finalTerm);
			System.out.printf("과제 점수(30) : %.1f\n", homework);
			System.out.printf("출석 점수(20) : %.1f\n", attendance);
			System.out.printf("총점 : %.1f\n", sum);
			
			if(sum >= 70.0) {
				System.out.println("PASS");
			}else {
				System.out.println("Fail [점수 미달]");
			}
			
		}
		
		
		
		
	}
	
	
	
	
}
