# banking
# 신분증 인증 단계 구현

개발 환경 : Spring boot, MyBatis, H2, Lombok
자바 기반의 RDBMS이면서 인메모리 기능이 있어서 H2를 사용하였습니다. 
테스트 : Postman 
신분증 인증 단계만을 구현하기 위해 앞 단계에서 필요한 데이터는 임의로 지정, 이후 단계에 필요한 테이블 필드 생략.

구현한 API 목록
1. 모든 유저 데이터 확인 : bankingAPI/selectAll
2. 유저 정보와 신분증 이미지 저장 API : bankingAPI/insertMemberInfo
3. 신분증 분석 정보 비교 API : bankingAPI/updateIdCardInfo
# banking_clone
