package com.sb.mongo.repository;

import com.sb.mongo.repository.entity.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public class CustomUniversityRepositoryImpl implements CustomUniversityRepository {

    private MongoTemplate mongoTemplate;

    @Autowired
    public CustomUniversityRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<University> getUniversitiesInSortedOrder() {

        SortOperation sortOperation= Aggregation.sort(Sort.by(Sort.Direction.ASC,"name"));
        Aggregation aggregation= Aggregation.newAggregation(sortOperation);
        AggregationResults<University> results=mongoTemplate.aggregate(aggregation,"universities",University.class);
        return results.getMappedResults();
    }
}
