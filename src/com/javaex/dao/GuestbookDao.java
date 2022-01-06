package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.GuestbookVo;

public class GuestbookDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "webdb";
	private String pw = "webdb";

	private void getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	private void close() {
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

	public List<GuestbookVo> getList() {
		List<GuestbookVo> guestbookList = new ArrayList<GuestbookVo>();
		getConnection();
		try {
			String query = "";
			query += " select no , ";
			query += " 		 name, ";
			query += " 		 password, ";
			query += "        content, ";
			query += " 		 to_char(reg_date,'yyyy-mm-dd hh:mi:ss') reg_date ";
			query += " from guestbook ";
			query += " order by reg_date desc ";

			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String content = rs.getString("content");
				String regDate = rs.getString("reg_date");

				GuestbookVo guestbookVo = new GuestbookVo(no, name, password, content, regDate);
				guestbookList.add(guestbookVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();

		return guestbookList;
	}// getList()끝

	// getInsert
	public int guestbookInsert(GuestbookVo vo) {
		int count = 0;
		this.getConnection();

		try {
			String query = "";
			query += "insert into guestbook ";
			query += " values(seq_guestbook_no.nextval, ?, ?, ?, sysdate)";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getContent());
			

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error: " + e);
		}

		this.close();
		return count;
	}//get insert end
	
	// 사람 삭제
			public int guestbookDelete(int no,String password ) {
				int count = 0;
				getConnection();

				try {
					// 3. SQL문 준비 / 바인딩 / 실행
					String query = ""; // 쿼리문 문자열만들기, ? 주의
					query += " delete from guestbook ";
					query += " where password = ?";
					query += "and no=?";
					pstmt = conn.prepareStatement(query); // 쿼리로 만들기

					pstmt.setString(1, password);// ?(물음표) 중 1번째, 순서중요
					pstmt.setInt(2, no);// ?(물음표) 중 1번째, 순서중요
					
					count = pstmt.executeUpdate(); // 쿼리문 실행

					// 4.결과처리
					// System.out.println(count + "건 삭제되었습니다.");

				} catch (SQLException e) {
					System.out.println("error:" + e);
				}

				close();
				return count;
			}
}