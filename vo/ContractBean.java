package com.hanjum.contract.vo;

import java.sql.Timestamp;

public class ContractBean {
	
	private int contract_id;
	private String contract_creator;
	private String contract_editor;
	private Timestamp contract_begin_date;
	private Timestamp contract_end_date;
	private int contract_price;
	private int contract_status;
	private int board_id;
	
	public int getContract_id() {
		return contract_id;
	}
	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}
	public String getContract_creator() {
		return contract_creator;
	}
	public void setContract_creator(String contract_creator) {
		this.contract_creator = contract_creator;
	}
	public String getContract_editor() {
		return contract_editor;
	}
	public void setContract_editor(String contract_editor) {
		this.contract_editor = contract_editor;
	}
	public Timestamp getContract_begin_date() {
		return contract_begin_date;
	}
	public void setContract_begin_date(Timestamp contract_begin_date) {
		this.contract_begin_date = contract_begin_date;
	}
	public Timestamp getContract_end_date() {
		return contract_end_date;
	}
	public void setContract_end_date(Timestamp contract_end_date) {
		this.contract_end_date = contract_end_date;
	}
	public int getContract_price() {
		return contract_price;
	}
	public void setContract_price(int contract_price) {
		this.contract_price = contract_price;
	}
	public int getContract_status() {
		return contract_status;
	}
	public void setContract_status(int contract_status) {
		this.contract_status = contract_status;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	
	

}
