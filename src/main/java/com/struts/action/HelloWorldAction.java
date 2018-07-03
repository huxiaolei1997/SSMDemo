package com.struts.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author xiaolei hu
 * @date 2018/7/3 19:34
 **/
public class HelloWorldAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        System.out.println("执行Action");
        return SUCCESS;
    }

    public String add() {
        return "add";
    }

    public String update() {
        return "update";
    }
}
