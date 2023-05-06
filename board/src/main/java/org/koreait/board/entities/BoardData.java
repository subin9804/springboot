package org.koreait.board.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Entity @Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class BoardData extends BaseUserEntity{
    @Id @GeneratedValue
    private Long id;    // 게시글 번호

    @Column(length = 40, nullable = false)
    private String boardId; // 게시판 아이디

    @Column(nullable = false)
    private String subject;

    @Lob
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)  // 지연로딩
    @JoinColumn(name="userNo")
    private Users user;
}
