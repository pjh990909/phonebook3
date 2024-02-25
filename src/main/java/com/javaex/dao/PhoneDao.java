package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.PersonVo;

public class PhoneDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/web_db";
	private String id = "web";
	private String pw = "web";

	// 메소드- 일반

	private void getConnection() {
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver); // 위에 생성자로 올려주고 변수명으로 넣어줌

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}

	} // getConnection()끝

	private void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	} // getConnection()끝
	
	
	
	
	
	// 전체 가져오기
	public List<PersonVo> personSelect() {

		List<PersonVo> personList = new ArrayList<PersonVo>();

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/phone_db";
			conn = DriverManager.getConnection(url, "phone", "phone");
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " select person_id, ";
			query += "		  name, ";
			query += "		  hp, ";
			query += "		  company ";
			query += " from person ";

			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();

			// 4.결과처리

			while (rs.next()) {
				int personId = rs.getInt("person_id");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String company = rs.getString("company");

				PersonVo personVo = new PersonVo(personId, name, hp, company);
				personList.add(personVo);

				/* System.out.println(personVo); */

			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
		return personList;
	}

	// 등록
	public int personInsert(PersonVo personVo) {

		int count = -1;

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/phone_db";
			conn = DriverManager.getConnection(url, "phone", "phone");

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " INSERT INTO person ";
			query += " VALUES (null,?, ?, ?) ";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, personVo.getName());
			pstmt.setString(2, personVo.getHp());
			pstmt.setString(3, personVo.getCompany());

			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건이 등록되었습니다.");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
		return count;
	}

	// 삭제
	public int personDelete(int no) {
		int count = -1;

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/phone_db";
			conn = DriverManager.getConnection(url, "phone", "phone");
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " delete from person ";
			query += "where person_id = ?";
			// 4.결과처리
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			// 실행
			count = pstmt.executeUpdate();

			System.out.println(no + "건이 삭제되었습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
		return count;
	}

	public int personUpdate(PersonVo personVo) {

		int count = -1;

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/phone_db";
			conn = DriverManager.getConnection(url, "phone", "phone");

			// 3. SQL문 준비 / 바인딩 / 실행

			String query = "";
			query += " update person ";
			query += " set name = ? , ";
			query += " 	   hp = ?, ";
			query += "     company = ? ";
			query += " where person_id = ? ";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, personVo.getName());
			pstmt.setString(2, personVo.getHp());
			pstmt.setString(3, personVo.getCompany());
			pstmt.setInt(4, personVo.getPersonId());

			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건이 수정되었습니다.");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
		return count;
	}
	
	public PersonVo personSelectOne(PersonVo personVo) {
		PersonVo personList = null;

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " select person_id, ";
			query += " 		 name, ";
			query += " 		 hp, ";
			query += " 		 company, ";
			query += " from person ";
			query += " where person_id = ? ";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, personVo.getPersonId());
			

			rs = pstmt.executeQuery();
			// 4.결과처리
			while (rs.next()) {
				int personId = rs.getInt("personId");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String company = rs.getString("company");
				personList = new PersonVo();
				personList.setPersonId(personId);
				personList.setName(name);
				personList.setHp(hp);
				personList.setCompany(company);

			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		this.close();
		return personList;
	}
	
	
	
	
	
}
