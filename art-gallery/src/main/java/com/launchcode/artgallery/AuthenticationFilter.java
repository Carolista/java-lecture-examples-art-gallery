package com.launchcode.artgallery;

import com.launchcode.artgallery.controllers.AuthenticationController;
import com.launchcode.artgallery.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class AuthenticationFilter implements HandlerInterceptor {

    // LaunchCode has this in their examples, but it is actually never used
    // @Autowired
    // UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    // Allow certain pages and static resources to be seen by the public (not logged in)
    private static final List<String> whitelist = Arrays.asList("/api", "/welcome", "/register", "/login", "/css", "/images");

    // Check all pages and static resources against blacklist
    private static boolean isWhitelisted(String path) {
        for (String pathRoot : whitelist) {
            if (path.equals("/") || path.startsWith(pathRoot)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

        // Don't require sign-in for whitelisted pages
        if (isWhitelisted(request.getRequestURI())) {
            // Early return to allow request to go through
            return true;
        }

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        // The user is logged in
        if (user != null) {
            return true;
        }

        // The user is NOT logged in
        response.sendRedirect("/login");
        return false;
    }
}
