package com.webservice.aws.springboot.web;

import com.webservice.aws.springboot.service.posts.PostsService;
import com.webservice.aws.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
