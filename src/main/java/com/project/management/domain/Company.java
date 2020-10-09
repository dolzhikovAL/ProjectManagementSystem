package com.project.management.domain;

public class Company {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String name;
    private String country;


    public String printOut(){
        return "Customer name --" + name + " country -- " + country;
    }

}
