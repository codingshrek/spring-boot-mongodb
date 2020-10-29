package com.sb.mongo.repository.entity;

public class StudentRecord {

    private Integer year;
    private Integer number;

    public StudentRecord() {
    }

    public StudentRecord(Integer year, Integer number) {
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
