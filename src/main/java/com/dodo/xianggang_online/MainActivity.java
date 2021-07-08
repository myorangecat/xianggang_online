package com.dodo.xianggang_online;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.TransactionTooLargeException;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//定义相关的组件
    private ImageView home,search,police;
    private TextView textView_1,textView_2,textView_3;
    Fragment f=new one();
    Intent intent;
    private byte[] buffer,buffer2;
    String state_data,search_data;
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //intent=new Intent(MainActivity.this,MainActivity2.class);
        //startActivity(intent);
        //标题区域可设置为 layout ，如此可以有丰富的展现方式
        setContentView(R.layout.activity_main);
        //获取信息
       state_data= getStateInfoFile();
       search_data=getSearchInfoPolice();
        //获取相关组件并为其添加点击事件监控
        findViewId();
        //setTitle(getResources().getString(R.string.search));
       // String string=new String();
        ////////////////////////////////
    }
    ///////////////////menu部分//////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=new MenuInflater(this);
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.setting:
                Intent intent=new Intent(this,setting.class);
                startActivity(intent);
                break;
            case R.id.about:
                Intent intent1=new Intent(this,about.class);
                startActivity(intent1);
                break;
        }
       return super.onOptionsItemSelected(item);
    }
    //点击事件的响应
    @Override
    public void onClick(View view){
        bundle.putString("data",state_data);
        bundle.putString("search",search_data);
        //更新图标颜色以显示在那个标签
        setItemBackground(view);
        FragmentManager manager=getSupportFragmentManager();        //获取到Franger管理
        FragmentTransaction fragmentTransaction=manager.beginTransaction();     //开启一个事务
        switch(view.getId()){
            case R.id.imageView1:
                //this.setTitle(getResources().getString(R.string.home));
                f=new home();
                f.setArguments(bundle);//数据传递到fragment中
                break;
            case R.id.imageView2:
                //this.setTitle(getResources().getString(R.string.search));
                stopService(new Intent(MainActivity.this,MyService.class));
                f=new one();
                f.setArguments(bundle);
                break;
            case R.id.imageView3:
                //this.setTitle(getResources().getString(R.string.police));
                //vibrator.vibrate(6000);
                startService(new Intent(MainActivity.this,MyService.class));
                f=new police();
                break;
        }
        //one one=new one();
        //if(one.getFlag()==2)f=new kongya_tow();
        //if(one.getFlag()==3)f=new kongya_three();
        fragmentTransaction.replace(R.id.fragment,f);
        fragmentTransaction.commit();
    }
    //底部导航栏实时状态颜色显示方法
    public  void setItemBackground(View view){
        View view_1=view;
        home.setImageResource(R.drawable.home);
        search.setImageResource(R.drawable.search);
        police.setImageResource(R.drawable.police);
        textView_1.setTextColor(getColor(R.color.icon_night));
        textView_2.setTextColor(getColor(R.color.icon_night));
        textView_3.setTextColor(getColor(R.color.icon_night));
        if(view_1.getId()==R.id.imageView1){
            home.setImageResource(R.drawable.home_is);
            textView_1.setTextColor(getColor(R.color.icon_light));
        }
        if(view_1.getId()==R.id.imageView2){
            search.setImageResource(R.drawable.search_is);
        textView_2.setTextColor(getColor(R.color.icon_light));
        }
        if(view_1.getId()==R.id.imageView3){police.setImageResource(R.drawable.police_is);
        textView_3.setTextColor(getColor(R.color.icon_light));}
    }
    //组件的初始化
    public void findViewId(){
        home=findViewById(R.id.imageView1);
        search=findViewById(R.id.imageView2);
        police=findViewById(R.id.imageView3);
        textView_1=findViewById(R.id.textView1);
        textView_2=findViewById(R.id.textView2);
        textView_3=findViewById(R.id.textView3);
        home.setOnClickListener(this);
        search.setOnClickListener(this);
        police.setOnClickListener(this);
    }
    @Override
    protected void onStart(){

        Toast.makeText(MainActivity.this,"欢迎使用",Toast.LENGTH_SHORT).show();
        //startService(new Intent(this,MyService.class));
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        bundle.putString("search",search_data);
        f=new one();
        f.setArguments(bundle);
        fragmentTransaction.add(R.id.fragment,f);
        fragmentTransaction.commit();
        super.onStart();
    }
    //获取后台三空压所有离心机状态文件的方法
    public String getStateInfoFile(){
        /*
        try{

            FileOutputStream fos=openFileOutput("info.text",MODE_APPEND);
            fos.flush();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();

        }
         */
        try {
            FileInputStream fis= openFileInput("info.txt");
            buffer=new byte[fis.available()];
            fis.read(buffer);
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return new String(buffer);

    }
    //获取Search界面的信息
    public  String getSearchInfoPolice(){
        try {
            FileInputStream fis= openFileInput("info_police.txt");
            buffer2=new byte[fis.available()];
            fis.read(buffer2);
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("读文件读到的内容:"+new String(buffer2));
        return new String(buffer2);
    }
}