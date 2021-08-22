package com.korkeep.summer.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDTO {
    private String title;
    private String content;
    private Long fileId;

    // Builder: Builder 패턴으로 생성 시점에 값을 채워주는 역할
    @Builder
    public PostsUpdateRequestDTO(String title, String content, Long fileId){
        this.title = title;
        this.content = content;
        this.fileId = fileId;
    }
}
