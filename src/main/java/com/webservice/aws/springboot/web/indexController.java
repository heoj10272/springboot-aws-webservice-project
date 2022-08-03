package com.webservice.aws.springboot.web;

import com.webservice.aws.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Controller
public class indexController {

    private final PostsService postsService;
    
    @GetMapping("/")
    // Model
        // 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음
        // 여기서는 postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달함
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
