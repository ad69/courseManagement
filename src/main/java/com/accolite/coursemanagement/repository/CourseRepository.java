package com.accolite.coursemanagement.repository;

import com.accolite.coursemanagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findCourseByLocation(String location);


    String findByCreator ="select * from coursemanagement.course join coursemanagement.creator on coursemanagement.course.id=coursemanagement.creator.course_id where coursemanagement.creator.name=?";
    @Query(value = findByCreator,nativeQuery = true)
    List<Course> findCourseByCreator(String trainerName);

    String findBySkill ="select * from coursemanagement.course join coursemanagement.skill on coursemanagement.course.id=coursemanagement.skill.course_id where coursemanagement.skill.name=?";
    @Query(value = findBySkill,nativeQuery = true)
    List<Course> findCourseBySkill(String skillName);

    String findLatest="select * from course order by created_at desc";
    @Query(value = findLatest,nativeQuery = true)
    List<Course> findLatestCourse();
}
