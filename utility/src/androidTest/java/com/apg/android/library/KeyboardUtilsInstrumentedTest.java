package com.apg.android.library;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class KeyboardUtilsInstrumentedTest {

    private Context appContext;

    @Before
    public void init() {
        appContext = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void noTest() throws Exception {

    }
}
