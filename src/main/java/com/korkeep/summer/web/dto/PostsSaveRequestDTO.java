package com.korkeep.summer.web.dto;

import com.korkeep.summer.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDTO {
    private Long id;
    private MultipartFile files;
    private String title;
    private String content;
    private String author;
    private Long fileId;

    // Builder: Builder 패턴으로 생성 시점에 값을 채워주는 역할
    @Builder
    public PostsSaveRequestDTO(Long id, MultipartFile files, String title, String content, String author, Long fileId) {
        this.id = id;
        this.files = files;
        this.title = title;
        this.content = content;
        this.author = author;
        this.fileId = fileId;
    }

    public Posts toEntity() {
        return Posts.builder()
                .id(id)
                .title(title)
                .content(content)
                .author(author)
                .fileId(fileId)
                .build();
    }
}
