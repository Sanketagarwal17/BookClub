package com.example.android.bookclub.IssueBook;

public class IssueBookAdapter {

    public String uniquid,name,author,price,issuedate,returndate,returned;

    public IssueBookAdapter(String uniquid, String name, String author, String price, String issuedate, String returndate, String returned) {
        this.uniquid = uniquid;
        this.name = name;
        this.author = author;
        this.price = price;
        this.issuedate = issuedate;
        this.returndate = returndate;
        this.returned = returned;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    public String getUniquid() {
        return uniquid;
    }

    public void setUniquid(String uniquid) {
        this.uniquid = uniquid;
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
