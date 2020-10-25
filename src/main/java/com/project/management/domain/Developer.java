package com.project.management.domain;

public class Developer {
    public Developer(String name, int salary, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
    }

    private String name;
    private String sex;
    private int age;
    private int salary;

    @Override
    public String toString() {
        return "Customer name --" + name + "  salary-- " + salary + "  age -- " + age + "  sex --" + sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


}
