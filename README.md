## Summer
> 한여름에 Spring 뽀개버리기 🏝  
> Spring Boot와 AWS로 구현하는 웹 서비스 ✨  

### Spring Layer
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
