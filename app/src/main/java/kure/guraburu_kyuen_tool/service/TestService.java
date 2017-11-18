package kure.guraburu_kyuen_tool.service;

import android.app.Service;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import kure.guraburu_kyuen_tool.ReliefFragment;

/**
 * Created by yuuma on 2017/11/18.
 */

public class TestService extends Service {
    private Timer timer = null;
    private int count = 0;
    private Handler handler = null;
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        timer = new Timer();
        handler = new Handler();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String comment = "Service:" + count;
                        Toast.makeText(getApplicationContext(), comment, Toast.LENGTH_SHORT).show();
                        CopyClipBoard(String.valueOf(count));
                        count++;
                    }
                });
            }
        }, 0, 2000);
        return super.onStartCommand(intent, flags, startId);
    }

    private boolean CopyClipBoard(String a) {
        try {
            //クリップボードに格納するItemの作成
            ClipData.Item item = new ClipData.Item(a);

            //MIMETYPEの作成
            String[] mimeType = new String[1];
            mimeType[0] = ClipDescription.MIMETYPE_TEXT_URILIST;

            //クリップボードに格納するClipDataオブジェクトの作成
            ClipData cd = new ClipData(new ClipDescription("text_data", mimeType), item);

            //クリップボードにデータを格納
            ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            cm.setPrimaryClip(cd);
            return true;
        }
        catch (Throwable e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (handler != null) {
            handler = null;
        }
    }

    @Override
    public IBinder onBind(Intent intent){
        return  null;
    }
}
