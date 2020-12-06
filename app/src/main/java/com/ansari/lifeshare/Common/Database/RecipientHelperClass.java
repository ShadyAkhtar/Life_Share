package com.ansari.lifeshare.Common.Database;

public class RecipientHelperClass {
    String pname,hospName,illnessDesc ,dob,bloodgroup,  gender, phoneNo;

    RecipientHelperClass(){}

    public RecipientHelperClass(String pname, String hospName, String illnessDesc, String dob, String gender, String phoneNo) {
        this.pname = pname;
        this.hospName = hospName;
        this.illnessDesc = illnessDesc;
        this.dob = dob;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.bloodgroup = bloodgroup;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getHospName() {
        return hospName;
    }

    public void setHospName(String hospName) {
        this.hospName = hospName;
    }

    public String getIllnessDesc() {
        return illnessDesc;
    }

    public void setIllnessDesc(String illnessDesc) {
        this.illnessDesc = illnessDesc;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }
}
