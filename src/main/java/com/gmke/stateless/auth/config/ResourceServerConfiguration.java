package com.gmke.stateless.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    private ClientResources clientResources;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/profile").authorizeRequests().anyRequest().authenticated();
        http.antMatcher("/scopes").authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    public OAuth2RestTemplate restTemplate() {
        return new OAuth2RestTemplate(clientResources.getClient());
    }
}
