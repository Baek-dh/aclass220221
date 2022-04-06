package edu.kh.jdbc.member.view;

import java.util.Scanner;

import edu.kh.jdbc.member.model.service.MemberService;
import edu.kh.jdbc.member.model.vo.Member;

public class MemberView { // 회원 관련 화면 입/출력

	private Scanner sc = new Scanner(System.in);
	
	// 회원 관련 서비스 제공 객체 생성 및 참조
	private MemberService service = new MemberService();
	
	
	/**
	 * 회원 가입 화면 출력용 메서드 
	 */
	public void signUp() {
		System.out.println("[회원 가입]");
		
		try {
			String memberId = null;
			String memberPw = null;
			String memberPw2 = null;
			String memberName = null;
			char memberGender = ' ';
			
			
			while(true) { // 중복 아이디가 없을 경우 종료하는 if문 필요
				System.out.print("아이디 : ");
				memberId = sc.next();
				
				/* 아이디 중복 검사 (DB에 일치하는 아이디 있으면 "중복" -> 다시 아이디 입력 받기)*/
				int result = service.duplicateCheck(memberId);
				// result는 중복이면 1, 아니면 0 반환될 예정
				
				if(result == 0) { // 중복 아니면 반복문 종료
					System.out.println("[사용 가능한 아이디 입니다.]");
					break;
				}else {
					System.out.println("[이미 사용중인 아이디 입니다. 다시 입력 해주세요.]");
				}
			} // 중복 검사 while 종료
			
			
			// 비밀번호, 비밀번호 확인을 각각 입력 받아
			// 일치할 때 까지 무한 반복
			while(true) {
				System.out.print("비밀번호 : ");
				memberPw = sc.next();
				
				System.out.print("비밀번호 확인 : ");
				memberPw2 = sc.next();
				
				if(  memberPw.equals(memberPw2) ) { // 일치하면
					break;
				} else {
					System.out.println("\n[비밀번호가 일치하지 않습니다. 다시 입력 해주세요.]\n");
				}
			} // 비밀번호 확인 while 종료
			
			
			// 이름 입력
			System.out.print("회원 이름 : ");
			memberName = sc.next();
			
			
			// 성별이 'M' 또는 'F'가 입력될 때 까지 반복
			while(true) {
				System.out.print("성별(M/F) : ");
				memberGender = sc.next().toUpperCase().charAt(0);
				// String.toUpperCase() : 문자열을 대문자로 변환
				
				if( memberGender != 'M' && memberGender != 'F' ) {
					System.out.println("\n[성별은 M 또는 F만 입력 해주세요.]\n");
				}else {
					break;
				}
			}
			
			// 입력 받은 값을 하나의 객체(Member)에 저장
			Member signUpMember = new Member(memberId, memberPw, memberName, memberGender);
			
			
			// 회원 가입 Service 호출 후 결과 반환 받기
			// -  회원 가입 == DB에 회원 정보 삽입 == INSERT(DML)
			//    -> DML 구문 수행 시 성공한 행의 개수가 반환됨 == int형 변수로 결과를 저장
			
			int result = service.signUp(signUpMember);
			
			// Service 결과에 따른 화면 처리
			if(result > 0) { // 가입 성공 시
				System.out.println("\n*** 회원 가입 성공 ***\n");
				
			}else {
				System.out.println("[회원 가입 실패]");
			}
		
		}catch(Exception e) {
			System.out.println("\n<회원 가입 중 예외 발생>\n");
			e.printStackTrace(); // 예외 내용 출력
		}
		
	}


	/** 로그인 메서드
	 * @return loginMember (실패 시 null, 성공 시 null X)
	 */
	public Member login() {
		System.out.println("[로그인]");
		
		System.out.print("아이디 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		
		// Member 객체를 생성하여 입력 받은 값 세팅
		Member mem = new Member();
		mem.setMemberId(memberId); // setter 이용해서 초기화
		mem.setMemberPw(memberPw); // setter 이용해서 초기화
		
		
		// 로그인 Service 수행 후 결과 반환 받기
		Member loginMember = null;
		
		try {
			loginMember = service.login(mem);
			
			if(loginMember != null) { // 참조하는 객체가 있다 == 로그인 성공
				System.out.println("\n*** " + loginMember.getMemberName() + "님 환영합니다. ***\n");
			
			} else {  // 로그인 실패(아이디 또는 비밀번호 불일치 또는 탈퇴한 회원)
				System.out.println("\n[아이디 또는 비밀번호가 일치하지 않습니다.]\n");
			}
			
		} catch (Exception e) {
			System.out.println("\n<로그인 과정에서 예외 발생>\n");
			e.printStackTrace();
		}
		
		return loginMember;
	}
	
	
	
	
	

}
