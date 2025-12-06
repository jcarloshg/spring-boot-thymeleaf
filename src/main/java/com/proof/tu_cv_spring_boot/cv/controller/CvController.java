package com.proof.tu_cv_spring_boot.cv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proof.tu_cv_spring_boot.cv.model.Person;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/cv")
@RequiredArgsConstructor
public class CvController {

    private final Person person;

    @GetMapping({ "", "/", "/index" })
    public String index(Model model) {
        // Person person = new Person("John", "Doe", "So");
        // model.addAttribute("name", "John");
        // model.addAttribute("person", person);
        model.addAttribute("property", person.getFirstName());
        return "index";
    }

    // @GetMapping({"/home", "/pepe"})
    // @RequestMapping(value = { "/home", "/pepe" }, method = RequestMethod.GET)
    @GetMapping({ "/home", "/pepe" })
    public String pepe() {
        return "pepe";
    }

}
