package com.company;

public class  maintenanceEmployee extends Employee{
    public maintenanceEmployee (){
        name = "Default Defaultidis";
        System.out.println("maintenanceEmployee created");
    }
    void workOn(PlaneComponent pc){
        pc.maintenance();
        this.report(pc);
    }

    void report(PlaneComponent pc){
        System.out.println(this.toString() +" is working on" + pc.toString());
    }
}
