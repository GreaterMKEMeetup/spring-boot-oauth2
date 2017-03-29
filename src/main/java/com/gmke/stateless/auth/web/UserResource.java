package com.gmke.stateless.auth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserResource {

    private final OAuth2RestTemplate restTemplate;

    @Autowired
    public UserResource(OAuth2RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/profile")
    public Map<String, String> user(Principal principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());

        return map;
    }

    @RequestMapping("/scopes")
    public List<String> testStuffs() {
        return restTemplate.getResource().getScope();
    }

}
