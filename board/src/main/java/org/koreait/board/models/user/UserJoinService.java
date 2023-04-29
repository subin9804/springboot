package org.koreait.board.models.user;

import lombok.RequiredArgsConstructor;
import org.koreait.board.controllers.users.JoinForm;
import org.koreait.board.entities.Users;
import org.koreait.board.repositories.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserJoinService {
    private final UsersRepository repository;
    private final PasswordEncoder passwordEncoder;

    public void join(JoinForm joinForm) {
        String hash = passwordEncoder.encode(joinForm.getUserPw());

        ModelMapper modelMapper = new ModelMapper();
        Users user = modelMapper.map(joinForm, Users.class);

        user.setUserPw(hash);

        repository.saveAndFlush(user);
    }
}
