package com.dodo.xianggang_online;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements  View.OnClickListener {
    //相关变量的定义
    Button login_button;
    TextView login_help;
    EditText login_user,login_pass_word;
/****************Activity实现部分**********************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        itemSetting();          //设置当前Activity的标题不可见，并且状态栏透明
        initViewId();

    }
/*********************环境配置方法*************************/
    //标题栏设置
    private void itemSetting() {
        //隐藏当前Activity的标题栏

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//透明状态栏
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);//取消状态栏
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    //按键响应
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login:
               if(checkUserInfo(login_user.getText().toString(),login_pass_word.getText().toString())) {


                 Toast.makeText(MainActivity2.this, "登录成功", Toast.LENGTH_SHORT).show();
                 Intent intent=new Intent(this,MainActivity.class);
                 startActivity(intent);
                 finish();
               }
               else {

                   Toast.makeText(MainActivity2.this, "输入的信息有误，请检查后重新登录!" , Toast.LENGTH_SHORT).show();
                    startService(new Intent(MainActivity2.this,MyService.class));
               }


               break;
            case R.id.login_help: {
                {
                    Toast.makeText(MainActivity2.this, "获取帮助", Toast.LENGTH_SHORT).show();
                    AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                    alertDialog.setIcon(R.drawable.login_help);
                    alertDialog.setTitle("获取帮助");
                    alertDialog.setMessage("由于此软件涉及设备隐私，" +
                            "账号只能由管理员给予，需要登录请联系管理员!\n" +
                            "Email:lxiaohui861@gmail.com");
                    //添加按钮
                    alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener() {
                        //为确定按钮添加点击事件
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alertDialog.show();
                }
                break;
            }
        }

    }

    //对布局文件的相关组件进行初始化并为其添加点击事件监听器
    public void initViewId(){
        login_help = findViewById(R.id.login_help);
        login_button = findViewById(R.id.button_login);
        login_user=findViewById(R.id.login_user);
        login_pass_word=findViewById(R.id.login_passWord);
        login_button.setOnClickListener(this);
        login_help.setOnClickListener(this);
    }

    //账号登录检测
    public boolean checkUserInfo(String user,String passWord){
        //检查账号和密码
        if(user.equals("201804134120")&&passWord.equals("88888888")) return true;
        else return false;
    }
}
    //帮助提示
