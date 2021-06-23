package com.accolite.coursemanagement.controller;

import com.accolite.coursemanagement.entity.Trainer;
import com.accolite.coursemanagement.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TrainerController {
    @Autowired
    TrainerRepository trainerRepository;





}
