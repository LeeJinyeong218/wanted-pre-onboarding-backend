# wanted-pre-onboarding-backend
원티드 프리온보딩 백엔드 인턴십 선발과제

[설계 문서](https://docs.google.com/document/d/1t4Guwm2BuQKQArTptHbHX3W-QVVPPk49jhFK1Ipskko/edit?usp=sharing)


## 요구사항
1. 채용 공고를 등록합니다.
2. 채용 공고를 수정합니다.
3. 채용 공고를 삭제합니다.
4. 채용 공고 목록을 가져옵니다.
   4-1. 채용 공고를 리스트로 확인
   4-2. 채용 공고 검색 기능 구현(추가 구현)
7. 채용 공고 상세 페이지를 가져옵니다.
8. 사용자는 채용 공고에 지원합니다.(추가 구현) -> 1회만 지원 가능


## 사용자 별 기능 정리
### 공통
* 회원가입(+)

  별도의 페이지 userSignup에서 id(아이디), password(비밀번호), name(이름), self_intro(자기소개)를 입력받아 데이터베이스에 저장
* 공고 목록 불러오기

  처음 페이지 Home에서 공고 목록을 불러옴

  JobPostingId(Primary Key)에 대해 내림차순으로 불러와 최신순으로 나열
* 공고 검색하기(+)

  처음 페이지 Home에서 검색 창에 키워드를 치고 버튼 click

  별도의 페이지 jobPostingSearch에서 검색 결과를 JobPostingId(Primary Key)에 대해 내림차순으로 불러와 최신순으로 나열
* 공고 상세페이지 보기

  공고 리스트 요소를 클릭 시 상세 페이지 jobPostingDetail로 넘어감

  개인 로그인이 되어있는 경우 지원하기 버튼 활성화

  회사 로그인이 되어있고 공고를 올린 회사인 경우(editable) 수정, 삭제, 지원자 보기 버튼 활성화
### 지원자
* 개인 로그인(+)

  별도의 페이지 userLogin에서 id(아이디), password(비밀번호)를 입력받아 데이터베이스에서 확인 뒤 성공 시 세션에 user_id, id 저장
* 공고 지원하기 (공고 당 1회 제한) (+)

  개인 로그인이 되어있다면 공고 상세페이지에서 지원 가능

  공고에 지원이 되어있다면 지원하기를 눌러도 1회로 계산
* 지원한 공고 보기(+)

  처음 페이지 Home에서 개인 로그인 시 지원한 공고 보기 링크 활성화

  지원한 공고를 JobPostingId(Primary Key)에 대해 내림차순으로 나열
### 회사
* 회사 로그인(+)

  별도의 페이지 companyLogin에서 id(아이디), password(비밀번호)를 입력받아 데이터베이스에서 확인 뒤 성공 시 세션에 company_id, id 저장
* 공고 추가하기

  처음 페이지 Home에서 회사 로그인 시 공고 추가하기 링크 활성화

  페이지 jobPostingWrite에서 recruitment_compensation(채용보상금), title(제목), position(포지션), content(내용), required_skill(요구 기술)을 입력받아 company_id와 합쳐 데이터베이스에 저장
* 공고 수정하기

  공고 상세 페이지에서 회사 로그인이 되어있다면 세션을 통해 확인, editable로 수정 버튼 활성화

  수정 버튼 클릭 시 수정 페이지 JobPostingEdit로 이동

  입력 값 수정 뒤 수정 완료 시 데이터베이스에 기존 jobPostingId로 저장
* 공고 삭제하기

  공고 상세 페이지에서 회사 로그인이 되어있다면 세션을 통해 확인, editable로 삭제 버튼 활성화

  삭제 버튼 클릭 시 데이터베이스에서 해당 공고 삭제

  처음 페이지 Home으로 이동
* 지원한 지원자 보기(+)

  공고 상세 페이지에서 지원자 보기 링크를 통해 가능

  지원자들의 정보 리스트 확인

# 데이터베이스 설계
![설계 이미지](https://github.com/LeeJinyeong218/wanted-pre-onboarding-backend/assets/130944003/b4ddad24-3a00-4e53-9912-4408adf61c57)

application.properties
```
server.port=8080
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/PRE_ONBOARDING_BACKEND
```

# 사용
Intellij, DataGrip, Docker, Java Spring, HTML, JQuery, Thymeleaf, MySQL, JPA
