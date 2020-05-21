package com.company;

import java.util.Random;
import java.util.Vector;

public class Plane{
    private String title;
    private int passengerCapacity ;
    private  CargoBay cb;
    private EquipmentCompartment ec1;
    private EquipmentCompartment ec2;
    private EquipmentCompartment ec3;
    private Vector<PassengerCompartment> pc_v = new Vector<PassengerCompartment>(0) ;

    Plane(){
        title = "Boeing";
        ec1 = new EquipmentCompartment();
        ec2 = new EquipmentCompartment();
        ec3 = new EquipmentCompartment();
        cb = new CargoBay();
        Random rand= new Random();
        passengerCapacity = rand.nextInt(150) +50;

        for (int i=0; i <= passengerCapacity/50 ; i++){
            pc_v.add(new PassengerCompartment());
        }
        System.out.println("Plane created with capacity "+ passengerCapacity);
    }


    boolean ready_check() {
        if (ec1.ready_check() && ec2.ready_check() && ec3.ready_check() && cb.ready_check()){
            for (int i=0; i < pc_v.size() ; i++){
                if (pc_v.get(i).ready_check() == false){
                    System.out.println("Plane not ready...");
                    return false;}
            }
            System.out.println("Plane ready for takeoff!");
            return true;
        }
        System.out.println("Plane not ready...");
        return false;
    }
    String getTitle(){
        return title;
    }

    CargoBay getCargoBay(){
        return cb;
    }

    EquipmentCompartment getEc1(){
        return ec1;
    }

    EquipmentCompartment getEc2(){
        return ec2;
    }

    EquipmentCompartment getEc3(){
        return ec3;
    }

    public Vector<PassengerCompartment> getPc_v() {
        return pc_v;
    }

    void process(Employee e) {
        ec1.process(e);
        ec2.process(e);
        ec3.process(e);
        cb.process(e);
        for (int i=0; i < pc_v.size() ; i++){
            pc_v.get(i).process(e);
        }
    }
    @Override
    public String toString(){
        String str ="Plane with " + cb.toString() + ec1.toString() + ec2.toString() + ec3.toString();
        for (int i=0; i < pc_v.size() ; i++){
            str = str + pc_v.get(i).toString();
        }
        return str;
    }

    @Override
    public boolean equals(Object o){
        Plane p = (Plane) o;
        if (title == p.getTitle() & cb.equals(p.getCargoBay()) & ec1.equals(p.getEc1()) & ec2.equals(p.getEc2()) & ec3.equals(p.getEc3() ) ) {
            if ( pc_v.size()==p.getPc_v().size() ){
                for (int i=0; i < pc_v.size() ; i++){
                    if (pc_v.get(i).equals( p.getPc_v().get(i) ) ==false ){
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
