package com.accolite.coursemanagement.repository;

import com.accolite.coursemanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
//    String getCourses ="select courses_id from student_courses where student_id=?";
//    @Query(value = getCourses,nativeQuery = true)
//    List<Long> getEnrolledCoursesId(Long student_id);

}
