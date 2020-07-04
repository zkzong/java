package com.zkzong.sc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zong on 2017/6/29.
 */
@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        StringBuilder result = new StringBuilder();

        // GET
        result.append(restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody()).append("<br>");

        result.append(restTemplate.getForEntity("http://HELLO-SERVICE/hello1?name={1}", String.class, "zong").getBody()).append("<br>");

        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "zong");
        result.append(restTemplate.getForEntity("http://HELLO-SERVICE/hello1?name={name}", String.class, params).getBody()).append("<br>");

        UriComponents uriComponents = UriComponentsBuilder.fromUriString(
                "http://HELLO-SERVICE/hello1?name={name}")
                .build()
                .expand("zong")
                .encode();
        URI uri = uriComponents.toUri();
        result.append(restTemplate.getForEntity(uri, String.class).getBody()).append("<br>");

        // POST
        User user = new User("zong", 20);
        String postResult = restTemplate.postForObject("http://HELLO-SERVICE/hello3", user, String.class);
        result.append(postResult).append("<br>");

        user = new User("zong", 30);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://HELLO-SERVICE/hello3", user, String.class);
        result.append(responseEntity.getBody()).append("<br>");

        user = new User("zong", 40);
        URI responseURI = restTemplate.postForLocation("http://HELLO-SERVICE/hello3", user);
        result.append(responseURI).append("<br>");

//        Long id = 10001L;
//        restTemplate.delete("http://USER-SERVICE/user/{1}",  id);

        return result.toString();
    }

}
