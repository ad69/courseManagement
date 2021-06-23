package com.accolite.coursemanagement.controller;

import com.accolite.coursemanagement.Dto.ResponseFile;
import com.accolite.coursemanagement.Dto.ResponseMessage;
import com.accolite.coursemanagement.entity.Course;
import com.accolite.coursemanagement.entity.CourseMaterial;
import com.accolite.coursemanagement.service.CourseMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CourseMaterialController {
    @Autowired
    private CourseMaterialService courseMaterialService;


    @PostMapping("/upload")
//    add courseid to db or get course id from url
    public ResponseEntity<ResponseMessage> uploadMaterial(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            courseMaterialService.store(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }


    @GetMapping("/material")
    public ResponseEntity<List<ResponseFile>> getAllMaterial() {
        List<ResponseFile> files = courseMaterialService.getAllMaterials().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/material/")
                    .path(dbFile.getId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/material/{id}")
    public ResponseEntity<byte[]> getMaterial(@PathVariable String id) {
        CourseMaterial material = courseMaterialService.getMaterial(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + material.getName() + "\"")
                .body(material.getData());
    }

    @GetMapping("/course/material/{courseId}")
    public ResponseEntity<List<ResponseFile>> getMaterialByCourse(@PathVariable long courseId){
        List<ResponseFile> files = courseMaterialService.getMaterialByCourse(courseId).map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/material/")
                    .path(dbFile.getId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);

    }
}
