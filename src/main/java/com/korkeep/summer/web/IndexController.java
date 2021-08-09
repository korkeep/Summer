package com.korkeep.summer.web;

import com.korkeep.summer.service.posts.PostsService;
import com.korkeep.summer.web.dto.PostsResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    
    // Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDTO DTO = postsService.findById(id);
        model.addAttribute("post", DTO);
        return "posts-update";
    }
}
