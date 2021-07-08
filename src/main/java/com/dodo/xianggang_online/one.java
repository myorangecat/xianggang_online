package com.dodo.xianggang_online;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

public class one extends Fragment implements View.OnClickListener {
    public   View textView1,textView2,textView3;
    public TextView textView_k1_1;
    public int flag;
    Fragment  f=null;
    private String search_data;
    private String[] data_array;
    Bundle bundle=new Bundle();
    /***********************一空压一号离心机*******************************/
     public TextView textView_k1_1_time1,textView_k1_1_time2,
            textView_k1_1_time3,textView_k1_1_time4,
            textView_k1_1_time5,textView_k1_1_time6,
            textView_k1_1_tem1,textView_k1_1_tem2,
            textView_k1_1_tem3,textView_k1_1_tem4,
            textView_k1_1_tem5,textView_k1_1_tem6,
            TextView_k1_1_level;
    /***********************一空压二号离心机*******************************/
    public TextView textView_k1_2_time1,textView_k1_2_time2,
            textView_k1_2_time3,textView_k1_2_time4,
            textView_k1_2_time5,textView_k1_2_time6,
            textView_k1_2_tem1,textView_k1_2_tem2,
            textView_k1_2_tem3,textView_k1_2_tem4,
            textView_k1_2_tem5,textView_k1_2_tem6,
            TextView_k1_2_level;
    /***********************一空压三号离心机*******************************/
    public TextView textView_k1_3_time1,textView_k1_3_time2,
            textView_k1_3_time3,textView_k1_3_time4,
            textView_k1_3_time5,textView_k1_3_time6,
            textView_k1_3_tem1,textView_k1_3_tem2,
            textView_k1_3_tem3,textView_k1_3_tem4,
            textView_k1_3_tem5,textView_k1_3_tem6,
            TextView_k1_3_level;
    @Override
    public void onSaveInstanceState(Bundle outState) {
        //不保存之前的fragment的状态
        super.onSaveInstanceState(outState);
    }
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.activity_kongya_one,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        Bundle bundle = this.getArguments();//得到从Activity传来的数据
        if (bundle != null) {
            search_data = bundle.getString("search");
        }
        System.out.println("收到信息:"+search_data);
        StringTokenizer st=new StringTokenizer(search_data,"@");
        int size=st.countTokens();
        System.out.println("总共有"+st.countTokens()+"个数据");
        data_array=new String [size];
        for(int i=0;i<size;i++){
            data_array[i]=st.nextToken();
            System.out.println(data_array[i]);
        }
        changeViewInfo(data_array);
        /*
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
         */
    }
    @Override
    //点击事件响应
    public void onClick(View view){
        FragmentManager manager=getFragmentManager();        //获取到Franger管理
        FragmentTransaction fragmentTransaction=manager.beginTransaction();
        bundle.putString("search",search_data);
       // f.isHidden();
        switch (view.getId()){
            case R.id.button_k1_tow:
                f=new kongya_tow();
                f.setArguments(bundle);
                break;
            case R.id.button_k1_three:
               f=new kongya_three();
                f.setArguments(bundle);
                break;
        }
        fragmentTransaction.replace(R.id.fragment,f);
        fragmentTransaction.commit();
    }
    //组件初始化
    public void initView(){

        textView1=getActivity().findViewById(R.id.button_k1_one);
        textView2=getActivity().findViewById(R.id.button_k1_tow);
        textView3=getActivity().findViewById(R.id.button_k1_three);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        /***********************一空压一号离心机*******************************/
        textView_k1_1_tem1=getActivity().findViewById(R.id.k1_1_tem1);
        textView_k1_1_tem2=getActivity().findViewById(R.id.k1_1_tem2);
        textView_k1_1_tem3=getActivity().findViewById(R.id.k1_1_tem3);
        textView_k1_1_tem4=getActivity().findViewById(R.id.k1_1_tem4);
        textView_k1_1_tem5=getActivity().findViewById(R.id.k1_1_tem5);
        textView_k1_1_tem6=getActivity().findViewById(R.id.k1_1_tem6);
        textView_k1_1_time1=getActivity().findViewById(R.id.k1_1_time1);
        textView_k1_1_time2=getActivity().findViewById(R.id.k1_1_time2);
        textView_k1_1_time3=getActivity().findViewById(R.id.k1_1_time3);
        textView_k1_1_time4=getActivity().findViewById(R.id.k1_1_time4);
        textView_k1_1_time5=getActivity().findViewById(R.id.k1_1_time5);
        textView_k1_1_time6=getActivity().findViewById(R.id.k1_1_time6);
        TextView_k1_1_level=getActivity().findViewById(R.id.k1_1_safe_level);
        /***********************一空压二号离心机*******************************/
        textView_k1_2_tem1=getActivity().findViewById(R.id.k1_2_tem1);
        textView_k1_2_tem2=getActivity().findViewById(R.id.k1_2_tem2);
        textView_k1_2_tem3=getActivity().findViewById(R.id.k1_2_tem3);
        textView_k1_2_tem4=getActivity().findViewById(R.id.k1_2_tem4);
        textView_k1_2_tem5=getActivity().findViewById(R.id.k1_2_tem5);
        textView_k1_2_tem6=getActivity().findViewById(R.id.k1_2_tem6);
        textView_k1_2_time1=getActivity().findViewById(R.id.k1_2_time1);
        textView_k1_2_time2=getActivity().findViewById(R.id.k1_2_time2);
        textView_k1_2_time3=getActivity().findViewById(R.id.k1_2_time3);
        textView_k1_2_time4=getActivity().findViewById(R.id.k1_2_time4);
        textView_k1_2_time5=getActivity().findViewById(R.id.k1_2_time5);
        textView_k1_2_time6=getActivity().findViewById(R.id.k1_2_time6);
        TextView_k1_2_level=getActivity().findViewById(R.id.k1_2_safe_level);
        /***********************一空压三号离心机*******************************/
        textView_k1_3_tem1=getActivity().findViewById(R.id.k1_3_tem1);
        textView_k1_3_tem2=getActivity().findViewById(R.id.k1_3_tem2);
        textView_k1_3_tem3=getActivity().findViewById(R.id.k1_3_tem3);
        textView_k1_3_tem4=getActivity().findViewById(R.id.k1_3_tem4);
        textView_k1_3_tem5=getActivity().findViewById(R.id.k1_3_tem5);
        textView_k1_3_tem6=getActivity().findViewById(R.id.k1_3_tem6);
        textView_k1_3_time1=getActivity().findViewById(R.id.k1_3_time1);
        textView_k1_3_time2=getActivity().findViewById(R.id.k1_3_time2);
        textView_k1_3_time3=getActivity().findViewById(R.id.k1_3_time3);
        textView_k1_3_time4=getActivity().findViewById(R.id.k1_3_time4);
        textView_k1_3_time5=getActivity().findViewById(R.id.k1_3_time5);
        textView_k1_3_time6=getActivity().findViewById(R.id.k1_3_time6);
        TextView_k1_3_level=getActivity().findViewById(R.id.k1_3_safe_level);

    }
    //在UI上显示信息
    public void changeViewInfo(String[] data){
        for(int i=0;i<data.length;i++){
            /***一空压***/
            if(i==0){
                textView_k1_1_time1.setText(data[i]);
                textView_k1_1_time2.setText(data[i]);
                textView_k1_1_time3.setText(data[i]);
                textView_k1_1_time4.setText(data[i]);
                textView_k1_1_time5.setText(data[i]);
                textView_k1_1_time6.setText(data[i]);
            }
            if(i==1)textView_k1_1_tem1.setText(data[i]);
            if(i==2)textView_k1_1_tem2.setText(data[i]);
            if(i==3)textView_k1_1_tem3.setText(data[i]);
            if(i==4)textView_k1_1_tem4.setText(data[i]);
            if(i==5)textView_k1_1_tem5.setText(data[i]);
            if(i==6)textView_k1_1_tem6.setText(data[i]);
            /***二空压***/
            if(i==7){
                textView_k1_2_time1.setText(data[i]);
                textView_k1_2_time2.setText(data[i]);
                textView_k1_2_time3.setText(data[i]);
                textView_k1_2_time4.setText(data[i]);
                textView_k1_2_time5.setText(data[i]);
                textView_k1_2_time6.setText(data[i]);
            }
            if(i==8)textView_k1_2_tem1.setText(data[i]);
            if(i==9)textView_k1_2_tem2.setText(data[i]);
            if(i==10)textView_k1_2_tem3.setText(data[i]);
            if(i==11)textView_k1_2_tem4.setText(data[i]);
            if(i==12)textView_k1_2_tem5.setText(data[i]);
            if(i==13)textView_k1_2_tem6.setText(data[i]);
            //三空压
            if(i==14){
                textView_k1_3_time1.setText(data[i]);
                textView_k1_3_time2.setText(data[i]);
                textView_k1_3_time3.setText(data[i]);
                textView_k1_3_time4.setText(data[i]);
                textView_k1_3_time5.setText(data[i]);
                textView_k1_3_time6.setText(data[i]);
            }
            if(i==15)textView_k1_3_tem1.setText(data[i]);
            if(i==16)textView_k1_3_tem2.setText(data[i]);
            if(i==17)textView_k1_3_tem3.setText(data[i]);
            if(i==18)textView_k1_3_tem4.setText(data[i]);
            if(i==19)textView_k1_3_tem5.setText(data[i]);
            if(i==20)textView_k1_3_tem6.setText(data[i]);
            if(i==21){

                /*
                TextView_k1_1_level.setText(data[i]);
                if(data[i].equals("A级"))
                TextView_k1_1_level.setBackground(getResources().getDrawable(R.drawable.shape_cir_safe));
                if(data[i].equals("B级"))
                    TextView_k1_1_level.setBackground(getResources().getDrawable(R.drawable.shape_cir_police));
                if(data[i].equals("S级"))
                    TextView_k1_1_level.setBackground(getResources().getDrawable(R.drawable.shape_cir_high_safe));

           */ }
            if(i==22) {
                /*
                TextView_k1_2_level.setText(data[i]);
                if(data[i].equals("A级"))
                    TextView_k1_2_level.setBackground(getResources().getDrawable(R.drawable.shape_cir_safe));
                if(data[i].equals("B级"))
                    TextView_k1_2_level.setBackground(getResources().getDrawable(R.drawable.shape_cir_police));
                if(data[i].equals("S级"))
                    TextView_k1_2_level.setBackground(getResources().getDrawable(R.drawable.shape_cir_high_safe));
                    }
                 */
                if (i == 23) {
                /*

                TextView_k1_3_level.setText(data[i]);
                if(data[i].equals("A级"))
                    TextView_k1_3_level.setBackground(getResources().getDrawable(R.drawable.shape_cir_safe));
                if(data[i].equals("B级"))
                    TextView_k1_3_level.setBackground(getResources().getDrawable(R.drawable.shape_cir_police));
                if(data[i].equals("S级"))
                    TextView_k1_3_level.setBackground(getResources().getDrawable(R.drawable.shape_cir_high_safe));
                    */
                }

            }   }
    }
}