package com.korkeep.summer.web.web;

import com.korkeep.summer.web.web.dto.HelloResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// RestController: JSON을 반환하는 컨트롤러로 만들어줌
@RestController
public class HelloController {
    // GetMapping: HTTP Get 메소드를 받을 수 있는 API 생성
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    // GetMapping: HTTP Get 메소드를 받을 수 있는 API 생성
    // RequestParam: 외부 API 파라미터를 저장
    @GetMapping("/hello/dto")
    public HelloResponseDTO dto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDTO(name, amount);
    }
}