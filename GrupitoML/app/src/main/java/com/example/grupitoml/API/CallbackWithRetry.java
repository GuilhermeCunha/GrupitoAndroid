package com.example.grupitoml.API;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;

public abstract class CallbackWithRetry<T> implements Callback<T> {

    //private static final int TOTAL_RETRIES = 3;
    private static final String TAG = CallbackWithRetry.class.getSimpleName();
    private int retryCount = 0;

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.e(TAG, t.getLocalizedMessage());
        retryCount++;
        Log.v(TAG, "Retrying... (" + retryCount + ")");
        retry(call);
    }

    private void retry(Call<T> call) {
        call.clone().enqueue(this);
    }
}
