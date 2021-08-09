package com.korkeep.summer.service.posts;

import com.korkeep.summer.domain.posts.Posts;
import com.korkeep.summer.domain.posts.PostsRepository;
import com.korkeep.summer.web.dto.PostsListResponseDTO;
import com.korkeep.summer.web.dto.PostsResponseDTO;
import com.korkeep.summer.web.dto.PostsSaveRequestDTO;
import com.korkeep.summer.web.dto.PostsUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

// RequiredArgsConstructor: final 선언된 모든 필드를 인자값으로 하는 생성자 생성
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDTO requestDTO) {
        return postsRepository.save(requestDTO.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDTO requestDTO){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        posts.update(requestDTO.getTitle(), requestDTO.getContent());
        return id;
    }

    @Transactional
    public void delete (Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        postsRepository.delete(posts);
    }

    public PostsResponseDTO findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return new PostsResponseDTO(entity);
    }

    @Transactional
    public List<PostsListResponseDTO> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDTO::new)
                .collect(Collectors.toList());
    }
}