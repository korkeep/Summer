package com.korkeep.summer.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
// MappedSuperClass: Entity 상속하는 경우, 필드(createdDate, modifiedDated)를 Column으로 인식
@MappedSuperclass
// EntityListeners: 클래스에 Auditing 기능 포함
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    //CreatedDate: Entity 생성되어 저장될 때, 시간이 자동 저장
    @CreatedDate
    private LocalDateTime createdDate;

    // LastModifiedDate: 조회한 Entity 값을 변경할 때, 시간이 자동 저장
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
