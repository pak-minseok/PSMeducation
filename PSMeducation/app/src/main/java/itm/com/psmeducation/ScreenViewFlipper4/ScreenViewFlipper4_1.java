package itm.com.psmeducation.ScreenViewFlipper4;

import itm.com.psmeducation.R;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

/**
 * ScreenView Flipper
 *
 * @author Mike
 */
public class ScreenViewFlipper4_1 extends LinearLayout implements OnTouchListener {

	/**
	 * Count of index buttons. Default is 3
	 */
	public static int countIndexes = 3;

	/**
	 * Button Layout
	 */
	LinearLayout buttonLayout;

	/**
	 * Index button images
	 */
	ImageView[] indexButtons;

	/**
	 * Views for the Flipper
	 */
	View[] views;

	/**
	 * Flipper instance
	 */
    ViewFlipper flipper;

    /**
     * X coordinate for touch down
     */
    float downX;

    /**
     * X coordinate for touch up
     */
    float upX;

    /**
     * Current index
     */
    int currentIndex = 0;


	public ScreenViewFlipper4_1(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper4_1(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		init(context);
	}

    /**
     * Initialize
     *
     * @param context
     */
	public void init(Context context) {
		setBackgroundColor(0x00000000);

		// Layout inflation
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.screenview4_1, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout4_1);
		flipper = (ViewFlipper) findViewById(R.id.flipper4_1);
		flipper.setOnTouchListener(this);


		LayoutParams params = new LayoutParams(
				LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		params.leftMargin = 50;

		indexButtons = new ImageView[countIndexes];
		views = new TextView[countIndexes];
		for(int i = 0; i < countIndexes; i++) {
			indexButtons[i] = new ImageView(context);

			if (i == currentIndex) {
				indexButtons[i].setImageResource(R.drawable.green);
			} else {
				indexButtons[i].setImageResource(R.drawable.white);
			}

			indexButtons[i].setPadding(10, 10, 10, 10);
			buttonLayout.addView(indexButtons[i], params);

			TextView curView = new TextView(context);
			switch (i) {
				case 0 : curView.setText("■개요\n" +
						"●유해, 위험물질, 동력기계, 설비사항을 체계적으로 목록화 문서화하여 위험성 평가의 수행 시 기초자료로 활용\n"); break;
				case 1 : curView.setText("■내용\n" +
						"●유해 위험물질 목록, 유해 위험물질 MSDS자료\n" +
						"\n" +
						"●유해 위험설비의 목록 및 사양\n" +
						"위해 위험설비 중 동력기계 목록 및 유해 위험설비의 장치/설비사양, 배관 및 가스킷 사양, 안전밸브 및 파열판 사양\n" +
						"\n" +
						"●공정도면\n" +
						"공정개요(공정설명서), 공정흐름도, 공정배관, 계장도(P&ID), 유틸리티 계통도 및 배관 계장도의 목록\n" +
						"\n" +
						"●건물 설비의 배치도\n" +
						"각종 건물의 설비배치도, 건물내부에서의 설비배치도, 건축물의 평명도 및 입면도, 철구조물의 내화구조사양, 가연성가스 누설탐지설비배치도, 안전보호설비(보호구) 설치현황\n" +
						"●방폭지역 구분도 및 전기단선도\n" +
						"※방폭지역구분도 : 화재폭발 우려가 있는 장소의 방폭 전기/기계·기구 선정기준 및 구분도\n" +
						"※전기단선도 : 수전설비의 책임분계점부터 저압 변압기의 2차측(부하설비 1차측)까지의 단선도\n" +
						"※접지계획 및 배치도 : 접지의 목적, 규격, 적용범위, 접지방법, 접지종류 및 배치도(접지극의 위치, 접지선 종류와 굵기)\n" +
						"\n" +
						"●안전설계 제작 및 설치 관련지침서\n" +
						"유해 위험설비에 대해 안전설계 제작 및 설치 등에 관한 설계 제작 설치 관련 코드 및 기준\n" +
						"\n" +
						"●기타자료(환경오염물질의 수지, 처리방법 및 최종 배출농도 등)\n" +
						"환경오염물질이 발생되는 설비의 오염물질의 수지, 처리방법 및 최종배출농도 등의 사항\n"); break;
				case 2 : curView.setText("■업무추진사항\n" +
						"\n" +
						"1.실천과제 :\n" +
						"\n" +
						"공정 안전자료의 주기적인 보완 및 체계적 관리\n" +
						"\n" +
						"2.세부추진사항 :\n" +
						"공정 안전자료의 주기적인 보완 및 체계적 관리\n" +
						"※공정안전자료 보완 및 관리규정 제정\n" +
						"※공정안전자료 관리 시스템 구축 및 주기적 보완(원본관리)\n" +
						"※보완 내용 공지 및 공정안전자료 제개정목록 작성\n"); break;

			}
			curView.setTextColor(Color.BLACK);
			curView.setTextSize(20);
			views[i] = curView;

	        flipper.addView(views[i]);
		}


	}
    
	/**
	 * Update the display of index buttons
	 */
	private void updateIndexes() {
		for(int i = 0; i < countIndexes; i++) {
			if (i == currentIndex) {
				indexButtons[i].setImageResource(R.drawable.green);
			} else {
				indexButtons[i].setImageResource(R.drawable.white);
			}
		}
	}

	/**
	 * onTouch event handling
	 */
	public boolean onTouch(View v, MotionEvent event) {
		if(v != flipper) return false;

		if(event.getAction() == MotionEvent.ACTION_DOWN) {
			downX = event.getX();
		}
		else if(event.getAction() == MotionEvent.ACTION_UP){
			upX = event.getX();

			if( upX < downX ) {  // in case of right direction
 
				flipper.setInAnimation(AnimationUtils.loadAnimation(getContext(),
		        		R.anim.wallpaper_open_enter));
		        flipper.setOutAnimation(AnimationUtils.loadAnimation(getContext(),
		        		R.anim.wallpaper_open_exit));

		        if (currentIndex < (countIndexes-1)) {
		        	flipper.showNext();

		        	// update index buttons
		        	currentIndex++;
		        	updateIndexes();
		        }
			} else if (upX > downX){ // in case of left direction

				flipper.setInAnimation(AnimationUtils.loadAnimation(getContext(),
		        		R.anim.push_right_in));
		        flipper.setOutAnimation(AnimationUtils.loadAnimation(getContext(),
		        		R.anim.push_right_out));

		        if (currentIndex > 0) {
		        	flipper.showPrevious();

		        	// update index buttons
		        	currentIndex--;
		        	updateIndexes();
		        }
			}
		}

		return true;
	}
 
}
