package com.apg.android.library;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CalendarUtilsTest {
    
    private Calendar c1, c2, c3;

    @Before
    public void init(){
        c1 = Calendar.getInstance();
        c1.set(Calendar.DATE, 1);
        c1.set(Calendar.MONTH, 1);
        c1.set(Calendar.YEAR, 2016);
        c1.set(Calendar.HOUR_OF_DAY, 5);
        c1.set(Calendar.MINUTE, 35);
        c1.set(Calendar.SECOND, 40);
        c1.set(Calendar.MILLISECOND, 350);

        c2 = Calendar.getInstance();
        c2.set(Calendar.DATE, 5);
        c2.set(Calendar.MONTH, 10);
        c2.set(Calendar.YEAR, 1900);
        c2.set(Calendar.HOUR_OF_DAY, 0);
        c2.set(Calendar.MINUTE, 0);
        c2.set(Calendar.SECOND, 0);
        c2.set(Calendar.MILLISECOND, 0);

        c3 = Calendar.getInstance();
        c3.set(Calendar.DATE, 28);
        c3.set(Calendar.MONTH, 2);
        c3.set(Calendar.YEAR, 2555);
        c3.set(Calendar.HOUR_OF_DAY, 7);
        c3.set(Calendar.MINUTE, 23);
        c3.set(Calendar.SECOND, 59);
        c3.set(Calendar.MILLISECOND, 500);

    }

    @Test
    public void addition_isCorrect() throws Exception {
//        CalendarUtils.getString(c1, CalendarUtils.CalendarFormat.BASE_FORMAT)
    }
}