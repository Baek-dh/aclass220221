package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

//	길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여
//	순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
//	홀수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급
	public void practice2() {

		int[] arr = new int[9];

		// int num = 9;

		int sum = 0; // 합계용 변수

		for (int i = 0; i < arr.length; i++) {

			arr[i] = 9 - i;
			// arr[i] = num;
			// num--;

			if (i % 2 == 1) { // i 가 홀수인 경우
				sum += arr[i];
			}

			System.out.print(arr[i] + " "); // 출력
		}

		System.out.println("\n홀수 번째 인덱스 합 : " + sum);

	}

//	문자열을 입력 받아 문자 하나하나를 배열에 넣고 
//	검색할 문자가 문자열에 몇 개 들어가 있는지
//	개수와 몇 번째 인덱스에 위치하는지 인덱스를 출력하세요

	public void practice5() {

		Scanner sc = new Scanner(System.in);

		System.out.print("문자열 : ");
		String input = sc.nextLine();

		System.out.print("문자 : ");
		char ch = sc.next().charAt(0); // 입력 받은 문자열에서 0번 인덱스 문자를 반환
		// String -> char

		char[] arr = new char[input.length()]; // 입력 받은 문자열 길이 만큼의 배열 생성

		int count = 0; // input에 일치하는 ch가 몇개 있는지 카운트하는 변수

		System.out.print(input + "에 " + ch + "가 존재하는 위치(인덱스) : ");

		for (int i = 0; i < arr.length; i++) {

			// 배열 대입
			arr[i] = input.charAt(i); // 입력 받은 문자열에서 i번째 인덱스 문자를 arr[i]에 대입

			// 검색 + 카운트
			if (arr[i] == ch) { // 검색 조건
				count++;
				System.out.print(i + " ");
			}
		}

		System.out.println("\n" + ch + "개수 : " + count);

	}

//	주민등록번호 번호를 입력 받아 char 배열에 저장한 후 출력하세요.
//	단, char 배열 저장 시 성별을 나타내는 숫자 이후부터 *로 저장하세요.

	public void practice7() {

		Scanner sc = new Scanner(System.in);

		System.out.print("주민등록번호(-포함) : ");
		String input = sc.nextLine();

		char[] arr = new char[input.length()];

		for (int i = 0; i < arr.length; i++) {

			if (i <= 7) { // 7번 인덱스 이하(생년월일, - , 성별)
				arr[i] = input.charAt(i);
			} else { // 8번 인덱스 이상부터는 *
				arr[i] = '*';
			}

			System.out.print(arr[i]);
		}

	}

//	3이상인 홀수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
//	중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
//	단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고
//	다시 정수를 받도록 하세요.

	public void practice8() {

		Scanner sc = new Scanner(System.in);

		while (true) { // 3 이상의 수가 입력 될 때 까지 무한 반봅
						// -> 3 이상이 입력되면 break문으로 종료

			System.out.print("정수 : ");
			int input = sc.nextInt();

			if (input < 3 || input % 2 == 0) { // 3 미만 또는 짝수인 경우 -> 반복
				System.out.println("다시 입력하세요.");
				// continue;
			} else {

				// 입력 받은 정수 만큼의 크기를 가지는 배열 생성
				int[] arr = new int[input];

				int num = 0; // arr 배열에 대입될 값

				for (int i = 0; i < arr.length; i++) {

					if (i <= arr.length / 2) { // 중간 이전 까지 -> 증가
						arr[i] = ++num;

					} else { // 중간 이후 -> 감소

						arr[i] = --num;
					}

					// 출력 시 , 추가 (단, 마지막 제외)
					if (i == arr.length - 1) { // 마지막 바퀴
						System.out.print(arr[i]);

					} else {
						System.out.print(arr[i] + ", ");

					}

				}

				break; // while 반복 멈춤
			}
		}

	}

//	10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
//	1~10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요
	public void practice11() {

		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {

			// 난수 생성 -> 대입 (단, 중복 제거)
			arr[i] = (int) (Math.random() * 10 + 1); // 1~10 사이 난수

			// 중복 확인 시 i값을 감소 시켜
			// 다음 반복에서 현재 인덱스에 난수 덮어쓰기

			for (int x = 0; x < i; x++) {

				if (arr[i] == arr[x]) {
					// 현재 생생된 난수가 앞서 대입된 난수와 같은 경우 == 중복

					i--; // i를 1 감소 시킴
							// 바깥쪽 for문 반복 시 다시 i가 1 증가
							// -> -1 + 1 == 0 (제자리)

					break; // 중복을 찾게되면 더 이상 검사할 필요가 없음
				}
			}
		}

		// 출력
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public void practice12() {
		// 로또 번호 생성기

		// 1. 1 ~ 45 사이 중복되지 않은 난수 6개 생성
		// 2. 생성된 난수가 오름차순으로 정렬

		// 1) 정수 6개를 저장할 배열 선언 및 할당
		int[] lotto = new int[6];

		// 2) 생성된 배열을 처음부터 끝까지 순차 접근하는 for문 작성
		for (int i = 0; i < lotto.length; i++) {

			// 3) 1 ~ 45 사이의 난수 생성
			int random = (int) (Math.random() * 45 + 1);
			// 0.0 <= x < 1.0
			// 0.0 <= x * 45 < 45.0
			// 1.0 <= x * 45 + 1 < 46.0
			// 1 <= (int)(x * 45 + 1) < 46

			// 4) 생성된 난수를 순서대로 배열 요소에 대입
			lotto[i] = random;

			// 5) 중복 검사를 위한 for문 작성
			for (int x = 0; x < i; x++) {

				// 6) 현재 생성된 난수와 같은 수가
				// 앞 쪽 요소에 있는지 검사
				if (random == lotto[x]) {

					i--;
					// i가 1씩 증가할 때 마다 난수가 하나 생성된다
					// -> 중복 값이 있으므로 난수를 새로 하나 더 생성해야된다.
					// --> i는 기본적으로 0~5까지 6회 반복 되지만
					// i값을 인위적으로 1 감소시켜 7회 반복 되는 모양을 만듦.

					break;
					// 앞쪽에서 중복 데이터를 발견하면
					// 남은 값을 비교할 필요가 없음
					// -> 효율 향상을 위해서 검사하는 for문을 종료
				}

			}

		} // for문 끝

		// 7) 오름차순 정렬
		// -> 선택, 삽입, 버블, 퀵 등등
		// --> 자바가 정렬 방법을 미리 만들어서 제공하고 있음
		// Arrays.sort(배열명) : 배열 내 값들이 오름차순으로 정렬됨

		Arrays.sort(lotto);

		// 결과 출력
		System.out.println(Arrays.toString(lotto));

	}
	
	
//	문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고
//	문자의 개수와 함께 출력하세요
	public void practice13() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String input = sc.nextLine();
		
		char[] arr = new char[input.length()];
		
		int count = 0; // 카운트용 변수
		
		System.out.print("문자열에 있는 문자 : ");
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = input.charAt(i); // 문자열 -> char배열에 옮겨 담기
			
			// 중복 검사 + flag
			// application
			//배열 : [a, p, p, l, i, c, a, t, i, o, n]
			//화면 :  a, p, l, i, c, t, o, n
			//개수 :  1  2  3  4  5  6  7  8
			
			boolean flag = true; // 신호용 변수
			
			for(int x=0 ; x<i ; x++) { // 중복 검사용 for문
				if( arr[i] == arr[x] ) {
					// 현재 대입된 문자가 앞서 대입된 문자와 같다면 == 중복
					flag = false; // 신호용 변수의 값을 false로 변경
					break; 
				}
			}
			
			if(flag) { // flag가 true인 경우 == 중복이 없었다라는 의미
				
				count++; // 카운트 1 증가
				
				if(i == 0) { // 첫 바퀴인 경우
					System.out.print(arr[i]);
					
				}else { // 첫 바퀴가 아닌 경우
					System.out.print(", " + arr[i]);
				}
				
			}
			
		} // 바깥쪽 for문 끝
		
		System.out.println("\n문자 개수 : " + count);
		
	}
	
	
	
	public void practice14() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		sc.nextLine();  // 입력 버퍼 개행 문자 제거
		
		
		String[] arr = new String[size]; // 배열 선언 및 할당
		
		int start = 0; // while 내 for문의 초기식에 사용될 변수
		
		while(true) {
			
			for(int i=start ; i<arr.length ; i++) {
				
				System.out.print( (i+1) + "번째 문자열 : ");
				arr[i] = sc.nextLine();
			}
			
			
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			char input = sc.nextLine().charAt(0);
						// 입력 받은 문자열 중 제일 앞 문자 하나만 얻어옴
			
			if(input == 'Y' || input == 'y') { 
				
				start = arr.length;
				// 추가 입력 받기 위한 추가 배열 부분의 시작 위치
				
				System.out.print("더 입력하고 싶은 개수 : ");
				int addSize = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행 문자 제거
				
				// 증가된 크기의 배열을 생성하여 arr 배열 깊은 복사
				String[] copyArr = new String[ arr.length + addSize ];	
				
				for(int i=0 ; i<arr.length ; i++) { // 기존 배열 크기 만큼만 반복
					
					copyArr[i] = arr[i]; // 복사 배열에 기존 배열 값을 같은 인덱스에 대입
				}
				
				// 배열 얕은 복사
				arr = copyArr; // arr이 참조하는 주소 값을
							   // copyArr의 주소 값으로 바꿔서
							   // arr이 참조하는 배열의 크기가 증가한 것 처럼 보이ㅔ함.
				
			} else { // y/n만 입력 했다는 상황을 가정
				
				break; // while 반복 종료
			}
			
		} // while 끝
		
		System.out.println(Arrays.toString(arr));
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
