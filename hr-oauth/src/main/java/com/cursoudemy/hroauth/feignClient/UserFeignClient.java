package com.cursoudemy.hroauth.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cursoudemy.hroauth.model.User;

@Component
@FeignClient(name = "hr-user", path = "user")
public interface UserFeignClient {

    @GetMapping("/findbyemail")
    ResponseEntity<User> findByEmail(@RequestParam String email);
    
    @GetMapping("/findbyusername")
    ResponseEntity<User> findByUsername(@RequestParam String username);
}
