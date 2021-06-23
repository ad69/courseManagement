package com.accolite.coursemanagement.service;

import com.accolite.coursemanagement.entity.Course;
import com.accolite.coursemanagement.entity.CourseMaterial;
import com.accolite.coursemanagement.repository.CourseMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CourseMaterialService {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    public void store(MultipartFile file) throws IOException{
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        CourseMaterial courseMaterial = new CourseMaterial(fileName, file.getContentType(), file.getBytes());
        courseMaterialRepository.save(courseMaterial);

    }

    public CourseMaterial getMaterial(String id){
        Optional<CourseMaterial> courseMaterial = courseMaterialRepository.findById(id);
        //throw exception
        return courseMaterial.orElse(null);
    }

    public Stream<CourseMaterial> getAllMaterials() {
        return courseMaterialRepository.findAll().stream();
    }

    public Stream<CourseMaterial> getMaterialByCourse(long courseId) {
        return courseMaterialRepository.findByCourseId(courseId).stream();
    }
}
