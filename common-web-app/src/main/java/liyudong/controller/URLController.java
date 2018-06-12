package liyudong.controller;

import liyudong.aop.Token;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class URLController {

  @Token(save = true)
  @RequestMapping("/save_token")
  @ResponseBody
  public String getToken(HttpServletRequest request, HttpServletResponse response) {
    return (String) request.getSession().getAttribute("token");
  }

  @Token(remove = true)
  @RequestMapping("/remove_token")
  @ResponseBody
  public String removeToken(HttpServletRequest request, HttpServletResponse response) {
    return "success";
  }
}