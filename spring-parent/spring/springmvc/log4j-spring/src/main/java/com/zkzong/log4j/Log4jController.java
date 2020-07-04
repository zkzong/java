package com.zkzong.log4j;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Zong on 2017/3/20.
 */
@Controller
@RequestMapping(value = "/log4j")
public class Log4jController {

    private static final Logger LOGGER = Logger.getLogger(Log4jController.class);

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("get is executed!");
        }

        LOGGER.error("This is Error message", new Exception("Testing"));

        ModelAndView model = new ModelAndView("welcome");
        model.addObject("msg", "Hello Spring MVC + Log4j");
        return model;
    }
}
