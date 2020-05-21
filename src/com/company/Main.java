package com.company;



public class Main {

    public static void main(String[] args) {

        Plane p = new Plane();
        securityEmployee se = new securityEmployee();
        cleaningEmployee ce = new cleaningEmployee();
        maintenanceEmployee me = new maintenanceEmployee();

        p.process(se);
        p.process(me);
        p.process(ce);
        p.ready_check();
    }

}

abstract class PlaneComponent{
    protected boolean securityCheck;

    abstract boolean ready_check();
    abstract void process(Employee e);
    @Override
    abstract public java.lang.String toString();
    abstract void security();
    abstract  void cleaning();
    abstract void maintenance();

}

abstract  class Employee{
    protected String name;
    abstract void workOn(PlaneComponent pc);
    abstract void report(PlaneComponent pc);

    public String getName() {
        return name;
    }
}


