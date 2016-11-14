package com.apg.android.library;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by alphaadmin on 5/10/2559.
 */

public class KeyboardUtils {

    public void hideKeyboard(Context activityContext){

        InputMethodManager imm = (InputMethodManager)
                activityContext.getSystemService(Context.INPUT_METHOD_SERVICE);

        //android.R.id.content ( http://stackoverflow.com/a/12887919/2077479 )
        View rootView = ((Activity) activityContext)
                .findViewById(android.R.id.content).getRootView();

        imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);
    }

    public static void showKeyboard(EditText edt) {
        InputMethodManager imm = (InputMethodManager) edt.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(edt, InputMethodManager.SHOW_IMPLICIT);
    }

    public void showKeyboard(Context activityContext, final EditText editText){

        final InputMethodManager imm = (InputMethodManager)
                activityContext.getSystemService(Context.INPUT_METHOD_SERVICE);

        if (!editText.hasFocus()) {
            editText.requestFocus();
        }

        editText.post(new Runnable() {
            @Override
            public void run() {
                imm.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
            }
        });
    }
}
