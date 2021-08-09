package com.korkeep.summer.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
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
    public void getContents(){
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

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
