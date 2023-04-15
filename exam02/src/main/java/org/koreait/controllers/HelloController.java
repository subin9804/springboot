package org.koreait.controllers;

import org.koreait.models.member.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @ResponseBody   // Rest형태로 응답, 일반 controller에서 부분적으로 Rest 사용하는 경우
    @GetMapping("/user2")
    public UserInfo userInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserNo(1L);
        userInfo.setUserId("user01");
        userInfo.setUserPw("123456");
        userInfo.setUserNm("사용자01");
        userInfo.setRegDt(LocalDateTime.now());

        return userInfo;
    }
}
