package com.company;

public class EquipmentCompartment extends PrivateCompartment{
    public EquipmentCompartment(){
        securityCheck = false;
        maintenanceCheck = false;
        System.out.println("EquipmentCompartment created");
    }
    @Override
    boolean ready_check() {
        if (securityCheck && maintenanceCheck ){
            System.out.println("Equipment compartment OK!");
            return true;
        }
        System.out.println("Equipment compartment not ready...");
        return false;
    }

    @Override
    void process(Employee e) {
        e.workOn(this);
    }

    @Override
    public String toString(){
        return (" EquipmentCompartment has securityCheck = " + securityCheck + " and maintenanceCheck"+ maintenanceCheck);
    }

    @Override
    public boolean equals(Object o){
        EquipmentCompartment ec = (EquipmentCompartment) o;
        if (securityCheck = ec.isSecurityCheck() & maintenanceCheck == ec.isMaintenanceCheck()){
            return true;
        }
        return false;
    }
}
