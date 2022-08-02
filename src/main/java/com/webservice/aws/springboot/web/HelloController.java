package com.webservice.aws.springboot.web;

import com.webservice.aws.springboot.web.dto.HelloResponseDto;
import org.hibernate.annotations.GeneratorType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON 을 반환하는 컨트롤러로 만들어 줌
public class HelloController {

    @GetMapping("/hello") // HTTP Method 인 Get 의 요청을 받을 수 있는 API 를 만들어 줌
    public String hello(){ // /hello 로 요청이 오면 문자열 hello 를 반환하는 기능
        return "hello";
    }
    
    // @RequestParam
        // 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
        // 여기서는 외부에서 name(@RequestParam("name"))이란 이름으로 넘긴 파라미터를 메소드 파라미터 name(String name)에 저장하게 됨
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}

