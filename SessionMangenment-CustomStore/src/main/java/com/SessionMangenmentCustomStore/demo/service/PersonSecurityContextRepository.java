package com.SessionMangenmentCustomStore.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

import com.SessionMangenmentCustomStore.demo.Repo.PersonSecurityContextRepo;
import com.SessionMangenmentCustomStore.demo.entity.Person;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class PersonSecurityContextRepository implements SecurityContextRepository {

    @Autowired
    private PersonSecurityContextRepo personSecurityContextRepo;

	@Override
	public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
		String sessinId=requestResponseHolder.getRequest().getSession().getId();
	     Person entity = personSecurityContextRepo.findBySessionId(sessinId);
	        return (entity != null) ? entity.getSecurityContext() : null;
	}

	
	@Override
    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
        String sessionId = request.getSession().getId();
        Person entity = personSecurityContextRepo.findBySessionId(sessionId);
        if (entity == null) {
            entity = new Person();
            entity.setSessionId(sessionId);
        }
        entity.setSecurityContext(context);
        personSecurityContextRepo .save(entity);
    }

	@Override
    public boolean containsContext(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        return personSecurityContextRepo.existsBySessionId(sessionId);
    }



	

   
}