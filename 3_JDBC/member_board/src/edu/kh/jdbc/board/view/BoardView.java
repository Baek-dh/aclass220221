package edu.kh.jdbc.board.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.model.service.BoardService;
import edu.kh.jdbc.board.model.vo.Board;
import edu.kh.jdbc.member.model.vo.Member;

// 게시판 메뉴 전용 화면
public class BoardView {

	private Scanner sc = new Scanner(System.in);
	
	private BoardService service = new BoardService();
	
	
	/** 게시판 전용 메뉴 화면
	 * @param loginMember (로그인한 회원 정보)
	 */
	public void boardMenu(Member loginMember) {
		
		int menuNum = -1;
		
		do {
			try {
				System.out.println("\n********** 게시판 메뉴 **********\n");
				
				System.out.println("1. 게시글 목록 조회");
				System.out.println("2. 게시글 상세 조회(게시글 번호 입력)");
							// 게시글 작성자와 로그인한 회원이 같을 때
							// 게시글 수정(UPDATE), 게시글 삭제(DELETE)
				
				System.out.println("3. 게시글 작성(INSERT)");
				System.out.println("4. 게시글 검색(제목/내용/제목+내용/작성자)");
				
				System.out.println("0. 회원 메뉴로 돌아가기");
				
				
				System.out.print("메뉴를 선택해주세요 >> ");
				menuNum = sc.nextInt();
				sc.nextLine(); // 개행 문자 제거
				System.out.println(); // 줄 바꿈
				
				switch(menuNum) {
				case 1: selectAll();  break;
				case 2:   break;
				case 3:   break;
				case 4:   break;
				case 0: System.out.println("회원 메뉴로 돌아갑니다 ..."); break;
				default: System.out.println("메뉴에 작성된 번호를 입력해주세요.");
				}
				
				
			}catch (InputMismatchException e) {
				System.out.println("\n입력 형식이 올바르지 않습니다. 다시 시도 해주세요.");
				sc.nextLine(); // 입력 버퍼에 남은 잘못된 문자열 제거
			}
			
		}while(menuNum != 0);
		
	}


	/**
	 * 게시글 목록 조회
	 */
	private void selectAll() {
		
		System.out.println("[게시글 목록 조회]");
		
		try {
			// 게시글 목록 조회 Service 호출 후 결과 반환 받기
			List<Board> boardList = service.selectAll();
			
			
			
			
		}catch (Exception e) {
			System.out.println("\n<게시글 목록 조회 중 예외 발생>\n");
			e.printStackTrace();
		}
	
	}

	
	
	
	
	
	
	
}
