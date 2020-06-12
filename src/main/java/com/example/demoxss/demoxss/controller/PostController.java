package com.example.demoxss.demoxss.controller;


import com.example.demoxss.demoxss.entity.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PostController {

    @GetMapping("/login")
    public String welcome(Model model,@RequestParam String redirect){
        model.addAttribute("post",new Post());
        model.addAttribute("redirect",redirect);
        return "login";
    }
    @PostMapping("/login")
    public String login(Post post){
        if(post.getRedirect() != null){
            return "redirect:"+post.getRedirect();
        }
//        if (post.getRedirect() != null && isRelative(post.getRedirect())) {
//            return "redirect:"+post.getRedirect();
//        }
//        return "redirect:/";
        return "redirect:/";
    }
    private boolean isRelative(String url) {
        return url.matches("/[^/\\]?.*");
    }
}
