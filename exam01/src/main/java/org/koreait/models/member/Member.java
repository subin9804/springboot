package org.koreait.models.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.java.Log;

import java.time.LocalDateTime;

@Getter @Setter @ToString
//@NoArgsConstructor(access= AccessLevel.PRIVATE)
//@AllArgsConstructor
//@RequiredArgsConstructor
@Builder @Log
public class Member {
    private Long userNo;
    private String userId;
    //@NonNull    // 필수항목
    private String userPw;
    @JsonIgnore // Json 변환 제외
    private String userNm;

    @JsonFormat(pattern="yyyy.MM.dd HH:mm")
    private LocalDateTime regDt;

    public void info() {
        log.info("테스트메세지!");
    }

}
