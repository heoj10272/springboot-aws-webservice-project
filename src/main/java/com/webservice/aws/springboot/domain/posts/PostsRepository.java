package com.webservice.aws.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// 해당 인터페이스는 Posts 클래스로 Database를 접근하게 해줄 JpaRepository임
// 보통 ibatis나 MyBatis 등에서 Dao라고 불리는 DB Layer 접근자임
// JPA에선 Repository라고 부르며 인터페이스로 생성함
// 단순히 인터페이스를 생성 후, JpaRepository<Entity 클래스, PK 타입>를 상속하면 기본적인 CRUD 메소드가 자동으로 생성됨
// Entity 클래스와 기본 Entity Repository는 함꼐 위치해야 함을 주의 !
// 클래스와 Repository는 아주 밀접한 관계로 나중에 프로젝트 규모가 커져 도메인별로 프로젝트를 분리해야 한다면 함꼐 움직일 수 있도록 도메인 패키지에서 함꼐 관리

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
