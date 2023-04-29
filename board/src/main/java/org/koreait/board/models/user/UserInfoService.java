package org.koreait.board.models.user;

import lombok.RequiredArgsConstructor;
import org.koreait.board.entities.Users;
import org.koreait.board.repositories.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserInfoService implements UserDetailsService {

    private final UsersRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repository.findByUserId(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }

        UserInfo userInfo = new ModelMapper().map(user, UserInfo.class);

        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getType().toString()));
        userInfo.setAuthorities(authorities);

        return userInfo;
    }
}
