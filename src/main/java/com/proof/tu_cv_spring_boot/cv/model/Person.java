package com.proof.tu_cv_spring_boot.cv.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates getters, setters, toString, equals, and hashCode
@AllArgsConstructor // Generates a constructor with all fields as parameters
@NoArgsConstructor // Generates a no-argument constructor
@Component
public class Person {

    @Value("${person.firstName}")
    private String firstName;

    private String name;
    private String lastName;
    private String profession;

}
