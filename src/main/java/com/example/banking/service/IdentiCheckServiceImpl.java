package com.example.banking.service;

import com.example.banking.dao.ApiDaoImpl;
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
 * @Description : 신분증 인증 구현 서비스 구현체
 */
@Service
public class IdentiCheckServiceImpl implements IdentiCheckService{
	@Autowired
	private ApiDaoImpl apiDao;

	@Override
	public String selectName(MemberInfo memberInfo) {
		return apiDao.selectName(memberInfo);
	}
	@Override
	public List<MemberInfo> selectAllMemberInfo(){

		return apiDao.selectAllMemberInfo();
	}

	@Override
	public List<SetAccountProcess> selectAllSetAccountProcess() {
		return apiDao.selectAllSetAccountProcess();
	}

	@Override
	public List<OpenAccountCheckLog> selectAllAccountLog() {
		return apiDao.selectAllAccountLog();
	}

	@Override
	public int insertMemberInfo(MemberInfo memberInfo){
		return apiDao.insertMemberInfo(memberInfo);
	}

	@Override
	public int updateIdCardImg(MemberInfo memberInfo) {

		return apiDao.updateIdCardImg(memberInfo);
	}

	@Override
	public int updateIdCardInfo(MemberInfo memberInfo) {
		return apiDao.updateIdCardInfo(memberInfo);
	}

	@Override
	public String insertLog(OpenAccountCheckLog openAccountCheckLog, SetAccountProcess setAccountProcess){
		Date now = new Date();
		openAccountCheckLog.setSET_ACCOUNT_PROCESS_PK(1);
		openAccountCheckLog.setSTAGE_TYPE("identi");
		openAccountCheckLog.setSTAGE_STATUE("error");
		openAccountCheckLog.setLOG_DATETIME(now);
		setAccountProcess.setIDENTI_CHECK("N");

		apiDao.insertIdentiErrorLog(openAccountCheckLog);
		return setAccountProcess.getIDENTI_CHECK();
	}


}
