package com.chadium.chadiumapi.contrllers;

import ch.qos.logback.core.model.Model;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class OAuth2LoginController {


    @GetMapping({"/", "/login/oauth2/code/google"})
    public ResponseEntity<String> test1(@AuthenticationPrincipal OAuth2User principal){
        return new ResponseEntity<>("asd", HttpStatus.OK);
    }
}