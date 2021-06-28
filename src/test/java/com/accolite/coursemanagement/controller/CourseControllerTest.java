package com.accolite.coursemanagement.controller;

import com.accolite.coursemanagement.entity.Course;
import com.accolite.coursemanagement.entity.CourseMaterial;
import com.accolite.coursemanagement.entity.Skill;
import com.accolite.coursemanagement.entity.Trainer;
import com.accolite.coursemanagement.service.CourseService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CourseController.class)
class CourseControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CourseService courseService;




    @Test
    void getCourses() throws Exception {
        Course course = new Course(1,"spring boot","", new Date(),new Date(),"banglore","","", new ArrayList<Trainer>(), new ArrayList<Skill>(),new ArrayList<CourseMaterial>());
        Course course2 = new Course(15,"spring core","", new Date(),new Date(),"mumbai","","", new ArrayList<Trainer>(), new ArrayList<Skill>(),new ArrayList<CourseMaterial>());
        Course course3 = new Course(16,"spring jpa","", new Date(),new Date(),"ngp","best course","12", new ArrayList<Trainer>(), new ArrayList<Skill>(),new ArrayList<CourseMaterial>());
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(course);
        courses.add(course2);
        courses.add(course3);
        Mockito.when(courseService.getCourses()).thenReturn(courses);
        mockMvc.perform(get("/course"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("spring boot")))
                .andExpect(jsonPath("$[0].location", is("banglore")))
                .andExpect(jsonPath("$[1].id", is(15)))
                .andExpect(jsonPath("$[1].name", is("spring core")))
                .andExpect(jsonPath("$[1].location", is("mumbai")))
                .andExpect(jsonPath("$[2].description", is("best course")))
                .andExpect(jsonPath("$[2].prerequisite", is("12")));


    }
}