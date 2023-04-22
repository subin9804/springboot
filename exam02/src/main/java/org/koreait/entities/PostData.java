package org.koreait.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Data
public class PostData extends BaseEntity {
    @Id @GeneratedValue
    private Long id;

    @Column(length = 150, nullable = false)
    private String subject;     // 게시글 제목

    private String content;     // 게시글 내용

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="user_no")
    private Users user;
}
