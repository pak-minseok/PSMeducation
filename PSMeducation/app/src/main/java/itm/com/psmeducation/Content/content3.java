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
import itm.com.psmeducation.ScreenActivity3.ScreenActivity3_1;
import itm.com.psmeducation.ScreenActivity3.ScreenActivity3_2;
import itm.com.psmeducation.ScreenActivity3.ScreenActivity3_3;
import itm.com.psmeducation.ScreenActivity3.ScreenActivity3_4;

// array of options --> ArrayAdapter --> ListView

// List view : {views : content1_list_item.xml}
public class content3 extends Activity {

    private ListView lv;


    String[] myItems = {"공정안전관리 개요",
            "공정안전관리 등급",
            "공정안전관리 시행절차서",
            "공정안전보고서 4대항목 12개 요소"};


    boolean[] onOff = new boolean[]{false, false, false, false};

    /// / ArrayList<contents1> contentList;
    //contentAdapter clAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content3);
        lv = (ListView) findViewById(R.id.list3);

        lv.setAdapter(new MyAdapter());
        lv.setOnItemClickListener(mItemClickListener);
    }
    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long l_position) {
            switch (position) {
                case 0:
                    Intent intent = new Intent(content3.this, ScreenActivity3_1.class);
                    startActivity(intent);
                    break;
                case 1:
                    Intent intent1 = new Intent(content3.this, ScreenActivity3_2.class);
                    startActivity(intent1);
                    break;
                case 2:
                    Intent intent2 = new Intent(content3.this, ScreenActivity3_3.class);
                    startActivity(intent2);
                    break;
                case 3:
                    Intent intent3 = new Intent(content3.this, ScreenActivity3_4.class);
                    startActivity(intent3);
                    break;
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
                converView = vi.inflate(R.layout.content3_list_item, null);


                holder.text = (TextView) converView.findViewById(R.id.titleofcontent3);
                holder.ToggleBut = (ToggleButton) converView.findViewById(R.id.toggle3);

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