package edu.kh.test;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 이기거나 질 때 까지 무한 반복
		while(true) {
			
			System.out.print("가위 바위 보 중 한 개를 입력하세요 : ");
			
			String input = sc.next(); // 사용자 입력
			
			// 난수를 발생시켜 랜덤하게 가위 바위 보 를 지정한다.
			int random = (int)(Math.random() * 3 + 1);
			
			String com = null; 
			
			switch(random) {
			case 1 : com = "가위"; break;
			case 2 : com = "바위";break;
			case 3 : com = "보";break;
			}
			
			System.out.println("당신은 " + input + "를 냈습니다.");
			System.out.println("컴퓨터는 " + com + "를 냈습니다.");
			
			
			// 비겼을 경우 -> 반복
			if( input.equals(com)  ) {
				// 	String 비교 시 == 사용 가능?X 그러면 어떤걸?.....
				System.out.println("비겼습니다. 다시 시작합니다.");
		
			} else {
				// 이기거나 지면 -> 반복 종료
				
				// 사용자가 이길 수 있는 경우
				boolean win1 = input.equals("가위") && com.equals("보");
				boolean win2 = input.equals("바위") && com.equals("가위");
				boolean win3 = input.equals("보") && com.equals("바위");
				
				if(win1 || win2 || win3 ) {
					System.out.println("당신이 이겼습니다!");
				}else {
					System.out.println("당신이 졌습니다");
				}
				
				break; // 반복 멈춤
			}
		}
	}
}
