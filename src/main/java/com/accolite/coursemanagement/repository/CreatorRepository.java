package com.accolite.coursemanagement.repository;

import com.accolite.coursemanagement.entity.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;




@Repository
public interface CreatorRepository extends JpaRepository<Creator,Long> {





}
