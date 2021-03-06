package com.example.banking.dao;

import com.example.banking.model.MemberInfo;
import com.example.banking.model.OpenAccountCheckLog;
import com.example.banking.model.SetAccountProcess;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author : DaEunKim
 * @version : 2020.09.19
 * @Description : Mapper 연결을 위한 DAO
 */
@Repository
public class ApiDaoImpl implements ApiDao{
	protected static final String NAMESPACE = "com.example.banking.dao.";

	@Autowired
	private SqlSession sqlSession;

	/** @Description : MEMBER_INFO 테이블 데이터 확인 함수 */
	@Override
	public List<MemberInfo> selectAllMemberInfo(){
		return sqlSession.selectList(NAMESPACE + "selectAllMemberInfo");
	}
	/** @Description : SET_ACCOUNT_PROCESS 테이블 데이터 확인 함수 */
	@Override
	public List<SetAccountProcess> selectAllSetAccountProcess() {
		return sqlSession.selectList(NAMESPACE + "selectAllSetAccountProcess");
	}
	/** @Description : OPEN_ACCOUNT_CHECK_LOG 테이블 데이터 확인 함수 */
	@Override
	public List<OpenAccountCheckLog> selectAllAccountLog() {
		return sqlSession.selectList(NAMESPACE + "selectAllAccountLog");
	}

	/** @Description : 고객 정보 확인 함수  */
	@Override
	public MemberInfo selectCheckName(String mobileUserInfo) {
		return sqlSession.selectOne(NAMESPACE + "selectCheckName", mobileUserInfo);
	}
	/** @Description : 계좌 개설 과정 확인 함수  */
	@Override
	public SetAccountProcess selectAccountProcess(Integer userInfoPK) {
		return sqlSession.selectOne("selectAccountProcess", userInfoPK);
	}

	/** @Description : 신분증 정보 일치 여부 update 함수  */
	@Override
	public int updateIdentiCheck(SetAccountProcess setAccountProcess) {
		return sqlSession.update("updateIdentiCheck", setAccountProcess);
	}
	/** @Description : 계좌 개설 과정 로그 정보 insert 함수  */
	@Override
	public int insertIdentiLog(OpenAccountCheckLog openAccountCheckLog) {
		return sqlSession.insert("insertIdentiLog", openAccountCheckLog);
	}


	@Override
	public int insertMemberInfo(MemberInfo memberInfo){
		return sqlSession.insert(NAMESPACE + "insertMemberInfo", memberInfo);
	}

	@Override
	public int updateIdCardImg(MemberInfo memberInfo) {
		return sqlSession.update(NAMESPACE+"updateIdCardImg", memberInfo);
	}

	@Override
	public int updateIdCardInfo(MemberInfo memberInfo) {
		return sqlSession.update(NAMESPACE+"updateIdCardInfo", memberInfo);
	}

	@Override
	public int insertIdentiErrorLog(OpenAccountCheckLog openAccountCheckLog) {
		return sqlSession.insert(NAMESPACE+"insertIdentiErrorLog", openAccountCheckLog);
	}


}
