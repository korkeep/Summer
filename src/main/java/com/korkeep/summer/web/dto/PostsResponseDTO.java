package com.korkeep.summer.web.dto;

import com.korkeep.summer.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDTO {
    private long id;
    private String title;
    private String content;
    private String author;
    
    // Constructor: Entity 필드 중 일부만 사용
    public PostsResponseDTO(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
