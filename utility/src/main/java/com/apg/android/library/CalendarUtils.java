package com.apg.android.library;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by siwarat.s on 23/5/2559.
 */
public class CalendarUtils {

    public static boolean isNotCurrentYear(long date) {
        Calendar compareCalendar = Calendar.getInstance();
        compareCalendar.setTime(new Date(date));

        Calendar todayCalendar = Calendar.getInstance();
        todayCalendar.setTime(new Date(System.currentTimeMillis()));

        int thisYear = todayCalendar.get(Calendar.YEAR);
        int compareYear = compareCalendar.get(Calendar.YEAR);

        return thisYear != compareYear;
    }

    public static TimeState getTimeState(long date) {

        long daysDiff = CountDayFromNow(date);

        if (daysDiff == 0) {
            return TimeState.TODAY;
        } else if (daysDiff == -1){
            return TimeState.YESTERDAY;
        }  else if (daysDiff == 1) {
            return TimeState.TOMORROW;
        } else if (daysDiff < -1) {
            return TimeState.PAST;
        } else {
            return TimeState.FUTURE;
        }
    }

    public static int CountDayFromNow(long milliSec) {
        Calendar compareCal = Calendar.getInstance();
        compareCal.setTimeInMillis(milliSec);
        int compare = compareCal.get(Calendar.DATE);

        Calendar todayCal = Calendar.getInstance();
        int today = todayCal.get(Calendar.DATE);

        return compare - today;
    }

    public static int CountDayBetween(long milliSecFrom, long milliSecTo) {
        Calendar fromCal = Calendar.getInstance();
        fromCal.setTimeInMillis(milliSecFrom);
        int from = fromCal.get(Calendar.DATE);

        Calendar toCal = Calendar.getInstance();
        toCal.setTimeInMillis(milliSecTo);
        int to = toCal.get(Calendar.DATE);

        return from - to;
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
