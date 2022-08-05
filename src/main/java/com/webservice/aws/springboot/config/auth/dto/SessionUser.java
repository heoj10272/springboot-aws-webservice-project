package com.webservice.aws.springboot.config.auth.dto;

import com.webservice.aws.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

// SessionUser에는 인증된 사용자 정보만 필요합니다.
// 그 외에 필요한 정보들은 없으니 name, email, picture만 필드로 선언합니다.
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}