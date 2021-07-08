package com.dodo.xianggang_online;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Vibrator;
import android.util.Log;

import java.io.FileInputStream;
import java.io.IOException;

public class getStateInfoFile extends Service {
    byte[] buffer;

    public getStateInfoFile() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate(){
        Log.i("Service:","Service已经创建");

        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        //调用手机振动

        return super.onStartCommand(intent,flags,startId);
    }
    @Override
    public void onDestroy(){
        Log.i("Service:","Service已停止");

        super.onDestroy();
    }
    public String getInfo(){
        try {
            FileInputStream fis= openFileInput("info_police.txt");
            buffer=new byte[fis.available()];
            fis.read(buffer);
            fis.close();
        }catch (
                IOException e){
            e.printStackTrace();
        }
       return new String(buffer);
    }
}