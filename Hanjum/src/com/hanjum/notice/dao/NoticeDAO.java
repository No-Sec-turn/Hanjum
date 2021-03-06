package com.hanjum.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hanjum.notice.db.jdbcUtil;
import com.hanjum.notice.vo.NoticeBean;

public class NoticeDAO {

	// Singleton Pattern
	
	// 외부에서 인스턴트 생성 불가능 하도록 private
	private NoticeDAO() {};
	
	// private 으로 설정해서 외부에서 접근 불가능
	// 생성자를 리턴하는 getInstance()에서 멤버변수에 접근 가능하도록 static으로 지정
	private static NoticeDAO instance =  new NoticeDAO();
	
	// 생성된 instance를 외부로 리턴하기위해 Getter -> getInstance() 정의
	// 외부에 인스턴스 생성없이 접근 가능하도록 static으로 정의
	public static NoticeDAO getInstance() {
		return instance;
	}
	
//---------------------------------------------------------------------------
	
	Connection con; // Connection 객체를 전달받아 저장할 멤버변수
	
	// Service 클래스로부터 Connection 객체를 전달받아 멤버변수에 저장하는 메서드
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	// ******GET******
	// 클릭한 크리에이터에게 알람이 가는 메서드
	public int getNotice(String user_id, String notice_from_id) {
		int alert = 0; // 
		
		
		
		
		
		return alert;
	}
	
	public ArrayList<NoticeBean> getNoticeList(NoticeBean noticeBean) {
		ArrayList<NoticeBean> nb = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			jdbcUtil.getConnection();
			
			sql = "select * from notice order by notice_date";
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
		
			while(rs.next()) {
				NoticeBean notice = new NoticeBean();
				notice.setBoard_id(rs.getInt("board_id"));
				notice.setNotice_content(rs.getString("notice_content"));
				notice.setNotice_date(rs.getTimestamp("notice_date"));
				notice.setNotice_from_id(rs.getString("notice_from_id"));
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setNotice_read(rs.getInt("notice_read"));
				notice.setNotice_url(rs.getString("notice_url"));
				notice.setUser_id(rs.getString("user_id"));
				
				nb.add(notice);
				
			}
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			jdbcUtil.close(con);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(rs);
		}
		
		return nb;
	}

	
	// ******UPDATE******
	public void updateStatus(int alert) {
		// 수락 : 상태가 진행 중으로 변하고 채팅창열림
		// 거절 : notice_from_id 에게 거절당했다고 알람보냄
		// 수락/거절 둘 다 안 할 경우 : 알람 계속 떠있??????
		
		
	}
	
	

}































