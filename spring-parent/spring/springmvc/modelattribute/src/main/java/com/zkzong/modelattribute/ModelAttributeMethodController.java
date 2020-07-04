package com.zkzong.modelattribute;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Zong
 * @Date: 2018/11/10
 */
@Controller
@RequestMapping(value = "/modelattribute")
public class ModelAttributeMethodController {

    @ModelAttribute
    public void myModel(@RequestParam(required = false) String abc, Model model) {
        model.addAttribute("attributeName", abc);
    }

    //@ModelAttribute
    //public String myModel(@RequestParam(required = false) String abc) {
    //    return abc;
    //}

    //@ModelAttribute
    //public Student myModel(@RequestParam(required = false) String abc) {
    //    Student student = new Student(abc);
    //    return student;
    //}

    //@ModelAttribute
    //public int myModel(@RequestParam(required = false) int number) {
    //    return number;
    //}

    //@ModelAttribute(value = "num")
    //public int myModel(@RequestParam(required = false) int number) {
    //    return number;
    //}

    @RequestMapping(value = "/method")
    public String method(@RequestParam(required = false) String abc, Model model) {
        return "method";
    }
}
