# Android-tableview

Android-Tableview is a simple library developed to provide a ncie looking table inside your layouts.

[![Release](https://jitpack.io/v/ChargeMap/android-tableview.svg)](https://jitpack.io/v/ChargeMap/android-tableview.svg)

---
<img src="https://github.com/ChargeMap/android-tableview/blob/master/art/demo1.png" width="300"/> 

<img src="https://github.com/ChargeMap/android-tableview/blob/master/art/demo2.png" width="300"/>

## Gradle Dependency

### Repository

Add this in your root (global) `build.gradle` file :

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

### Dependency

Add this to your specific module `build.gradle` file:

```gradle
dependencies {
	...
	compile 'com.github.ChargeMap:android-tableview:1.1'
}
```

## Initialisation

### 1 -  Add the view to your XML


```xml
    <com.chargemap_beta.android.tableview.library.TableView
        android:id="@+id/tableview"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:tv_data_background_color="@color/md_white_1000" <!-- Background color for data cells -->
        app:tv_data_borders_color="@color/md_grey_500" <!--  Borders color for data cells -->
        app:tv_header_background_color="@color/md_grey_300" <!--  Background color for header cells -->
        app:tv_header_borders_color="@color/md_grey_500" <!--  Borders color for header cells -->
        app:tv_headersOnTop="false" <!--  Table view header is the first row ? If false, headers are shown as the first column -->
        app:tv_scrollingEnabled="false" <!-- Scrolling ? -->
        app:tv_padding="8" /> <!--  padding -->
```

### 2 -  Add the data

#### Tableview with headers on the left

```java
    List<Cell> column1 = new ArrayList<>(); // Add headers as the first column
    column1.add(new Cell("Header 1"));
    column1.add(new Cell("Header 1"));
    column1.add(new Cell("Header 1"));
    column1.add(new Cell("Header 1"));
    column1.add(new Cell("Header 1"));
    column1.add(new Cell("Header 1"));

    List<Cell> column2 = new ArrayList<>(); // Add data after headers
    column2.add(new Cell("Data11"));
    column2.add(new Cell("Data12"));
    column2.add(new Cell("Data13"));
    column2.add(new Cell("Data14"));
    column2.add(new Cell("Data15"));
    column2.add(new Cell("Data16"));

    List<Cell> column3 = new ArrayList<>();
    column3.add(new Cell("Data21"));
    column3.add(new Cell("Data22"));
    column3.add(new Cell("Data23"));
    column3.add(new Cell("Data24"));
    column3.add(new Cell("Data25"));
    column3.add(new Cell("Data26"));

    List<List<Cell>> columns = new ArrayList<>();
    columns.add(column1);
    columns.add(column2);
    columns.add(column3);

    tableView.setItems(columns);
```

#### Tableview with headers on the top

```java
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
```

### 3 - Finished !

There is no sep 3, you are ready to go :)

## ChargeMap ( [http://chargemap.com](https://chargemap.com) )

<img src="https://chargemap.com/img/logo.png" />

 This library has been developed and released by ChargeMap.

## License

This library is distributed under the apache 2.0 license.