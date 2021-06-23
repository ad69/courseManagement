package com.accolite.coursemanagement.controller;

import com.accolite.coursemanagement.entity.Creator;
import com.accolite.coursemanagement.repository.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreatorController {
    @Autowired
    CreatorRepository creatorRepository;





}
