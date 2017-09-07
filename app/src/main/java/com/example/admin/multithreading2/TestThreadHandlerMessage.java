package com.example.admin.multithreading2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by Luis Aguirre on 9/6/2017.
 */

public class TestThreadHandlerMessage extends Thread {

    android.os.Handler handler;

    public TestThreadHandlerMessage(android.os.Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        super.run();

        Bundle bundle = new Bundle();
        bundle.putString("data", "Hi from the TestThreadHandlerMessage");

        Message message = new Message();
        message.setData(bundle);
        handler.sendMessage(message);

    }
}
