package com.accolite.coursemanagement.repository;

import com.accolite.coursemanagement.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//@Repository
public interface SkillRepository extends JpaRepository<Skill,Long> {
    String sql="select * from skill where name=?";
    @Query(value = sql,nativeQuery = true)
    Optional<Skill> findByName(String name);

    boolean existsByName(String name);


}
