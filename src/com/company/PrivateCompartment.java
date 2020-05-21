package com.company;

public class PrivateCompartment extends PlaneComponent{
    protected boolean maintenanceCheck;
    protected boolean cleaningCheck;

    public PrivateCompartment(){
        securityCheck = false;
        maintenanceCheck = false;
        cleaningCheck = false;
        System.out.println("PrivateCompartment created");
    }
    void security(){
        securityCheck = true;
    }

    void cleaning(){
        cleaningCheck = true;
    }
    void maintenance(){
        maintenanceCheck = true;
    }
    @Override
    boolean ready_check() {
        if (securityCheck && maintenanceCheck && cleaningCheck){
            System.out.println("Private compartment OK!");
            return true;
        }
        System.out.println("Private compartment not ready...");
        return false;
    }

    @Override
    void process(Employee e) {
        e.workOn(this);
    }

    public boolean isCleaningCheck() {
        return cleaningCheck;
    }
    public boolean isSecurityCheck(){
        return securityCheck;
    }
    public boolean isMaintenanceCheck() { return maintenanceCheck; }

    @Override
    public String toString(){
        System.out.print(this.toString());
        return (" Private Compartment  has securityCheck = " + securityCheck + " and maintenanceCheck = " + maintenanceCheck +" and cleaningCheck = " +cleaningCheck );

    }
    @Override
    public boolean equals(Object o) {
        PrivateCompartment pc = (PrivateCompartment) o;
        if (securityCheck == pc.isSecurityCheck() & cleaningCheck == pc.isCleaningCheck() & maintenanceCheck == pc.isMaintenanceCheck()) {
            return true;
        }
        return false;
    }
}
