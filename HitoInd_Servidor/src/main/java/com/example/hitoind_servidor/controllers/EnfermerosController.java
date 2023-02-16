package com.example.hitoind_servidor.controllers;

import com.example.hitoind_servidor.models.Usuarios;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EnfermerosController {

    @RequestMapping("/enfermeros")
    public ModelAndView enfermerosView(Authentication aut){
        ModelAndView mv = new ModelAndView();

        mv.addObject("auth", aut.getName());
        mv.setViewName("enfermeros");
        return mv;
    }

}
