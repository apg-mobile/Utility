package com.apg.android.library;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by alphaadmin on 11/10/2559.
 */

public class TimerUtils {

    public static Timer createTimer() {
        return new TimerImpl();
    }

    private static class TimerImpl implements Timer {

        private ScheduledExecutorService scheduledExecutorService
                = Executors.newScheduledThreadPool(1);
        private ScheduledFuture<?> schedule;
        private long travelMilli, finishMilli, passedMilli;
        private Callback callback;
        private boolean isFinish;

        @Override
        public void start(long travelMilli, long finishMilli, Callback callback) {
            this.travelMilli = travelMilli;
            this.finishMilli = finishMilli;
            this.callback = callback;
            this.passedMilli = finishMilli;
            schedule = scheduledExecutorService.scheduleAtFixedRate(onTick, travelMilli, travelMilli, TimeUnit.MILLISECONDS);
            scheduledExecutorService.schedule(onFinish, finishMilli, TimeUnit.MILLISECONDS);
            callback.onStart(passedMilli);
            isFinish = false;
        }

        @Override
        public void cancel() {
            schedule.cancel(true);
            callback.onCancel();
            isFinish = true;
        }

        @Override
        public void restart() {
            if (!isFinish) {
                cancel();
            }
            start(travelMilli, finishMilli, callback);
        }

        private Runnable onTick = new Runnable() {
            @Override
            public void run() {
                passedMilli -= travelMilli;
                if (passedMilli <= 0) {
                    schedule.cancel(true);
                    isFinish = true;
                } else {
                    callback.onTick(passedMilli);
                }
            }
        };

        private Runnable onFinish = new Runnable() {
            @Override
            public void run() {
                callback.onFinish(finishMilli);
                isFinish = true;
            }
        };
    }

    public interface Timer {
        void start(long travelMilli, long finishMilli, Callback callback);

        void cancel();

        void restart();

        interface Callback {

            void onStart(long milli);

            void onTick(long milli);

            void onFinish(long milli);

            void onCancel();
        }
    }
}
