package com.sb.mongo.service.dto;

public class StudentRecordDto {
    private Integer year;
    private Integer number;

    public StudentRecordDto() {
    }

    public StudentRecordDto(Integer year, Integer number) {
        this.year = year;
        this.number = number;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}
