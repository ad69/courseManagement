package com.accolite.coursemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Course {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String feedback;
    private Date createdAt;
    private Date updatedAt;
    private String location;
    private String prerequisite;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId")
    private List<Trainer> trainers;
    @JoinColumn(name = "courseId")
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Skill> skills;


}
