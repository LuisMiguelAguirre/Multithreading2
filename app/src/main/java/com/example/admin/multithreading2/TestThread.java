package com.example.admin.multithreading2;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.content.ContentValues.TAG;


/**
 * Created by Luis Aguirre on 9/6/2017.
 */

public class TestThread extends Thread {

    TextView tvCounter;
    Handler handler = new Handler(Looper.getMainLooper());

    public TestThread(TextView tvCounter) {
        this.tvCounter = tvCounter;
    }

    public static final String TAG = "TestThreadTag";
    int i = 0;


    @Override
    public void run() {
        super.run();

        for (i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    tvCounter.setText(String.valueOf(i));
                }
            });

            Log.d(TAG, "run: " + i + " " + Thread.currentThread());
        }


    }


}
