package com.proof.tu_cv_spring_boot.cv.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proof.tu_cv_spring_boot.cv.model.Skill;

@Controller
@RequestMapping("/skills")
public class SkillsController {

    private final List<Skill> skills = new ArrayList<>(
            List.of(
                    new Skill("Java", "Advanced"),
                    new Skill("Spring Boot", "Intermediate"),
                    new Skill("Thymeleaf", "Intermediate"),
                    new Skill("RESTful APIs", "Advanced"),
                    new Skill("SQL", "Intermediate"),
                    new Skill("Git", "Advanced")));

    // @GetMapping
    // public String showSkills(Model model) {
    // // List<String> skills = Arrays.asList("Java", "Spring Boot", "Thymeleaf",
    // // "RESTful APIs", "SQL", "Git");
    // model.addAttribute("skills", skills);
    // return "skills";
    // }

    @GetMapping
    public String showSkills(@RequestParam(defaultValue = "", required = false) String filter, Model model) {
        List<Skill> filteredSkill = skills.stream()
                .filter(skill -> filter == null || skill.getName().toLowerCase().contains(filter.toLowerCase()))
                .toList();

        // List<String> skills = Arrays.asList("Java", "Spring Boot", "Thymeleaf",
        // "RESTful APIs", "SQL", "Git");
        model.addAttribute("skills", filteredSkill);
        model.addAttribute("filter", filter);
        return "skills";
    }

    @GetMapping("/{index}")
    public String showSkillDetails(@PathVariable int index, Model model) {
        if (index < 0 || index >= skills.size()) {
            return "redirect:/skills";
        }
        Skill skill = skills.get(index);
        model.addAttribute("skill", skill);
        return "skill-details";
    }

    /**
     * Handles GET requests to retrieve a skill by its name and level.
     * <p>
     * Searches the list of skills for a skill matching the provided name and level
     * (case-insensitive).
     * If found, adds the skill and a success message to the model and returns the
     * "skill-details" view.
     * If not found, redirects to the skills list page.
     * </p>
     *
     * @param name  the name of the skill to search for (from the URL path)
     * @param level the level of the skill to search for (from the URL path)
     * @param model the Spring Model to pass attributes to the view
     * @return the name of the view to render ("skill-details") if found, or a
     *         redirect to "/skills" if not found
     */
    @GetMapping("/{name}/{level}")
    public String showSkillByNameAndLevel(@PathVariable String name, @PathVariable String level, Model model) {
        Skill skill = skills.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name) && s.getLevel().equalsIgnoreCase(level))
                .findFirst()
                .orElse(null);

        if (skill == null) {
            return "redirect:/skills";
        }

        model.addAttribute("skill", skill);
        model.addAttribute("message", "Skill found: " + name + " with level " + level);

        return "skill-details";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("skill", new Skill());
        return "add-skills";
    }

    @PostMapping("/add")
    public String addSkill(@ModelAttribute Skill skill) {
        skills.add(skill);
        return "redirect:/skills";
    }

    @ModelAttribute(name = "skills2")
    public List<Skill> getSkills() {
        return skills;
    }

}