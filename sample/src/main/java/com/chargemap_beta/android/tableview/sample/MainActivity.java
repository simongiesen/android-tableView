package com.chargemap_beta.android.tableView.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chargemap_beta.android.tableView.library.Cell;
import com.chargemap_beta.android.tableView.library.TableView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableView tableView = (TableView) findViewById(R.id.tableview);

        /*List<Cell> column1 = new ArrayList<>();
        column1.add(new Cell().setTitle("Header 1"));
        column1.add(new Cell().setTitle("Data11"));
        column1.add(new Cell().setTitle("Data12"));
        column1.add(new Cell().setTitle("Data13"));
        column1.add(new Cell().setTitle("Data14"));
        column1.add(new Cell().setTitle("Data15"));
        column1.add(new Cell().setTitle("Data16"));

        List<Cell> column2 = new ArrayList<>();
        column2.add(new Cell().setTitle("Header 2"));
        column2.add(new Cell().setTitle("Data21"));
        column2.add(new Cell().setTitle("Data22"));
        column2.add(new Cell().setTitle("Data23"));
        column2.add(new Cell().setTitle("Data24"));
        column2.add(new Cell().setTitle("Data25"));
        column2.add(new Cell().setTitle("Data26"));

        List<Cell> column3 = new ArrayList<>();
        column3.add(new Cell().setTitle("Header 3"));
        column3.add(new Cell().setTitle("Data31"));
        column3.add(new Cell().setTitle("Data32"));
        column3.add(new Cell().setTitle("Data33"));
        column3.add(new Cell().setTitle("Data34"));
        column3.add(new Cell().setTitle("Data35"));
        column3.add(new Cell().setTitle("Data36"));

        List<List<Cell>> columns = new ArrayList<>();
        columns.add(column1);
        columns.add(column2);
        columns.add(column3);*/


        List<Cell> column1 = new ArrayList<>();
        column1.add(new Cell("Header 1"));
        column1.add(new Cell("Data11"));
        column1.add(new Cell("Data12"));
        column1.add(new Cell("Data13"));
        column1.add(new Cell("Data14"));
        column1.add(new Cell("Data15"));
        column1.add(new Cell("Data16"));

        List<Cell> column2 = new ArrayList<>();
        column2.add(new Cell("Header 2"));
        column2.add(new Cell("Data21"));
        column2.add(new Cell("Data22"));
        column2.add(new Cell("Data23"));
        column2.add(new Cell("Data24"));
        column2.add(new Cell("Data25"));
        column2.add(new Cell("Data26"));

        List<Cell> column3 = new ArrayList<>();
        column3.add(new Cell("Header 3"));
        column3.add(new Cell("Data31"));
        column3.add(new Cell("Data32"));
        column3.add(new Cell("Data33"));
        column3.add(new Cell("Data34"));
        column3.add(new Cell("Data35"));
        column3.add(new Cell("Data36"));

        List<List<Cell>> columns = new ArrayList<>();
        columns.add(column1);
        columns.add(column2);
        columns.add(column3);

        tableView.setItems(columns);
    }
}
