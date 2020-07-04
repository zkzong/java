package com.zkzong.chapter1.web.servlet;

import com.zkzong.chapter1.javabean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Zong on 2016/9/28.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);//为了简单，直接委托给doPost进行处理
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String submitFlag = req.getParameter("submitFlag");
        if ("toLogin".equals(submitFlag)) {
            toLogin(req, resp);
            return;
        } else if ("login".equals(submitFlag)) {
            login(req, resp);
            return;
        }
        super.doPost(req, resp);
    }

    private void toLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        String loginPath = req.getContextPath() + "/servletLogin";
        PrintWriter write = resp.getWriter();
        write.write("<form action='" + loginPath + "' method='post'>");
        write.write("<input type='text' name='submitFlag' value='login'/>");
        write.write("username:<input type='text' name='username'/>");
        write.write("password:<input type='password' name='password'/>");
        write.write("<input type='submit' value='login'/>");
        write.write("</form>");
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1收集参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2验证并封装参数(重复的步骤)
        UserBean user = new UserBean();
        user.setUsername(username);
        user.setPassword(password);
        //3调用javabean对象（业务方法）
        if (user.login()) {
            //4根据返回值选择下一个页面
            resp.getWriter().write("login success");
        } else {
            resp.getWriter().write("login fail");
        }
    }
}
