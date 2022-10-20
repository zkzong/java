package org.example.http;

import org.example.http.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/http")
public class HttpController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String testGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("age"));
        System.out.println(request.getParameter("sex"));
        return "success";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String testPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("age"));
        System.out.println(request.getParameter("sex"));
        return "success";
    }

    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public String testGetByObject(@ModelAttribute("user") User user, Model model) {
        System.out.println(user.getUserName());
        System.out.println(user.getUserAge());
        System.out.println(user.getUserSex());
        return "success";
    }

    @RequestMapping(value = "/index2", method = RequestMethod.POST)
    public String testPostByObject(@ModelAttribute("user") User user, Model model) {
        System.out.println(user.getUserName());
        System.out.println(user.getUserAge());
        System.out.println(user.getUserSex());
        return "success";
    }

    @RequestMapping(value = "/index3", method = RequestMethod.POST)
    @ResponseBody
    public User testPostByJson(@RequestBody User user, Model model) {
        System.out.println(user.getUserName());
        System.out.println(user.getUserAge());
        System.out.println(user.getUserSex());
        return user;
    }

    @RequestMapping(value = "/url", method = RequestMethod.POST)
    @ResponseBody
    public String url(HttpServletRequest request) {
        System.out.println("getRequestURI() : " + request.getRequestURI());
        System.out.println("getServletPath() : " + request.getServletPath());
        System.out.println("getRequestURL : " + request.getRequestURL());

//        getRequestURI() : /http/http/url
//        getServletPath() : /http/url
//        getRequestURL : http://localhost:8090/http/http/url
        return null;
    }
}
