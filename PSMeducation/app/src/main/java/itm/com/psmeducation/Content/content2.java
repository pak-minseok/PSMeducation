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
import itm.com.psmeducation.ScreenActivity1.ScreenActivity1_1;
import itm.com.psmeducation.ScreenActivity1.ScreenActivity1_10;
import itm.com.psmeducation.ScreenActivity1.ScreenActivity1_11;
import itm.com.psmeducation.ScreenActivity1.ScreenActivity1_12;
import itm.com.psmeducation.ScreenActivity1.ScreenActivity1_13;
import itm.com.psmeducation.ScreenActivity1.ScreenActivity1_2;
import itm.com.psmeducation.ScreenActivity1.ScreenActivity1_3;
import itm.com.psmeducation.ScreenActivity1.ScreenActivity1_4;
import itm.com.psmeducation.ScreenActivity1.ScreenActivity1_5;
import itm.com.psmeducation.ScreenActivity1.ScreenActivity1_6;
import itm.com.psmeducation.ScreenActivity1.ScreenActivity1_7;
import itm.com.psmeducation.ScreenActivity1.ScreenActivity1_8;
import itm.com.psmeducation.ScreenActivity1.ScreenActivity1_9;
import itm.com.psmeducation.ScreenActivity2.ScreenActivity2_1;
import itm.com.psmeducation.ScreenActivity2.ScreenActivity2_2;
import itm.com.psmeducation.ScreenActivity2.ScreenActivity2_3;
import itm.com.psmeducation.ScreenActivity2.ScreenActivity2_4;
import itm.com.psmeducation.ScreenActivity2.ScreenActivity2_5;

// array of options --> ArrayAdapter --> ListView

// List view : {views : content1_list_item.xml}

public class content2 extends Activity {

    private ListView lv;

    String[] myItems = {"개요",
            "공정안전관리 도입 배경",
            "법적근거",
            "공정안전 보고서 제출대상",
            "유해 위험물질 규정 수량"};

    boolean[] onOff = new boolean[]{false, false, false, false, false};

    /// / ArrayList<contents1> contentList;
    //contentAdapter clAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content2);
        lv = (ListView) findViewById(R.id.list2);

        lv.setAdapter(new MyAdapter());
        lv.setOnItemClickListener(mItemClickListener);
    }
    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long l_position) {
            if(position==0) {
                Intent intent = new Intent(content2.this, ScreenActivity2_1.class);
                startActivity(intent);
            }
            else if(position==1) {
                Intent intent1 = new Intent(content2.this, ScreenActivity2_2.class);
                startActivity(intent1);
            }
            else if(position==2) {
                Intent intent2 = new Intent(content2.this, ScreenActivity2_3.class);
                startActivity(intent2);
            }
            else if(position==3) {
                Intent intent3 = new Intent(content2.this, ScreenActivity2_4.class);
                startActivity(intent3);
            }
            else if(position==4) {
                Intent intent4 = new Intent(content2.this, ScreenActivity2_5.class);
                startActivity(intent4);
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
                converView = vi.inflate(R.layout.content2_list_item, null);


                holder.text = (TextView) converView.findViewById(R.id.titleofcontent2);
                holder.ToggleBut = (ToggleButton) converView.findViewById(R.id.toggle2);

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

