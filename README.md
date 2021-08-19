## Summer 🏝
한여름에 Spring 뽀개버리기 (●'◡'●)

### Spring Architecture
> ![layer](https://user-images.githubusercontent.com/20378368/128653677-2b58b2e6-e170-49dd-856b-a0ef417e0f40.png)
#### Web Layer
- 브라우저상의 웹 클라이언트의 요청 및 응답을 처리
- Service Layer와 Repository Layer에서 발생하는 Exception 처리
- 컨트롤러(@Controller), 필터(@Filter), JSP, Freemarker 등의 뷰 템플릿 영역
#### Service Layer
- Web Layer와 Repository Layer를 연결하는 역할로서 트랜잭션과 도메인의 순서 보장
- 서비스(@Service)와 트랜잭션(@Transaction)이 사용되는 영역
#### Repository Layer
- DB와 같은 데이터 저장소에 접근하는 영역
- ORM(Mybatis, Hibernate, JPA)를 주로 사용하는 영역
- @Repository를 사용하여 작성된 DAO(Data Access Object) 클래스의 영역
#### DTOs
- 계층 간 데이터 교환을 위한 객체 정의
- DTO(Data Transfer Object) 영역
#### Domain Model
- 데이터를 도메인 형식으로 모델화시킨 것
- 애플리케이션 비즈니스 로직 처리
- 엔티티(@Entity)가 사용되는 영역
- DB 테이블, IO 객체 포함
<br/>

### Spring Bean
> ![bean](https://user-images.githubusercontent.com/20378368/128664936-db8822bc-4539-4136-8b57-baef94134004.png)
- Bean: Spring IoC 컨테이너가 관리하는 JAVA 객체
- IoC: Inversion of Control, 객체 생성을 관리 위임 주체에게 이관
- Bean은 Spring에 의하여 생성되고 관리되는(IoC) JAVA 객체
- @Autowired, Setter, Constructor 등으로 Spring으로부터 Bean 주입받음
<br/>

### H2, JPA, MyBatis
| Contnet | H2 | JPA | MyBatis |
| --- | --- | --- | --- |
| Role | Java 기반 저용량 RDBMS | 직접 SQL을 작성하지 않아도 자동 생성 | 직접 SQL을 작성하여 객체와 매핑 |
| Pos. | Web Browser 기반 콘솔모드</br> JDBC API 지원 | 객체중심적(ORM) 데이터 관리</br> Entity 변경 시 관련 쿼리 자동 반영 | SQL 쿼리를 직접 작성하여 최적화</br> Entity에 종속받지 않고 최적화된 쿼리 구현 |
| Con. | 메모리에 데이터 저장 → 휘발성 | 복잡한 연산 처리의 어려움</br> 고도화될수록 학습 곡선이 높아짐 | 스키마 변경 시 SQL 쿼리 수정 필요</br> DB에 종속적인 쿼리문 발생 |
<br/>

### H2 Database (for Testing)
- Link: http://localhost:8080/h2-console  
- JDBC URL: jdbc:h2:mem:testdb
> ![H2](https://user-images.githubusercontent.com/20378368/128664766-9efe5f0a-dffd-4b7d-a243-1916bcf63446.png)
```sql
insert into posts (author, content, title) values ('author', 'content', 'title');
select * from posts;
```
> ![insert-query](https://user-images.githubusercontent.com/20378368/128666004-485d8523-515c-408e-8b69-88f50d855577.png)  
> ![insert-result](https://user-images.githubusercontent.com/20378368/128665276-2a756081-49b1-4ece-9547-11e6702b201c.png)
<br/>

### Dirty Checking
> ![DC](https://user-images.githubusercontent.com/20378368/128669641-50a3cfc5-c540-461c-9033-e907ff527402.png)
- Dirty Checking: Transaction 안에서 Entity 상태의 변경에 대한 검사
- Dirty Checking은 영속성 컨텍스트(Persistence Context)가 관리하는 Entity에만 적용
- JPA는 최초 조회 상태(Snapshot)에서 변화가 있는 Entity 객체를 DB에 자동으로 반영
<br/>

### JPA, Hibernate, Spring Data JPA (Repository)
> ![JPA-Hibernate-Repository](https://user-images.githubusercontent.com/20378368/128971468-ffb03907-7f52-49d6-b4e2-62b37e9944c2.png)

### Enum Class
- 서로 연관되거나 관련이 있는 상수들의 집합
- 코드가 간략해지고 가독성이 높아진다
- Instance 생성과 함께 상속을 방지하여 타입 안전성 보장
- Enum 상수는 고정된 값으로 다른 클래스에서 변경할 수 없음

### OAuth2 Google Login
- 다른 서비스의 회원 정보를 안전하게 사용하기 위한 방법
- ID/PW 등 사용자 정보를 알려주지 않아도, 해당 서비스에서 로그인 가능
    - Ex) Naver, Kakao, Google로 로그인하기
- 1. 서비스를 등록하는 과정
    - 1) Google에 자사 서비스 등록하기
    - 2) 이 과정에서 redirect_uri 등을 합의하기
- 2. 토큰을 받기 위한 과정
    - 1) 사용자를 Google 로그인 페이지로 이동시키기
    - 2) Google이 사용자를 우리 서비스로 리다이렉트 시키기
- 3. 토큰을 이용해 정보를 요청하는 과정
```sql
update user set role = 'USER';
select * from user;
```
> ![image](https://user-images.githubusercontent.com/20378368/130082102-66112867-975f-4c6c-8b7b-036c32be89cc.png)
```sql
select * from spring_session;
```
> ![image](https://user-images.githubusercontent.com/20378368/130087795-004aff1a-34ce-4de1-8837-cf11ec7ce424.png)