package com.webservice.aws.springboot.service.posts;

import com.webservice.aws.springboot.domain.posts.Posts;
import com.webservice.aws.springboot.domain.posts.PostsRepository;
import com.webservice.aws.springboot.web.dto.PostsListResponseDto;
import com.webservice.aws.springboot.web.dto.PostsResponseDto;
import com.webservice.aws.springboot.web.dto.PostsSaveRequestDto;
import com.webservice.aws.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    // readOnly = true
        // 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선됨
        // 등록, 수정, 삭제 기능이 전혀 없는 서비스 메소드에서 사용한는 것을 추천
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                // 다음 람다식은 다음과 같다
                // .map(posts -> new PostsListResponseDto(posts))
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

}
