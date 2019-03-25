package com.example.android.bookclub.allbooks.AllBookMVP;

public class AllBookModel {

    public String bookname,authorname,price;

    public AllBookModel(String bookname, String authorname, String price) {
        this.bookname = bookname;
        this.authorname = authorname;
        this.price = price;
    }

    public AllBookModel()
    {

    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
