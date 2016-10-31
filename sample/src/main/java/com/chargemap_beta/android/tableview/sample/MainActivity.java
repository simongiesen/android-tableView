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

        List<Cell> column1 = new ArrayList<>();
        column1.add(new Cell().setTitle("Data11"));
        column1.add(new Cell().setTitle("Data12"));
        column1.add(new Cell().setTitle("Data13"));
        column1.add(new Cell().setTitle("Data14"));
        column1.add(new Cell().setTitle("Data15"));
        column1.add(new Cell().setTitle("Data16"));

        cellListHashMap.put(
                new Cell().setTitle("Header1"),
                column1
        );

        List<Cell> column2 = new ArrayList<>();
        column2.add(new Cell().setTitle("Data21"));
        column2.add(new Cell().setTitle("Data22"));
        column2.add(new Cell().setTitle("Data23"));
        column2.add(new Cell().setTitle("Data24"));
        column2.add(new Cell().setTitle("Data25"));
        column2.add(new Cell().setTitle("Data26"));

        cellListHashMap.put(
                new Cell().setTitle("Header2"),
                column2
        );

        List<Cell> column3 = new ArrayList<>();
        column3.add(new Cell().setTitle("Data31"));
        column3.add(new Cell().setTitle("Data32"));
        column3.add(new Cell().setTitle("Data33"));
        column3.add(new Cell().setTitle("Data34"));
        column3.add(new Cell().setTitle("Data35"));
        column3.add(new Cell().setTitle("Data36"));

        cellListHashMap.put(
                new Cell().setTitle("Header3"),
                column3
        );

        tableView.setItems(cellListHashMap);
    }
}
