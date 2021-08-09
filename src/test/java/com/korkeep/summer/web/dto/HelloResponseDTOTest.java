package com.korkeep.summer.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDto {
    @Test
    public void lombokTest(){
        String name = "test";
        int amount = 1000;

        HelloResponseDTO dto = new HelloResponseDTO(name, amount);
        
        // assertThat: 대상을 인자로 받아 검증
        // assertj: 테스트 검증을 위한 라이브러리
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
