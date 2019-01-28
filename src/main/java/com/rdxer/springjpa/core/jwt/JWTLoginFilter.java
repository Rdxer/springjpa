package com.rdxer.springjpa.core.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rdxer.springjpa.model.Account;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 登录
 */
public class JWTLoginFilter
        extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;


    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    // 接收并解析用户凭证
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            LoginPara para = new ObjectMapper()
                    .readValue(req.getInputStream(), LoginPara.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            para.username,
                            para.password,
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 用户成功登录后，这个方法会被调用，我们在这个方法里生成token
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        long time = JWTConfiguration.sessionTime;

        String token = Jwts.builder()
                .setSubject(((User) auth.getPrincipal()).getUsername())
//                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .signWith(SignatureAlgorithm.HS512, JWTConfiguration.secret)
                .compact();

        res.addHeader("Authorization", "Bearer " + token);
        
//        String refreshToken = Jwts.builder()
//                .setSubject(((User) auth.getPrincipal()).getUsername())
//                .setExpiration(new Date(System.currentTimeMillis() + time * 2))
//                .signWith(SignatureAlgorithm.HS512, JWTConfiguration.secret)
//                .compact();
//
//        res.addHeader("RefreshToken", "Bearer " + token);
    }
}

class LoginPara{
    String username;
    String password;
}