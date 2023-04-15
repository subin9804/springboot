package org.koreait.exam;

public class Ex01 {
    public static void main(String[] args) {
        User user = User.builder()
                .userId("user01")
                .userNm("사용자01")
                .userPw("123456")
                .build();
        System.out.println(user);
    }
}
