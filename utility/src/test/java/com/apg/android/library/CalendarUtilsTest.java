package com.apg.android.library;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by X-tivity on 11/21/2016 AD.
 */
public class CalendarUtilsTest {

    @Test
    public void checkPassTimeState() throws Exception {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -2);
        long time = cal.getTimeInMillis();

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
//        Date parse = sdf.parse("2016-06-06T10:26:51.500");
//        long time = parse.getTime();

        CalendarUtils.TimeState timeState = CalendarUtils.getTimeState(time);
        assertEquals(CalendarUtils.TimeState.PAST, timeState);
    }

    @Test
    public void checkYesterdayTimeState() throws Exception {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        long time = cal.getTime().getTime();

        CalendarUtils.TimeState timeState = CalendarUtils.getTimeState(time);
        assertEquals(CalendarUtils.TimeState.YESTERDAY, timeState);
    }

    @Test
    public void checkTodayTimeState() throws Exception {

        long time = new Date().getTime();

        CalendarUtils.TimeState timeState = CalendarUtils.getTimeState(time);
        assertEquals(CalendarUtils.TimeState.TODAY, timeState);
    }


    @Test
    public void checkTomorrowTimeState() throws Exception {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        long time = cal.getTime().getTime();

        CalendarUtils.TimeState timeState = CalendarUtils.getTimeState(time);
        assertEquals(CalendarUtils.TimeState.TOMORROW, timeState);
    }

    @Test
    public void checkFutureTimeState() throws Exception {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 2);
        long time = cal.getTimeInMillis();

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
//        Date parse = sdf.parse("2017-01-07T00:00:00.000");
//        long time = parse.getTime();

        CalendarUtils.TimeState timeState = CalendarUtils.getTimeState(time);
        assertEquals(CalendarUtils.TimeState.FUTURE, timeState);
    }
}