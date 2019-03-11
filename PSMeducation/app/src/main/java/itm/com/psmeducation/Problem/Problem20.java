package itm.com.psmeducation.Problem;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.Calendar;

import itm.com.psmeducation.R;
import itm.com.psmeducation.Result;

public class Problem20 extends Activity{

    Calendar c;
    ImageView priorPage;
    ImageView nextPage;
    Button submit;
    RadioGroup select;
    int count;
    String answer;
    int curMonth, curDay;

    public int score(){

        select = (RadioGroup)findViewById(R.id.answer20);
        switch (select.getCheckedRadioButtonId()){
            case R.id.a20:  answer = "true"; updateIsAnswer(answer); return count+5;
            case R.id.b20: answer = "false"; updateIsAnswer(answer);
                return count+0;
            case R.id.c20: answer = "false"; updateIsAnswer(answer); return count+0;
            case R.id.d20: answer = "false"; updateIsAnswer(answer); return count+0;

        }
        answer = "false"; updateIsAnswer(answer); return count+0;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam20);

        Intent intent = getIntent();
        int getScore = intent.getIntExtra("score", 0);
        count = count+getScore;

        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Result.class);
                intent.putExtra("score", score());
                updateScore(score());
                startActivity(intent);
                finish();
            }
        });
    }

    public void updateIsAnswer(String answer){
        ParseUser user = ParseUser.getCurrentUser();
        user.add("IsAnswer", answer);
        user.saveEventually();
    }

    public void updateScore(int score)
    {
        ParseUser user = ParseUser.getCurrentUser();
        c = Calendar.getInstance();
        curMonth = c.get(Calendar.MONTH)+1;
        curDay = c.get(Calendar.DAY_OF_MONTH);
        ParseObject p = new ParseObject("Data");
        p.put("point", score);
        p.put("Month", curMonth);
        p.put("Day", curDay);
        p.put("username",user.getUsername());
        p.saveInBackground();
    }
}
