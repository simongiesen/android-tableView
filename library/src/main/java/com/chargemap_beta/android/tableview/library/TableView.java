package com.chargemap_beta.android.tableview.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.HashMap;
import java.util.List;

/**
 * Created by rbertin on 24/10/2016.
 */

public class TableView extends RecyclerView {

    private HashMap<Cell, List<Cell>> items;

    private Boolean headersOnTop;

    private int tv_header_borders_color;
    private int tv_header_background_color;

    private int tv_data_borders_color;
    private int tv_data_background_color;

    private int tv_radius;

    public TableView(Context context) {
        super(context);
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    public TableView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public TableView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TableView);

        tv_header_borders_color = a.getColor(R.styleable.TableView_tv_header_borders_color, ContextCompat.getColor(context, R.color.md_grey_500));
        tv_header_background_color = a.getColor(R.styleable.TableView_tv_header_background_color, ContextCompat.getColor(context, R.color.md_grey_300));

        tv_data_borders_color = a.getColor(R.styleable.TableView_tv_data_borders_color, ContextCompat.getColor(context, R.color.md_grey_500));
        tv_data_background_color = a.getColor(R.styleable.TableView_tv_data_background_color, ContextCompat.getColor(context, R.color.md_white_1000));

        tv_radius = a.getColor(R.styleable.TableView_tv_radius, 0);

        headersOnTop = a.getBoolean(R.styleable.TableView_tv_headersOnTop, true);

        setAdapter(new TableViewAdapter(getContext(), this));

        a.recycle();
    }

    public void setItems(HashMap<Cell, List<Cell>> tabs) {

        items = tabs;

        setLayoutManager(new GridLayoutManager(getContext(), items.size()));
    }

    public HashMap<Cell, List<Cell>> getItems() {
        return items;
    }

    public Boolean getHeadersOnTop() {
        return headersOnTop;
    }

}