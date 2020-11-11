package com.hanjum.vo;

public class Constant {
	public static final int BOARD_PAGE_SIZE = 20; // 게시물 한 페이지에 담을 갯수
	public static final int REVIEW_PAGE_SIZE = 10; // 리뷰 한 페이지에 담을 갯수
	public static final int CONTRACT_PAGE_SIZE = 10; // 계약성사된 프로젝트 한 페이지에 담을 갯수
	public static final int LIKEUSER_PAGE_SIZE = 5; // 좋아요 한 유저의 리스트 담을 갯수
	public static final int ADMIN_USER_PAGE_SIZE = 20; // 회원관리페이지에 회원 리스트 담을 갯수

	public static final String arrMsg = "<script> "
			+ "alert('작성에 실패했습니다. 계속 실패 시 관리자에게 문의해주십시오.'); "
			+ "history.back();"
			+ "</script>";
}
