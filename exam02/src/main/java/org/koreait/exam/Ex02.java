package org.koreait.exam;

public class Ex02 {
    public static void main(String[] args) {
        User2 user = User2.builder()
                .userId("user02")
                .userPw("123456")
                .userNm("사용자02")
                .build();

        System.out.println(user);
    }
}
