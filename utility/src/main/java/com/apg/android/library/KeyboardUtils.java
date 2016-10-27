package com.apg.android.library;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by alphaadmin on 5/10/2559.
 */

public class KeyboardUtils {

    public static void showKeyboard(EditText edt) {
        InputMethodManager imm = (InputMethodManager) edt.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(edt, InputMethodManager.SHOW_IMPLICIT);
    }
}
