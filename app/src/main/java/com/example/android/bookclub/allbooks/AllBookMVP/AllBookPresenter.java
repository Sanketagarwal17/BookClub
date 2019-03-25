package com.example.android.bookclub.allbooks.AllBookMVP;

import java.util.List;

public class AllBookPresenter implements  Allbookpresenterinterface {

private  AllBookview allBookview;
private  AllBookModel allBookModel;

    public AllBookPresenter(AllBookview allBookview, AllBookModel allBookModel) {
        this.allBookview = allBookview;
        this.allBookModel = allBookModel;
    }

    @Override
    public void loadbookfromfirebase() {
        allBookview.loading();

    }

    @Override
    public void onclickanybook() {
        allBookview.onclickstartnewactivity();

    }

    @Override
    public void showbookinvew() {
        allBookview.joinadaptertolistview();

    }

    @Override
    public void onsearchanybook() {
        allBookview.loading();
        allBookview.search();

    }
}
