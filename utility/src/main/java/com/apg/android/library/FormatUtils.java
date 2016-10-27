package com.apg.android.library;

import java.text.NumberFormat;

/**
 * Created by alphaadmin on 27/9/2559.
 */

public class FormatUtils {

    public static String getMoneyFormat(int m) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(true);
        return numberFormat.format(m);
    }

    public static String getMoneyFormat(double m) {
        return getMoneyFormat((int) m);
    }
}
