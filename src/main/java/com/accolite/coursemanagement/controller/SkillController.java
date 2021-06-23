package com.accolite.coursemanagement.controller;

import com.accolite.coursemanagement.entity.Skill;
import com.accolite.coursemanagement.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkillController {
    @Autowired
    SkillRepository skillRepository;

    @PostMapping("/skill")
    public void addSkill(@RequestBody Skill skill){
        System.out.println(skill);
        skillRepository.save(skill);
    }
    @GetMapping("/skill/{name}")
    public void getSkill(@PathVariable String name){
        System.out.println(name);
//        Skill skill = skillRepository.findByName(name);
//        List<Skill> skills = skillRepository.findByName(name);
//        System.out.println(skills);
    }

}
