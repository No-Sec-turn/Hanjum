package com.hanjum.contract.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static com.hanjum.db.JdbcUtil.*;

import com.hanjum.contract.vo.ContractBean;

public class ContractDAO {

	private ContractDAO() {}
	
	private static ContractDAO instance = new ContractDAO();
	
	public static ContractDAO getinstance() {
		return instance;
	}
	
	Connection con;
	
	public  void setConnection(Connection con) {
		this.con = con;
		
	}
	
	

	public ArrayList<ContractBean> selectContractList(){
		
		ArrayList<ContractBean> contractList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			System.out.println("SQL문 앞");
			String sql = "select * from contract;";
			System.out.println("SQL문 뒤");
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			contractList = new ArrayList<ContractBean>();
			
			while(rs.next()) {
				ContractBean cb = new ContractBean();
				
				
				cb.setContract_id(rs.getInt("contract_id"));
				cb.setContract_creator(rs.getString("contract_creator"));
				cb.setContract_editor(rs.getString("contract_editor"));
				cb.setContract_begin_date(rs.getTimestamp("contract_begin_date"));
				cb.setContract_end_date(rs.getTimestamp("contract_end_date"));
				cb.setContract_price(rs.getInt("contract_price"));
				cb.setContract_status(rs.getInt("contract_status"));
				cb.setBoard_id(rs.getInt("board_id"));
				
				contractList.add(cb);
			}
		} catch (Exception e) {
			System.out.println("selectContractList - 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		
		
		return contractList;
		
		
	}
	
}

