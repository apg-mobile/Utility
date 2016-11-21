package com.apg.android.library;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by siwarat.s on 23/5/2559.
 */
public class CalendarUtils {

    public static TimeState getTimeState(long date) {

        Calendar compareCalendar = Calendar.getInstance();
        compareCalendar.setTime(new Date(date));

        Calendar todayCalendar = Calendar.getInstance();
        todayCalendar.setTime(new Date(System.currentTimeMillis()));

        int today = todayCalendar.get(Calendar.DATE);
        int compareDay = compareCalendar.get(Calendar.DATE);
        if (today == compareDay) {
            return TimeState.TODAY;
        } else if (today > compareDay && (today - compareDay) == 1) {
            return TimeState.YESTERDAY;
        } else if (today > compareDay) {
            return TimeState.PAST;
        } else if (today < compareDay && (compareDay - today) == 1) {
            return TimeState.TOMORROW;
        } else {
            return TimeState.FUTURE;
        }
    }

    public enum TimeState {
        PAST,
        YESTERDAY,
        TODAY,
        TOMORROW,
        FUTURE
    }

    public static boolean isToday(long date) {

        Calendar compareCalendar = Calendar.getInstance();
        compareCalendar.setTime(new Date(date));

        Calendar todayCalendar = Calendar.getInstance();
        todayCalendar.setTime(new Date(System.currentTimeMillis()));

        return todayCalendar.get(Calendar.DATE) == compareCalendar.get(Calendar.DATE);
    }

    public static boolean isYesterday(long date) {

        Calendar compareCalendar = Calendar.getInstance();
        compareCalendar.setTime(new Date(date));

        Calendar todayCalendar = Calendar.getInstance();
        todayCalendar.setTime(new Date(System.currentTimeMillis()));

        return todayCalendar.get(Calendar.DATE) < compareCalendar.get(Calendar.DATE);
    }

    public static boolean isFuture(long date) {

        Calendar compareCalendar = Calendar.getInstance();
        compareCalendar.setTime(new Date(date));

        Calendar todayCalendar = Calendar.getInstance();
        todayCalendar.setTime(new Date(System.currentTimeMillis()));

        return todayCalendar.get(Calendar.DATE) > compareCalendar.get(Calendar.DATE);
    }

    public static String getString(Calendar calendar, CalendarFormat format) {
        SimpleDateFormat s = new SimpleDateFormat(format.getPattern());
        String result;
        result = s.format(calendar.getTime());
        if (result == null) {
            result = "";
        }
        return result;
    }

    public static String getString(long millisecond, CalendarFormat format) {
        SimpleDateFormat s = new SimpleDateFormat(format.getPattern());
        String result;
        result = s.format(new Date(millisecond));
        if (result == null) {
            result = "";
        }
        return result;
    }

    public static Calendar fromString(String dateTimeString, CalendarFormat format) {
        SimpleDateFormat s = new SimpleDateFormat(format.getPattern());
        Date date = null;
        try {
            date = s.parse(dateTimeString);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
            date = new Date();
        }
        if (date == null) {
            date = new Date();
        }
        Calendar result = Calendar.getInstance();
        result.setTime(date);
        return result;
    }

    public static String convert(String dateTimeString, CalendarFormat sourceFormat, CalendarFormat desFormat) {
        Calendar c = fromString(dateTimeString, sourceFormat);
        return getString(c, desFormat);
    }

    public enum CalendarFormat {
        BASE_FORMAT("yyyy-MM-dd'T'HH:mm:ss"),
        FILTER_DISPLAY_FORMAT("dd - MMMM - yyyy");

        private String pattern;

        CalendarFormat(String pattern) {
            this.pattern = pattern;
        }

        public String getPattern() {
            return pattern;
        }
    }
}
