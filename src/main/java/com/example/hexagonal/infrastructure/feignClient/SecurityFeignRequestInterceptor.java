package com.example.hexagonal.infrastructure.feignClient;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
public class SecurityFeignRequestInterceptor implements RequestInterceptor {

    //private static final String AUTHENTICATION_HEADER = "my-security-header";
    private static final String AUTHENTICATION_HEADER = "Authorization";
    @Override
    public void apply(RequestTemplate template) {
        System.out.println("pasa por apply iterceptor");
        //requestTemplate.header(AUTHORIZATION_HEADER, getBearerTokenHeader());
        propagateAuthorizationHeader(template);
    }

    private void propagateAuthorizationHeader(RequestTemplate template) {
        System.out.println("llega a Template Headers propagateAuthorizationHeader:"+template.headers());
        if (template.headers().containsKey(AUTHENTICATION_HEADER)) {
            log.trace("the authorization {} token has been already set", AUTHENTICATION_HEADER);

        } else {
            log.trace("setting the authorization token {}", AUTHENTICATION_HEADER);
            template.header(AUTHENTICATION_HEADER, SecurityContextHolder.getContext().getAuthentication().getName());
        }




    }}
