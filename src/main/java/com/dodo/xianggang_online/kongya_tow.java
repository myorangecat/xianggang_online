package com.dodo.xianggang_online;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.StringTokenizer;

public class kongya_tow extends Fragment implements View.OnClickListener {
    public   View textView1,textView2,textView3;
    Fragment  f=null;
    private String search_data;
    private String[] data_array=new String[7];
    Bundle bundle=new Bundle();
    @Override
    public void onSaveInstanceState(Bundle outState) {
        //不保存之前的fragment的状态
        super.onSaveInstanceState(outState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.activity_kongya_tow,null);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView1=getActivity().findViewById(R.id.button_k2_one);
        textView3=getActivity().findViewById(R.id.button_k2_three);
        textView1.setOnClickListener(this);
        textView3.setOnClickListener(this);
        ///////////////////////////////////////////////
        Bundle bundle = this.getArguments();//得到从Activity传来的数据
        if (bundle != null) {
            search_data = bundle.getString("search");
        }
        System.out.println("收到信息:"+search_data);

        StringTokenizer st=new StringTokenizer(search_data,"@");
        System.out.println("总共有"+st.countTokens()+"个数据");
        for(int i=0;i<7;i++){
            data_array[i]=st.nextToken();
            System.out.println(data_array[i]);
        }
    }
    @Override
    public void onClick(View view){
        FragmentManager manager=getFragmentManager();        //获取到Franger管理
        FragmentTransaction fragmentTransaction=manager.beginTransaction();
        bundle.putString("search",search_data);
        //f.isHidden();
        switch (view.getId()){
            case R.id.button_k2_one:
                f=new one();
                f.setArguments(bundle);
                break;
            case R.id.button_k2_three:
                f=new kongya_three();
                f.setArguments(bundle);
                break;
        }
        fragmentTransaction.replace(R.id.fragment,f);
        fragmentTransaction.commit();
    }
}