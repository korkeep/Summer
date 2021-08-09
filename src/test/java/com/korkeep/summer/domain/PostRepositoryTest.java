package com.korkeep.summer.domain;

import com.korkeep.summer.domain.posts.Posts;
import com.korkeep.summer.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// RunWith: JUnit 이외의 다른 실행자 실행 (SpringRunner)
@RunWith(SpringRunner.class)
// SpringBootTest: JPA 기능까지 한번에 테스트하기 위함
@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    // After: Junit 단위 테스트가 끝날 때마다 수행되는 메소드 지정
    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void getContentsTest(){
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // postRepository.save: postsRepository → insert, update 쿼리 실행
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("korkeep@khu.ac.kr")
                .build());

        // postRepository.findAll: postsRepository → 모든 데이터를 조회해오는 메소드
        List<Posts> postsList = postsRepository.findAll();

        // assertThat: 대상을 인자로 받아 검증
        // assertj: 테스트 검증을 위한 라이브러리
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntityBuild(){
        LocalDateTime now = LocalDateTime.of(2021, 8, 9, 0, 0, 0);

        // postRepository.save: postsRepository → insert, update 쿼리 실행
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        // postRepository.findAll: postsRepository → 모든 데이터를 조회해오는 메소드
        List<Posts> postsList = postsRepository.findAll();

        // assertThat: 대상을 인자로 받아 검증
        // assertj: 테스트 검증을 위한 라이브러리
        Posts posts = postsList.get(0);
        System.out.println(">> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
