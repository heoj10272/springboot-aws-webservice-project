package com.webservice.aws.springboot.web;

import javax.servlet.http.HttpSession;
import com.webservice.aws.springboot.config.auth.dto.SessionUser;
import com.webservice.aws.springboot.service.posts.PostsService;
import com.webservice.aws.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

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

        SessionUser user = (SessionUser) HttpSession.getAttribute("user");
        if (user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
