package ex0923;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.net.httpserver.Authenticator.Result;

public class memberDAO {// JDBC관련 일 처리, dao : Database Access Object
	                    // 데이터베이스 접근을 관리하는 우리가 설계한 객체

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	private void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "hr";
			String db_pw = "hr";

			conn = DriverManager.getConnection(db_url, db_id, db_pw);
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {		
			e.printStackTrace();
		}

		
	}
	
	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public int join(memberVO vo) {
		getConn();
		int cnt = 0;

//		Connection conn = null;
//		PreparedStatement psmt = null;

		// JDBC
		// 0. 프로젝트 안에 드라이브 파일 넣기 (한번만 넣어주면 된다)
		// 1. 드라이버 로딩(동적 로딩)
		// - 어떠한 DBMS의 드라이버를 사용할지 명시(드라이버의 경로 명시)
		//
		try { // 내가 실행할 문장
//			Class.forName("oracle.jdbc.driver.OracleDriver");// 오라클 드라이버의 경로(외울 필요 X) -> 드라이브 동적 로딩
//			// 2. 커넥션 연결
//			// 드라이버를 통해서 DB URL(주소), DB ID, DB PW 보내 커넥션을 연결한다
//			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String db_id = "hr";
//			String db_pw = "hr";
//
//			conn = DriverManager.getConnection(db_url, db_id, db_pw);
			// 3. SQL문 실행
			String sql = "insert into big_member values(?, ?, ?, ?)";// (1, 2, 3, 4)
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getNick());
			psmt.setString(4, vo.getPhone());

			cnt = psmt.executeUpdate();// 성공 여부를 cnt에 담아준다(성공 :1 , 실패 : 0)
										// select 빼고는 다 executeUpdate

		
//		catch (ClassNotFoundException e) { // 예외 상황 처리
//			e.printStackTrace();  		} 
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			// 4. 연결 종료
//			// -> 연결 종료는 역순으로 수행한다.
//			try {
//				if (psmt != null) {// psmt가 잘 생설 되었을때만 닫아주겠다
//					psmt.close();
//				}
//
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			close();

		}

		return cnt;
	}

	public memberVO login(memberVO vo) {
		memberVO info = null;
		// JDBC 기능을 수행
		getConn();
		
		try {
			String sql = "select * from big_member where id=? and pw=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());// ?에 들어갈 값을 채워줌
			psmt.setString(2, vo.getPw());
			rs = psmt.executeQuery();// Result Set 화살표(->)가 맨처음 컬럼을 가리킨다
										// 밑에 데이터가 있으면 한칸 아래로 내려올 수 있다.
										// 로그인 성공
			if (rs.next()) {// 커서(->) 내릴 수 있으면 true, 없으면 false
//				String id = rs.getString(1);
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String nick = rs.getString("nick");
				String phone = rs.getString("phone");

				info = new memberVO(id, pw, nick, phone);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return info;
	}

	public int update(memberVO vo) {
		getConn();//getConn() 호출
		int cnt = 0;

		try {
			String sql = "update big_member set pw=?, nick=?, phone=? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(4, vo.getId());
			psmt.setString(1, vo.getPw());
			psmt.setString(2, vo.getNick());
			psmt.setString(3, vo.getPhone());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	public ArrayList<memberVO> selectAll() {
		//모든 회원의 정보를 되돌려 주는 기능
		ArrayList<memberVO> list = new ArrayList<memberVO>();
		
		getConn();
		
		String sql = "select * from big_member";
		try {
			psmt = conn.prepareStatement(sql);
			// 내가 따로 채워줄 물음표가 있는지 확인
			
			// insert, delete, update ---> executeUpdate
			
			// select ---> excuteQuery
			
			rs = psmt.executeQuery();
			//ResultSet
			//결과를 테이블과 같은 형태로 가지고 있는 객체
			
			
			
			while(rs.next()) {
				String id = rs.getNString("id");
				String pw = rs.getNString("pw");
				String nick = rs.getNString("nick");
				String phone = rs.getNString("phone");
				
				memberVO vo = new memberVO(id, pw, nick, phone);
				list.add(vo);
				
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		
		
		
		return list;
	}

	public int delete(memberVO vo) {
		getConn();//getConn() 호출
		int cnt = 0;
		String sql = "delete big_member where id=? and pw=?";
		try {
						
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());// ?에 들어갈 값을 채워줌
			psmt.setString(2, vo.getPw());
			
			//************다시 sql구문 담지 말기
			cnt = psmt.executeUpdate();
			// -> 영향을 받은 행의 개수를 의미
			
			
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		
		
		
		return cnt;
	}

}
