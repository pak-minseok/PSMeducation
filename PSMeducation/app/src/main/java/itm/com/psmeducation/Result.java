package itm.com.psmeducation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;

public class Result extends Activity implements View.OnClickListener{
    java.util.Calendar cal;
    int minute;
    int count = 0;
    TextView score;
    TextView result;
    Button btn_reset;
    Button btn_note;
    static long c;

    private static CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result1);



        cal = java.util.Calendar.getInstance();
        minute = cal.get(cal.MINUTE);

        btn_reset=(Button)findViewById(R.id.button_reset);
        btn_reset.setOnClickListener(this);

        btn_note=(Button)findViewById(R.id.button2);
        btn_note.setOnClickListener(this);

        timer = new CountDownTimer(1800 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                c = millisUntilFinished;
                if(c<=2000){
                    c=0;
                }
                Log.d("c의 값 :",c+"");
            }

            @Override
            public void onFinish() {

            }
        };

        Intent intent = getIntent();
        int getScore = intent.getIntExtra("score", 0);
        count = count + getScore;

        ParseUser user = ParseUser.getCurrentUser();
        user.put("point", count);
        user.saveEventually();

        score = (TextView) findViewById(R.id.score);
        result = (TextView) findViewById(R.id.result);
        score.setText("점수:" + count + "점");
        if (count >= 90) {
            result.setText("합격");
         } else {
            result.setText("불합격");
            Toast.makeText(Result.this, "재시험은 30분 후부터 가능합니다", Toast.LENGTH_LONG).show();
            timer.start();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button_reset){
                if(c != 0 ){
                    Toast.makeText(Result.this, "30분 후부터 가능합니다 ", Toast.LENGTH_LONG).show();
                }
                else {
                    timer.cancel();
                    Intent i = new Intent(Result.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
        }
        else if(v.getId()==R.id.button2){
            Intent i2= new Intent(Result.this, incorrectnote.class);
            startActivity(i2);
        }
    }

}


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
*/