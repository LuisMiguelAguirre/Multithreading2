package com.example.admin.multithreading2;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Luis Aguirre on 9/6/2017.
 */

public class TestRunnable implements Runnable {

    TextView tvCounter;
    Handler handler = new Handler(Looper.getMainLooper());

    public TestRunnable(TextView tvCounter) {
        this.tvCounter = tvCounter;
    }


    private static final String TAG = "TestRunnableTag";
    int i = 0;

    @Override
    public void run() {
        for (i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                Log.d(TAG, "run: " + Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
/*
            handler.post(new Runnable() {
                @Override
                public void run() {
                    tvCounter.setText(String.valueOf( 5 -  i));
                }
            });*/

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    tvCounter.setText(String.valueOf( 5 -  i));
                }
            },1000);

        }
    }
}
