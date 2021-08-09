package com.korkeep.summer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// EnableJpaAuditing: JPA Auditing 활성화
@EnableJpaAuditing
// SpringBootApplication: 프로젝트의 최상단 위치, 프로젝트의 엔트리포인트
@SpringBootApplication
public class Application{
    public static void main(String[] args){
        // SpringApplication.run: 언제 어디서나 같은 환경에서 배포 가능 (내장 WAS, jar 파일로 실행)
        SpringApplication.run(Application.class, args);
    }
}