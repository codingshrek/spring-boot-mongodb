package com.sb.mongo.service;

import com.sb.mongo.repository.entity.University;
import com.sb.mongo.service.dto.UniversityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UniversityMapper {

    /*@Mappings(
            {@Mapping(target = "id",ignore = true)}
    )*/
    UniversityDto entityToApi(University university);
}
