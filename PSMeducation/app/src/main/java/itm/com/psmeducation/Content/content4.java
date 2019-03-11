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
import itm.com.psmeducation.ScreenActivity4.ScreenActivity4_1;
import itm.com.psmeducation.ScreenActivity4.ScreenActivity4_10;
import itm.com.psmeducation.ScreenActivity4.ScreenActivity4_11;
import itm.com.psmeducation.ScreenActivity4.ScreenActivity4_12;
import itm.com.psmeducation.ScreenActivity4.ScreenActivity4_2;
import itm.com.psmeducation.ScreenActivity4.ScreenActivity4_3;
import itm.com.psmeducation.ScreenActivity4.ScreenActivity4_4;
import itm.com.psmeducation.ScreenActivity4.ScreenActivity4_5;
import itm.com.psmeducation.ScreenActivity4.ScreenActivity4_6;
import itm.com.psmeducation.ScreenActivity4.ScreenActivity4_7;
import itm.com.psmeducation.ScreenActivity4.ScreenActivity4_8;
import itm.com.psmeducation.ScreenActivity4.ScreenActivity4_9;

// array of options --> ArrayAdapter --> ListView

// List view : {views : content1_list_item.xml}


public class content4 extends Activity {

    private ListView lv;

    String[] myItems = {"공정안전 자료",
            "위험성 평가",
            "안전운전지침서",
            "설비점검, 검사, 유지 보수 계획",
            "안전작업허가",
            "도급업체 안전관리 계획",
            "교육 계획",
            "가동전 점검사항",
            "변경요소 관리 계획",
            "자체감사",
            "공정사고 조사",
            "비상대피계획"};

    boolean[] onOff = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false};

    /// / ArrayList<contents1> contentList;
    //contentAdapter clAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content4);
        lv = (ListView) findViewById(R.id.list4);

        lv.setAdapter(new MyAdapter());
        lv.setOnItemClickListener(mItemClickListener);
    }
    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long l_position) {
            switch (position){
                case 0: Intent intent = new Intent(content4.this, ScreenActivity4_1.class);
                    startActivity(intent); break;
                case 1: Intent intent1 = new Intent(content4.this, ScreenActivity4_2.class);
                    startActivity(intent1); break;
                case 2: Intent intent2 = new Intent(content4.this, ScreenActivity4_3.class);
                    startActivity(intent2); break;
                case 3: Intent intent3 = new Intent(content4.this, ScreenActivity4_4.class);
                    startActivity(intent3); break;
                case 4: Intent intent4 = new Intent(content4.this, ScreenActivity4_5.class);
                    startActivity(intent4); break;
                case 5: Intent intent5 = new Intent(content4.this, ScreenActivity4_6.class);
                    startActivity(intent5); break;
                case 6: Intent intent6 = new Intent(content4.this, ScreenActivity4_7.class);
                    startActivity(intent6); break;
                case 7: Intent intent7 = new Intent(content4.this, ScreenActivity4_8.class);
                    startActivity(intent7); break;
                case 8: Intent intent8 = new Intent(content4.this, ScreenActivity4_9.class);
                    startActivity(intent8); break;
                case 9: Intent intent9 = new Intent(content4.this, ScreenActivity4_10.class);
                    startActivity(intent9); break;
                case 10: Intent intent10 = new Intent(content4.this, ScreenActivity4_11.class);
                    startActivity(intent10); break;
                case 11: Intent intent11 = new Intent(content4.this, ScreenActivity4_12.class);
                    startActivity(intent11); break;

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
                converView = vi.inflate(R.layout.content4_list_item, null);


                holder.text = (TextView) converView.findViewById(R.id.titleofcontent4);
                holder.ToggleBut = (ToggleButton) converView.findViewById(R.id.toggle4);

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
