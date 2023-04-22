package org.koreait.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
// 공통속성

@Getter @Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp  // SQL INSERT 구문 실행 시 추가됨
    @Column(updatable = false)  // 수정 불가, 추가만 가능
    private LocalDateTime regDt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp    // SQL UPDATE 구문 실행 시 추가됨
    @Column(insertable = false)  // 수정 가능, 추가 불가
    private LocalDateTime modDt;
}
