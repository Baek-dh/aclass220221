package edu.kh.comm.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.kh.comm.board.model.vo.Board;
import edu.kh.comm.board.model.vo.BoardDetail;
import edu.kh.comm.board.model.vo.BoardType;
import edu.kh.comm.board.model.vo.Pagination;

//@Component // bean 등록
@Repository // DB랑 통신하는 클래스 명시 + bean 등록
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	/** 게시판 코드,이름 조회
	 * @return boardTypeList
	 */
	public List<BoardType> selectBoardType() {
		return sqlSession.selectList("boardMapper.selectBoardType");
	}

 
	/** 특정 게시판의 전체 게시글 수 조회 DAO
	 * @param boardCode
	 * @return listCount
	 */
	public int getListCount(int boardCode) {
		return sqlSession.selectOne("boardMapper.getListCount", boardCode);
	}


	/** 게시판 목록 조회 DAO
	 * @param pagination
	 * @param boardCode
	 * @return boardList
	 */
	public List<Board> selectBoardList(Pagination pagination, int boardCode) {
		
		// RowBounds 객체(마이바티스)
		// - 전체 조회 결과에서
		//   몇 개의 행을 건너 뛰고(offset)
		//   그 다음 몇 개의 행만(limit) 조회할 것인지 지정
		
		int offset = ( pagination.getCurrentPage() - 1 ) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("boardMapper.selectBoardList", boardCode, rowBounds);
	}


	
	/** 게시글 상세 조회 DAO
	 * @param boardNo
	 * @return dtail
	 */
	public BoardDetail selectBoardDetail(int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoardDetail", boardNo);
	}


	/** 조회수 증가 DAO
	 * @param boardNo
	 * @return result
	 */
	public int updateReadCount(int boardNo) {
		return sqlSession.update("boardMapper.updateReadCount", boardNo);
	}

}









