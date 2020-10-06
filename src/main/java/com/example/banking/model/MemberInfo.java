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


}
