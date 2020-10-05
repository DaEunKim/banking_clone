package com.example.banking.model;

import lombok.Data;

/**
 * @author : DaEunKim
 * @version : 2020.09.21
 * @Description : SET_ACCOUNT_PROCESS 테이블 데이터
 */
@Data
public class SetAccountProcess {
	private Integer index;
	private Integer user_info_pk; // MEMBER_INFO 테이블 pk (유저 정보)
	private Integer last_page; // 마지막 완료 페이지 번호
	private String account_type; // 개설 통장 종류
	private String identi_check; // 신분증 확인 여부 (Y/N)

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getUser_info_pk() {
		return user_info_pk;
	}

	public void setUser_info_pk(Integer user_info_pk) {
		this.user_info_pk = user_info_pk;
	}

	public Integer getLast_page() {
		return last_page;
	}

	public void setLast_page(Integer last_page) {
		this.last_page = last_page;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getIdenti_check() {
		return identi_check;
	}

	public void setIdenti_check(String identi_check) {
		this.identi_check = identi_check;
	}
}
