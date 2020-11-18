package com.hanjum.contract.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjum.action.Action;
import com.hanjum.contract.service.ContractListService;
import com.hanjum.contract.vo.ContractBean;
import com.hanjum.vo.ActionForward;

public class ContractListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("ContractListAction");
		
		
		ActionForward forward = null;
		
		
		ContractListService contractlist = new ContractListService();
		
		ArrayList<ContractBean> contractList = new ArrayList<ContractBean>();
		
		
		contractList = ContractListService.getListCount();
		
		request.setAttribute("contractList", contractList);
		System.out.println("객체:"+ contractList);
		
		System.out.println("ContractListService 객체 생성 완료");
		forward = new ActionForward();
		forward.setPath("/manager.jsp");
		forward.setRedirect(false);  // 디폴트 false 이므로 생략 가능
		
		
		
		return forward;
		
		
	}

}
