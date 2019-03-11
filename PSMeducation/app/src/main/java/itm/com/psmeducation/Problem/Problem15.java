package itm.com.psmeducation.Problem;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.parse.ParseUser;

import itm.com.psmeducation.R;
import itm.com.psmeducation.Result;

public class Problem15 extends Activity{

    ImageView priorPage;
    ImageView nextPage;
    Button submit;
    RadioGroup select;
    int count;
    String answer;



    public int score(){

        select = (RadioGroup)findViewById(R.id.answer15);
        switch (select.getCheckedRadioButtonId()){
            case R.id.a15: answer = "true"; updateIsAnswer(answer); return count+5;
            case R.id.b15:answer = "false"; updateIsAnswer(answer);return count+0;
            case R.id.c15:answer = "false"; updateIsAnswer(answer); return count+0;
            case R.id.d15:answer = "false"; updateIsAnswer(answer); return count+0;

        }
        answer = "false"; updateIsAnswer(answer); return count+0;}

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam15);

        Intent intent = getIntent();
        int getScore = intent.getIntExtra("score", 0);
        count = count+getScore;

        nextPage = (ImageView)findViewById(R.id.next);
        nextPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Problem16.class);
                intent.putExtra("score",score());
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
}
