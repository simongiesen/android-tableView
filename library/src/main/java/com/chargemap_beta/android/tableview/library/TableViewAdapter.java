package com.chargemap_beta.android.tableview.library;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chargemap_beta.android.tableview.library.callbacks.ClickListener;

import java.util.List;

/**
 * Created by r4phab on 02/10/2016.
 */

public class TableViewAdapter extends RecyclerView.Adapter<TableViewAdapter.VH> {

    private TableView tableView;

    public TableViewAdapter(Context context, TableView tableView) {
        this.tableView = tableView;
    }

    @Override
    public int getItemCount() {
        return tableView.count;
    }

    public void setItems(TableView tableview) {
        this.tableView = tableview;
    }

    @Override
    public void onBindViewHolder(VH vh, int position) {
        Cell item;

        if (tableView.tv_headersOnTop) {
            // Headers are at the top of the table

            if (position < tableView.headers.size()) {
                // Cell is header

                item = tableView.headers.get(position);

            } else {
                // Cell is data

                // Manual modulo to get the iteration count
                int pos = 0;
                while (position >= tableView.headers.size()) {
                    pos++;

                    position = position - tableView.headers.size();
                }
                pos--;

                List<Cell> column = tableView.data.get(position);

                item = column.get(pos);
            }
        } else {
            // Headers are at the left of the table

            // Manual modulo to get the iteration count
            int index = 0;
            while (position > tableView.data.size()) {
                index++;

                position = position - (tableView.data.size() + 1);
            }

            if (position == 0) {
                // Cell is header

                item = tableView.headers.get(index);

            } else {

                // Cell is data

                item = tableView.data.get(position - 1).get(index);
            }
        }

        if (item != null) {
            vh.title.setText(item.getTitle());
            vh.title.setGravity(Gravity.CENTER);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup viewGroup, int position) {
        return new VH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_cell, viewGroup, false));
    }

    static class VH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;

        RelativeLayout container;

        ClickListener clickListener;

        public VH(View v) {
            super(v);

            title = (TextView) v.findViewById(R.id.title);

            container = (RelativeLayout) v.findViewById(R.id.container);

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onClick(v, getAdapterPosition(), false);
            }
        }
    }
}