package com.example.kjs.myfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Fragment1 fragment1;
    Fragment2 fragment2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fragment 객체
        fragment1 = (Fragment1)getSupportFragmentManager().findFragmentById(R.id.Fragment1);
        fragment2 = new Fragment2();
    }

    //fragment 교체
    public void onFragmentChanged(int index){
        if(index==0){
            //fragment manager 를 이용하여 현재의 fragment를 교체
            //begin transaction를 이용하여 롤백할 수 있도록한다
            //commit를 호출하여 실행
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
        }else if(index==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
        }
    }
}