package com.korkeep.summer.domain.posts;

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
public class Posts {
    // Id: 해당 테이블의 PK 필드
    @Id
    // GeneratedValue: PK의 생성 규칙
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Column: 테이블의 칼럼, 클래스의 필드는 모두 Column
    // Column: 기본값 외에 추가로 변경이 필요한 경우 Annotation 명시
    @Column(length = 500, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    // Builder: Builder 패턴으로 생성 시점에 값을 채워주는 역할
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
