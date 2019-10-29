package com.example.stust.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_mile;
    private TextView tv_anwswer;
    private Button btn_change;
    private Button btn_leave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_mile = (EditText)findViewById(R.id.et_mile);
        tv_anwswer = (TextView)findViewById(R.id.tv_answer);
        btn_change = (Button)findViewById(R.id.btn_change);
        btn_leave = (Button)findViewById(R.id.btn_leave);

        //按鈕事件外部方法
        btn_change.setOnClickListener(mBtnChange);
        
        //按鈕事件內部方法
        btn_leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("確定了嗎")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });
    }

    private Button.OnClickListener mBtnChange = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            double mile = Double.parseDouble(et_mile.getText().toString());
            double km = mile * 1.6;
            tv_anwswer.setText("時速="+String.valueOf(km)+"公里");
        }
    };
}
