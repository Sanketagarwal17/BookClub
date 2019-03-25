package com.example.android.bookclub.acceptedrequest;

public class Acceptedrequestmodel {

    public String addmissionno,name,author,price;


    public Acceptedrequestmodel(String addmissionno, String name, String author, String price) {
        this.addmissionno = addmissionno;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getAddmissionno() {
        return addmissionno;
    }

    public void setAddmissionno(String addmissionno) {
        this.addmissionno = addmissionno;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
