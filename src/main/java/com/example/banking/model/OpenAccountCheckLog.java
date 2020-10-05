package com.example.banking.model;

import lombok.Data;

import java.util.Date;

/**
 * @author : DaEunKim
 * @version : 2020.09.20
 * @Description : OPEN_ACCOUNT_CHECK_LOG 테이블 데이터
 */
@Data
public class OpenAccountCheckLog {
	private Integer index;
	private Integer set_account_process_PK;
	private String type;
	private String status;
	private Date datetime;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getSet_account_process_PK() {
		return set_account_process_PK;
	}

	public void setSet_account_process_PK(Integer set_account_process_PK) {
		this.set_account_process_PK = set_account_process_PK;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}
