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

public class Problem14 extends Activity{

    ImageView priorPage;
    ImageView nextPage;
    Button submit;
    RadioGroup select;
    int count;
    String answer;



    public int score(){

        select = (RadioGroup)findViewById(R.id.answer14);

        switch (select.getCheckedRadioButtonId()){
            case R.id.a14: answer = "false";updateIsAnswer(answer); return count+0;
            case R.id.b14: answer = "false"; updateIsAnswer(answer); return count+0;
            case R.id.c14: answer = "false"; updateIsAnswer(answer); return count+0;
            case R.id.d14:  answer = "true"; updateIsAnswer(answer); return count+5;

        }
        answer = "false"; updateIsAnswer(answer); return count+0;}

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam14);

        Intent intent = getIntent();
        int getScore = intent.getIntExtra("score", 0);
        count = count+getScore;

        nextPage = (ImageView)findViewById(R.id.next);
        nextPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Problem15.class);
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
