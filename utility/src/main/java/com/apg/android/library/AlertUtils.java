package com.apg.android.library;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.annotation.IntDef;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.widget.Toast;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by alphaadmin on 28/9/2559.
 */

public class AlertUtils {

    @IntDef({Toast.LENGTH_SHORT, Toast.LENGTH_LONG})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    public static boolean playSound(Context context) {
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(context, notification);
            r.play();
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean vibrate(Context context) {
        try {
            Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Toast centerToast(Context context, String text,
                                    @Duration int duration) {
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        return toast;
    }

    public static Toast centerToast(Context context, @StringRes int id,
                                    @Duration int duration) {
        return centerToast(context, context.getString(id), duration);
    }
}
