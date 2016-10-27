package com.apg.android.library;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LocaleUtilsInstrumentedTest {

    private Context appContext;

    @Before
    public void init() {
        appContext = InstrumentationRegistry.getTargetContext();
        LocaleUtils.setLocale(Locale.getDefault());
    }

    @Test
    public void useAppContext() throws Exception {

    }
}
