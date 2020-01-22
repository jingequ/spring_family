package com.jin.demo.controller;

import com.jin.demo.common.CommonStr;
import com.jin.demo.dao.UserInfoDao;
import com.jin.demo.dao.model.MyEvenet;
import com.jin.demo.dao.model.UserInfo;
import com.jin.demo.integration.VendorService;
import com.jin.demo.service.UserService;
//import com.netflix.discovery.EurekaClient;
//import com.netflix.discovery.converters.Auto;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RestController()
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private VendorService vendorService;

//    @Autowired
//    private EurekaClient eurekaClient;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private CommonStr commonStr;

    @RequestMapping("/get")
    public UserInfo getOne(@RequestParam long id, @RequestParam String name, HttpServletRequest request) {
        UserInfo userInfo = userService.getUserInfo(id);
        UserInfo userInfo2 = userService.getUserInfoByDesc("2");
        System.out.println("test");
        System.out.println(userInfo2);
        if (id == 1) {
            System.out.println("set");
            System.out.println(new Date());
            request.getSession().setAttribute("name", name);
            System.out.println(request.getSession().getId());
            request.getSession().setAttribute("user", userInfo);
        } else if (id == 2) {
            System.out.println("get");
            System.out.println(new Date());
            System.out.println(request.getSession().getId());
            System.out.println(request.getSession().getAttribute("name"));
            System.out.println(request.getSession().getAttribute("user"));
        }
        return userInfo;
    }

    @PostMapping("/p2")
    public String p2(@RequestParam("name") String name) {
        return "hello " + name + "!";
    }

    @GetMapping("/get3")
    @Bulkhead(name = "order")
    public String get3(@RequestParam long id) {
        String s = vendorService.get(id);
//        System.out.println(eurekaClient.getNextServerFromEureka("vendor", true));
//        System.out.println();
//        System.out.println(eurekaClient.getNextServerFromEureka("vendor", false));
        publisher.publishEvent(new MyEvenet("id:"+id));
        if (StringUtils.isBlank(s)) {
            return "fail !";
        }
        return "success ! " + s;
    }

    @RequestMapping("/get4")
    public String get4() {
        return commonStr.toString();
    }
}
