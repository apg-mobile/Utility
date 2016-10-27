package com.apg.android.library;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Toast;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AlertUtilsInstrumentedTest {

    private Context appContext;

    @Before
    public void init() {
        appContext = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void playSoundTest() throws Exception {
        assertTrue(AlertUtils.playSound(appContext));
        assertFalse(AlertUtils.playSound(null));
    }

    @Test
    public void vibrateTest() throws Exception {
        assertTrue(AlertUtils.vibrate(appContext));
        assertFalse(AlertUtils.vibrate(null));
    }

    @Test
    public void centerToastTest() throws Exception {

    }
}
