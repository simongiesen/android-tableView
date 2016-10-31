# Android-tableview

Android-Tableview is a simple library developed to provide a ncie looking table inside your layouts.

[![Release](https://jitpack.io/v/ChargeMap/android-tableview.svg)](https://jitpack.io/v/ChargeMap/android-tableview.svg)

---
![](https://github.com/ChargeMap/android-tableview/blob/master/art/demo.gif)

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
	compile 'com.github.ChargeMap:android-tableview:1.0'
}
```

## Initialisation

### 1 -  Add the view to your XML


```xml
    <com.chargemap_beta.android.tableview.library.TableView
        android:id="@+id/bottomBar"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:layout_alignParentBottom="true" />
```

### 2 -  Customise its behavior


```java
    bottomBar.setColors(
    	R.color.colorPrimary, // Color used for the active tab text
    	R.color.md_grey_500 // Color used for the inactive tabs text
    ); 
```

### 3 -  Add the tabs

```java
    ArrayList<BottombarItem> items = new ArrayList<BottombarItem>(){{
            add(new BottombarItem()
                    .setId(0) // Caution - Needs to be unique
                    .setTitle("Charge") // Specify tab title
                    .setActiveIcon(ContextCompat.getDrawable(getContext(), R.drawable.ic_check_dark)) // Active icon drawable
                    .setActiveIcon(ContextCompat.getDrawable(getContext(), R.drawable.ic_check_dark_disabled)) // Inactive icon drawable
                    .setClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                        	// Place your code to run when the tab is getting active
                            Toast.makeText(getContext(), "Item 1", Toast.LENGTH_LONG).show();
                        }
                    })
            );

            add(new BottombarItem()
                    .setId(1)
                    .setTitle("Map")
                    .setActiveIcon(ContextCompat.getDrawable(getContext(), R.drawable.ic_check_dark))
                    .setActiveIcon(ContextCompat.getDrawable(getContext(), R.drawable.ic_check_dark_disabled))
                    .setClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getContext(), "Item 2", Toast.LENGTH_LONG).show();
                        }
                    })
            );
        }};
```

### 4 -  Set the bar items

```java
   	bottomBar.setItems(items);
```

## ChargeMap ( [http://chargemap.com](https://chargemap.com) )

<img src="https://chargemap.com/img/logo.png" />

 This library has been developed and released by ChargeMap.

## License

This library is distributed under the apache 2.0 license.