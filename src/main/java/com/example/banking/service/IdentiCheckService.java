package com.example.banking.service;

import com.example.banking.dao.ApiDao;
import com.example.banking.model.MemberInfo;
import com.example.banking.model.OpenAccountCheckLog;
import com.example.banking.model.SetAccountProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

/**
 * @author : DaEunKim
 * @version : 2020.09.11
 * @Description : 신분증 인증 구현 서비스
 */
@Service
public class IdentiCheckService {
	@Autowired
	private ApiDao apiDao;

	public String selectName(MemberInfo memberInfo) {
		return apiDao.selectName(memberInfo);
	}

	public List<MemberInfo> selectAll(){

		return apiDao.selectAll();
	}
	public int insertMemberInfo(MemberInfo memberInfo){
		return apiDao.insertMemberInfo(memberInfo);
	}

	public int updateIdCardImg(MemberInfo memberInfo) {

		return apiDao.updateIdCardImg(memberInfo);
	}

	public int updateIdCardInfo(MemberInfo memberInfo) {
		return apiDao.updateIdCardInfo(memberInfo);
	}

	public String insertLog(OpenAccountCheckLog openAccountCheckLog, SetAccountProcess setAccountProcess){
		Date now = new Date();
		openAccountCheckLog.setSet_account_process_PK(1);
		openAccountCheckLog.setType("identi");
		openAccountCheckLog.setStatus("error");
		openAccountCheckLog.setDatetime(now);
		setAccountProcess.setIdenti_check("N");

		apiDao.insertIdentiErrorLog(openAccountCheckLog);
		return setAccountProcess.getIdenti_check();
	}

}
