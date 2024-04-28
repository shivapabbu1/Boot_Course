//package com.SessionMangenmentCustomStore.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
//import org.springframework.security.web.context.SecurityContextRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.SessionMangenmentCustomStore.demo.Repo.PersonSecurityContextRepo;
//import com.SessionMangenmentCustomStore.demo.entity.Person;
//import com.SessionMangenmentCustomStore.demo.entity.RequestDto;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@Controller
//public class PersonController {
//	
//	@Autowired
//	private PersonSecurityContextRepo personSecurityContextRepo;
//      
//	@Autowired
//    private final AuthenticationManager authenticationManager;
//	@Autowired
//    private final SecurityContextRepository securityContextRepository;
//
//    public PersonController(AuthenticationManager authenticationManager, SecurityContextRepository securityContextRepository) {
//        this.authenticationManager = authenticationManager;
//        this.securityContextRepository = securityContextRepository;
//    }
//   
//
////    @GetMapping("/login")
////    public String getlog() {
////    	return "login";
////    }
//    
//
//   
//    
// 
//    
//    
//    
//    
//    
////
////    @PostMapping("/login")
////    public void login(@RequestBody RequestDto requestDto, HttpServletRequest request, HttpServletResponse response) {
////        Authentication authentication = authenticationManager.authenticate(
////                new UsernamePasswordAuthenticationToken(requestDto.getUsername(), requestDto.getPassword()));
////Person person=new Person();
////                  
////        HttpSession session=request.getSession();
////        person.setSecurityContext( SecurityContextHolder.getContext().setAuthentication(authentication));
////        person.setSessionId(session.getId());
////        
////      
////        personSecurityContextRepo.save(person);
////    }
//}
