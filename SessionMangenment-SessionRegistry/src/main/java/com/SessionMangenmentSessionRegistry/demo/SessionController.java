package com.SessionMangenmentSessionRegistry.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

@Controller
public class SessionController {

    @Autowired
    private SessionManager sessionManager;
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    @GetMapping("/user")
    public String getuser() {
        return "index";
    }
    
    @GetMapping("/hr")
    public String gethr() {
        return "hr";
    }
    @GetMapping("/admin")
    public String getadm() {
        return "admin";
    }
    
    @GetMapping("/getSessionId")
    public String getSessionId(HttpServletRequest request, Model model) {
        
        String sessionId = request.getSession().getId();
      

        model.addAttribute("sessionId", sessionId);
      


        return "sessionId";
    }

    @GetMapping("/active-usernames")
    public String getActiveUsernames(Model model) {
        List<String> activeUsernames = sessionManager.getActiveUsernames();
        model.addAttribute("activeUsernames", activeUsernames);
        return "username";
    }

    @GetMapping("/active-sessions")
    public String getActiveSessions(Model model) {
        // Add the active sessions to the model
        model.addAttribute("activeSessions", sessionManager.getActiveSessions());
        return "act-session";  // Return the name of the view template
    }

    @GetMapping("/remove-session/{sessionId}")
    public String removeSession(@RequestParam String sessionId, Model model) {
            sessionManager.removeSession(sessionId);
     
        return "remove_session";  // Return the name of the view template
    }
}