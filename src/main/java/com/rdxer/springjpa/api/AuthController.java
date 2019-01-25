package com.rdxer.springjpa.api;

import com.rdxer.springjpa.model.Account;
import com.rdxer.springjpa.service.AccountService;
import io.swagger.annotations.Api;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api("")
@RestController
@RequestMapping(path = "/api/auth")
public class AuthController {

    @Resource
    private AccountService service;
    @Resource
    private PasswordEncoder bCryptPasswordEncoder;

    /**
     * 该方法是注册用户的方法，默认放开访问控制
     */
    @PostMapping("/signup")
    public Account signUp(@RequestBody Account account) {
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        return service.store(account);
    }
}


class SignupPara{

}