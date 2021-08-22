package com.korkeep.summer.web.dto;

import com.korkeep.summer.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDTO {
    private Long id;
    private String title;
    private String content;
    private String author;
    private Long fileId;

    // Builder: Builder 패턴으로 생성 시점에 값을 채워주는 역할
    @Builder
    public PostsSaveRequestDTO(String title, String content, String author, Long id, Long fileId){
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.fileId = fileId;
    }

    public Posts toEntity(){
        return Posts.builder()
                .id(id)
                .title(title)
                .content(content)
                .author(author)
                .fileId(fileId)
                .build();
    }
}
