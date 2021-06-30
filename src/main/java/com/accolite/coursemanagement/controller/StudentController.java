package com.accolite.coursemanagement.controller;

import com.accolite.coursemanagement.Dto.StudentDto;
import com.accolite.coursemanagement.entity.Course;
import com.accolite.coursemanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController()
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping
    public void addStudent(@RequestBody StudentDto studentDto){
        System.out.println(studentDto);
        studentService.addStudent(studentDto);
    }

    @PostMapping("/course/{courseId}")
    public void enrollToCourse(@PathVariable Long courseId) {

//        get id  of current logged in user
        Long studentId =2L;
        studentService.enrollToCourse(courseId,studentId);
    }

    @GetMapping
    public List<Course> getEnrolledCourses(){
        //        get id  of current logged in user
        Long studentId =2L;
        List<Course> courses = studentService.getEnrolledCourses(studentId);
        if (!courses.isEmpty()){
            return courses;
        }
        return null;

    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);

    }



}
