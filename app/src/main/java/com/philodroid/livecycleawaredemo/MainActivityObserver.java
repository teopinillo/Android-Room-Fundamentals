package com.philodroid.livecycleawaredemo;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
//https://developer.android.com/reference/android/arch/lifecycle/Lifecycle.html

public class MainActivityObserver implements LifecycleObserver {
    private static String TAG = MainActivity.class.getSimpleName();

    //On the activity to observe

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreateEvent() {
        Log.i(TAG, "Observer ON_CREATE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStartEvent() {
        Log.i(TAG, "Observer ON_START");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResumeEvent() {
        Log.i(TAG, "Observer ON_RESUME");
    }

    //The next three happends before the activity event
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPauseEvent() {
        Log.i(TAG, "Observer ON_PAUSE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStopEvent() {
        Log.i(TAG, "Observer ON_STOP");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroyEvent() {
        Log.i(TAG, "Observer ON_DESTROY");
    }

}
