package com.accolite.coursemanagement.service;

import com.accolite.coursemanagement.Dto.CourseDto;
import com.accolite.coursemanagement.entity.Course;
import com.accolite.coursemanagement.entity.Creator;
import com.accolite.coursemanagement.entity.Skill;
import com.accolite.coursemanagement.repository.CourseRepository;
import com.accolite.coursemanagement.repository.CreatorRepository;
import com.accolite.coursemanagement.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    CreatorRepository creatorRepository;


    public void addCourse(CourseDto courseDto){
        Course course=new Course();
        course.setName(courseDto.getName());
        course.setLocation(courseDto.getLocation());
        course.setCreatedAt(new Date());
        course.setFeedback(courseDto.getFeedback());
        ArrayList<Skill> skills = new ArrayList<>();
        for (int i = 0; i < courseDto.getSkills().size(); i++) {
            skills.add(new Skill(courseDto.getSkills().get(i)));

        }
        ArrayList<Creator> creators = new ArrayList<>();
        for (int i = 0; i < courseDto.getCreators().size(); i++) {
            creators.add(new Creator(courseDto.getCreators().get(i)));
        }
        course.setSkills(skills);
        course.setCreators(creators);
        courseRepository.save(course);
        System.out.println("done");

    }


    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(long courseId) {
        return courseRepository.findById(courseId);
    }

    public void deleteCourseById(long courseId) {
        courseRepository.deleteById(courseId);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }


    public Course dtoToObject(CourseDto courseDto){
        Course course=new Course();
        course.setName(courseDto.getName());
        course.setLocation(courseDto.getLocation());
        ArrayList<Skill> skills = new ArrayList<>();
        for (int i = 0; i < courseDto.getSkills().size(); i++) {
            skills.add(new Skill(courseDto.getSkills().get(i)));

        }
        ArrayList<Creator> creators = new ArrayList<>();
        for (int i = 0; i < courseDto.getCreators().size(); i++) {
            creators.add(new Creator(courseDto.getCreators().get(i)));
        }
        course.setSkills(skills);
        course.setCreators(creators);
        return course;

    }

    public List<Course> getCourseByLocation(String location) {
        return courseRepository.findCourseByLocation(location);
    }

    public List<Course> getCourseByTrainer(String trainerName) {
        return courseRepository.findCourseByCreator(trainerName);
    }

    public List<Course> getCourseBySkill(String skillName) {
        return courseRepository.findCourseBySkill(skillName);
    }


    public List<Course> getLatestCourse() {
        return courseRepository.findLatestCourse();
    }
}
