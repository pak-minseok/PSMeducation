package itm.com.psmeducation.ScreenViewFlipper1;


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
public class ScreenViewFlipper1_13 extends LinearLayout implements OnTouchListener {

	/**
	 * Count of index buttons. Default is 3
	 */
	public static int countIndexes = 2;

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


	public ScreenViewFlipper1_13(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper1_13(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview1_13, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout1_13);
		flipper = (ViewFlipper) findViewById(R.id.flipper1_13);
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
				case 0 : curView.setText("-실천 방법 \n (1) 선결조건\n" +
						" ⓵ 구성원별 비상조치임무가 부여된 비상조치기준 확보\n" +
						" ⓶ 비상조치계획 수립·시행을 위한 조직·인력·장비 확보\n" +
						" ⓷ 사내·외 및 관련기관의 유기적인 협조체제 구축\n" +
						" \n" +
						"(2) 추진사항\n" +
						" ⓵ 최악의 상태를 가정한 비상대응 시나리오 작성\n" +
						" ⓶ 종합적이고 입체적인 피해 최소화 전략 수립\n" +
						" ⓷ 주기적인 자체비상훈련 및 외부 합동비상훈련\n" +
						"\n" +
						"(3) 수행방법\n" +
						" ⓵ 정량적 위험성평가를 실시하여 부서별 최악의 사고 발생가능성에 대한 비상대응       시나리오 작성, 종합위험관리시스템 등을 활용하여 시나리오별 사고피해범위 예측      등, 피해 최소화 대응전략 수립\n" +
						" ⓶ 피해예측 결과를 반영하여 대피방법·대피로 등을 포함하는 비상 대응계획 수립 및      근로자 교육(인근주민 소개 및 정보제공 포함)\n" +
						" ⓷ 주기적으로 협력업체 근로자를 포함하여 전사적인 비상훈련을 실시하여 비상대응      방법 습관화(검토를 위해 Video 촬영)\n" +
						" ⓸ 비상훈련 결과를 종합 검토하여 미비점 발굴·보완, 비상계획 최적화\n" +
						" ⓹ 사고시나리오의 지속적인 발굴, 주기적인 비상대응계획 수정·보완\n" +
						" \n" +
						"(4)참고사항\n" +
						"⓵ 안전공단에서 최악의 사고시나리오를 비상조치계획에 반영하는 방법 등에 관하여      교육실시(IRMS 활용방법 교육)\n" +
						"⓶ 안전공단에서 개발한 IRMS 이외에 기타 피해예측프로그램 활용가능\n"); break;
				case 1 : curView.setText("-확인방법 \n ⓵비상조치계획 수립 및 시나리오의 발굴상태 확인\n" +
						"⓶교육 및 훈련결과보고서 확인 개인별 임무의 숙지상태(면담 확인)\n"); break;

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
