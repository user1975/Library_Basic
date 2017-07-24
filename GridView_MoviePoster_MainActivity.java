package com.example.kjs.project11_01;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Integer[] posterID = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gv = (GridView) findViewById(R.id.gridView1);

        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }

    public class MyGridAdapter extends BaseAdapter {

        Context context;

        public MyGridAdapter(Context c) {
            context=c;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //GridView에 출력할 ImaggeView를 생성하여 이미지 출력
            ImageView ivG = new ImageView(context);
            ivG.setLayoutParams(new GridView.LayoutParams(250,300));
            ivG.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ivG.setPadding(5,5,5,5);

            ivG.setImageResource(posterID[position]);

            final int pos = position;
            ivG.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dlgView = View.inflate(MainActivity.this,R.layout.dialog,null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView) dlgView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);

                    dlg.setTitle("영화 포스터");
                    dlg.setIcon(R.mipmap.ic_launcher);
                    dlg.setView(dlgView);
                    dlg.setNegativeButton("닫기",null);
                    dlg.show();
                }
            });

            return ivG;
        }
    }
}