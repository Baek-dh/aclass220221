package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.vo.Board;

public class BoardDAO {

	// JDBC 객체 참조용 변수 선언(java.sql)
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// SQL 내용을 저장한 Properties 객체 참조 변수 선언
	private Properties prop;
	
	// 기본 생성자(board-sql.xml 파일 읽어오기(Properties))
	public BoardDAO() {
		try {
			prop = new Properties();
			
			// XML 파일 읽어오기
			prop.loadFromXML(new FileInputStream("board-sql.xml"));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 게시글 목록 조회 DAO
	 * @param conn
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectAll(Connection conn) throws Exception {
		
		// 결과 저장용 변수
		List<Board> boardList = new ArrayList<Board>();
		
		try {
			// 1) SQL 작성
			String sql = prop.getProperty("selectAll");
			
			// 2) Statement 생성
			stmt = conn.createStatement();
			
			// 3) SQL 수행(SELECT) 후 결과 반환 받기(ResultSet)
			rs = stmt.executeQuery(sql);
			
			// 4) ResultSet을 한 행씩(rs.next()) 모두(while) 접근
			while(rs.next()) {
				
				// 5) 현재 행에서 컬럼명을 이용해서 컬럼 값 얻어오기
				int boardNo 		= rs.getInt("BOARD_NO");
				String boardTitle 	= rs.getString("BOARD_TITLE");
				Date createDate		= rs.getDate("CREATE_DATE"); 
				int readCount		= rs.getInt("READ_COUNT");
				String memberName	= rs.getString("MEMBER_NM");
				int replyCount		= rs.getInt("REPLY_COUNT");
						
				
				// 6) Board 객체를 생성하여 컬럼 값 담기
				Board board = new Board(boardNo, boardTitle, createDate, readCount, memberName, replyCount);  
				
				// 7) Board객체를 boardList에 추가
				boardList.add(board);
			}
			
		}finally {
			// 8) JDBC 자원 반환(Connection 제외)
			close(rs);
			close(stmt);
		}
		
		// 결과 반환
		return boardList;
	}

	
	
	
}
