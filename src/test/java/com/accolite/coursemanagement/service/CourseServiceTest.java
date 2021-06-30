package com.accolite.coursemanagement.service;

import com.accolite.coursemanagement.Dto.CourseDto;
import com.accolite.coursemanagement.entity.Course;
import com.accolite.coursemanagement.entity.CourseMaterial;
import com.accolite.coursemanagement.entity.Skill;
import com.accolite.coursemanagement.entity.Trainer;
import com.accolite.coursemanagement.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {

    CourseRepository courseRepository=Mockito.mock(CourseRepository.class);
    CourseService courseService;


    @BeforeEach
    public void setUp(){
        courseService =new CourseService(courseRepository);

    }


    @Test
    void getCourseById() {
        Course course = new Course(1,"spring boot","", new Date(),new Date(),"banglore","","", new ArrayList<Trainer>(), new ArrayList<Skill>(),new ArrayList<CourseMaterial>());
        Mockito.when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        assertEquals(Optional.of(course),courseService.getCourseById(1L));
    }



    @Test
    void getCourses() {
        Course course = new Course(1,"spring boot","", new Date(),new Date(),"banglore","","", new ArrayList<Trainer>(), new ArrayList<Skill>(),new ArrayList<CourseMaterial>());
        Mockito.when(courseRepository.findAll()).thenReturn(Arrays.asList(course));
        assertEquals(1,courseService.getCourses().size());
    }

    @Test
    void getCourseByLocation(){
        String location ="banglore";
        Course course = new Course(1,"spring boot","", new Date(),new Date(),location,"","", new ArrayList<Trainer>(), new ArrayList<Skill>(),new ArrayList<CourseMaterial>());
        Mockito.when(courseRepository.findCourseByLocation(location)).thenReturn(Arrays.asList(course));
        assertEquals(1,courseService.getCourseByLocation(location).size());
    }

    @Test
    void getCourseByTrainer(){
        String trainerName="me";
        Course course = new Course(1,"spring boot","", new Date(),new Date(),"location","","", new ArrayList<Trainer>(), new ArrayList<Skill>(),new ArrayList<CourseMaterial>());
        Mockito.when(courseRepository.findCourseByTrainer(trainerName)).thenReturn(Arrays.asList(course));
        assertEquals(1,courseService.getCourseByTrainer(trainerName).size());

    }

    @Test
    void getCourseBySkill(){
        String skillName="java";
        Course course = new Course(1,"spring boot","", new Date(),new Date(),"location","","", new ArrayList<Trainer>(), new ArrayList<Skill>(),new ArrayList<CourseMaterial>());
        Mockito.when(courseRepository.findCourseBySkill(skillName)).thenReturn(Arrays.asList(course));
        assertEquals(1,courseService.getCourseBySkill(skillName).size());
    }


    @Test
    void deleteCourseById() {
        Long id=15L;
        courseService.deleteCourseById(id);
        Mockito.verify(courseRepository,Mockito.times(1)).deleteById(id);
    }


    @Test
    void getLatestCourse(){
        Course course = new Course(1,"spring boot","", new Date(),new Date(),"location","","", new ArrayList<Trainer>(), new ArrayList<Skill>(),new ArrayList<CourseMaterial>());
        Mockito.when(courseRepository.findLatestCourse()).thenReturn(Arrays.asList(course));
        assertEquals(1,courseService.getLatestCourse().size());

    }

}