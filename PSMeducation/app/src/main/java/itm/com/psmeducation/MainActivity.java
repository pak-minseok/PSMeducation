package itm.com.psmeducation;

/**
 * Created by park min seok on 2015-10-10.
 */ import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import itm.com.psmeducation.Problem.Problem1;

/**
 * 초기 선택 버튼들이 들어가 있음
 */
public class MainActivity extends Activity implements View.OnClickListener {

    ImageView list_btn;
    ImageView exam_btn;
    java.util.Calendar cal;
    int hour;
    int getScore;
    long con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hour=cal.get(Calendar.MINUTE);

        list_btn = (ImageButton) findViewById(R.id.ListButton);

        exam_btn = (ImageButton) findViewById(R.id.TestButton);

        list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TabAndListView.class);
                startActivity(intent);
            }
        });

        exam_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(Result.c != 0) {
                    Toast.makeText(MainActivity.this, "재시험은 30분 후부터 가능합니다"+"\n"+ ((Result.c)/1000)/60+"분 남았습니다", Toast.LENGTH_LONG).show();
                }
                else {

                    Intent intent = new Intent(MainActivity.this, Problem1.class);
                    startActivity(intent);
                }
            }
        });
    }

    protected void onStop(){
        super.onStop();
    }


    @Override
    public void onClick(View v) {

    }
}

