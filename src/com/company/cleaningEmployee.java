package com.company;

public class cleaningEmployee extends Employee{
    public cleaningEmployee (){
        name = "Default Defaultidis";
        System.out.println("cleaningEmployee created");
    }
    void workOn(PlaneComponent pc){
        pc.cleaning();
        this.report(pc);
    }

    void report(PlaneComponent pc){
        System.out.println(this.toString() +" is working on" + pc.toString());
    }
}
