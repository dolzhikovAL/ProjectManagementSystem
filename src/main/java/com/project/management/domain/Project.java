package com.project.management.domain;

import java.time.LocalDate;

public class Project {


    private String name;
    private LocalDate deadLine;

    public Project(String name, LocalDate deadLine) {
        this.name = name;
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "Customer name --" + name + " deadLine -- " + deadLine;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }
}
