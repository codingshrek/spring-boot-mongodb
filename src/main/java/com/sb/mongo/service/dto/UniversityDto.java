package com.sb.mongo.service.dto;


import java.util.List;

public class UniversityDto {

    private String country;
    private String city;
    private String name;
    private List<StudentRecordDto> students;

    public UniversityDto() {
    }

    public UniversityDto(String country, String city, String name, List<StudentRecordDto> students) {
        this.country = country;
        this.city = city;
        this.name = name;
        this.students = students;
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

    public List<StudentRecordDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentRecordDto> students) {
        this.students = students;
    }
}
