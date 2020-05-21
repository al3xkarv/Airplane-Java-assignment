package com.company;

public class CargoBay extends PrivateCompartment{
    private EquipmentCompartment cargoEquip ;
    public CargoBay(){
        securityCheck = false;
        maintenanceCheck = false;
        cleaningCheck = false;
        cargoEquip = new EquipmentCompartment();
        System.out.println("CargoBay created");
    }
    @Override
    boolean ready_check() {
        if (securityCheck && maintenanceCheck && cleaningCheck && cargoEquip.ready_check()){
            System.out.println("CargoBay OK!");
            return true;
        }
        System.out.println("CargoBay not ready...");
        return false;
    }

    void process(Employee e) {
        e.workOn(cargoEquip);
        e.workOn(this);
    }

    public EquipmentCompartment getCargoEquip(){
        return cargoEquip;
    }
    @Override
    public String toString(){
        return (" Equipment Compartment has securityCheck = " + securityCheck + " and maintenanceCheck = " + maintenanceCheck +" and cleaningCheck = " + cleaningCheck + " and Equipement Compartment:" + cargoEquip.toString());

    }

    @Override
    public boolean equals(Object o) {
        CargoBay cb = (CargoBay) o;
        if ( cargoEquip.equals(cb.getCargoEquip()) & securityCheck == cb.isSecurityCheck() & maintenanceCheck == cb.isMaintenanceCheck() & cleaningCheck == cb.isCleaningCheck()) {
            return true;
        }
        return false;
        }

}
