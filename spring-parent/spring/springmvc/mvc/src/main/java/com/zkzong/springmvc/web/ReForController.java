package com.zkzong.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zong on 16-9-15.
 */
@Controller
public class ReForController {

    @RequestMapping(value = "/re", method = RequestMethod.GET)
    public String re() {
        return "redirect:redirectPage";
    }

    @RequestMapping(value = "/redirectPage", method = RequestMethod.GET)
    public String redirectPage() {
        return "redirectPage";
    }

    @RequestMapping(value = "/forw", method = RequestMethod.GET)
    public String forw() {
        return "forward:forwardPage";
    }

    @RequestMapping(value = "/forwardPage", method = RequestMethod.GET)
    public String forwardPage() {
        return "forwardPage";
    }
}
