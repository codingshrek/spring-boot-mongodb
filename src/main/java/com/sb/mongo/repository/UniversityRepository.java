package com.sb.mongo.repository;

import com.sb.mongo.repository.entity.University;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UniversityRepository extends CrudRepository<University,String>,CustomUniversityRepository {

    //Using method name
    Optional<University> findByName(String name);

    //Using @Query annotation

    //Where name is passed parameter
    //Return type can also be Stram
    @Query(value = "{name:?0}")
    Optional<University> findByNameUsingQuery(String name);

    //Use of $and operator with less than and greater than
    @Query(value = "{$and:[{rank:{$lt:?0}},{rank:{$gt:?1}}]}")
    List<University> findUniversitiesBasedOnRank(Integer lessThan,Integer greaterThan);

    //Use of complex $and and $or with $regex
    //Where name starts with passed regex and Country and City
    @Query("{$and:[{name:?0,$or:[{city:{$regex:?1}},{country:{$regex:?2}}]}]}")
    List<University> findUniversitiesBasedOnRegex(String regex, String city, String country);



}
