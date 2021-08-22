package com.korkeep.summer.web;

import com.korkeep.summer.config.auth.LoginUser;
import com.korkeep.summer.config.auth.dto.SessionUser;
import com.korkeep.summer.service.file.FileService;
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
    private final FileService fileService;

    // Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장
    // @LoginUser: 세션 값 받아오는 코드 반복을 줄이기 위해 Annotation 추가
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());
        // if: 세션에 저장된 값이 없으면 login 버튼 출력
        if(user!=null) {
            model.addAttribute("userName", user.getName());
        }
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
