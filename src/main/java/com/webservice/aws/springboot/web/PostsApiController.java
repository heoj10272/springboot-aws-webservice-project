package com.webservice.aws.springboot.web;

import com.webservice.aws.springboot.domain.posts.PostsRepository;
import com.webservice.aws.springboot.service.posts.PostsService;
import com.webservice.aws.springboot.web.dto.PostsListResponseDto;
import com.webservice.aws.springboot.web.dto.PostsResponseDto;
import com.webservice.aws.springboot.web.dto.PostsSaveRequestDto;
import com.webservice.aws.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


// @RequiredArgsConstructor
    // final이 선언된 모든 필드를 인자값으로 하는 생성자를 대신 생성함
@RequiredArgsConstructor
@RestController // 컨트롤러를 JSON 을 반환하는 컨트롤러로 만들어 줌
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    // 모든 리스트 가져오기 api (테스트 작성)
    @GetMapping("/api/v1/posts/all")
    public List<PostsListResponseDto> all(){
        return postsService.findAllDesc();
    }

    // postman 테스트용
    @GetMapping("/api/v1/posts/test")
    public List test() {
        List list = new ArrayList();
        list.add("test");
        return list;
    }

}
