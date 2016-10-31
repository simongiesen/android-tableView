package com.chargemap_beta.android.tableview.library.callbacks;

import android.view.View;

/**
 * Created by rbertin on 21/10/2016.
 */

public interface ClickListener {
    void onClick(View v, int position, boolean isLongClick);
}