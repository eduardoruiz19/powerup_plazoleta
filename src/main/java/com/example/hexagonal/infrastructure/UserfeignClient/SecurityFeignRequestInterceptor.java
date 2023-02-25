package com.example.hexagonal.infrastructure.UserfeignClient;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

@Slf4j
public class SecurityFeignRequestInterceptor implements RequestInterceptor {

    //private static final String AUTHENTICATION_HEADER = "my-security-header";
    private static final String AUTHENTICATION_HEADER = "Authorization";
    @Override
    public void apply(RequestTemplate template) {
        System.out.println("pasa por apply iterceptor");
        System.out.println(template.headers());
        //requestTemplate.header(AUTHORIZATION_HEADER, getBearerTokenHeader());
        propagateAuthorizationHeader(template);
    }

    private void propagateAuthorizationHeader(RequestTemplate template) {
        System.out.println("llega a Template Headers propagateAuthorizationHeader:"+template.headers());
        System.out.println(template.headers());
        if (template.headers().containsKey(AUTHENTICATION_HEADER)) {
            System.out.println("the authorization {"+ AUTHENTICATION_HEADER+"} token has been already set");
            log.trace("the authorization {} token has been already set", AUTHENTICATION_HEADER);

        } else {
            log.trace("setting the authorization token {}", AUTHENTICATION_HEADER);
            System.out.println("setting the authorization token "+ AUTHENTICATION_HEADER);
            template.header(AUTHENTICATION_HEADER, SecurityContextHolder.getContext().getAuthentication().getName());
        }




    }}
