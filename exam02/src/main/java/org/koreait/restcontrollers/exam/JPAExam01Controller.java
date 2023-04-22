package org.koreait.restcontrollers.exam;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.koreait.entities.PostData;
import org.koreait.entities.Users;
import org.koreait.repositories.PostDataRepository;
import org.koreait.repositories.UsersRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import static org.springframework.data.domain.Sort.Order.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Log
@RestController
@RequestMapping("/jpa/exam01")
@RequiredArgsConstructor    // 멤버변수 생성자로 의존성 주입
public class JPAExam01Controller {

    private final UsersRepository usersRepository;
    private final PostDataRepository postDataRepository;

    @GetMapping("/ex01")
    public void ex01() {
        Users user = new Users();
        user.setUserId("user01");
        user.setUserPw("123456");
        user.setUserNm("사용자01");
        user.setEmail("user01@test.org");
        user.setMobile("01000000000");

        Users user2 = usersRepository.saveAndFlush(user);   // 영속성 상태
        log.info(user2.toString());

        user2.setUserNm("(수정)사용자01");
        usersRepository.flush();

        usersRepository.delete(user2);
        usersRepository.flush();
    }

    @GetMapping("/ex02")
    public void ex02() {
            List<Users> users = new ArrayList<>();
        for (int i = 11; i <= 20; i++) {
            Users user = new Users();
            user.setUserId("user" + i);
            user.setUserPw("123456");
            user.setUserNm("사용자" + i);
            user.setEmail("user" + i + "@test.org");
            user.setMobile("01000000000");

            users.add(user);
        }
        List<Users> users2 = usersRepository.saveAllAndFlush(users);
        for (Users user : users) {
            user.setUserNm("(수정)" + user.getUserNm());
        }
        usersRepository.flush();
    }

    @GetMapping("/ex03")
    public void ex03() {
        Users user = usersRepository.findById(2L).orElse(null);
        log.info(user.toString());
    }

    @GetMapping("/ex04")
    public void ex04() {
//        List<Users> users = usersRepository.findAll();
//        List<Users> users = usersRepository.findAll(Sort.by(Sort.Order.desc("regDt")));     // sort: 정렬옵션
//        List<Users> users = usersRepository.findAll(Sort.by(desc("regDt"), asc("userId")));

//        Pageable pageable = PageRequest.of(1, 3);   // 2페이지
        Pageable pageable = PageRequest.of(1, 3, Sort.by(desc("regDt")));
        Page<Users> page = usersRepository.findAll(pageable);
        List<Users> users = page.getContent();

        for(Users user : users) {
            log.info(user.toString());
        }
    }

    @GetMapping("/ex05")
    public void ex05() {
        Users user = usersRepository.findByUserId("user2");
        log.info(user.toString());

    }

    @GetMapping("/ex06")
    public void ex06() {
        Users user = usersRepository.findByUserIdAndUserNm("user2", "사용자2");
        log.info(user.toString());

        List<Users> users = usersRepository.findByUserIdOrUserId("user2", "user3");
    }

    @GetMapping("/ex07")
    public void ex07() {
        List<String> userIds = Arrays.asList("user2", "user3");
        //List<Users> users = usersRepository.findByUserIdIn(userIds);
        //List<Users> users2 = usersRepository.findByUserIdInOrderByRegDtDesc(userIds);

        //List<Users> users = usersRepository.findByUserNmContaining("3");

        //Pageable pageable = PageRequest.of(2, 3, Sort.by(desc("regDt")));
        //List<Users> users = usersRepository.findByUserIdContaining("ser", pageable);

        /**
        List<Users> users = usersRepository.findUsers("3");
         */

        List<Users> users = usersRepository.findUsers2("3");
        for(Users user : users) {
            log.info(user.toString());
        }

    }

    @GetMapping("/ex08")
    public void ex08() {
        Users user = new Users();
        user.setUserId("user01");
        user.setUserPw("123456");
        user.setUserNm("사용자01");
        user.setEmail("user01@test.org");
        user.setMobile("01000000000");

        user = usersRepository.saveAndFlush(user);

        PostData postData = new PostData();
        postData.setSubject("제목1");
        postData.setContent("내용1");
        postData.setUser(user);

        postDataRepository.saveAndFlush(postData);
    }

    @GetMapping("/ex09")
    public void ex09() {
        PostData postData = postDataRepository.findById(1L).orElse(null);
        Users user = postData.getUser();
        log.info(postData.toString());
    }

    @GetMapping("ex10")
    public void ex10() {
        Users user = usersRepository.findById(1L).orElse(null);
        List<PostData> datas = new ArrayList<>();
        for(int i = 2; i <= 10; i++) {
            PostData postData = new PostData();
            postData.setSubject("제목" + i);
            postData.setContent("내용" + i);
            postData.setUser(user);

            datas.add(postData);
        }
        postDataRepository.saveAllAndFlush(datas);
    }

    @GetMapping("/ex11")
    public void ex11() {
        Users user = usersRepository.findById(1L).orElse(null);
        List<PostData> datas = user.getPostDatas();
        for (PostData data : datas){
            log.info(data.toString());  // user
        }
    }
}
