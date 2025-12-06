package com.proof.tu_cv_spring_boot.cv.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proof.tu_cv_spring_boot.cv.model.Person;

@RestController
@RequestMapping("/api")
public class CvApiController {

    @RequestMapping("/cv")
    public Person getPerson() {
        return new Person("John", "Doe", "Software Engineer", " ");
    }
}
