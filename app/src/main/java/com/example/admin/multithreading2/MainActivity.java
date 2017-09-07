package com.example.admin.multithreading2;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivityTag";
TextView tvCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: " + Thread.currentThread());

        tvCounter = (TextView) findViewById(R.id.tvCounter);
    }

    public void executeThreads(View view) {

        Log.d(TAG, "executeThreads: " + Thread.currentThread());
        /*ExecutorService executorService = Executors.newSingleThreadExecutor();
        TestRunnable testRunnable = new TestRunnable();
        executorService.submit(testRunnable);*/


        switch (view.getId()){

            case R.id.btnThreads:
                TestThread testThread = new TestThread(tvCounter);
                testThread.start();
                break;
            case R.id.btnRunnable:
                TestRunnable testRunnable = new TestRunnable(tvCounter);
                Thread thread =  new Thread(testRunnable);
                thread.start();
                break;
            case R.id.btnAsyncTask:




                break;
            case R.id.btnThreadHandlerMessage:

                Handler handler = new Handler(new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message message) {
                        tvCounter.setText(message.getData().getString("data"));
                        return false;
                    }
                });

                TestThreadHandlerMessage testThreadHandlerMessage = new TestThreadHandlerMessage(handler);
                testThreadHandlerMessage.start();

                break;

        }

    }
}
