package com.korkeep.summer.web;

import com.korkeep.summer.domain.posts.Posts;
import com.korkeep.summer.domain.posts.PostsRepository;
import com.korkeep.summer.web.dto.PostsSaveRequestDTO;
import com.korkeep.summer.web.dto.PostsUpdateRequestDTO;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// RunWith: JUnit 이외의 다른 실행자 실행 (SpringRunner)
@RunWith(SpringRunner.class)
// SpringBootTest: JPA 기능까지 한번에 테스트하기 위함
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsAPIControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void tearDown() throws Exception{
        postsRepository.deleteAll();
    }

    // Posts Entity 생성
    @Test
    public void postsBuild() throws Exception {
        String title = "title";
        String content = "content";
        PostsSaveRequestDTO requestDTO = PostsSaveRequestDTO.builder()
                .title(title)
                .content(content)
                .author("author")
                .build();
        String url = "http://localhost:" + port +"/api/v1/posts";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDTO, Long.class);

        // assertThat: 대상을 인자로 받아 검증
        // assertj: 테스트 검증을 위한 라이브러리
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

    // Posts Entity 수정
    @Test
    public void postsUpdate() throws Exception{
        Posts savedPosts = postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        Long updateId = savedPosts.getId();
        String expectedTitle = "title2";
        String expectedContent = "content2";
        PostsUpdateRequestDTO requestDTO = PostsUpdateRequestDTO.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .build();
        String url = "http://localhost:" + port +"/api/v1/posts/" + updateId;
        HttpEntity<PostsUpdateRequestDTO> requestEntity = new HttpEntity<>(requestDTO);

        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        // assertThat: 대상을 인자로 받아 검증
        // assertj: 테스트 검증을 위한 라이브러리
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
    }
}
