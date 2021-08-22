package com.korkeep.summer.domain.user;

import com.korkeep.summer.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/* Entity 클래스에서는 Setter 메소드를 만들지 않는다 */
/* 필드 값 변경이 필요한 경우 메소드를 추가하는 식으로 구현 */
// Getter: 클래스 내 모든 필드의 Getter 생성
@Getter
// NoArgsConstructor: 기본 생성자 자동 추가
@NoArgsConstructor
// Entity: 테이블과 링크될 클래스
/* Entity 클래스를 Request, Response 클래스로 사용하지 말 것 */
/* Entity 클래스와 DTO 클래스는 반드시 분리하여 사용 */
@Entity
public class User extends BaseTimeEntity {
    // Id: 해당 테이블의 PK 필드
    @Id
    // GeneratedValue: PK의 생성 규칙
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Column: 테이블의 칼럼, 클래스의 필드는 모두 Column
    // Column: 기본값 외에 추가로 변경이 필요한 경우 Annotation 명시
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    // Enumerated: JPA로 DB에 저장할 때 Enum 값을 어떤 형태로 저장할지 지정
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // Builder: Builder 패턴으로 생성 시점에 값을 채워주는 역할
    @Builder
    public User(String name, String email, String picture, Role role){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}
