package com.korkeep.summer.web;

import com.korkeep.summer.service.posts.PostsService;
import com.korkeep.summer.web.dto.PostsResponseDTO;
import com.korkeep.summer.web.dto.PostsSaveRequestDTO;
import com.korkeep.summer.web.dto.PostsUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsAPIController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDTO requestDTO){
        return postsService.save(requestDTO);
    }

    @PostMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDTO requestDTO){
        return postsService.update(id, requestDTO);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDTO findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
