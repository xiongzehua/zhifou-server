package com.xiongzehua.freetalk.controller;

import com.xiongzehua.freetalk.common.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.LinkedHashMap;

/**
 * Created by xiongzehua on 2019/3/9.
 */
@RequestMapping("/test")
@Controller
public class TestController {

    /**
     * 若参数中带HttpSession httpSession
     * 第一次请求的response中会带
     * Set-Cookie: JSESSIONID=39C09DCD23FD3261280AA9AE8F0A4B1D; Path=/; HttpOnly
     * 第二次及以后请求的request中会带
     * Cookie: JSESSIONID=39C09DCD23FD3261280AA9AE8F0A4B1D
     * @param httpSession
     * @return
     */
    @GetMapping("/helloWithSession")
    @ResponseBody
    public Response helloWithSession(HttpSession httpSession) {
        return Response.success("helloWithSession");
    }

    @GetMapping("/request")
    @ResponseBody
    public Response request(HttpServletRequest httpServletRequest,
                              HttpServletResponse httpServletResponse,
                              HttpSession httpSession) {
        System.out.println("springmvc");
        LinkedHashMap hashMap = new LinkedHashMap();
        hashMap.put("httpServletRequest.getRequestURL()", httpServletRequest.getRequestURL());
        hashMap.put("httpServletRequest.getRequestURI()", httpServletRequest.getRequestURI());
        hashMap.put("httpServletRequest.getRemoteAddr()", httpServletRequest.getRemoteAddr());
        hashMap.put("httpServletRequest.getRemoteHost()", httpServletRequest.getRemoteHost());
        hashMap.put("httpServletRequest.getRemotePort()", httpServletRequest.getRemotePort());
        hashMap.put("httpServletRequest.getMethod()", httpServletRequest.getMethod());
        hashMap.put("httpServletRequest.getQueryString()", httpServletRequest.getQueryString());

        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            hashMap.put("httpServletRequest.header." + headerName, httpServletRequest.getHeader(headerName));
        }
        hashMap.put("httpServletResponse", httpServletResponse.toString());
        hashMap.put("httpSession", httpSession.toString());
        return Response.success(hashMap);
    }

    @GetMapping("/cookie/signIn")
    @ResponseBody
    public Response cookieSignIn(HttpServletResponse httpServletResponse) {
        Cookie cookie1 = new Cookie("userId","5");
        Cookie cookie2 = new Cookie("userName","zhang3");
        cookie1.setPath("/"); // 此ip下所有uri有效
        cookie2.setPath("/"); // 此ip下所有uri有效
        cookie1.setMaxAge(60 * 60 * 24);
        cookie2.setMaxAge(60 * 60 * 24);
        httpServletResponse.addCookie(cookie1);
        httpServletResponse.addCookie(cookie2);
        return Response.success();
    }

    @GetMapping("/cookie/signOut")
    @ResponseBody
    public Response cookieSignOut(HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie("userName","zhang3");
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
        return Response.success();
    }

    @GetMapping("/cookie/business")
    @ResponseBody
    public Response cookieBusiness(HttpServletResponse httpServletResponse) {
        return Response.success();
    }


    @GetMapping("/session/signIn")
    @ResponseBody
    public Response signIn(HttpSession httpSession) {
        // 验证用户名密码 假设userId = 5的用户已经验证成功
        httpSession.setAttribute("userId", 5);
        return Response.success();
    }

    @GetMapping("/session/signOut")
    @ResponseBody
    public Response signOut(HttpSession httpSession) {
        httpSession.removeAttribute("userId");
        return Response.success();
    }

    @GetMapping("/session/business")
    @ResponseBody
    public Response business(HttpSession httpSession) {
        LinkedHashMap hashMap = new LinkedHashMap();
        hashMap.put("httpSession.getId", httpSession.getId());

        Enumeration<String> attributeNames = httpSession.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            hashMap.put("httpSession.attributeName." + attributeName, httpSession.getAttribute(attributeName));
        }

        return Response.success(hashMap);
    }

    @GetMapping("/hello")
    @ResponseBody
    public Response hello() {
        return Response.success("hello app");
    }
}
