package com.SessionMangenmentCustomStore.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SessionMangenmentCustomStore.demo.Repo.PersonInfoRepo;
import com.SessionMangenmentCustomStore.demo.Repo.PersonSecurityContextRepo;
import com.SessionMangenmentCustomStore.demo.entity.Person;
import com.SessionMangenmentCustomStore.demo.entity.PersonInfo;
import com.SessionMangenmentCustomStore.demo.entity.RequestDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class Rest {

    private  SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();
    private  AuthenticationManager authenticationManager;

    public Rest(AuthenticationManager authenticationManager, SecurityContextRepository securityContextRepository) {
        this.authenticationManager = authenticationManager;
        this.securityContextRepository= securityContextRepository;
    }

    @Autowired
    private PersonInfoRepo contextRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private PersonSecurityContextRepo personSecurityContextRepo;

    

  

    @PostMapping("/save")
    public PersonInfo saveperson(@RequestBody PersonInfo personInfo) {
        personInfo.setPassword(encoder.encode(personInfo.getPassword()));
        return contextRepo.save(personInfo);
    }

//    @PostMapping("/login")
//    public void login(@RequestBody RequestDto requestDto, HttpServletRequest request, HttpServletResponse response) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(requestDto.getUsername(), requestDto.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        securityContextRepository.saveContext(SecurityContextHolder.getContext(), request, response);
//    }

    @GetMapping("/user")
    public String getUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return "user" + " " + session.getId();
    }

    @GetMapping("/data")
    public List<PersonInfo> getData() {
        return contextRepo.findAll();
    }
    @GetMapping("/sessdata")
    public List<Person> getda() {
        return personSecurityContextRepo.findAll();
    }
    
    

    @PostMapping("/login")
    public void login(@RequestBody PersonInfo personInfo, HttpServletResponse response,HttpServletRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(personInfo.getUsername(), personInfo.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        securityContextRepository.saveContext(SecurityContextHolder.getContext(), request, response);
    }
}