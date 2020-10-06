package com.example.banking.dao;

import com.example.banking.model.MemberInfo;
import com.example.banking.model.OpenAccountCheckLog;
import com.example.banking.model.SetAccountProcess;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author : DaEunKim
 * @version : 2020.09.19
 * @Description : Mapper 연결을 위한 DAO 구현체
 */
@Repository
public class ApiDaoImpl implements ApiDao{
	protected static final String NAMESPACE = "com.example.banking.dao.";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public String selectName(MemberInfo memberInfo) {
		return sqlSession.selectOne(NAMESPACE + "selectName", memberInfo);
	}
	@Override
	public List<MemberInfo> selectAllMemberInfo(){
		return sqlSession.selectList(NAMESPACE + "selectAllMemberInfo");
	}

	@Override
	public List<SetAccountProcess> selectAllSetAccountProcess() {
		return sqlSession.selectList(NAMESPACE + "selectAllSetAccountProcess");
	}

	@Override
	public List<OpenAccountCheckLog> selectAllAccountLog() {
		return sqlSession.selectList(NAMESPACE + "selectAllAccountLog");
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
