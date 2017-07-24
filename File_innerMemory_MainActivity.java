package com.example.kjs.project08_01;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    CalendarView cv;
    EditText edtDiary;
    Button btnWrite;
    String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("간단한 일기장");

        cv = (CalendarView) findViewById(R.id.cv);
        edtDiary = (EditText) findViewById(R.id.edtDiary);
        btnWrite = (Button) findViewById(R.id.btnWrite);

        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                filename = Integer.toString(year) + "_" + Integer.toString(month + 1) + "_" +
                        Integer.toString(dayOfMonth) + ".txt"; //현재 날짜에 해당하는 파일 생성

                String str = readDiary(filename); //현재 날짜의 일기 파일을 읽어들여
                edtDiary.setText(str); //editText에 출력
                btnWrite.setEnabled(true); //버튼 활성화
            }
        });


        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = openFileOutput(filename, Context.MODE_PRIVATE);
                    String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), filename + "이 저장됨", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                }
            }
        });
    }

    public String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inFs;

        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];

            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
            btnWrite.setText("수정하기");
        } catch (IOException e) {
            edtDiary.setHint("일기 없음");
            btnWrite.setText("새로 저장");
        }
        return diaryStr;
    }
}