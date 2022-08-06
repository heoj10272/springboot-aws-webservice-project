package com.webservice.aws.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// @EnableJpaAuditing // JPA Auditing 활성화
// Application class = main class
// @SpringBootApplication 으로 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정
// @SpringBootApplication 이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야 함
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        // run() -> 내장 WAS(Web Application Server) 실행
        SpringApplication.run(Application.class, args);
    }
}
