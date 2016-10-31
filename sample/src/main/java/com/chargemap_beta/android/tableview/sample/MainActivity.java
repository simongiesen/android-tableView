package com.chargemap_beta.android.tableview.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chargemap_beta.android.tableview.library.Cell;
import com.chargemap_beta.android.tableview.library.TableView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableView tableView = (TableView) findViewById(R.id.tableview);

        HashMap<Cell, List<Cell>> cellListHashMap = new HashMap<>();

        List<Cell> column = new ArrayList<>();
        column.add(new Cell().setTitle("Data1"));
        column.add(new Cell().setTitle("Data2"));
        column.add(new Cell().setTitle("Data3"));
        column.add(new Cell().setTitle("Data4"));
        column.add(new Cell().setTitle("Data5"));
        column.add(new Cell().setTitle("Data6"));

        cellListHashMap.put(
                new Cell().setTitle("Header1"),
                column
            );

        cellListHashMap.put(
                new Cell().setTitle("Header2"),
                column
        );

        cellListHashMap.put(
                new Cell().setTitle("Header3"),
                column
        );

        tableView.setItems(cellListHashMap);
    }
}
