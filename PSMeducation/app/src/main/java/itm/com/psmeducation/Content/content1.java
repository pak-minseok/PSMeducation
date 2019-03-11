package itm.com.psmeducation.Content;

/**
 * Created by 재훈 on 2015-10-08.
 */
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.parse.ParseUser;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
import itm.com.psmeducation.ScreenViewFlipper1.ScreenViewFlipper1_1;

// array of options --> ArrayAdapter --> ListView

// List view : {views : content1_list_item.xml}

public class content1 extends Activity {

    private ListView lv;

    Boolean[] bookmark=new Boolean[13];//parse에서 IsAnswer 가져오기
    List <Boolean> mList = new ArrayList<Boolean>();

    String[] myItems = {"PSM 12대 실천 과제별 세부 추진사항",
            "공정안전자료의 주기적인 보완 및 체계적인 관리",
            "공정위험성평가 체제 구축 및 사후관리",
            "안전운전절차 보완 및 준수",
            "설비별 위험등급에 다른 효율적인 관리",
            "작업허가절차 준수",
            "협력업체 선정시 안전관리 수준 반영",
            "근로자(임직원)에 대한 실질적인 PSM교육",
            "유해, 위험설비의 가동(시운전)전 안전점검",
            "설비 등 변경시 변경관리절차 준수",
            "객관적인 자체감사 실시 및 사후조치",
            "정확한 사고원인규명 및 재발방지",
            "비상대응 시나리오 작성 및 주기적인 훈련"};
    /// / ArrayList<contents1> contentList;
    //contentAdapter clAdapter;
    Boolean[] onOff = {false, false, false, false, false, false, false, false, false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content1);
/*
        for(int i=0; i<onOff.length; i++)
        {
            bookmark[i]=false;
        }
        */
        lv = (ListView) findViewById(R.id.list1);

        lv.setAdapter(new MyAdapter());
        lv.setOnItemClickListener(mItemClickListener);
    }
    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long l_position) {
            if (position==0) {
                Intent intent = new Intent(content1.this, ScreenActivity1_1.class);
                startActivity(intent);
            } else if (position==1) {
                Intent intent1 = new Intent(content1.this, ScreenActivity1_2.class);
                startActivity(intent1);
            } else if (position==2) {
                Intent intent2 = new Intent(content1.this, ScreenActivity1_3.class);
                startActivity(intent2);
            } else if (position==3) {
                Intent intent3 = new Intent(content1.this, ScreenActivity1_4.class);
                startActivity(intent3);
            } else if (position==4) {
                Intent intent4 = new Intent(content1.this, ScreenActivity1_5.class);
                startActivity(intent4);
            } else if (position==5) {
                Intent intent5 = new Intent(content1.this, ScreenActivity1_6.class);
                startActivity(intent5);
            } else if (position==6) {
                Intent intent6 = new Intent(content1.this, ScreenActivity1_7.class);
                startActivity(intent6);
            } else if (position==7) {
                Intent intent7 = new Intent(content1.this, ScreenActivity1_8.class);
                startActivity(intent7);
            } else if (position==8) {
                Intent intent8 = new Intent(content1.this, ScreenActivity1_9.class);
                startActivity(intent8);
            } else if (position==9) {
                Intent intent9 = new Intent(content1.this, ScreenActivity1_10.class);
                startActivity(intent9);
            } else if (position==10) {
                Intent intent10 = new Intent(content1.this, ScreenActivity1_11.class);
                startActivity(intent10);
            } else if (position==11) {
                Intent intent11 = new Intent(content1.this, ScreenActivity1_12.class);
                startActivity(intent11);
            } else if (position==12) {
                Intent intent12 = new Intent(content1.this, ScreenActivity1_13.class);
                startActivity(intent12);
            }
        }
    };

    public class MyAdapter extends BaseAdapter{
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
                converView = vi.inflate(R.layout.content1_list_item, null);


                holder.text1 = (TextView) converView.findViewById(R.id.titleofcontent1);
                holder.ToggleBut1 = (ToggleButton) converView.findViewById(R.id.toggle1);

                holder.ToggleBut1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        ToggleButton tb = (ToggleButton) v;
                        onOff[position] = true;
          //              bookmark[position] = true;
                    }
                });
                converView.setTag(holder);
            }else{
                holder=(ViewHolder)converView.getTag();
            }

            holder.text1.setText(myItems[position]);
            holder.ToggleBut1.setChecked(onOff[position]);

           /* ParseUser cur_user = ParseUser.getCurrentUser();

            for(int i=0; i<onOff.length; i++) {
                cur_user.add("BookmarkOfContent1", bookmark[i]);
                cur_user.saveEventually();
            }*/
            return converView;
        }
    }
    static class ViewHolder{
        TextView text1;
        ToggleButton ToggleBut1;
    }
}

/*
        displayContentList();
    }
    private void displayContentList(){
        contentList = new ArrayList<contents1>();
        contentList.add(new contents1("PSM 12대 실천 과제별 세부 추진사항")); //3쪽
        contentList.add(new contents1("공정안전자료의 주기적인 보완 및 체계적인 관리")); //4쪽
        contentList.add(new contents1("공정위험성평가 체제 구축 및 사후관리"));//5쪽
        contentList.add(new contents1("안전운전절차 보완 및 준수"));//6쪽
        contentList.add(new contents1("설비별 위험등급에 다른 효율적인 관리"));//7쪽
        contentList.add(new contents1("작업허가절차 준수"));//8쪽
        contentList.add(new contents1("협력업체 선정시 안전관리 수준 반영"));//9쪽
        contentList.add(new contents1("근로자(임직원)에 대한 실질적인 PSM교육"));//10쪽
        contentList.add(new contents1("유해, 위험설비의 가동(시운전)전 안전점검"));//11쪽
        contentList.add(new contents1("설비 등 변경시 변경관리절차 준수"));//12쪽
        contentList.add(new contents1("객관적인 자체감사 실시 및 사후조치"));//13쪽
        contentList.add(new contents1("정확한 사고원인규명 및 재발방지"));//14쪽
        contentList.add(new contents1("비상대응 시나리오 작성 및 주기적인 훈련"));//15쪽

        clAdapter = new contentAdapter(contentList, this);
        lv.setAdapter(clAdapter);
        lv.setOnItemClickListener(listener);
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
                if(value.equals("PSM 12대 실천 과제별 세부 추진사항")) {
                    Intent intent = new Intent(content1.this, ScreenActivity1_1.class);
                    startActivity(intent);
                }
                else if(value.equals("공정안전자료의 주기적인 보완 및 체계적인 관리")) {
                    Intent intent1 = new Intent(content1.this, ScreenActivity1_2.class);
                    startActivity(intent1);
                }
                else if(value.equals("공정위험성평가 체제 구축 및 사후관리")) {
                    Intent intent2 = new Intent(content1.this, ScreenActivity1_3.class);
                    startActivity(intent2);
                }
                else if(value.equals("안전운전절차 보완 및 준수")) {
                    Intent intent3 = new Intent(content1.this, ScreenActivity1_4.class);
                    startActivity(intent3);
                }
                else if(value.equals("설비별 위험등급에 다른 효율적인 관리")) {
                    Intent intent4 = new Intent(content1.this, ScreenActivity1_5.class);
                    startActivity(intent4);
                }
                else if(value.equals("작업허가절차 준수")){
                    Intent intent5 = new Intent(content1.this, ScreenActivity1_6.class);
                    startActivity(intent5);
                }
                else if(value.equals("협력업체 선정시 안전관리 수준 반영")) {
                    Intent intent6 = new Intent(content1.this, ScreenActivity1_7.class);
                    startActivity(intent6);
                }
                else if(value.equals("근로자(임직원)에 대한 실질적인 PSM교육")) {
                    Intent intent7 = new Intent(content1.this, ScreenActivity1_8.class);
                    startActivity(intent7);
                }
                else if(value.equals("유해, 위험설비의 가동(시운전)전 안전점검")) {
                    Intent intent8 = new Intent(content1.this, ScreenActivity1_9.class);
                    startActivity(intent8);
                }
                else if(value.equals("설비 등 변경시 변경관리절차 준수")) {
                    Intent intent9 = new Intent(content1.this, ScreenActivity1_10.class);
                    startActivity(intent9);
                }
                else if(value.equals("객관적인 자체감사 실시 및 사후조치")) {
                    Intent intent10 = new Intent(content1.this, ScreenActivity1_11.class);
                    startActivity(intent10);
                }
                else if(value.equals("정확한 사고원인규명 및 재발방지")) {
                    Intent intent11 = new Intent(content1.this, ScreenActivity1_12.class);
                    startActivity(intent11);
                }
                else if(value.equals("비상대응 시나리오 작성 및 주기적인 훈련")) {
                    Intent intent12 = new Intent(content1.this, ScreenActivity1_13.class);
                    startActivity(intent12);
                }

           }
       };
}
*/


/*public class content1 extends Activity {
    //static final Class[] classArray = new Class[]{ScreenViewFlipper1_1.class, ScreenViewFlipper1_2.class, ScreenViewFlipper1_3.class, ScreenViewFlipper1_4.class, ScreenViewFlipper1_5.class, ScreenViewFlipper1_6.class, ScreenViewFlipper1_7.class, ScreenViewFlipper1_8.class, ScreenViewFlipper1_9.class, ScreenViewFlipper1_10.class, ScreenViewFlipper1_11.class, ScreenViewFlipper1_12.class, ScreenViewFlipper1_13.class};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content1);

        populateListView();
    }

    private void populateListView() {
        // Create list of items

        //m_Adapter.add("PSM 12대 실천 과제별 세부 추진사항"); //3쪽
        //m_Adapter.add("1) 공정안전자료의 주기적인 보완 및 체계적인 관리"); //4쪽
        //m_Adapter.add("2) 공정위험성평가 체제 구축 및 사후관리");//5쪽
        //m_Adapter.add("3) 안전운전절차 보완 및 준수");//6쪽
        //m_Adapter.add("4) 설비별 위험등급에 다른 효율적인 관리");//7쪽
        //m_Adapter.add("5) 작업허가절차 준수");//8쪽
        //m_Adapter.add("6) 협력업체 선정시 안전관리 수준 반영");//9쪽
        //m_Adapter.add("7) 근로자(임직원)에 대한 실질적인 PSM교육");//10쪽
        //m_Adapter.add("8) 유해, 위험설비의 가동(시운전)전 안전점검");//11쪽
        //m_Adapter.add("9) 설비 등 변경시 변경관리절차 준수");//12쪽
        //m_Adapter.add("10) 객관적인 자체감사 실시 및 사후조치");//13쪽
        //m_Adapter.add("11) 정확한 사고원인규명 및 재발방지");//14쪽
        //m_Adapter.add("12) 비상대응 시나리오 작성 및 주기적인 훈련");//15쪽

        String[] myItems = {"PSM 12대 실천 과제별 세부 추진사항",
                "1) 공정안전자료의 주기적인 보완 및 체계적인 관리",
                "2) 공정위험성평가 체제 구축 및 사후관리",
                "3) 안전운전절차 보완 및 준수",
                "4) 설비별 위험등급에 다른 효율적인 관리",
                "5) 작업허가절차 준수",
                "6) 협력업체 선정시 안전관리 수준 반영",
                "7) 근로자(임직원)에 대한 실질적인 PSM교육",
                "8) 유해, 위험설비의 가동(시운전)전 안전점검",
                "9) 설비 등 변경시 변경관리절차 준수",
                "10) 객관적인 자체감사 실시 및 사후조치",
                "11) 정확한 사고원인규명 및 재발방지",
                "12) 비상대응 시나리오 작성 및 주기적인 훈련"};

        // Build Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, // Context for the activity
                R.layout.content1_list_item, // Layout to use(create)
                myItems); // Items to be displayed

        // Configure the list view
        ListView list = (ListView) findViewById(R.id.list1);
        list.setAdapter(adapter);

        list.setOnItemClickListener(listener);
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String value = parent.getItemAtPosition(position).toString();
            if(value.equals("PSM 12대 실천 과제별 세부 추진사항")) {
                Intent intent = new Intent(content1.this, ScreenActivity1_1.class);
                startActivity(intent);
            }
            else if(value.equals("1) 공정안전자료의 주기적인 보완 및 체계적인 관리")) {
                Intent intent1 = new Intent(content1.this, ScreenActivity1_2.class);
                startActivity(intent1);
            }
            else if(value.equals("2) 공정위험성평가 체제 구축 및 사후관리")) {
                Intent intent2 = new Intent(content1.this, ScreenActivity1_3.class);
                startActivity(intent2);
            }
            else if(value.equals("3) 안전운전절차 보완 및 준수")) {
                Intent intent3 = new Intent(content1.this, ScreenActivity1_4.class);
                startActivity(intent3);
            }
            else if(value.equals("4) 설비별 위험등급에 다른 효율적인 관리")) {
                Intent intent4 = new Intent(content1.this, ScreenActivity1_5.class);
                startActivity(intent4);
            }
            else if(value.equals("5) 작업허가절차 준수")){
                Intent intent5 = new Intent(content1.this, ScreenActivity1_6.class);
                startActivity(intent5);
            }
            else if(value.equals("6) 협력업체 선정시 안전관리 수준 반영")) {
                Intent intent6 = new Intent(content1.this, ScreenActivity1_7.class);
                startActivity(intent6);
            }
            else if(value.equals("7) 근로자(임직원)에 대한 실질적인 PSM교육")) {
                Intent intent7 = new Intent(content1.this, ScreenActivity1_8.class);
                startActivity(intent7);
            }
            else if(value.equals("8) 유해, 위험설비의 가동(시운전)전 안전점검")) {
                Intent intent8 = new Intent(content1.this, ScreenActivity1_9.class);
                startActivity(intent8);
            }
            else if(value.equals("9) 설비 등 변경시 변경관리절차 준수")) {
                Intent intent9 = new Intent(content1.this, ScreenActivity1_10.class);
                startActivity(intent9);
            }
            else if(value.equals("10) 객관적인 자체감사 실시 및 사후조치")) {
                Intent intent10 = new Intent(content1.this, ScreenActivity1_11.class);
                startActivity(intent10);
            }
            else if(value.equals("11) 정확한 사고원인규명 및 재발방지")) {
                Intent intent11 = new Intent(content1.this, ScreenActivity1_12.class);
                startActivity(intent11);
            }
            else if(value.equals("12) 비상대응 시나리오 작성 및 주기적인 훈련")) {
                Intent intent12 = new Intent(content1.this, ScreenActivity1_13.class);
                startActivity(intent12);
            }

         }
    };
}
*/