package com.example.kjs.ex07_19;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);

        final String[] versionArray = new String[] {"젤리빈","킷캣","롤리팝"};

        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

        dlg.setTitle("사용하고 있는 버전은?");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                button1.setText(versionArray[which]);
            }
        });

        dlg.setPositiveButton("닫기",null);
        dlg.show();
    }
}
