package com.example.stust.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private ListView list_text;
    private TextView tv_title;
    private Button btn_show;

    String[] balls = new String[] {"棒球", "籃球", "桌球"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_text = (ListView)findViewById(R.id.list_text);
        tv_title = (TextView)findViewById(R.id.tv_data);
        btn_show = (Button)findViewById(R.id.btn_show);

        // 將 ListView 改為多選
        ArrayAdapter<String> adapterBalls = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, balls);
        list_text.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list_text.setAdapter(adapterBalls);

        list_text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               setTitle("目前選取..." + balls[position]);
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
