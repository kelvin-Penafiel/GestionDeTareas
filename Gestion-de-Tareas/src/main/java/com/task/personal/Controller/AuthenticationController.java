package com.task.personal.Controller;

import com.task.personal.jwt.JwtService;
import com.task.personal.models.AuthenticationRequest;
import com.task.personal.models.AuthenticationResponse;
import com.task.personal.Service.MyUserDetailsService;
import com.task.personal.response.ApiResponse;
import com.task.personal.response.HeaderApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthenticationResponse>> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        logger.info("Login users");
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtService.getToken(userDetails);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(jwt);

        HeaderApp headerApp = new HeaderApp(HttpStatus.OK.value(), "Successfully authenticated");
        ApiResponse<AuthenticationResponse> response = new ApiResponse<>(headerApp, authenticationResponse);

        return ResponseEntity.ok(response);
    }
}