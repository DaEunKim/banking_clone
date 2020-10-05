package com.example.banking.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

/**
 * @author : DaEunKim
 * @version : 2020.09.11
 * @Description : Member_Info 테이블 데이터
 */

@Data
public class MemberInfo {
	private Integer index;
	private String user_id;
	private String user_name;
	private String account_num;
	private String account_pw;
	private String idcard_img;
	private String idcard_user_name;
	private String regis_num;
	private String idcard_num;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date idcard_reg_day;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getAccount_num() {
		return account_num;
	}

	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}

	public String getAccount_pw() {
		return account_pw;
	}

	public void setAccount_pw(String account_pw) {
		this.account_pw = account_pw;
	}

	public String getIdcard_img() {
		return idcard_img;
	}

	public void setIdcard_img(String idcard_img) {
		this.idcard_img = idcard_img;
	}

	public String getIdcard_user_name() {
		return idcard_user_name;
	}

	public void setIdcard_user_name(String idcard_user_name) {
		this.idcard_user_name = idcard_user_name;
	}

	public String getRegis_num() {
		return regis_num;
	}

	public void setRegis_num(String regis_num) {
		this.regis_num = regis_num;
	}

	public String getIdcard_num() {
		return idcard_num;
	}

	public void setIdcard_num(String idcard_num) {
		this.idcard_num = idcard_num;
	}

	public Date getIdcard_reg_day() {
		return idcard_reg_day;
	}

	public void setIdcard_reg_day(Date idcard_reg_day) {
		this.idcard_reg_day = idcard_reg_day;
	}
}
