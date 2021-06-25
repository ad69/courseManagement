package com.accolite.coursemanagement.controller;

import com.accolite.coursemanagement.Dto.CourseDto;
import com.accolite.coursemanagement.entity.Course;
import com.accolite.coursemanagement.entity.Skill;
import com.accolite.coursemanagement.entity.Trainer;
import com.accolite.coursemanagement.repository.CourseRepository;
import com.accolite.coursemanagement.service.CourseMaterialService;
import com.accolite.coursemanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@CrossOrigin
@RestController()
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseMaterialService courseMaterialService;


    @PostMapping
    public void addCourse(@RequestBody CourseDto courseDto) {
        System.out.println(courseDto);
        courseService.addCourse(courseDto);
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/{courseId}")
    public ResponseEntity getCourseById(@PathVariable long courseId) {


        Optional<Course> course = courseService.getCourseById(courseId);
        if (course.isPresent()) {
            System.out.println(course);
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
        return new ResponseEntity("Course Not Found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<String> deleteCourseById(@PathVariable long courseId) {
        Optional<Course> course = courseService.getCourseById(courseId);
        if (course.isPresent()) {
            courseService.deleteCourseById(courseId);
            return new ResponseEntity<>("Course Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);


    }

    @PatchMapping
    public void updateCourse(@RequestBody Course course) {
        System.out.println(course);
        course.setUpdatedAt(new Date());
        courseService.updateCourse(course);
    }

    @GetMapping("/location/{location}")
    public List<Course> getCourseByLocation(@PathVariable String location) {
        return courseService.getCourseByLocation(location);
    }

    @GetMapping("/trainer/{trainerName}")
    public List<Course> getCourseByTrainer(@PathVariable String trainerName) {
        System.out.println(trainerName);
        return courseService.getCourseByTrainer(trainerName);
    }

    @GetMapping("/skill/{skillName}")
    public List<Course> getCourseBySkill(@PathVariable String skillName) {
        return courseService.getCourseBySkill(skillName);
    }

    @GetMapping("/recent")
    public List<Course> getLatestCourse() {
        return courseService.getLatestCourse();
    }


}
