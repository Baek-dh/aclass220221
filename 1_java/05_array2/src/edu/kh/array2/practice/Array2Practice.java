package edu.kh.array2.practice;

public class Array2Practice {

	
//	4행 4열 2차원 배열을 생성하여 
//	0행 0열부터 2행 2열까지는 1~10까지의 임의의 정수 값 저장 후
//	아래의 내용처럼 처리하세요.
	public void practice4() {
		
		int[][] arr = new int[4][4];
		
		// 상수 사용법 : 변하지 않는 특정 값에 이름을 붙여줌
		final int ROW_LAST_INDEX = arr.length - 1; // 행 마지막 인덱스
		final int COL_LAST_INDEX = arr[0].length - 1; // 열 마지막 인덱스
		
		
		for(int row=0 ; row<arr.length ; row++) { // 행 반복
							// 행의 길이
			
			for(int col=0 ; col<arr[row].length ;col++) { // 열 반복
						// row번째 행의 열의 길이
				
				// 마지막 행, 마지막 열이 아닌 경우
				if(row != ROW_LAST_INDEX && col != COL_LAST_INDEX) {
					
					int random = (int)(Math.random() * 10 + 1); // 1~10 난수
					arr[row][col] = random;
					
					// 각 행의 마지막 열에 난수를 누적
					arr[row][COL_LAST_INDEX] += arr[row][col];
					
					// 각 열의 마지막 행에 난수를 누적
					arr[ROW_LAST_INDEX][col] += arr[row][col];
					
					// 생성된 모든 난수를 마지막 행, 마지막 열에 누적
					arr[ROW_LAST_INDEX][COL_LAST_INDEX] += arr[row][col];
					
				}
				
				System.out.printf("%4d", arr[row][col]);
				
				
			} // 열 반복 끝
		
			System.out.println(); // 줄바꿈
			
		} // 행 반복 끝
			
	}
	
	
	
	/*실습문제7
	1차원 문자열 배열에 학생 이름 초기화되어 있다.
	3행 2열 짜리 2차원 문자열 배열 2개를 새로 선언 및 할당하여
	학생 이름을 2차원 배열에 순서대로 저장하고 아래와 같이 출력하시오.
	(첫 번째 2차원 배열이 모두 저장된 경우 두 번째 2차원 배열에 저장 진행)
	String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
	"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
	[실행 화면]
	== 1분단 ==
	강건강 남나나
	도대담 류라라
	문미미 박보배
	== 2분단 ==
	송성실 윤예의
	진재주 차천축
	피풍표 홍하하
	*/
	public void practice7() {
		String[] students = { "강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하" };
	
		String[][] arr1 = new String[3][2];
		String[][] arr2 = new String[3][2];
		
		int index = 0; // students 배열에서 0 부터 1씩 증가하며 학생들을 선택하는 용도의 변수
		
		System.out.println("== 1분단 ==");
		for(int row=0 ; row<arr1.length ; row++) {
			for(int col=0 ; col<arr1[row].length ; col++) {
				
				arr1[row][col] = students[index];
				// students배열 index 번째 학생을 arr1[row][col]에 대입
				
				index++; 
				
				System.out.print(arr1[row][col] + " ");
			}
			System.out.println();// 줄바꿈
		}
		
		System.out.println("== 2분단 ==");
		for(int row=0 ; row<arr2.length ; row++) {
			for(int col=0 ; col<arr2[row].length ; col++) {
				
				arr2[row][col] = students[index];
				// students배열 index 번째 학생을 arr2[row][col]에 대입
				
				index++; 
				
				System.out.print(arr2[row][col] + " ");
			}
			System.out.println();// 줄바꿈
		}
		
		
		
		
		
	}
	
	
	
	
	
}
