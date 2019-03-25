package com.example.android.bookclub.Profile;

public class ProfileModel {


    public String name,admissionno,poneno,email;


    public ProfileModel(String name, String admissionno, String poneno, String email) {
        this.name = name;
        this.admissionno = admissionno;
        this.poneno = poneno;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdmissionno() {
        return admissionno;
    }

    public void setAdmissionno(String admissionno) {
        this.admissionno = admissionno;
    }

    public String getPoneno() {
        return poneno;
    }

    public void setPoneno(String poneno) {
        this.poneno = poneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
