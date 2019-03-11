package itm.com.psmeducation.Problem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import itm.com.psmeducation.R;
import itm.com.psmeducation.Result;

public class Problem1 extends Activity {

    ImageView nextPage;
    Button submit;
    RadioGroup select;
    int count; // 점수 계산 변수
    String answer;


    public int score() {  // 점수 계산 함수 count+5를 리턴해주는게 정답
        select = (RadioGroup) findViewById(R.id.answer);
        InitIsAnswer();
        switch (select.getCheckedRadioButtonId()) {
            case R.id.a1:answer = "false"; updateIsAnswer(answer);
                return count + 0;
            case R.id.b1:answer = "false"; updateIsAnswer(answer);
                return count + 0;
            case R.id.c1:
                answer = "false"; updateIsAnswer(answer);
                return count + 0;
            case R.id.d1:
                answer="true";
                updateIsAnswer(answer);
                return count + 5;

        }
        answer = "false"; updateIsAnswer(answer); return count + 0;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam1);

        nextPage = (ImageView) findViewById(R.id.next);
        nextPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //'오른쪽화살표'누르면 다음 페이지로 넘어감

                Intent intent = new Intent(getApplicationContext(), Problem2.class);
                intent.putExtra("score", score());
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

    public void InitIsAnswer(){
        ParseUser user = ParseUser.getCurrentUser();
        user.remove("IsAnswer");
        user.saveEventually();
     }
}
