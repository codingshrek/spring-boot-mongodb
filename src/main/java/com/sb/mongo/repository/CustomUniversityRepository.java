package com.sb.mongo.repository;

import com.sb.mongo.repository.entity.University;

import java.util.List;

public interface CustomUniversityRepository {

    List<University> getUniversitiesInSortedOrder();
}
