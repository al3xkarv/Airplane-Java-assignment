package com.company;


public class securityEmployee extends Employee{
    public securityEmployee (){
        name = "Default Defaultidis";
        System.out.println("securtyEmployee created");
    }
    void workOn(PlaneComponent pc){
        pc.security();
        this.report(pc);
    }

    void report(PlaneComponent pc){
        System.out.println(this.toString() +" is working on" + pc.toString());
    }
}

