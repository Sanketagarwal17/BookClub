package com.example.android.bookclub.addbook;

public class Addbookmodel {

    public String name;
    public String author;
    public String price,bookid,totalnumberofbook;


    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getTotalnumberofbook() {
        return totalnumberofbook;
    }

    public void setTotalnumberofbook(String totalnumberofbook) {
        this.totalnumberofbook = totalnumberofbook;
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

    public Addbookmodel(String name, String author, String price, String bookid, String totalnumberofbook) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.bookid = bookid;
        this.totalnumberofbook = totalnumberofbook;
    }
}
