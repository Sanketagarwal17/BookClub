package com.example.android.bookclub.requestbook;

public class requetbookdatamodel {

    public String usernaame,admissionno,phoneno,email;

    public requetbookdatamodel(String usernaame, String admissionno, String phoneno, String email) {

        this.usernaame = usernaame;
        this.admissionno = admissionno;
        this.phoneno = phoneno;
        this.email = email;
    }

    public String getUsernaame() {
        return usernaame;
    }

    public void setUsernaame(String usernaame) {
        this.usernaame = usernaame;
    }

    public String getAdmissionno() {
        return admissionno;
    }

    public void setAdmissionno(String admissionno) {
        this.admissionno = admissionno;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
