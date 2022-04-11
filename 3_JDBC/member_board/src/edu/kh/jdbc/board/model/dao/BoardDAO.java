package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
		
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
