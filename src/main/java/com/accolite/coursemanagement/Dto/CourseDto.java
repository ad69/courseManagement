package com.accolite.coursemanagement.Dto;

import com.accolite.coursemanagement.entity.Trainer;
import com.accolite.coursemanagement.entity.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDto {
    private String name;
    private String feedback;
    private String location;
    private String prerequisite;
    private List<String> skills;
    private List<String> trainers;
    private String description;

}
