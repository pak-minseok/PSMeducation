package itm.com.psmeducation;

/**
 * Created by park min seok on 2015-10-10.
 */import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import itm.com.psmeducation.pasre.MActivity;


public class IntroActivity extends Activity {

    Handler handler_intro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        handler_intro = new Handler();
        handler_intro.postDelayed(run_intro, 3000);

    }
    Runnable run_intro = new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(IntroActivity.this, MActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }
    };
    @Override
    public void onBackPressed(){

    }

}
