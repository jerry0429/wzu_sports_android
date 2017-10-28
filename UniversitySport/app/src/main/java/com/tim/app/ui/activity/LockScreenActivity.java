package com.tim.app.ui.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.application.library.log.DLOG;
import com.tim.app.R;
import com.tim.app.ui.view.SlideBackView;

import java.util.List;

public class LockScreenActivity extends Activity {

    private static final String TAG = "LockScreenActivity";

    private TextView tvDistance;
    private TextView tvAverageSpeed;
    private TextView tvElapseTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_screen);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        DLOG.d(TAG, "开启锁屏界面");
        SlideBackView slideBackLayout = new SlideBackView(LockScreenActivity.this);
        slideBackLayout.bind();

        // 绑定 LocationService 服务
        // startService(new Intent(this, LocationService.class));
        DLOG.d(TAG, "isServiceRunning(this, ):" + isServiceRunning(this, "com.tim.app.ui.activity.LockScreenActivity"));
        if (!isServiceRunning(this, "com.tim.app.ui.activity.LockScreenActivity")) {
            Intent bindIntent = new Intent(this, LocationService.class);
            bindService(bindIntent, connection, BIND_AUTO_CREATE);
        }

        tvDistance = (TextView) findViewById(R.id.tvDistance);
        tvAverageSpeed = (TextView) findViewById(R.id.tvAverageSpeed);
        tvElapseTime = (TextView) findViewById(R.id.tvElapseTime);

        hideBottomUIMenu();
    }

    private Messenger lockMessenger = new Messenger(new InComingServiceHandler());
    private Messenger locationServiceMessenger = null;

    private long elapseTime = 0;

    class InComingServiceHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case LocationService.MSG_FROM_SERVICE:
                    Bundle data = msg.getData();
                    tvDistance.setText(String.valueOf(data.getInt("currentDistance")));
                    tvAverageSpeed.setText(String.valueOf(data.getFloat("currentSpeed")));
                    break;
                case LocationService.MSG_FROM_SERVICE_TIMER:
                    elapseTime = msg.getData().getLong("elapseTime", elapseTime);
                    DLOG.d(TAG, "elapseTime:" + elapseTime);
                    String time = com.tim.app.util.TimeUtil.formatMillisTime(elapseTime * 1000);
                    tvElapseTime.setText(time);
                    break;
                default:
                    super.handleMessage(msg);
                    break;
            }
        }
    }

    public Message getMessageToService(int what) {
        Message msg = Message.obtain(null, what);
        msg.replyTo = lockMessenger;
        return msg;
    }

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            DLOG.d(TAG, "onServiceConnected name: " + name + ", service: " + service);
            locationServiceMessenger = new Messenger(service);
            try {
                Message msg = getMessageToService(LocationService.MSG_REGISTER_CLIENT);
                locationServiceMessenger.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };


    /**
     * 隐藏虚拟按键，并且全屏
     */
    protected void hideBottomUIMenu() {
        //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);

        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onPause() {
        DLOG.d("LockScreenActivity", "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        DLOG.d("LockScreenActivity", "onStop");
        super.onStop();
    }

    protected void onDestroy() {
        super.onDestroy();
        DLOG.d(TAG, "locationServiceMessenger is " + locationServiceMessenger);
        if (locationServiceMessenger != null) {
            unbindService(connection);
        }
        DLOG.d("LockScreenActivity", "onDestroy");
    }

    @Override
    protected void onRestart() {
        DLOG.d("LockScreenActivity", "onRestart");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
        DLOG.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        DLOG.d(TAG, "onResume");
    }
    public boolean isServiceRunning(Context mContext, String className) {
        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager)
                mContext.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager.getRunningServices(30);
        if (!(serviceList.size()>0)) {
            return false;
        }
        for (int i=0; i<serviceList.size(); i++) {
            if (serviceList.get(i).service.getClassName().equals(className) == true) {
                isRunning = true;
                break;
            }
        }
        return isRunning;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
    }
}
