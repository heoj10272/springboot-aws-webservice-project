package com.webservice.aws.springboot.config;

import com.webservice.aws.springboot.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    // HandlerMethodArgumentResolver(=loginUserArgumentResolver)는 항상 WebMvcConfigurer의 addArgumentResolvers()를 통해 추가해야 합니다.
    // 다른 HandlerMethodArgumentResolver가 필요하다면 같은 방식으로 추가해 주면 됩니다.
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserArgumentResolver);
    }
}
