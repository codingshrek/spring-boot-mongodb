package com.sb.mongo.repository;

import com.sb.mongo.repository.entity.University;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UniversityRepository extends CrudRepository<University,String>,CustomUniversityRepository {

    Optional<University> findByName(String name);
}
