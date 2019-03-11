package itm.com.psmeducation;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.handstudio.android.hzgrapherlib.animation.GraphAnimation;
import com.handstudio.android.hzgrapherlib.graphview.LineGraphView;
import com.handstudio.android.hzgrapherlib.graphview.RadarGraphView;
import com.handstudio.android.hzgrapherlib.vo.GraphNameBox;
import com.handstudio.android.hzgrapherlib.vo.linegraph.LineGraph;
import com.handstudio.android.hzgrapherlib.vo.linegraph.LineGraphVO;
import com.handstudio.android.hzgrapherlib.vo.radargraph.RadarGraph;
import com.handstudio.android.hzgrapherlib.vo.radargraph.RadarGraphVO;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
/**
 * Created by park min seok on 2015-11-08.
 */
public class ShowResult extends Activity {
    int userscore;
    String username;

    int curMonth, curDay;
    Calendar c;

    TextView todaychew;
    TextView evaluation;


    private ViewGroup layoutGraphView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showresult);
        //hour=cal.get(Calendar.MINUTE);

        Intent i = getIntent();

        username = i.getStringExtra("uname");
        TextView user = (TextView) findViewById(R.id.Username);
        user.setText(username+" 사원 정보");
        userscore = i.getIntExtra("userscore", 0);
        TextView score = (TextView) findViewById(R.id.ScoreOfUser);
        score.setText("최근 시험 점수: "+ userscore+"점");
        TextView ispass = (TextView) findViewById(R.id.ResultOfUser);

        if(userscore>=90){
            ispass.setText("합격");
        }
        else{
            ispass.setText("불합격");
        }
        layoutGraphView = (ViewGroup) findViewById(R.id.layoutGraphView);
        setLineGraph();

    }
    private void setLineGraph() {
        //all setting //loading 시 그림
        LineGraphVO vo = makeLineGraphAllSetting();

        //default setting -> 미리 그려놓음
        //LineGraphVO vo = makeLineGraphDefaultSetting();

        layoutGraphView.addView(new LineGraphView(this, vo));
    }
    private LineGraphVO makeLineGraphAllSetting() {
        //BASIC LAYOUT SETTING
        //padding
        int paddingBottom 	= LineGraphVO.DEFAULT_PADDING;
        int paddingTop 		= LineGraphVO.DEFAULT_PADDING;
        int paddingLeft 	= LineGraphVO.DEFAULT_PADDING;
        int paddingRight 	= LineGraphVO.DEFAULT_PADDING;

        //graph margin
        int marginTop 		= LineGraphVO.DEFAULT_MARGIN_TOP;
        int marginRight 	= LineGraphVO.DEFAULT_MARGIN_RIGHT;

        //max value
        int maxValue 		= 100;

        //increment
        int increment 		= 10;

        //GRAPH SETTING
        c = Calendar.getInstance();
        curMonth = c.get(Calendar.MONTH)+1;
        curDay = c.get(Calendar.DAY_OF_MONTH);

        int[] tc= new int[7];
        for(int i=0; i<tc.length; i++)
        {
            tc[i] = pointvalue(curMonth, curDay - i, i);
        }

        String[] legendArr 	= {calanderset(curMonth, curDay-6), calanderset(curMonth, curDay-5),calanderset(curMonth, curDay-4),calanderset(curMonth, curDay-3),calanderset(curMonth, curDay-2),calanderset(curMonth, curDay-1), calanderset(curMonth, curDay)}; //씹는 타임 count
        float[] graph3 		= {tc[6], tc[5],tc[4],tc[3], tc[2],tc[1], tc[0]};


        List<LineGraph> arrGraph = new ArrayList<LineGraph>();

        arrGraph.add(new LineGraph("점수", 0xaaff0066, graph3));

        LineGraphVO vo = new LineGraphVO(
                paddingBottom, paddingTop, paddingLeft, paddingRight,
                marginTop, marginRight, maxValue, increment, legendArr, arrGraph);

        //set animation
        vo.setAnimation(new GraphAnimation(GraphAnimation.LINEAR_ANIMATION, GraphAnimation.DEFAULT_DURATION));
        //set graph name box
        vo.setGraphNameBox(new GraphNameBox());
        //set draw graph region
//		vo.setDrawRegion(true);

        //use icon
//		arrGraph.add(new Graph(0xaa66ff33, graph1, R.drawable.icon1));
//		arrGraph.add(new Graph(0xaa00ffff, graph2, R.drawable.icon2));
//		arrGraph.add(new Graph(0xaaff0066, graph3, R.drawable.icon3));

//		LineGraphVO vo = new LineGraphVO(
//				paddingBottom, paddingTop, paddingLeft, paddingRight,
//				marginTop, marginRight, maxValue, increment, legendArr, arrGraph, R.drawable.bg);
        return vo;
    }
    public String calanderset(int month, int day){
        switch (day) {
            case 0:month --;
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    day = 31;
                } else if (month == 2) {
                    day = 28;
                } else day = 30; break;
            case -1:month --;
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    day = 30;
                } else if (month == 2) {
                    day = 27;
                } else day = 29;break;
            case -2:month --;
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    day = 29;
                } else if (month == 2) {
                    day = 26;
                } else day = 28; break;
            case -3:month --;
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    day = 28;
                } else if (month == 2) {
                    day = 25;
                } else day = 27; break;
            case -4:month --;
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    day = 27;
                } else if (month == 2) {
                    day = 24;
                } else day = 26; break;
            case -5:month --;
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    day = 26;
                } else if (month == 2) {
                    day = 23;
                } else day = 25; break;
            case -6:month --;
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    day = 25;
                } else if (month == 2) {
                    day = 22;
                } else day = 24; break;
            default:break;
        }
        return (String.valueOf(month)+"월 "+String.valueOf(day)+"일");
    }

    int point;
    public int pointvalue(int month, int day, final int position) {
        switch (day) {
            case 0:month --;
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    day = 31;
                } else if (month == 2) {
                    day = 28;
                } else day = 30; break;
            case -1:month --;
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    day = 30;
                } else if (month == 2) {
                    day = 27;
                } else day = 29;break;
            case -2:month --;
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    day = 29;
                } else if (month == 2) {
                    day = 26;
                } else day = 28; break;
            case -3:month --;
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    day = 28;
                } else if (month == 2) {
                    day = 25;
                } else day = 27; break;
            case -4:month --;
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    day = 27;
                } else if (month == 2) {
                    day = 24;
                } else day = 26; break;
            case -5:month --;
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    day = 26;
                } else if (month == 2) {
                    day = 23;
                } else day = 25; break;
            case -6:month --;
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    day = 25;
                } else if (month == 2) {
                    day = 22;
                } else day = 24; break;
            default:break;
        }
        ParseUser cu = ParseUser.getCurrentUser();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Data");
        query.whereEqualTo("username", username);
        query.whereEqualTo("Month", month);
        query.whereEqualTo("Day", day);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> data, ParseException e) {
                if (data.isEmpty() == false) {
                    ParseUser pu = ParseUser.getCurrentUser();
                    if (pu.getInt("point" + String.valueOf(position)) != 0) {
                        pu.remove("point" + String.valueOf(position));
                        pu.saveEventually();
                    }
                    point = data.get(0).getInt("point");
                    pu.put("point" + String.valueOf(position), point);
                    pu.saveInBackground();
                } else {
                    point = 0;
                    ParseUser pu = ParseUser.getCurrentUser();
                    pu.put("point" + String.valueOf(position), point);
                    pu.saveInBackground();
                }
            }
        });
        ParseUser pu = ParseUser.getCurrentUser();
        return pu.getInt("point"+String.valueOf(position));
    }

}