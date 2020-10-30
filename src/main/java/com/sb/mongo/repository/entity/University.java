package com.sb.mongo.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("universities")
public class University {

    @Id
    private String id;
    private String country;
    private String city;
    private Integer rank;
    @Indexed(unique = true)
    private String name;
    private List<StudentRecord> students;

    public University() {

    }

    public University(String id, String country, String city, Integer rank, String name, List<StudentRecord> students) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.rank = rank;
        this.name = name;
        this.students = students;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentRecord> getStudents() {
        return students;
    }

    public void setStudents(List<StudentRecord> students) {
        this.students = students;
    }



    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
