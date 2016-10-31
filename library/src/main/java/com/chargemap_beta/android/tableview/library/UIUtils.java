package com.chargemap_beta.android.tableview.library;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by rbertin on 03/10/16.
 */

public class UIUtils {

    public static float convertPixelsToDp(float px) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return Math.round(dp);
    }

    public static float convertDpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }
}
