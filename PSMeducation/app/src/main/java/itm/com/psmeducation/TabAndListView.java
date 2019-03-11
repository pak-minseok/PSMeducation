package itm.com.psmeducation;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabAndListView extends TabActivity {
    private TabHost mTabHost;

    // TabSpec Names
    private static final String CONTENT1_SPEC = "content1"; //1챕터 PSM 12대 과제 탭
    private static final String CONTENT2_SPEC = "content2"; //2챕처 PSM 제도 탭
    private static final String CONTENT3_SPEC = "content3"; //3챕터 PSM이란 탭
    private static final String CONTENT4_SPEC = "content4"; //4챕터 공정안전관리 보고서 내용
    private static final String CONTENT5_SPEC = "content5"; //5챕터 공정안전보고서 이해사항 질문

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        mTabHost = getTabHost();
        DialogUtil.timeThread(this); //로딩메시지

        // 첫번째 탭
        TabSpec content1 = mTabHost.newTabSpec(CONTENT1_SPEC);
        // Tab Icon
        content1.setIndicator("1.PSM 12대 과제");
        Intent content1_Intent = new Intent(this, itm.com.psmeducation.Content.content1.class);
        // Tab Content
        content1.setContent(content1_Intent);

        // 두번째 탭
        TabSpec content2 = mTabHost.newTabSpec(CONTENT2_SPEC);
        content2.setIndicator("2.PSM 제도");
        Intent content2_Intent = new Intent(this, itm.com.psmeducation.Content.content2.class);
        content2.setContent(content2_Intent);

        // 세번째 탭
        TabSpec content3 = mTabHost.newTabSpec(CONTENT3_SPEC);
        content3.setIndicator("3.PSM 란?");
        Intent content3_Intent = new Intent(this, itm.com.psmeducation.Content.content3.class);
        content3.setContent(content3_Intent);

        // 4번째 탭
        TabSpec content4 = mTabHost.newTabSpec(CONTENT4_SPEC);
        content4.setIndicator("4.공정안전관리 보고서 내용");
        Intent content4_Intent = new Intent(this, itm.com.psmeducation.Content.content4.class);
        content4.setContent(content4_Intent);

        TabSpec content5 = mTabHost.newTabSpec(CONTENT5_SPEC);
        content5.setIndicator("5.공정안전보고서 이해사항 질문");
        Intent content5_Intent = new Intent(this, itm.com.psmeducation.Content.content5.class);
        content5.setContent(content5_Intent);

        // Adding all TabSpec to TabHost
        mTabHost.addTab(content1); // 첫번째 탭 추가
        mTabHost.addTab(content2); // 두번째 탭 추가
        mTabHost.addTab(content3); // 세번째 탭 추가
        mTabHost.addTab(content4); // 네번째 탭 추가
        mTabHost.addTab(content5); // 다섯번째 탭 추가
    }
}