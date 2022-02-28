package edu.kh.array.ex;

public class ArrayExample1 {

	/* 배열 (Array)
	 * - 같은 자료형의 변수를 하나의 묶음으로 다루는 것. (자료구조)
	 * - 묶여진 변수들은 하나의 배열명으로 불러지고
	 *   구분은 index를 이용함. (index는 0부터 시작하는 정수)
	 * */
	
	public void ex1() {
		
		// 변수 vs 배열
		
		// 1-1. 변수 선언
		int num;
		// Stack 영역에 int 자료형을 저장할 수 있는 공간 4byte를 생성(할당)하고
		// 그 공간에 num 이라는 이름을 부여.
		
		// 1-2. 변수 대입
		num = 10;
		// 생성된 num 이라는 변수 공간에 10을 대입
		
		// 1-3. 변수 사용
		System.out.println("num에 저장된 값 : " + num);
		// num이 작성된 자리에 num에 저장된 값을 읽어와서 출력
		
		// ----------------------------------------------------------
		
		// 2-1. 배열 선언
		int[] arr;
		// Stack 영역에 int[] (int 배열) 자료형 공간을 4byte 할당하고
		// 그 공간에 arr 이라는 이름을 부여
		// ** 해당 변수는 참조형으로 주소 값(4byte)만을 저장할 수 있음.
		
		
		// 2-2. 배열 할당
		arr = new int[3];
		
		// new : "new 연산자" 라고 하며 
		//       Heap 메모리 영역에 새로운 공간(배열, 객체)을 할당
		
		// int[3] : int 자료형 변수 3개를 하나의 묶음으로 나타내는 배열
		
		// new int[3] : heap 영역에 int 3칸 짜리 int[]을 생성(할당)
					//  ** 생성된 int[]에는 시작 주소가 지정된다!! **
		
		//  arr  =  new Int[3];
		//(int[])    (int[])  -> 같은 자료형 == 연산 가능
		
		// heap 영역에 생성된 int[]의 시작 주소를
		// stack 영역에 생성된 arr 변수에 대입
		
		// -> arr 변수가 int[]을 참조하게됨!
		//    (그래서 arr을 참조형이라고 함)
		
		
		// 2-3. 배열 요소 값 대입
		// arr은 int[] 참조형 변수 이지만
		// arr[0] int 자료형 변수이기 때문에 정수 값을 대입할 수 있다.
		
		arr[0] = 10;
		arr[1] = 50;
		arr[2] = 1000;
		
		
		// 2-4. 배열 요소 값 읽어오기
		System.out.println( arr[0] ); // arr이 참조하고 있는 배열의 0번 인덱스 값을 얻어옴
		System.out.println( arr[1] ); // arr이 참조하고 있는 배열의 1번 인덱스 값을 얻어옴
		System.out.println( arr[2] ); // arr이 참조하고 있는 배열의 2번 인덱스 값을 얻어옴
		
	}
	
	
	public void ex2() {
		
		// 배열 선언 및 할당
		int[] arr = new int[4];
		
		// 1) stack 영역에 int[] 자료형 참조형 변수 arr 선언
		// 2) heap 영역에 int 자료형 4개를 묶음으로 다루는 int[] 할당
		// 3) 생성된 int[]의 주소를 arr에 대입하여
		//    참조하는 형태를 만든다.
		
		
		// 배열 길이(몇 칸 인가)  : 배열명.length
		System.out.println("배열의 길이 : " + arr.length);
		
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 500;
		arr[3] = 1000;
		
		// 배열과 for문
		// i == index
		for(int i=0 ; i < arr.length ; i++) {
			// 0 이상 arr 배열 길이 미만의 정수
			
			System.out.printf("arr[%d]에 저장된 값 : %d\n", i, arr[i]);
		}
		
	}
	
	// (참고지만 알고있는게 좋음)
	
	// 비어있다 : stack 영역에 선언된 변수에 값이 대입되지 않음.
	
	// null : 참조형 변수가 선언 되었으나 아무곳도 참조하지 않음.
	// 		  (빈칸 아님!!)
	
	// 0 : int 자료형 0  (확실히 존재하는 값)
	
	// "" : String 자료형이지만 내용 없음(빈 문자열)
	
	
}






