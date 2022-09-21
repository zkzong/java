package org.example.lb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
public class NacosProvider4LoadBalance {

    public static void main(String[] args) {
        SpringApplication.run(NacosProvider4LoadBalance.class, args);
    }

    @RestController
    class EchoController {

        @GetMapping("/")
        public String echo(HttpServletRequest request) {
            return request.getLocalAddr() + ":" + request.getLocalPort();
        }

    }

}
