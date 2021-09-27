package ex0923;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.net.httpserver.Authenticator.Result;

public class memberDAO {// JDBC���� �� ó��, dao : Database Access Object
	                    // �����ͺ��̽� ������ �����ϴ� �츮�� ������ ��ü

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
		// 0. ������Ʈ �ȿ� ����̺� ���� �ֱ� (�ѹ��� �־��ָ� �ȴ�)
		// 1. ����̹� �ε�(���� �ε�)
		// - ��� DBMS�� ����̹��� ������� ���(����̹��� ��� ���)
		//
		try { // ���� ������ ����
//			Class.forName("oracle.jdbc.driver.OracleDriver");// ����Ŭ ����̹��� ���(�ܿ� �ʿ� X) -> ����̺� ���� �ε�
//			// 2. Ŀ�ؼ� ����
//			// ����̹��� ���ؼ� DB URL(�ּ�), DB ID, DB PW ���� Ŀ�ؼ��� �����Ѵ�
//			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String db_id = "hr";
//			String db_pw = "hr";
//
//			conn = DriverManager.getConnection(db_url, db_id, db_pw);
			// 3. SQL�� ����
			String sql = "insert into big_member values(?, ?, ?, ?)";// (1, 2, 3, 4)
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getNick());
			psmt.setString(4, vo.getPhone());

			cnt = psmt.executeUpdate();// ���� ���θ� cnt�� ����ش�(���� :1 , ���� : 0)
										// select ����� �� executeUpdate

		
//		catch (ClassNotFoundException e) { // ���� ��Ȳ ó��
//			e.printStackTrace();  		} 
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			// 4. ���� ����
//			// -> ���� ����� �������� �����Ѵ�.
//			try {
//				if (psmt != null) {// psmt�� �� ���� �Ǿ������� �ݾ��ְڴ�
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
		// JDBC ����� ����
		getConn();
		
		try {
			String sql = "select * from big_member where id=? and pw=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());// ?�� �� ���� ä����
			psmt.setString(2, vo.getPw());
			rs = psmt.executeQuery();// Result Set ȭ��ǥ(->)�� ��ó�� �÷��� ����Ų��
										// �ؿ� �����Ͱ� ������ ��ĭ �Ʒ��� ������ �� �ִ�.
										// �α��� ����
			if (rs.next()) {// Ŀ��(->) ���� �� ������ true, ������ false
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
		getConn();//getConn() ȣ��
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
		//��� ȸ���� ������ �ǵ��� �ִ� ���
		ArrayList<memberVO> list = new ArrayList<memberVO>();
		
		getConn();
		
		String sql = "select * from big_member";
		try {
			psmt = conn.prepareStatement(sql);
			// ���� ���� ä���� ����ǥ�� �ִ��� Ȯ��
			
			// insert, delete, update ---> executeUpdate
			
			// select ---> excuteQuery
			
			rs = psmt.executeQuery();
			//ResultSet
			//����� ���̺�� ���� ���·� ������ �ִ� ��ü
			
			
			
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
		getConn();//getConn() ȣ��
		int cnt = 0;
		String sql = "delete big_member where id=? and pw=?";
		try {
						
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());// ?�� �� ���� ä����
			psmt.setString(2, vo.getPw());
			
			//************�ٽ� sql���� ���� ����
			cnt = psmt.executeUpdate();
			// -> ������ ���� ���� ������ �ǹ�
			
			
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		
		
		
		return cnt;
	}

}
