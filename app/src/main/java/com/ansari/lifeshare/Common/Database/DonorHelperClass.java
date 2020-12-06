package com.ansari.lifeshare.Common.Database;

public class DonorHelperClass {
    String _fname, _lname, _dob, _gender, bloodgroup, _phone, _q1, _q2, _q3, _q4, _q5, _q6;

    DonorHelperClass() {
    }

    public DonorHelperClass(String _fname, String _lname, String _dob, String _gender, String bloodgroup, String _phone, String _q1, String _q2, String _q3, String _q4, String _q5, String _q6) {
        this._fname = _fname;
        this._lname = _lname;
        this._dob = _dob;
        this._gender = _gender;
        this.bloodgroup = bloodgroup;
        this._phone = _phone;
        this._q1 = _q1;
        this._q2 = _q2;
        this._q3 = _q3;
        this._q4 = _q4;
        this._q5 = _q5;
        this._q6 = _q6;
    }

    public String get_fname() {
        return _fname;
    }

    public void set_fname(String _fname) {
        this._fname = _fname;
    }

    public String get_lname() {
        return _lname;
    }

    public void set_lname(String _lname) {
        this._lname = _lname;
    }

    public String get_dob() {
        return _dob;
    }

    public void set_dob(String _dob) {
        this._dob = _dob;
    }

    public String get_gender() {
        return _gender;
    }

    public void set_gender(String _gender) {
        this._gender = _gender;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String get_phone() {
        return _phone;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }

    public String get_q1() {
        return _q1;
    }

    public void set_q1(String _q1) {
        this._q1 = _q1;
    }

    public String get_q2() {
        return _q2;
    }

    public void set_q2(String _q2) {
        this._q2 = _q2;
    }

    public String get_q3() {
        return _q3;
    }

    public void set_q3(String _q3) {
        this._q3 = _q3;
    }

    public String get_q4() {
        return _q4;
    }

    public void set_q4(String _q4) {
        this._q4 = _q4;
    }

    public String get_q5() {
        return _q5;
    }

    public void set_q5(String _q5) {
        this._q5 = _q5;
    }

    public String get_q6() {
        return _q6;
    }

    public void set_q6(String _q6) {
        this._q6 = _q6;
    }
}