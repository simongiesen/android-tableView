package com.chargemap_beta.android.tableview.library;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chargemap_beta.android.tableview.library.callbacks.ClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by r4phab on 02/10/2016.
 */

public class TableViewAdapter extends RecyclerView.Adapter<TableViewAdapter.VH> {

    private HashMap<Cell, List<Cell>> items;

    private List<Cell> headers;

    private List<List<Cell>> data;

    private int count;

    private boolean headsOnTop;

    public TableViewAdapter(Context context, TableView tableView) {
        this.items = tableView.getItems();

        headers = new ArrayList<>();
        data = new ArrayList<>();

        headsOnTop = tableView.getHeadersOnTop();

        count = items.size();
        for (Map.Entry<Cell, List<Cell>> entry : items.entrySet()) {
            headers.add(entry.getKey());
            data.add(entry.getValue());

            count += entry.getValue().size();
        }
    }

    @Override
    public int getItemCount() {

        return count;
    }

    @Override
    public void onBindViewHolder(VH vh, int position) {
        Cell item = null;

        if (headsOnTop) {
            // Headers are at the top of the table

            if (position < items.size()) {
                // Cell is header

                item = headers.get(position);

                if (position == 0) {
                    // Top left cell
                    vh.title.setBackgroundResource(R.drawable.table_borders_header_right);

                } else if (position == headers.size() - 1) {
                    // Middle cell
                    vh.title.setBackgroundResource(R.drawable.table_borders_header_right);

                } else {
                    // Top right cell
                    vh.title.setBackgroundResource(R.drawable.table_borders_header_left);
                }

            } else {
                // Cell is data

                // Manual modulo to get the iteration count
                int pos = 0;
                while (position >= headers.size()) {
                    pos++;

                    position = position - headers.size();
                }
                pos--;

                List<Cell> column = data.get(position);

                item = column.get(pos);

                if (position == 0) {
                    // Left cell
                    vh.title.setBackgroundResource(R.drawable.table_borders_right_top);

                } else if (position == headers.size() - 1) {
                    // Middle cell
                    vh.title.setBackgroundResource(R.drawable.table_borders_right_top);

                } else {
                    // Right cell
                    vh.title.setBackgroundResource(R.drawable.table_borders_left_top);
                }
            }
        }


        if (item != null) {
            vh.title.setText(item.getTitle());
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup viewGroup, int position) {
        return new VH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_header, viewGroup, false));
    }

    static class VH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;

        ClickListener clickListener;

        public VH(View v) {
            super(v);

            title = (TextView) v.findViewById(R.id.title);
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