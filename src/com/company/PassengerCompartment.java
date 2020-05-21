package com.company;

import java.util.Random;

public class PassengerCompartment extends PlaneComponent {
    private boolean cleaningCheck;
    private PassengerCompartment innerCompartment = null;

    public PassengerCompartment() {
        securityCheck = false;
        cleaningCheck = false;
        Random rand = new Random();

        if (rand.nextInt(2) == 1) {
            innerCompartment = new PassengerCompartment(true);
            innerCompartment.securityCheck = false;
            innerCompartment.cleaningCheck = false;
        }

        System.out.println("PassengerCompartment created");
    }

    public PassengerCompartment(boolean innerStop) {
        securityCheck = false;
        cleaningCheck = false;
        System.out.println("Inner PassengerCompartment created");
    }

    void security() {
        securityCheck = true;
    }

    void cleaning() {
        cleaningCheck = true;
    }

    void maintenance() {
    }

    @Override
    boolean ready_check() {
        if (securityCheck && cleaningCheck) {
            if (innerCompartment != null) {
                if (innerCompartment.isSecurityCheck() && innerCompartment.isCleaningCheck()) {
                } else {
                    System.out.println("Passenger compartment not ready...");
                    return false;
                }
            }
            System.out.println("Passenger compartment OK!");
            return true;
        }
        System.out.println("Passenger compartment not ready...");
        return false;
    }

    PassengerCompartment getInnerCompartment() {
        return innerCompartment;
    }

    @Override
    void process(Employee e) {
        e.workOn(this);
        if (innerCompartment != null) {
            e.workOn(innerCompartment);
        }
    }

    public boolean isCleaningCheck() {
        return cleaningCheck;
    }

    public boolean isSecurityCheck() {
        return securityCheck;
    }

    @Override
    public String toString() {
        String str = " Passenger Compartment  has securityCheck = " + securityCheck + " and cleaningCheck = " + cleaningCheck;
        if (innerCompartment != null) {
            str = str + (" and innerCompartment with " + innerCompartment.toString());
        }
        return str;
    }

    @Override
    public boolean equals(Object o) {
        PassengerCompartment pc = (PassengerCompartment) o;
        if (securityCheck == pc.isSecurityCheck() & cleaningCheck == pc.isCleaningCheck()){
            if (innerCompartment != null & pc.getInnerCompartment() != null) {
                if (innerCompartment.isSecurityCheck() == pc.getInnerCompartment().isSecurityCheck() & innerCompartment.isSecurityCheck() == pc.getInnerCompartment().isCleaningCheck()) {
                    return true;
                }
            }
        else if(innerCompartment == null & pc.getInnerCompartment()== null){
            return true;
        }
        else{
            return false;
        }
        }
        return false;
    }
    }
