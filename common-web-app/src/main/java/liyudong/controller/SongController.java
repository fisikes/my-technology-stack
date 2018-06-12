package liyudong.controller;

import liyudong.aop.Token;
import liyudong.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
  public String add(HttpServletRequest request,Song song) {

    System.out.println(song.toString());
    return "index";
  }


}
