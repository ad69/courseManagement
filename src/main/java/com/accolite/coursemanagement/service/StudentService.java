package com.accolite.coursemanagement.service;


import com.accolite.coursemanagement.Dto.StudentDto;
import com.accolite.coursemanagement.entity.Course;
import com.accolite.coursemanagement.entity.Student;
import com.accolite.coursemanagement.repository.CourseRepository;
import com.accolite.coursemanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;


    public void addStudent(StudentDto studentDto) {
        Student student = mapDtoToObject(studentDto);
        studentRepository.save(student);


    }

    public Student mapDtoToObject(StudentDto studentDto) {
        Student student = new Student();
        student.setEmail(studentDto.getEmail());
        student.setQualification(studentDto.getQualification());
        return student;
    }


    public void enrollToCourse(Long courseId, Long studentId){
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            Course course = courseRepository.findOne(courseId);
            System.out.println(course);
            List<Course> courses = student.getCourses();
            courses.add(course);
            student.setCourses(courses);
            try {
                studentRepository.save(student);
            }catch (DataIntegrityViolationException e){
                System.out.println(e);
            }


        }
    }

    public List<Course> getEnrolledCourses(Long studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            List<Course> courses = student.getCourses();
            System.out.println(courses);
            return courses;

        }
        return null;
    }

    public void deleteStudent(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()){
            studentRepository.deleteById(studentId);
        }
    }
}