package com.example.hitoind_servidor.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public ModelAndView peticionSesion() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }


    @RequestMapping("/")
    public ModelAndView peticionRaiz(Authentication aut) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("user", aut);



        mv.setViewName("home");
        return mv;
    }
    @RequestMapping("/denegado")
    public ModelAndView peticionDenegada() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("denegado");
        return mv;
    }

}
