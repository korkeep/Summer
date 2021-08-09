package com.korkeep.summer.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// Getter: 선언된 모든 필드의 Get 메소드 생성
@Getter
// RequiredArgsConstructor: final 필드가 포함된 경우의 생성자
@RequiredArgsConstructor
public class HelloResponseDTO {
    private final String name;
    private final int amount;
}
