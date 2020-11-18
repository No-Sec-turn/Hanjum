package com.hanjum.contract.service;



import java.sql.Connection;
import java.util.ArrayList;

import com.hanjum.contract.dao.ContractDAO;
import com.hanjum.contract.vo.ContractBean;

import static com.hanjum.db.JdbcUtil.*;



public class ContractListService {
	
	public static ArrayList<ContractBean> getListCount() throws Exception{
		
		ArrayList<ContractBean> contractList = null;
		
		// 1. 공통 Connetion 객체 가져오기
		Connection con = getConnection();
		System.out.println("1번");
		// 2.(공통) BoardDAO 객체 가져오기
		ContractDAO CDAO = ContractDAO.getinstance();
		System.out.println("2");		
				
		// 3.(공통) BoardDAO 객체에 Connection 객체 전달
		CDAO.setConnection(con);
		System.out.println("3");
		//4단계
		contractList = CDAO.selectContractList();
		System.out.println("4");
		close(con);
		System.out.println("5");
		System.out.println("객체요" + contractList);
		return contractList;
	}
}
