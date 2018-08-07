package com.sunkuet02.springboot2.services.Impls;

import com.sunkuet02.springboot2.services.GreetingsService;
import org.springframework.stereotype.Service;

@Service
public class GreetingsServiceImpls implements GreetingsService {
    @Override
    public String hello() {
        return "hello";
    }

}
