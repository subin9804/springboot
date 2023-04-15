package org.koreait.exam;

import lombok.Data;

import java.time.LocalDateTime;

// Builder 패턴
@Data
public class User {
    private String userId;
    private String userPw;
    private String userNm;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPw='" + userPw + '\'' +
                ", userNm='" + userNm + '\'' +
                '}';
    }

    private User() {}

    public static Builder builder() {
        return new Builder();
    }

    protected static class Builder {
        private static User user = new User();

        public Builder userId(String userId) {
            user.userId = userId;
            return this;
        }

        public Builder userPw(String userPw) {
            user.userPw = userPw;
            return this;
        }

        public Builder userNm(String userNm) {
            user.userNm = userNm;
            return this;
        }


        public User build() {
            return user;
        }
    }
}
