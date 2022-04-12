package edu.kh.jdbc.board.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.model.service.BoardService;
import edu.kh.jdbc.board.model.vo.Board;
import edu.kh.jdbc.board.model.vo.Reply;
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
							// 게시글 상세조회 + 댓글 목록 조회
				
							// 게시글 작성자와 로그인한 회원이 같을 때
							// 게시글 수정(UPDATE), 게시글 삭제(DELETE)
				
							// 댓글 삽입, 수정, 삭제
				
				System.out.println("3. 게시글 작성(INSERT)");
				System.out.println("4. 게시글 검색(제목/내용/제목+내용/작성자)");
				
				System.out.println("0. 회원 메뉴로 돌아가기");
				
				
				System.out.print("메뉴를 선택해주세요 >> ");
				menuNum = sc.nextInt();
				sc.nextLine(); // 개행 문자 제거
				System.out.println(); // 줄 바꿈
				
				switch(menuNum) {
				case 1: selectAll();  break;
				case 2: selectOne(loginMember); break;
					// 상세 조회 시 게시글 수정/삭제(게시글 작성 == 로그인한 회원 비교)
					// 댓글(누가 작성? / 작성자가 수정,삭제 확인)
					// -> loginMember를 매개변수로 전달
				
				
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
			
			if(boardList.isEmpty()) { // 조회 결과가 없는 경우
				System.out.println("\n[조회된 게시글이 없습니다.]\n");
				
			}else {
				System.out.println("------------------------------------------------------------------------");
				System.out.printf("%3s  %13s%12s   %7s%3s %7s%2s %s\n",
							"글번호", "제목", "", "작성자", "", "작성일", "" , "조회수");
				System.out.println("------------------------------------------------------------------------");
				
				// 향상된 for문
				for(Board b : boardList) {
					
					System.out.printf("%3d  %20s [%d]  %10s  %s %3d\n",
							b.getBoardNo(), b.getBoardTitle(), b.getReplyCount(),
							b.getMemberName(), b.getCreateDate().toString(), b.getReadCount());
				}
			}
			
		}catch (Exception e) {
			System.out.println("\n<게시글 목록 조회 중 예외 발생>\n");
			e.printStackTrace();
		}
	
	}

	
	
	
	/** 게시글 상세조회
	 * @param loginMember
	 */
	private void selectOne(Member loginMember) {
		System.out.println("[게시글 상세 조회]");
		
		System.out.print("조회할 게시글 번호 입력 : ");
		
		int boardNo = sc.nextInt();
		sc.nextLine();
		
		// 게시글 상세조회 Service를 호출 후 결과 반환(게시글 1개의 정보 == Board)
		try {
			Board board = service.selectOne(boardNo);
			
			if(board != null) { // 조회된 게시글이 있을 경우
			
					
				// 상세 조회 출력
				System.out.println("\n------------------------------------------------------------");
				System.out.printf("번호 : %d     |  제목 : %s\n", board.getBoardNo(), board.getBoardTitle());
				System.out.println("------------------------------------------------------------");
				System.out.printf("작성자 : %s\n"
								+ "작성일 : %s\n"
								+ "조회수 : %d\n", 
								board.getMemberName(), board.getCreateDate(), board.getReadCount());
				System.out.println("------------------------------------------------------------");
				System.out.printf("\n%s\n\n", board.getBoardContent());
				System.out.println("------------------------------------------------------------");
				
				// 댓글 목록 조회
				System.out.println("\n[댓글]");
				for( Reply r : board.getReplyList() ) {
					System.out.printf("<%d> | %s | %s\n", 
							r.getReplyNo(), r.getMemberName(), r.getCreateDate());
					
					System.out.println(r.getReplyContent());
					System.out.println(".............................................................\n");
				}
				
				
				// -------------------------------------------
				// 상세 조회용 메뉴 출력
				
				System.out.println("===== 상세 조회 메뉴 =====");
				
				System.out.println("1. 댓글 삽입"); // 어떤 회원이든 가능
				
				// 댓글 번호 입력받아 
				// 댓글을 작성한 회원 번호 == 로그인한 회원 번호
				// -> 수정/삭제
				System.out.println("2. 댓글 수정"); 
				System.out.println("3. 댓글 삭제");
				
				// 상세 조회된 게시글의 회원 번호 == 로그인한 회원 번호
				// -> 게시글 수정/삭제
				if(board.getMemberNo() == loginMember.getMemberNo() ) {
					System.out.println("4. 게시글 수정");
					System.out.println("5. 게시글 삭제");
				}
				
				System.out.print("메뉴 선택 >> ");
				int menuNum = sc.nextInt();
				sc.nextLine();
				
				switch(menuNum) {
				case 1:  break;
				case 2:  break;
				case 3:  break;
				
				case 4:  case 5:  
					
					// 게시글 작성자 번호 == 로그인 회원 번호
					if(board.getMemberNo() == loginMember.getMemberNo() ) {
						
						// 4번 게시글 수정
						if(menuNum == 4) {
							
							
						} else { // 5번 게시글 삭제
							
							// 삭제용 메서드
							deleteBoard(boardNo);
							
							
						}
						
						
					} else {
						System.out.println("메뉴에 표시된 번호만 입력 해주세요.");
					}
					
				break;
				
				default:  System.out.println("메뉴에 표시된 번호만 입력 해주세요.");
				}
				
			} // if(board != null) 끝
			
			else {  // board == null -> 조회된 게시글이 없을 경우
				System.out.println("\n존재하지 않는 게시글 번호 입니다.\n");
				
			}
			
		} catch (Exception e) {
			System.out.println("\n<게시글 상세 조회 중 예외 발생>\n");
			e.printStackTrace();
		}
		
	}

	
	
	
	/** 게시글 삭제
	 * @param boardNo
	 */
	private void deleteBoard(int boardNo) {
		// "정말 삭제 하시겠습니까?(Y/N)  -- 제대로 입력 될 때 까지 무한 반복" 
		// -> "Y" 입력 시 
		// -> 보안문자 생성
		// -> 보안 문자가 일치하는 경우에 삭제 진행
		
		System.out.println("\n[게시글 삭제]\n");
		
		char ch = ' '; // Y/N 저장
		
		while(true) {
			System.out.print("정말 삭제 하시겠습니까?(Y/N) : ");
			ch = sc.next().toUpperCase().charAt(0);
			//    String   대문자String  대문자char
			
			if(ch == 'Y' || ch == 'N') { // Y 또는 N인 경우 추가 입력 X (반복 종료)
				break;
			}else {
				System.out.println("Y 또는 N을 입력해주세요.\n");
			}
		}
		
		
		if(ch == 'Y') { // 삭제를 하려고 하는 경우
			
			// 보안문자 생성
			String cap = captcha();
			System.out.print("다음 보안문자를 입력해주세요 >> " + cap);
			
			System.out.print("보안 문자 입력 : ");
			String input = sc.next();
			
			if(input.equals(cap)) { // 입력받은 문자열과 보안 문자가 같을 때
				// 삭제 Service 호출
				
				int result = service.deleteBoard(boardNo);
				
				if(result > 0) {
					System.out.println(boardNo + "번 게시글이 삭제되었습니다.");
				}else {
					System.out.println("삭제 실패");
				}
				
				
			} else {
				// 취소
				System.out.println("\n보안 문자가 일치하지 않습니다.(삭제 취소)\n");
			}
			
			
			
		} else { // 삭제 취소
			System.out.println("\n삭제를 취소했습니다.\n");
		}

	}
	
	
	/** 보안문자 생성 메서드(랜던 영어소문자 5개)
	 * @return cap
	 */
	private String captcha() {
		String cap = "";
		
		for(int i=0 ; i<5 ; i++) { // 5바퀴 반복
			cap += (char)(Math.random() * 26 + 'a');
					// int  형변환 : 91 ~ 116
					// char 형변환 : 'a' ~ 'z'
		}
		
		return cap;
	}
	
	
	
	
}
