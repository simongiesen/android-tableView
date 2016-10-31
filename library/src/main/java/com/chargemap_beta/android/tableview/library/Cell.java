package com.chargemap_beta.android.tableview.library;

import android.view.View;

/**
 * Created by rbertin on 24/10/2016.
 */

public class Cell {

    private String title;

    public Cell(String title) {
        this.title = title;
    }

    private View.OnClickListener clickListener;

    public String getTitle() {
        return title;
    }

    public Cell setTitle(String title) {
        this.title = title;
        return this;
    }

    public View.OnClickListener getClickListener() {
        return clickListener;
    }

    public Cell setClickListener(View.OnClickListener clickListener) {
        this.clickListener = clickListener;
        return this;
    }

}
