package com.korkeep.summer.config.auth;

import com.korkeep.summer.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
// EnableWebSecurity: Spring Security 설정 활성화
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http    
                // h2-console 화면 사용하기 위해 옵션 disable -> 취약 포인트로 작용 가능
                .csrf().disable().headers().frameOptions().disable()
                // authorizeRequests: URL 권한 관리를 설정하는 옵션
                // antMatchers: 권한 관리 대상을 지정, URL, HTTP 메소드별 관리 가능
                // anyRequest: 설정된 값 이외의 URL 관리
                .and().authorizeRequests()
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated()
                // logout().logoutSuccessUrl: 로그아웃 기능에 대한 진입점
                .and().logout().logoutSuccessUrl("/")
                // oauth2Login: OAuth2 로그인 기능에 대한 진입점
                // userInfoEndpoint: OAuth2 로그인 이후 사용자 정보 가져올 때의 설정
                // userService: 로그인 성공 시 후속 조치를 진행할 인터페이스, 사용자 정보 가져온 상태에서 추가로 진행하려는 기능 명시
                .and().oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }
}
