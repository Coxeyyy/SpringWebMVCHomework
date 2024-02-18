package com.coxey.app.model;

public class Employee {

    private int id;
    private String name;
    private JobTitle jobTitle;

    public Employee() {

    }

    public Employee(int id, String name, JobTitle jobTitle) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }
}
