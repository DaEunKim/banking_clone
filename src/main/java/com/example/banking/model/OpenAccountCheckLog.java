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

}
