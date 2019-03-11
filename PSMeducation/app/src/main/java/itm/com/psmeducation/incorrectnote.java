package itm.com.psmeducation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by park min seok on 2015-11-09.
 */
public class incorrectnote extends AppCompatActivity {
    TextView note;
    int tmpID;//for 문을 이용하여 한 번에 하기 위해 string의 이름들을 숫자외에 통일하고 이를 위해 ID값을 가져옴.
    String str;//strings 에서 오답노트 글 가져오기
    String[] answer;//parse에서 IsAnswer 가져오기
    List <String> mList = new ArrayList<String>();
    Button backtomain;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incorrectnote);

        backtomain = (Button) findViewById(R.id.backtomain);
        backtomain.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent intent = new Intent(incorrectnote.this, MainActivity.class);
                                              startActivity(intent);
                                              finish();
                                          }
                                      });
        note = (TextView) findViewById(R.id.note);
        note.setText("");
        ParseUser cur_user = ParseUser.getCurrentUser();
        mList = cur_user.getList("IsAnswer");
        answer = mList.toArray(new String[mList.size()]);
        /*ParseQuery<ParseObject> query = ParseQuery.getQuery("IsAnswer");
        query.getInBackground(cur_user.getObjectId(), new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseObject, ParseException e) {
                if (e == null) {
                    mList = parseObject.getList("IsAnswer");
                    answer = mList.toArray(new String[mList.size()]);
                }
            }
        });
        */
        for(int i=0; i<20; i++) {
            if(answer[i].equals("false")) {
                tmpID = getResources().getIdentifier("pro" + i, "string", "itm.com.psmeducation");
                str = getResources().getString(tmpID);
                note.append(str + "\n");
            }
        }
    }
}