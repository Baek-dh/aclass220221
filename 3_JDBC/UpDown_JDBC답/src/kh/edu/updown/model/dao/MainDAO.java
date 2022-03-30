package kh.edu.updown.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import kh.edu.updown.model.vo.Member;

public class MainDAO {

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	/** 아이디 중복 검사 DAO
	 * @param memberId
	 * @return result
	 */
	public int duplicateCheck(String memberId) {
		int result = 0;
		
		try {
			// oracle jdbc driver 메모리 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 커넥션 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.22:9000:xe", "updown", "updown1234");
						
			// DB에 입력 받은 아이디가 있는지 검사
			// - 같은 아이디가 있을 경우 COUNT(*) 시 1이 반환됨.
			// - 같은 아이디가 없을 경우 COUNT(*) 시 0이 반환됨.
			
			String sql = "SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery(); // SELECT문 수행 -> ResultSet 반환
			
			
			// 그룹함수 COUNT 수행 결과는 무조건 1행 이므로 if문 사용
			if(rs.next()) {
				result = rs.getInt(1); // 조회 결과 중 1번 컬럼 값 == COUNT(*) 컬럼
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result; // 중복 X == 0,  중복 O == 1 반환
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/** 회원 가입 DAO
	 * INSERT 구문 작성 시
	 * HIGH_SCORE 컬럼의 값을 삽입하는 경우 0 또는 DEFAULT로 지정
	 * (DEFAULT는 컬럼에 지정된 기본값으로 0으로 지정한 상태입니다.)
	 * 
	 * @param mem 
	 * @return result
	 */
	public int signUp(Member mem) {
		int result = 0;
		
		try {
			// oracle jdbc driver 메모리 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 커넥션 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.22:9000:xe", "updown", "updown1234");
			conn.setAutoCommit(false); // 자동 커밋 비활성화
			
			String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, DEFAULT)";
			// 삽입되는 값 DEFAULT는 컬럼에 지정된 기본값을 삽입한다는 의미로
			// MEMBER 테이블의 HIGH_SCORE 컬럼의 기본값은 0으로 설정되어 있음.
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPw());
			pstmt.setString(3, mem.getMemberName());
			
			// SQL 수행
			result = pstmt.executeUpdate();
			
			// 트랜잭션 제어 처리
			if(result > 0)  conn.commit();
			else			conn.rollback();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result; 
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/** 로그인 DAO
	 * 아이디, 비밀번호가 일치하는 회원의
	 * MEMBER_ID, MEMBER_NAME, HIGH_SCORE를 조회
	 * 
	 * @param mem
	 * @return loginMember
	 */
	public Member login(Member mem) {
		Member loginMember = null;
		
		try {
			// oracle jdbc driver 메모리 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 커넥션 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.22:9000:xe", "updown", "updown1234");
						
			
			String sql = "SELECT MEMBER_ID, MEMBER_NAME, HIGH_SCORE FROM MEMBER "
					   + "WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPw());
			
			rs = pstmt.executeQuery(); // SELECT문 수행 -> ResultSet 반환
			
			// 조회 성공 시 한 행 밖에 조회되지 않으므로 if문 사용
			if(rs.next()) {
				String memberName = rs.getString("MEMBER_NAME");
				int highScore = rs.getInt("HIGH_SCORE");
				
				// Member 객체를 생성하여 조회된 결과를 저장
				loginMember = new Member();
				loginMember.setMemberId(mem.getMemberId());
				loginMember.setMemberName(memberName);
				loginMember.setHighScore(highScore);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return loginMember; 
	}

}
