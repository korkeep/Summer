## Summer ๐
ํ์ฌ๋ฆ์ Spring ๋ฝ๊ฐ๋ฒ๋ฆฌ๊ธฐ (โ'โก'โ)

### Spring Architecture
> ![layer](https://user-images.githubusercontent.com/20378368/128653677-2b58b2e6-e170-49dd-856b-a0ef417e0f40.png)
#### Web Layer
- ๋ธ๋ผ์ฐ์ ์์ ์น ํด๋ผ์ด์ธํธ์ ์์ฒญ ๋ฐ ์๋ต์ ์ฒ๋ฆฌ
- Service Layer์ Repository Layer์์ ๋ฐ์ํ๋ Exception ์ฒ๋ฆฌ
- ์ปจํธ๋กค๋ฌ(@Controller), ํํฐ(@Filter), JSP, Freemarker ๋ฑ์ ๋ทฐ ํํ๋ฆฟ ์์ญ
#### Service Layer
- Web Layer์ Repository Layer๋ฅผ ์ฐ๊ฒฐํ๋ ์ญํ ๋ก์ ํธ๋์ญ์๊ณผ ๋๋ฉ์ธ์ ์์ ๋ณด์ฅ
- ์๋น์ค(@Service)์ ํธ๋์ญ์(@Transaction)์ด ์ฌ์ฉ๋๋ ์์ญ
#### Repository Layer
- DB์ ๊ฐ์ ๋ฐ์ดํฐ ์ ์ฅ์์ ์ ๊ทผํ๋ ์์ญ
- ORM(Mybatis, Hibernate, JPA)๋ฅผ ์ฃผ๋ก ์ฌ์ฉํ๋ ์์ญ
- @Repository๋ฅผ ์ฌ์ฉํ์ฌ ์์ฑ๋ DAO(Data Access Object) ํด๋์ค์ ์์ญ
#### DTOs
- ๊ณ์ธต ๊ฐ ๋ฐ์ดํฐ ๊ตํ์ ์ํ ๊ฐ์ฒด ์ ์
- DTO(Data Transfer Object) ์์ญ
#### Domain Model
- ๋ฐ์ดํฐ๋ฅผ ๋๋ฉ์ธ ํ์์ผ๋ก ๋ชจ๋ธํ์ํจ ๊ฒ
- ์ ํ๋ฆฌ์ผ์ด์ ๋น์ฆ๋์ค ๋ก์ง ์ฒ๋ฆฌ
- ์ํฐํฐ(@Entity)๊ฐ ์ฌ์ฉ๋๋ ์์ญ
- DB ํ์ด๋ธ, IO ๊ฐ์ฒด ํฌํจ
<br/>

### SpringBoot
- Tomcat ๋ฑ WAS์ ๋ํ ์ค์  ์์ด ๋ฐ๋ก ๊ฐ๋ฐ์ ๋ค์ด๊ฐ ์ ์๋๋ก ๋ง๋  ํ๋ ์์ํฌ
- CoC: Convention over Configuration, spring-boot-starter-web์ ๋ฐ์์ค๋ฉด ๋ผ์ด๋ธ๋ฌ๋ฆฌ ๋ฐ์์จ๋ค
- ๋ด์ฅ Tomcat์ ์ง์ํ๋ฏ๋ก JAR ํ์ผ๋ก ํจํค์งํ์ฌ Web Application ์คํ ๊ฐ๋ฅ
- pom.xml์ ์คํ๋ง๋ถํธ ๋ฒ์ ์ ์๋ ฅํ๋ฉด ์๋ํํฐ ๋ผ์ด๋ธ๋ฌ๋ฆฌ๋ ํธํ๋๋ ๋ฒ์ ์ผ๋ก ์๋ ๋ค์ด๋จ
- Annotation์ ํตํด spring ์ค์ ์ ์๋์ผ๋ก ๋ฑ๋กํด์ค ์ ์์
<br/>

### Spring Bean
> ![bean](https://user-images.githubusercontent.com/20378368/128664936-db8822bc-4539-4136-8b57-baef94134004.png)
- Bean: Spring IoC ์ปจํ์ด๋๊ฐ ๊ด๋ฆฌํ๋ JAVA ๊ฐ์ฒด
- IoC: Inversion of Control, ๊ฐ์ฒด ์์ฑ์ ๊ด๋ฆฌ ์์ ์ฃผ์ฒด์๊ฒ ์ด๊ด
- ์ธ๋ถ ๋ผ์ด๋ธ๋ฌ๋ฆฌ์ ์ฝ๋๊ฐ ํ๋ก๊ทธ๋๋จธ๊ฐ ์์ฑํ ์ฝ๋๋ฅผ ํธ์ถ
- Bean์ Spring์ ์ํ์ฌ ์์ฑ๋๊ณ  ๊ด๋ฆฌ๋๋(IoC) JAVA ๊ฐ์ฒด
- @Autowired, Setter, Constructor ๋ฑ์ผ๋ก Spring์ผ๋ก๋ถํฐ Bean ์ฃผ์๋ฐ์
<br/>

### H2, JPA, MyBatis
| Contnet | H2 | JPA | MyBatis |
| --- | --- | --- | --- |
| Role | Java ๊ธฐ๋ฐ ์ ์ฉ๋ RDBMS | ์ง์  SQL์ ์์ฑํ์ง ์์๋ ์๋ ์์ฑ | ์ง์  SQL์ ์์ฑํ์ฌ ๊ฐ์ฒด์ ๋งคํ |
| Pos. | Web Browser ๊ธฐ๋ฐ ์ฝ์๋ชจ๋</br> JDBC API ์ง์ | ๊ฐ์ฒด์ค์ฌ์ (ORM) ๋ฐ์ดํฐ ๊ด๋ฆฌ</br> Entity ๋ณ๊ฒฝ ์ ๊ด๋ จ ์ฟผ๋ฆฌ ์๋ ๋ฐ์ | SQL ์ฟผ๋ฆฌ๋ฅผ ์ง์  ์์ฑํ์ฌ ์ต์ ํ</br> Entity์ ์ข์๋ฐ์ง ์๊ณ  ์ต์ ํ๋ ์ฟผ๋ฆฌ ๊ตฌํ |
| Con. | ๋ฉ๋ชจ๋ฆฌ์ ๋ฐ์ดํฐ ์ ์ฅ โ ํ๋ฐ์ฑ | ๋ณต์กํ ์ฐ์ฐ ์ฒ๋ฆฌ์ ์ด๋ ค์</br> ๊ณ ๋ํ๋ ์๋ก ํ์ต ๊ณก์ ์ด ๋์์ง | ์คํค๋ง ๋ณ๊ฒฝ ์ SQL ์ฟผ๋ฆฌ ์์  ํ์</br> DB์ ์ข์์ ์ธ ์ฟผ๋ฆฌ๋ฌธ ๋ฐ์ |
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
- Dirty Checking: Transaction ์์์ Entity ์ํ์ ๋ณ๊ฒฝ์ ๋ํ ๊ฒ์ฌ
- Dirty Checking์ ์์์ฑ ์ปจํ์คํธ(Persistence Context)๊ฐ ๊ด๋ฆฌํ๋ Entity์๋ง ์ ์ฉ
- JPA๋ ์ต์ด ์กฐํ ์ํ(Snapshot)์์ ๋ณํ๊ฐ ์๋ Entity ๊ฐ์ฒด๋ฅผ DB์ ์๋์ผ๋ก ๋ฐ์
<br/>

### JPA, Hibernate, Spring Data JPA (Repository)
> ![JPA-Hibernate-Repository](https://user-images.githubusercontent.com/20378368/128971468-ffb03907-7f52-49d6-b4e2-62b37e9944c2.png)
<br/>

### Enum Class
- ์๋ก ์ฐ๊ด๋๊ฑฐ๋ ๊ด๋ จ์ด ์๋ ์์๋ค์ ์งํฉ
- ์ฝ๋๊ฐ ๊ฐ๋ตํด์ง๊ณ  ๊ฐ๋์ฑ์ด ๋์์ง๋ค
- Instance ์์ฑ๊ณผ ํจ๊ป ์์์ ๋ฐฉ์งํ์ฌ ํ์ ์์ ์ฑ ๋ณด์ฅ
- Enum ์์๋ ๊ณ ์ ๋ ๊ฐ์ผ๋ก ๋ค๋ฅธ ํด๋์ค์์ ๋ณ๊ฒฝํ  ์ ์์
<br/>

### OAuth2 Google Login
- ๋ค๋ฅธ ์๋น์ค์ ํ์ ์ ๋ณด๋ฅผ ์์ ํ๊ฒ ์ฌ์ฉํ๊ธฐ ์ํ ๋ฐฉ๋ฒ
- ID/PW ๋ฑ ์ฌ์ฉ์ ์ ๋ณด๋ฅผ ์๋ ค์ฃผ์ง ์์๋, ํด๋น ์๋น์ค์์ ๋ก๊ทธ์ธ ๊ฐ๋ฅ
    - Ex) Naver, Kakao, Google๋ก ๋ก๊ทธ์ธํ๊ธฐ
- 1. ์๋น์ค๋ฅผ ๋ฑ๋กํ๋ ๊ณผ์ 
    - 1) Google์ ์์ฌ ์๋น์ค ๋ฑ๋กํ๊ธฐ
    - 2) ์ด ๊ณผ์ ์์ redirect_uri ๋ฑ์ ํฉ์ํ๊ธฐ
- 2. ํ ํฐ์ ๋ฐ๊ธฐ ์ํ ๊ณผ์ 
    - 1) ์ฌ์ฉ์๋ฅผ Google ๋ก๊ทธ์ธ ํ์ด์ง๋ก ์ด๋์ํค๊ธฐ
    - 2) Google์ด ์ฌ์ฉ์๋ฅผ ์ฐ๋ฆฌ ์๋น์ค๋ก ๋ฆฌ๋ค์ด๋ ํธ ์ํค๊ธฐ
- 3. ํ ํฐ์ ์ด์ฉํด ์ ๋ณด๋ฅผ ์์ฒญํ๋ ๊ณผ์ 
```sql
update user set role = 'USER';
select * from user;
```
> ![image](https://user-images.githubusercontent.com/20378368/130082102-66112867-975f-4c6c-8b7b-036c32be89cc.png)
```sql
select * from spring_session;
```
> ![image](https://user-images.githubusercontent.com/20378368/130087795-004aff1a-34ce-4de1-8837-cf11ec7ce424.png)