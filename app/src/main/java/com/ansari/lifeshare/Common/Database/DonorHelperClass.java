package com.ansari.lifeshare.Common.Database;

public class DonorHelperClass {
    String fname, lname, dob, gender, bloodgroup, phone,quest1,quest2,quest3,quest4,quest5,quest6;

    DonorHelperClass(){}

    public DonorHelperClass(String fname, String lname, String dob, String gender, String bloodgroup, String phone, String quest1, String quest2, String quest3, String quest4, String quest5, String quest6) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.gender = gender;
        this.bloodgroup = bloodgroup;
        this.phone = phone;
        this.quest1 = quest1;
        this.quest2 = quest2;
        this.quest3 = quest3;
        this.quest4 = quest4;
        this.quest5 = quest5;
        this.quest6 = quest6;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQuest1() {
        return quest1;
    }

    public void setQuest1(String quest1) {
        this.quest1 = quest1;
    }

    public String getQuest2() {
        return quest2;
    }

    public void setQuest2(String quest2) {
        this.quest2 = quest2;
    }

    public String getQuest3() {
        return quest3;
    }

    public void setQuest3(String quest3) {
        this.quest3 = quest3;
    }

    public String getQuest4() {
        return quest4;
    }

    public void setQuest4(String quest4) {
        this.quest4 = quest4;
    }

    public String getQuest5() {
        return quest5;
    }

    public void setQuest5(String quest5) {
        this.quest5 = quest5;
    }

    public String getQuest6() {
        return quest6;
    }

    public void setQuest6(String quest6) {
        this.quest6 = quest6;
    }
}
