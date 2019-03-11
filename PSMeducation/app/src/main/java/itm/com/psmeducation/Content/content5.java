package itm.com.psmeducation.Content;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import itm.com.psmeducation.R;
import itm.com.psmeducation.ScreenActivity1.ScreenActivity1_12;
import itm.com.psmeducation.ScreenActivity1.ScreenActivity1_13;
import itm.com.psmeducation.ScreenActivity5.ScreenActivity5_1;
import itm.com.psmeducation.ScreenActivity5.ScreenActivity5_10;
import itm.com.psmeducation.ScreenActivity5.ScreenActivity5_11;
import itm.com.psmeducation.ScreenActivity5.ScreenActivity5_12;
import itm.com.psmeducation.ScreenActivity5.ScreenActivity5_13;
import itm.com.psmeducation.ScreenActivity5.ScreenActivity5_14;
import itm.com.psmeducation.ScreenActivity5.ScreenActivity5_15;
import itm.com.psmeducation.ScreenActivity5.ScreenActivity5_2;
import itm.com.psmeducation.ScreenActivity5.ScreenActivity5_3;
import itm.com.psmeducation.ScreenActivity5.ScreenActivity5_4;
import itm.com.psmeducation.ScreenActivity5.ScreenActivity5_5;
import itm.com.psmeducation.ScreenActivity5.ScreenActivity5_6;
import itm.com.psmeducation.ScreenActivity5.ScreenActivity5_7;
import itm.com.psmeducation.ScreenActivity5.ScreenActivity5_8;
import itm.com.psmeducation.ScreenActivity5.ScreenActivity5_9;

// array of options --> ArrayAdapter --> ListView

// List view : {views : content1_list_item.xml}


public class content5 extends Activity {

    private ListView lv;

    String[] myItems = {"업무수행시 공정안전자료는 무엇이며, 어떻게 활용하고 있는가?",
            "공정안전보고서 등에 규정된 안전운전절차를 정확하게 숙지하고 있는가?",
            "공정 또는 설비가 변경된 경우 변경사항에 대한 교육을 받는가?",
            "자체감사 결과를 설명 받았는가?",
            "사업장내 공정사고에 대하여 알고있는가?",
            "작업장에서 발생할 수 있는 사고에 대처하는 방법에 대하여 알고 있는가?",
            "비상사태 발생시 대피경로에 대하여 알고 있는가?",
            "안전작업 허가는 무엇인가?",
            "PSM(공정안전보고서)의 정의는 무엇인가?",
            "국내의 중대산업사고의 예를 들어보라",
            "PSM 대상 사업장의 차등관리제도란 무엇인가?",
            "비상사태 발생시 취할 조치에 대하여 알고 있는가?",
            "용접작업시 안전조치사항 및 안전작업허가 절차에 대해 알고 있는가?",
            "밀폐공간 출입시 안전조치사항 및 안전작업허가 절차에 대해 알고 있는가?",
            "방폭지역을 알고 있는가?"};

    boolean[] onOff = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

    /// / ArrayList<contents1> contentList;
    //contentAdapter clAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content5);
        lv = (ListView) findViewById(R.id.list5);

        lv.setAdapter(new MyAdapter());
        lv.setOnItemClickListener(mItemClickListener);
    }
    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long l_position) {
            switch (position){
                case 0: Intent intent = new Intent(content5.this, ScreenActivity5_1.class);
                    startActivity(intent); break;
                case 1: Intent intent1 = new Intent(content5.this, ScreenActivity5_2.class);
                    startActivity(intent1); break;
                case 2: Intent intent2 = new Intent(content5.this, ScreenActivity5_3.class);
                    startActivity(intent2); break;
                case 3: Intent intent3 = new Intent(content5.this, ScreenActivity5_4.class);
                    startActivity(intent3); break;
                case 4: Intent intent4 = new Intent(content5.this, ScreenActivity5_5.class);
                    startActivity(intent4); break;
                case 5: Intent intent5 = new Intent(content5.this, ScreenActivity5_6.class);
                    startActivity(intent5); break;
                case 6: Intent intent6 = new Intent(content5.this, ScreenActivity5_7.class);
                    startActivity(intent6); break;
                case 7: Intent intent7 = new Intent(content5.this, ScreenActivity5_8.class);
                    startActivity(intent7); break;
                case 8: Intent intent8 = new Intent(content5.this, ScreenActivity5_9.class);
                    startActivity(intent8); break;
                case 9: Intent intent9 = new Intent(content5.this, ScreenActivity5_10.class);
                    startActivity(intent9); break;
                case 10: Intent intent10 = new Intent(content5.this, ScreenActivity5_11.class);
                    startActivity(intent10); break;
                case 11: Intent intent11 = new Intent(content5.this, ScreenActivity5_12.class);
                    startActivity(intent11); break;
                case 12: Intent intent12 = new Intent(content5.this, ScreenActivity5_13.class);
                    startActivity(intent12); break;
                case 13: Intent intent13 = new Intent(content5.this, ScreenActivity5_14.class);
                    startActivity(intent13); break;
                case 14: Intent intent14 = new Intent(content5.this, ScreenActivity5_15.class);
                    startActivity(intent14); break;

            }
        }
    };
    public class MyAdapter extends BaseAdapter {
        public int getCount(){
            return myItems.length;
        }

        public Object getItem(int position){
            return position;
        }

        public long getItemId(int position){
            return position;
        }

        public int getViewTypeCount(){
            return myItems.length;
        }

        public View getView(final int position, View converView, ViewGroup parent){

            ViewHolder holder;

            if(converView==null) {
                holder = new ViewHolder();


                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                converView = vi.inflate(R.layout.content5_list_item, null);


                holder.text = (TextView) converView.findViewById(R.id.titleofcontent5);
                holder.ToggleBut = (ToggleButton) converView.findViewById(R.id.toggle5);

                holder.ToggleBut.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        ToggleButton tb = (ToggleButton) v;
                        onOff[position] = true;
                    }
                });
                converView.setTag(holder);
            }else{
                holder=(ViewHolder)converView.getTag();
            }

            holder.text.setText(myItems[position]);
            holder.ToggleBut.setChecked(onOff[position]);

            return converView;
        }
    }
    static class ViewHolder{
        TextView text;
        ToggleButton ToggleBut;
    }
}



