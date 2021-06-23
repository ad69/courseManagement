package com.accolite.coursemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseMaterial {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String type;
    @Lob
    private byte[] data;
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    public CourseMaterial(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }
}
