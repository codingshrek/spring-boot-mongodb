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

import java.util.List;

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
    @GetMapping("/university/query-name/{name}")
    public UniversityDto getUniversityByNameUsingQuery(@PathVariable String name){
        if(name==null || name.equals("")){
            throw  new InvalidInputException("Please Provide a name to search for");
        }
        University university=repo.findByNameUsingQuery(name).orElseThrow(()->new NotFoundException("No university found with this name :- "+name));
        UniversityDto response= mapper.entityToApi(university);
        return  response;
    }

    @GetMapping("/university/query-regex/{name}/{city}/{country}")
    public List<UniversityDto> getUniversityByRegexAndRank(@PathVariable String name,@PathVariable String city,@PathVariable String country){
        List<University> universities=repo.findUniversitiesBasedOnRegex(name,city,country);
        List<UniversityDto> response=mapper.entityListToApiList(universities);
        return  response;
    }

    @GetMapping("/university/query-rank/{lessThan}/{greaterThan}")
    public List<UniversityDto> getUniversityListBasedOnRank(@PathVariable Integer lessThan,@PathVariable  Integer greaterThan){
        if(lessThan==0 || greaterThan==0){
            throw  new InvalidInputException("Please Provide a valid criteria");
        }
        List<University> university=repo.findUniversitiesBasedOnRank(lessThan,greaterThan);
        List<UniversityDto> response= mapper.entityListToApiList(university);
        return  response;
    }

    @GetMapping("/university/sorted")
    public List<UniversityDto> getUniversityInSortedOrder(){
        List<University> university=repo.getUniversitiesInSortedOrder();
        List<UniversityDto> response= mapper.entityListToApiList(university);
        return  response;
    }

    @GetMapping("/university/unwinded")
    public List<String> getUniversityUnwindedAndSorted(){
        List<String> university=repo.getUniversitiesUnwindedAndSorted();
        //List<UniversityDto> response= mapper.entityListToApiList(university);
        return  university;
    }


}
