package org.example.sb.runner.commandlinerunner;

import org.springframework.stereotype.Service;

/**
 * @author zkzong
 * @date 2017/11/30
 */
@Service
public class HelloService {
    public String getMessage() {
        return "Hello World!";
    }
}
