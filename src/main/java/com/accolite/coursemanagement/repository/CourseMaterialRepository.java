package com.accolite.coursemanagement.repository;

import com.accolite.coursemanagement.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,String> {

    List<CourseMaterial> findByCourseId(Long courseId);


}
