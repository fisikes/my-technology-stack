package liyudong.controller;

import javax.servlet.http.HttpServletRequest;
import liyudong.aop.Token;
import liyudong.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/song")
public class SongController {

  @GetMapping("/addPage")
  @Token(save = true)
  public String addPage(HttpServletRequest request, Model model) {
    model.addAttribute("token", request.getSession().getAttribute("token"));
    return "song";
  }

  @PostMapping("/add")
  @Token(remove = true)
  public String add(HttpServletRequest request, Song song) {

    System.out.println(song.toString());
    return "redirect:index";
  }

  @ResponseBody
  @PostMapping("/do_post")
  public String doPost(Integer key1,Integer key2) {

    System.out.println("key1: "+key1);
    System.out.println("key2: "+key2);
    return "yes";
  }

}
