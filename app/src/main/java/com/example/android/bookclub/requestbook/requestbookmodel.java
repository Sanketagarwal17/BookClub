package com.example.android.bookclub.requestbook;

public class requestbookmodel {

    public String bookname;
    public String author;
    public String price;
    public String username,admission,phone,email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
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

    public requestbookmodel(String name, String author, String price, String username, String admission, String phone, String email) {
        this.bookname = name;
        this.author = author;
        this.price = price;
        this.username = username;
        this.admission = admission;
        this.phone = phone;
        this.email = email;
    }
}
