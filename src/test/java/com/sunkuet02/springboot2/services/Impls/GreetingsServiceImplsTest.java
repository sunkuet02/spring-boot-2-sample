package com.sunkuet02.springboot2.services.Impls;

import com.sunkuet02.springboot2.services.GreetingsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class GreetingsServiceImplsTest {

    @TestConfiguration
    static class GreetingsServiceImplsTestConfig {
        @Bean
        public GreetingsService greetingsService() {
            return new GreetingsServiceImpls();
        }
    }

    @Autowired
    private GreetingsService greetingsService;

    @Test
    public void hello() {
        String helloResponse = greetingsService.hello();
        assertEquals("hello", helloResponse);
    }
}