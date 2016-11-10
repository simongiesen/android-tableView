package com.chargemap_beta.android.tableview.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbertin on 24/10/2016.
 */

public class TableView extends RecyclerView {

    public Boolean tv_headersOnTop;

    public Boolean tv_scrollingEnabled;

    public int tv_header_borders_color;
    public int tv_header_background_color;

    public int tv_data_borders_color;
    public int tv_data_background_color;

    public int tv_radius;

    public int tv_padding;

    public int count;

    public int columnCount;

    public List<Cell> headers;

    public List<List<Cell>> data;

    private TableViewAdapter tableViewAdapter;

    public TableView(Context context) {
        super(context);
    }

    public TableView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TableView);

        tv_header_borders_color = a.getColor(R.styleable.TableView_tv_header_borders_color, ContextCompat.getColor(context, R.color.md_grey_500));
        tv_header_background_color = a.getColor(R.styleable.TableView_tv_header_background_color, ContextCompat.getColor(context, R.color.md_grey_300));

        tv_data_borders_color = a.getColor(R.styleable.TableView_tv_data_borders_color, ContextCompat.getColor(context, R.color.md_grey_500));
        tv_data_background_color = a.getColor(R.styleable.TableView_tv_data_background_color, ContextCompat.getColor(context, R.color.md_white_1000));

        tv_radius = a.getInteger(R.styleable.TableView_tv_radius, 0);

        tv_padding = a.getInteger(R.styleable.TableView_tv_padding, 0);

        tv_headersOnTop = a.getBoolean(R.styleable.TableView_tv_headersOnTop, true);

        tv_scrollingEnabled = a.getBoolean(R.styleable.TableView_tv_scrollingEnabled, true);

        if (!tv_scrollingEnabled) {
            setClickable(false);
            setFocusable(false);
            setNestedScrollingEnabled(false);
        }

        tableViewAdapter = new TableViewAdapter(getContext(), this);

        setAdapter(tableViewAdapter);

        a.recycle();
    }

    public TableView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setItems(List<List<Cell>> items) {

        headers = new ArrayList<>();
        data = new ArrayList<>();

        tableViewAdapter.setItems(this);

        if (tv_headersOnTop) {
            columnCount = items.size();

            count = 0;
            for (List<Cell> column : items) {
                count += column.size();

                headers.add(column.get(0));
                column.remove(0);

                data.add(column);
            }

        } else {
            columnCount = items.size();

            count = items.get(0).size();

            headers.addAll(items.get(0));
            items.remove(0);

            for (List<Cell> column : items) {
                count += column.size();
                data.add(column);
            }

        }

        setLayoutManager(new CustomGridLayoutManager(getContext(), columnCount, tv_scrollingEnabled));

        addItemDecoration(new TableViewDivider(this));
    }
}