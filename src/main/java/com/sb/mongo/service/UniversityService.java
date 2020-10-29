package com.sb.mongo.service;

import com.sb.mongo.repository.UniversityRepository;
import com.sb.mongo.repository.entity.University;
import com.sb.mongo.service.dto.UniversityDto;
import com.sb.mongo.util.exceptions.InvalidInputException;
import com.sb.mongo.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UniversityService {

    private UniversityRepository repo;
    private UniversityMapper mapper;

    @Autowired
    public UniversityService(UniversityRepository repo, UniversityMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @GetMapping("/university/{name}")
    public UniversityDto getUniversity(@PathVariable String name){
     if(name==null || name.equals("")){
         throw  new InvalidInputException("Please Provide a name to search for");
     }
     University university=repo.findByName(name).orElseThrow(()->new NotFoundException("No university found with this name :- "+name));
     UniversityDto response= mapper.entityToApi(university);
     return  response;
    }


}
