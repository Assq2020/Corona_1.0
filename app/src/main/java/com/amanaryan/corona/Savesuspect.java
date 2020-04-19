package com.amanaryan.corona;

class Savesuspect {
    private String nname,aage,aaddress,rrealtion,pphone,oother,ddoubt,Complainer_name,Complainer_ph;

    public Savesuspect(String nname, String aage, String aaddress, String rrealtion, String pphone, String oother, String ddoubt, String Complainer_name, String Complainer_ph) {
        this.nname=nname;
        this.aage=aage;
        this.aaddress=aaddress;
        this.rrealtion=rrealtion;
        this.pphone=pphone;
        this.oother=oother;
        this.ddoubt=ddoubt;
        this.Complainer_name=Complainer_name;
        this.Complainer_ph=Complainer_ph;
        }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public void setAage(String aage) {
        this.aage = aage;
    }

    public void setAaddress(String aaddress) {
        this.aaddress = aaddress;
    }

    public void setRrealtion(String rrealtion) {
        this.rrealtion = rrealtion;
    }

    public void setPphone(String pphone) {
        this.pphone = pphone;
    }

    public void setOother(String oother) {
        this.oother = oother;
    }

    public void setDdoubt(String ddoubt) {
        this.ddoubt = ddoubt;
    }

    public void setComplainer_name(String complainer_name) {
        Complainer_name = complainer_name;
    }

    public void setComplainer_ph(String complainer_ph) {
        Complainer_ph = complainer_ph;
    }
}
