package com.rdxer.springjpa.core.jwt;

import com.rdxer.springjpa.model.Account;
import com.rdxer.springjpa.repository.AccountRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private AccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> byUsername = repository.findByUsername(username);

        if (byUsername.isEmpty()) {
            throw new UsernameNotFoundException(username + " UsernameNotFoundException");
        }

        Account account = byUsername.get();

        List<GrantedAuthority> roles = new ArrayList<>();

        return new User(account.getUsername(),account.getPassword(),roles);
    }
}
