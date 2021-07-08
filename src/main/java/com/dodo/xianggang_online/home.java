package com.dodo.xianggang_online;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringTokenizer;

public class home extends Fragment {
    //定义三个空压的所有离心机的状态view组件
    private TextView button;
    String mess;
    byte[] buffer;
    private TextView
            button_one_1, button_one_2, button_one_3, button_one_4,button_one_5,button_one_6,button_one_7,
            button_tow_1, button_tow_2, button_tow_3, button_tow_4,button_tow_5,button_tow_6,button_tow_7,
            button_three_1, button_three_2, button_three_3, button_three_4,button_three_5,button_three_6,button_three_7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, null);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        initView();         //初始化组件
        //从Activity中获取数据
        Bundle bundle = this.getArguments();//得到从Activity传来的数据
        if (bundle != null) {
            mess = bundle.getString("data");
        }
        System.out.println("从主Activity得到的字符串的长度:"+mess.length());
        change_button_background(data_int_to_array(mess));
        //int data_int = Integer.parseInt(mess);
    }

    /*
            StringTokenizer stringTokenizer = new StringTokenizer(mess, " ");
            while (stringTokenizer.hasMoreTokens()) {
            }



             */

    //初始化HomeXML文件中组件并获取其的ID
    public void initView() {
        /*************一空压七个离心机*****************/
        {
            button_one_1 = getActivity().findViewById(R.id.button_one_1);
            button_one_2 = getActivity().findViewById(R.id.button_one_2);
            button_one_3 = getActivity().findViewById(R.id.button_one_3);
            button_one_4 = getActivity().findViewById(R.id.button_one_4);
            button_one_5 = getActivity().findViewById(R.id.button_one_5);
            button_one_6 = getActivity().findViewById(R.id.button_one_6);
            button_one_7 = getActivity().findViewById(R.id.button_one_7);
        }
        /*************二空压七个离心机*****************/
        {
            button_tow_1 = getActivity().findViewById(R.id.button_tow_1);
            button_tow_2 = getActivity().findViewById(R.id.button_tow_2);
            button_tow_3 = getActivity().findViewById(R.id.button_tow_3);
            button_tow_4 = getActivity().findViewById(R.id.button_tow_4);
            button_tow_5 = getActivity().findViewById(R.id.button_tow_5);
            button_tow_6 = getActivity().findViewById(R.id.button_tow_6);
            button_tow_7 = getActivity().findViewById(R.id.button_tow_7);
        }
        /*************三空压七个离心机*****************/
        {
            button_three_1 = getActivity().findViewById(R.id.button_three_1);
            button_three_2 = getActivity().findViewById(R.id.button_three_2);
            button_three_3 = getActivity().findViewById(R.id.button_three_3);
            button_three_4 = getActivity().findViewById(R.id.button_three_4);
            button_three_5 = getActivity().findViewById(R.id.button_three_5);
            button_three_6 = getActivity().findViewById(R.id.button_three_6);
            button_three_7 = getActivity().findViewById(R.id.button_three_7);
        }
        //其他组件
        button = getActivity().findViewById(R.id.button);
    }

    //将String类型的数据转换为int数组
    public int[] data_int_to_array(String data){
       System.out.println("处理前的长度:"+data.length());
       int[] data_array=new int[21];
       for(int i=0;i<21;i++){
           System.out.println(i);
           Character ch=data.charAt(i);
           data_array[i]=Integer.parseInt(ch.toString());
       }
        System.out.println("处理后整型数组的长度:"+data_array.length);
      return data_array;
    }

    //根据读取的整型数组的数据更改图标的颜色
    public void change_button_background(int[] data){
        System.out.println("使用时的长度:"+data.length);
        /**********一空压*************/
        {
            if (data[0] == 0) {
                button_one_1.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[1] == 0) {
                button_one_2.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[2] == 0) {
                button_one_3.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[3] == 0) {
                button_one_4.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[4] == 0) {
                button_one_5.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[5] == 0) {
                button_one_6.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[6] == 0) {
                button_one_7.setBackgroundResource(R.drawable.shape_cir_police);
            }
        }
        /**********二空压*************/
        {
            if (data[7] == 0) {
                button_tow_1.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[8] == 0) {
                button_tow_2.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[9] == 0) {
                button_tow_3.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[10] == 0) {
                button_tow_4.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[11] == 0) {
                button_tow_5.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[12] == 0) {
                button_tow_6.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[13] == 0) {
                button_tow_7.setBackgroundResource(R.drawable.shape_cir_police);
            }
        }
        /**********三空压*************/
        {
            if (data[14] == 0) {
                button_three_1.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[15] == 0) {
                button_three_2.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[16] == 0) {
                button_three_3.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[17] == 0) {
                button_three_4.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[18] == 0) {
                button_three_5.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[19] == 0) {
                button_three_6.setBackgroundResource(R.drawable.shape_cir_police);
            }
            if (data[20] == 0) {
                button_three_7.setBackgroundResource(R.drawable.shape_cir_police);
            }
        }
    }
}
