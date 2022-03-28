package edu.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.vo.Employee;

// DAO(Data Access Object) : 데이터 접근 객체
// - DB와 연결되어 SQL을 수행하고 결과를 반환 받는 역할
public class EmployeeDAO {
	
	// JDBC 객체 저장용 참조 변수 필드 선언
	
	private Connection conn;
	// DB 연결 정보를 담은 객체(Java - DB사이의 통로 역할)
	
	private Statement stmt;
	// Connection을 통해 SQL을 수행하고 결과를 반환 받는 객체
	
	private PreparedStatement pstmt;
	// Statement의 자식으로 좀 더 향상된 기능을 제공
	// - ?(위치홀더)를 이용하여 SQL에 작성되어지는 리터럴을 동적으로 제어함.
	// --> 오타 위험 감소, 가독성 상승
	
	private ResultSet rs;
	// SELECT 수행 후 반환되는 객체
	
	

	/** 전체 사원 정보 조회 DAO
	 * @return
	 */
	public List<Employee> selectAll() {
		
		// 결과 저장용 변수 준비
		List<Employee> empList = new ArrayList<Employee>();
		
		try {
			// 1) Oracle JDBC Driver 메모리 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) DB 연결 작업(Connection 얻어오기)
			String type = "jdbc:oracle:thin:@"; // 오라클 드라이버 타입
			
//			String ip = "127.0.0.1"; // 루프백 아이피(자기 컴퓨터)
//			String ip = "localhost"; // 루프백 아이피와 같음(자기 컴퓨터)
			String ip = "115.90.212.22"; // 접속할 아이피
			String port = ":20000"; // 개인컴퓨터는 1521 or 1522
			String sid = ":xe"; // 접속할 DB 이름
			String user = "bdh"; // 사용자 계정 명
			String pw = "bdh1234"; // 사용자 계정 비밀번호
			
			conn = DriverManager.getConnection(type + ip + port + sid,  user  ,  pw);
			// DriverManager : Connection 생성 메서드 제공
			
			
			// 3) 수행할 SQL 작성
			String sql = "SELECT * FROM EMPLOYEE2 ORDER BY EMP_ID";
					// *** SQL 작성 시 세미콜론은 없어야된다 !! ***
			
			
			// 4) Statement 객체 생성
			stmt = conn.createStatement(); // 커넥션을 왔다 갔다 하는 셔틀버스 같은 역할
			
			
			// 5) SQL 수행 후 결과(ResultSet) 반환 받기
			rs = stmt.executeQuery(sql);
			// executeQuery() : SELECT 문 수행 후 ResultSet 결과를 반환
			
			
			// 6) 결과를 List에 옮겨 담기
			// -> ResultSet을 한 행씩 접근하여 컬럼값을 얻어와
			//    한 행의 정보가 담긴 Employee 객체를 생성하고
			//    이를 empList에 추가
			
			while(rs.next()) {
				// rs.next() : 다음 행이 있으면 true, 호출 시 마다 다음 행으로 이동
				
				int empId = rs.getInt("EMP_ID"); // 현재 행의 EMP_ID 컬럼 값을 int 자료형으로 얻어옴
				String empName = rs.getString("EMP_NAME");
				String empNo = rs.getString("EMP_NO");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String deptCode = rs.getString("DEPT_CODE");
				String jobCode = rs.getString("JOB_CODE");
				String salLevel = rs.getString("SAL_LEVEL");
				int salary = rs.getInt("SALARY");
				double bonus = rs.getDouble("BONUS"); // 실수형
				int managerId = rs.getInt("MANAGER_ID");
				Date hireDate = rs.getDate("HIRE_DATE");
				Date entDate = rs.getDate("ENT_DATE");
				char entYn = rs.getString("ENT_YN").charAt(0);
						
				// rs.getChar()는 존재하지 않음
				// 왜? 자바에서는 문자 하나(char) 개념이 있지만
				//     DB에서는 오로지 문자열 개념만 존재 함.
				// -> String.charAt(0) 을 이용함
				
				// 얻어온 컬럼 값으로 객체 생성 후 초기화
				Employee emp = new Employee(empId, empName, empNo, email, phone, 
											deptCode, jobCode, salLevel, salary, 
											bonus, managerId, hireDate, entDate, entYn);
				
				// empList에 추가
				empList.add(emp);
				
			}
			
			
		} catch(Exception e) {
			// Exception : 모든 예외의 최상위 부모
			// -> try에서 발생하는 모든 예외를 잡아서 처리
			e.printStackTrace();
		
		} finally {
			// 7) 사용한 JDBC 자원 반환(close)
			// -> 이 때 생성 역순으로 반환하는게 좋다!
			
			try {
				if(rs != null) 	 rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		// 8) List 호출부로 반환
		return empList;
	}



	/** 사번으로 사원 정보 조회 DAO
	 * @param input
	 * @return emp
	 */
	public Employee selectOne(int input) {
		
		Employee emp = null; // 결과 저장용 변수
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 메모리 로드
			
			// 커넥션 생성에 필요한 값 준비
			String type = "jdbc:oracle:thin:@"; // 오라클 드라이버 타입
			String ip = "115.90.212.22"; // 접속할 아이피
			String port = ":20000"; // 개인컴퓨터는 1521 or 1522
			String sid = ":xe"; // 접속할 DB 이름
			String user = "bdh"; // 사용자 계정 명
			String pw = "bdh1234"; // 사용자 계정 비밀번호
			
			// 커넥션 생성
			conn = DriverManager.getConnection(type + ip + port + sid,  user  ,   pw);
			
			// SQL 준비
			String sql = "SELECT * FROM EMPLOYEE2 WHERE EMP_ID = " + input;
			
			// Statement 생성
			stmt = conn.createStatement();
			
			// SQL 수행 후 결과 반환 받기
			rs = stmt.executeQuery(sql);
			
			// 조회 결과가 있다면 1행 밖에 나오지 않으므로
			// while 대신 if문을 사용한다
			if(rs.next()) {
				// 조회 결과가 있으면 rs.next() == true --> if문 수행
				
				// 조회 결과가 없으면 rs.next() == false  --> if문 수행 x --> Employee 객체 생성X
				
				int empId = rs.getInt("EMP_ID"); // 현재 행의 EMP_ID 컬럼 값을 int 자료형으로 얻어옴
				String empName = rs.getString("EMP_NAME");
				String empNo = rs.getString("EMP_NO");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String deptCode = rs.getString("DEPT_CODE");
				String jobCode = rs.getString("JOB_CODE");
				String salLevel = rs.getString("SAL_LEVEL");
				int salary = rs.getInt("SALARY");
				double bonus = rs.getDouble("BONUS"); // 실수형
				int managerId = rs.getInt("MANAGER_ID");
				Date hireDate = rs.getDate("HIRE_DATE");
				Date entDate = rs.getDate("ENT_DATE");
				char entYn = rs.getString("ENT_YN").charAt(0);
				
				emp = new Employee(empId, empName, empNo, email, phone, 
									deptCode, jobCode, salLevel, salary, 
									bonus, managerId, hireDate, entDate, entYn);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			// 사용한 JDBC 객체 자원 반환(생성 역순)
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
					
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		// 조회 결과 있으면 Employee 객체 주소
		// 없으면 null 반환
		return emp;
	}



	/** 입력 받은 급여 이상으로 받는 모든 직원 조회 DAO
	 * @param input
	 * @return empList
	 */
	public List<Employee> selectSalary(int input) {
		
		List<Employee> empList = new ArrayList<Employee>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 커넥션 생성에 필요한 값 준비
			String type = "jdbc:oracle:thin:@"; // 오라클 드라이버 타입
			String ip = "115.90.212.22"; // 접속할 아이피
			String port = ":20000"; // 개인컴퓨터는 1521 or 1522
			String sid = ":xe"; // 접속할 DB 이름
			String user = "bdh"; // 사용자 계정 명
			String pw = "bdh1234"; // 사용자 계정 비밀번호
			
			// 커넥션 생성
			conn = DriverManager.getConnection(type + ip + port + sid,  user  ,   pw);
			
			String sql = "SELECT * FROM EMPLOYEE2 WHERE SALARY >= " + input;
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int empId = rs.getInt("EMP_ID"); // 현재 행의 EMP_ID 컬럼 값을 int 자료형으로 얻어옴
				String empName = rs.getString("EMP_NAME");
				String empNo = rs.getString("EMP_NO");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String deptCode = rs.getString("DEPT_CODE");
				String jobCode = rs.getString("JOB_CODE");
				String salLevel = rs.getString("SAL_LEVEL");
				int salary = rs.getInt("SALARY");
				double bonus = rs.getDouble("BONUS"); // 실수형
				int managerId = rs.getInt("MANAGER_ID");
				Date hireDate = rs.getDate("HIRE_DATE");
				Date entDate = rs.getDate("ENT_DATE");
				char entYn = rs.getString("ENT_YN").charAt(0);
				
				Employee emp = new Employee(empId, empName, empNo, email, phone, 
									deptCode, jobCode, salLevel, salary, 
									bonus, managerId, hireDate, entDate, entYn);
				
				empList.add(emp);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return empList;
	}



	/** 새로운 사원 정보 추가 DAO
	 * @param emp
	 * @return result
	 */
	public int insertEmployee(Employee emp) {
		
		int result = 0; // 결과 저장용 변수
		
		try {
			// 오라클 JDBC 드라이버 메모리 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 커넥션 생성에 필요한 값 준비
			String type = "jdbc:oracle:thin:@"; // 오라클 드라이버 타입
			String ip = "115.90.212.22"; // 접속할 아이피
			String port = ":20000"; // 개인컴퓨터는 1521 or 1522
			String sid = ":xe"; // 접속할 DB 이름
			String user = "bdh"; // 사용자 계정 명
			String pw = "bdh1234"; // 사용자 계정 비밀번호
			
			// 커넥션 생성
			conn = DriverManager.getConnection(type + ip + port + sid,  user  ,   pw);
			
			// SQL 작성
			String sql = "INSERT INTO EMPLOYEE2 VALUES(?, ?, ?, ?, ?, ?, ?, 'S5', ?, ?, 200, SYSDATE, NULL, 'N')";
						// ? 기호 == 위치 홀더
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return result;
	}
	
	
	
	

}
