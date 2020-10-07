package com.example.banking.service;

import com.example.banking.dao.ApiDao;

import com.example.banking.model.MemberInfo;
import com.example.banking.model.OpenAccountCheckLog;
import com.example.banking.model.SetAccountProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author : DaEunKim
 * @version : 2020.09.11
 * @Description : 신분증 인증 구현 서비스 구현체
 */
@Service
public class IdentiCheckServiceImpl implements IdentiCheckService{
	@Autowired
	private ApiDao apiDao;

	/** @Description : MEMBER_INFO 테이블 데이터 확인 함수 */
	@Override
	public List<MemberInfo> selectAllMemberInfo(){ return apiDao.selectAllMemberInfo(); }

	/** @Description : SET_ACCOUNT_PROCESS 테이블 데이터 확인 함수 */
	@Override
	public List<SetAccountProcess> selectAllSetAccountProcess() {
		return apiDao.selectAllSetAccountProcess();
	}

	/** @Description : OPEN_ACCOUNT_CHECK_LOG 테이블 데이터 확인 함수 */
	@Override
	public List<OpenAccountCheckLog> selectAllAccountLog() {
		return apiDao.selectAllAccountLog();
	}


	/** @Description : 고객 정보 확인 함수  */
	@Override
	public MemberInfo selectCheckName(String mobileUserInfo ) {
		return apiDao.selectCheckName(mobileUserInfo);
	}
	/** @Description : 계좌 개설 과정 확인 함수  */
	@Override
	public SetAccountProcess selectAccountProcess(Integer userInfoPK) {
		return apiDao.selectAccountProcess(userInfoPK);
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
//		Date now = new Date();
//		openAccountCheckLog.setSET_ACCOUNT_PROCESS_PK(1);
//		openAccountCheckLog.setSTAGE_TYPE("identi");
//		openAccountCheckLog.setSTAGE_STATUE("error");
//		openAccountCheckLog.setLOG_DATETIME(now);
//		setAccountProcess.setIDENTI_CHECK("N");
//
//		apiDao.insertIdentiErrorLog(openAccountCheckLog);
		return setAccountProcess.getIDENTI_CHECK();
	}


	/** @Description : 신분증 정보 일치 여부 update 함수  */
	@Override
	public int updateIdentiCheck(SetAccountProcess setAccountProcess) {
		return apiDao.updateIdentiCheck(setAccountProcess);
	}

	/** @Description : 계좌 개설 과정 로그 정보 insert 함수  */
	@Override
	public int insertIdentiLog(OpenAccountCheckLog openAccountCheckLog) {
		return apiDao.insertIdentiLog(openAccountCheckLog);
	}


}
