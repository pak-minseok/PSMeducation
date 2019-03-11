package itm.com.psmeducation.ScreenViewFlipper3;


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

import itm.com.psmeducation.R;

/**
 * ScreenView Flipper
 *
 * @author Mike
 */
public class ScreenViewFlipper3_4 extends LinearLayout implements OnTouchListener {

	/**
	 * Count of index buttons. Default is 3
	 */
	public static int countIndexes = 4;

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


	public ScreenViewFlipper3_4(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper3_4(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview3_4, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout3_4);
		flipper = (ViewFlipper) findViewById(R.id.flipper3_4);
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
				case 0 : curView.setText("공정안전 자료\n" +
						"가. 유해 위험물질 자료\n" +
						"●유해 위험물질 물성 및 사용량\n" +
						"●물질 안전 보건자료\n" +
						"\n" +
						"나. 유해 위험설비 목록 및 사양\n" +
						"●동력기계 목록\n" +
						"●장치 및 설비사양\n" +
						"●배관 및 가스켓 사양\n" +
						"●안전벨트 및 파열판 사양 \n" +
						"\n" +
						"다. 공정도면\n" +
						"●공정설명서\n" +
						"●공정흐름도(PFD)\n" +
						"●공정배관, 계장도(P&ID)\n" +
						"●유틸리티 계통도\n" +
						"●유틸리티 배관 계장도(UFP)\n" +
						"\n" +
						"라. 건물설비의 배치도\n" +
						"●건물설비 전체 배치 도면\n" +
						"●설비 배치도면\n" +
						"●건물 및 철구조물의 평면도 및 입면도\n" +
						"●내화구조 사양\n" +
						"●소화설비 설치 계획\n" +
						"●화재탐지 및 경보설비 설치계획\n" +
						"●가스누출 감지 경보기 설치계획\n" +
						"●세척, 세안시설 및 안전\n" +
						"●국소배기장치 설치 계획\n" +
						"마. 방폭지역 구분 및 전기 단선도\n" +
						"●방폭지역 구분도\n" +
						"●방폭전기 계장기계기구 선정 기준 전기 단선도\n" +
						"  접지계획\n" +
						"\n" +
						"바. 안전설계, 제작, 설치 지침서\n" +
						"사. 배출물의 처리 설계기준 및 사양\n"); break;
				case 1 : curView.setText("위험성 평가\n" +
						"가. 위험성 평가 결과\n" +
						"나. 위험성 평가 결과 조치 계획\n"); break;
				case 2 : curView.setText("안전운전 계획\n" +
						"가. 안전운전 지침서\n" +
						"나. 설비검사 및 보수, 유지계획 및 지침서\n" +
						"다. 안전작업 허가\n" +
						"라. 도급업체 안전 관리계획\n" +
						"마. 근로자 교육계획\n" +
						"바. 가동전 점검 지침서\n" +
						"사. 변경요소 관리계획\n" +
						"아. 자체감사 계획\n" +
						"자. 공정사고 조사 계획\n\n"); break;
				case 3 : curView.setText("비상조치계획\n"); break;

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
