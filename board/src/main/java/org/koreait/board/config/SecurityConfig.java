package org.koreait.board.config;

import org.koreait.board.models.user.LoginFailureHandler;
import org.koreait.board.models.user.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/user/login")
                .usernameParameter("userId")
                .passwordParameter("userPw")
                //.defaultSuccessUrl("/")
                .successHandler(new LoginSuccessHandler())
                //.failureUrl("/user/login")
                .failureHandler(new LoginFailureHandler())
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/user/login");

        http.authorizeHttpRequests()
                .requestMatchers("/mypage/**").authenticated()  // 회원전용
                .requestMatchers("/admin/**")  .hasAuthority("ADMIN")   // 관리자 전용
                .anyRequest().permitAll();  // 나머지는 전체 가능

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
