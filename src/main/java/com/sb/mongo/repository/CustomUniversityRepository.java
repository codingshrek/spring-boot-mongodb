package com.sb.mongo.repository;

import com.sb.mongo.repository.entity.University;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

public interface CustomUniversityRepository {

    List<University> getUniversitiesInSortedOrder();
    List<String> getUniversitiesUnwindedAndSorted();
}
