package com.SessionMangenmentSessionRegistry.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SessionManager {

	@Autowired
    private final SessionRegistry sessionRegistry;

    public SessionManager(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    public List<String> getActiveUsernames() {
        return sessionRegistry.getAllPrincipals().stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    public List<SessionInformation> getActiveSessions() {
    	return sessionRegistry.getAllSessions(sessionRegistry,true);
    }

    public void removeSession(String sessionId) {
        sessionRegistry.removeSessionInformation(sessionId);
    }
}