<%@page import="com.hanjum.contract.vo.ContractBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
	ArrayList<ContractBean> contractList = (ArrayList<ContractBean>)request.getAttribute("contractList");
	String status=null;
	%>
	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/default.css" rel="stylesheet" type="text/css">
<link href="css/front.css" rel="stylesheet" type="text/css">
<link href="css/manager.css" rel="stylesheet">
<script src="js/jquery-3.5.1.js"></script>
<script src="js/rollingJob.js"></script>
<script src="js/topMenu.js"></script>
<script src="js/manager.js"></script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="inc/top.jsp" />

		<h2>계약 관리</h2>

		<table id="t1">
			<tr>
				<th>검색어</th>
				<td><select>
						<option>게시글 번호</option>
						<option>게시글 명</option>
						<option>편집자 명</option>
						<option>크리에이터 명</option>
				</select> <input type="text" name="search"></td>
			</tr>
			<tr>
				<th>기간</th>

				<td><input type="radio" name="period" id="ra1" value="1" checked="checked"><label for="ra1" class="period_radio">오늘</label>
				<input type="radio" name="period" id="ra2" value="2"><label for="ra2" class="period_radio">어제</label>
				<input type="radio" name="period" id="ra3" value="3"><label for="ra3" class="period_radio">3일</label>
				<input type="radio" name="period" id="ra4" value="4"><label for="ra4" class="period_radio">7일</label> 
				<input type="radio" name="period" id="ra5" value="5"><label for="ra5" class="period_radio">15일</label>
				<input type="radio" name="period" id="ra6" value="6"><label for="ra6" class="period_radio">1개월</label>
				<input type="radio" name="period" id="ra7" value="7"><label for="ra7" class="period_radio">3개월</label>
				<input type="radio" name="period" id="ra8" value="8"><label for="ra8" class="period_radio">6개월</label>
				<input type="date" id="date_begin" name=date_begin value=""> ~ 
				<input type="date" id= "date_end" name=date_end value=""> 
				<input type="radio" name="date_check" value="on"> on 
				<input type="radio" name="date_check" value="off" checked="checked"> off</td>

			</tr>

			<tr>
				<th>지역</th>
				<td><input type="checkbox" name="contract_status" value="서울">서울
					<input type="checkbox" name="contract_status" value="부산">부산
					<input type="checkbox" name="contract_status" value="대구">대구
					<input type="checkbox" name="contract_status" value="대전">대전
					<input type="checkbox" name="contract_status" value="인천">인천
					<input type="checkbox" name="contract_status" value="광주">광주
					<input type="checkbox" name="contract_status" value="울산">울산
					<input type="checkbox" name="contract_status" value="세종">세종
					<input type="checkbox" name="contract_status" value="경기">경기
					<input type="checkbox" name="contract_status" value="강원">강원
					<input type="checkbox" name="contract_status" value="충북">충북
					<input type="checkbox" name="contract_status" value="충남">충남
					<input type="checkbox" name="contract_status" value="경북">경북
					<input type="checkbox" name="contract_status" value="경남">경남
					<input type="checkbox" name="contract_status" value="전북">전북
					<input type="checkbox" name="contract_status" value="전남">전남
					<input type="checkbox" name="contract_status" value="제주">제주</td>
			</tr>
			<tr>
				<th>계약 상태</th>
				<td><input type="checkbox" name="contract_status" value="1">프로젝트착수 대기(입금대기) 
					<input type="checkbox" name="contract_status" value="2">프로젝트진행 중 
					<input type="checkbox" name="contract_status" value="3">프로젝트 완료검토중(컨펌 대기) 
					<input type="checkbox" name="contract_status" value="4">프로젝트 종료(계약금 지급 완료) 
					<input type="checkbox" name="contract_status" value="5">프로젝트 중단</td>
			</tr>
			<tr>
				<th>계약단가 설정</th>
				<td><input type="text" name="contract_payment">원 ~ 
					<input type="text" name="contract_payment">원	</td>
					
			</tr>
				<th>회원 레벨 구분</th>
				<td rowspan="2">
				<input type="text" name="contract_payment" value="1"> ~ 
					<input type="text" name="contract_payment" value="10"> 
				</td>
		</table>
		<input type="button" value="검색" class="bt1"> &nbsp;&nbsp;
		<input type="reset" value="초기화">


		<hr>



		<div id="side">
			<table>
				<tr>
					<th>게시글 번호</th>
					<th>게시글 명</th>
					<th>계약 단가</th>
					<th>크리에이터</th>
					<th>편집자</th>
					<th>지역</th>
					<th>프로젝트 시작일</th>
					<th>프로젝트 종료일</th>
					<th>계약 상태</th>
				</tr>
			<%
			
			for(int i = 0; i < contractList.size(); i++){
			%>
			
			<tr align="center">
			<td><%=contractList.get(i).getBoard_id() %></td>
			<td><%=contractList.get(i).getBoard_ed_subject() %></td>
			<td><%=contractList.get(i).getContract_price() %></td>
			<td><%=contractList.get(i).getContract_creator() %></td>
			<td><%=contractList.get(i).getContract_editor() %></td>
			<td><%=contractList.get(i).getBoard_ed_address() %>  </td>
			<td><%=contractList.get(i).getContract_begin_date() %>
			<td><%=contractList.get(i).getContract_end_date() %>
			
			<% switch(contractList.get(i).getContract_status()){
			 case 1:
				 status = "계약 대기";
				 break;
			 case 2:
				 status = "계약 진행 중";
				 break;
			 case 3:
				 status = "프로젝트 완료";
				 break;
			 case 4:
				 status = "계약 종료";
				 break;
		 	default: 
		 		status = " ?? ";
		 		
			
			}%>
			
			<td><%=status%>
			
			

			
			
		
			
			
			
			
			
			
			
			
			
			</tr> 
				
				
				
				
				
			
			
			
			<%
			
			}	
			%>	
			
				
				
				
				
				
				
			</table>


		</div>









		<jsp:include page="inc/bottom.jsp" />
</body>
</html>