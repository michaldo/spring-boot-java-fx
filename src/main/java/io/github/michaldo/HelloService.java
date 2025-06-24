package io.github.michaldo;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String sayHello() {
        return "Hello World!";
    }
}
