package com.chargemap_beta.android.tableview.library;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

/**
 * Created by rbertin on 31/10/2016.
 */

public class TableViewDivider extends RecyclerView.ItemDecoration {

    private TableView tableView;

    public TableViewDivider(TableView tableView) {
        this.tableView = tableView;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Boolean cellIsHeader;
        int position = parent.getChildAdapterPosition(view); // item position
        int column = position % tableView.columnCount; // item column

        View container = view.findViewById(R.id.container);
        TextView title = (TextView) view.findViewById(R.id.title);

        int padding = (int) convertDpToPixel(1);

        container.setPadding(
                column != 0 ? 0 : padding,
                position >= tableView.columnCount ? 0 : padding,
                padding,
                padding
        );

        if (tableView.tv_headersOnTop) {
            cellIsHeader = position < tableView.headers.size();
        } else {
            cellIsHeader = column == 0;
        }

        if (cellIsHeader) {
            container.setBackgroundColor(tableView.tv_header_borders_color);
            title.setBackgroundColor(tableView.tv_header_background_color);
        } else {
            container.setBackgroundColor(tableView.tv_data_borders_color);
            title.setBackgroundColor(tableView.tv_data_background_color);
        }
    }

    public static float convertDpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }
}