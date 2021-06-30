package com.accolite.coursemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@MappedSuperclass
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    protected long id;
    protected String email;


}
