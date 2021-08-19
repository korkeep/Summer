package com.korkeep.summer.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Target: 해당 Annotation이 생성될 수 있는 위치(PARAMETER, TYPE ...) 지정
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
// @interface LoginUser: LoginUser 이름의 Annotation 생성
public @interface LoginUser {
}
