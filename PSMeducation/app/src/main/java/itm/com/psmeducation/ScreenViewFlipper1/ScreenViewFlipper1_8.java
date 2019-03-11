package itm.com.psmeducation.ScreenViewFlipper1;

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
public class ScreenViewFlipper1_8 extends LinearLayout implements OnTouchListener {

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


	public ScreenViewFlipper1_8(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper1_8(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview1_8, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout1_8);
		flipper = (ViewFlipper) findViewById(R.id.flipper1_8);
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
						" ⓵ 교육훈련절차서 및 근로자 PSM 교육에 적합한 교육교재 확보\n" +
						" ⓶ PSM 교육이 가능한 교육장, 사내·외 강사 확보\n" +
						" \n" +
						"(2) 추진사항\n" +
						" ⓵ 연간 교육계획의 수립 및 실행\n" +
						" ⓶ PSM 12개 구성요소별 교육교재 작성\n" +
						" ⓷ 계층별 PSM 교육 및 성과측정\n" +
						"\n" +
						"(3) 수행방법\n" +
						" ⓵ 연간 PSM 교육계획 수립(전체 및 부서별 교육계획)\n" +
						"  ※PSM 업무수행능력이 향상될 수 있도록 실질적인 계획 수립\n" +
						"   (전체 연1회 이상 수강)\n" +
						" ⓶ 외부 PSM 전문교육 수강을 통하여 자체 PSM 강사요원 양성\n" +
						" ⓷ PSM 교육교재 및 재료 작성\n" +
						"  -업무특성별 교육교재 및 시청각 교육자료 작성\n" +
						"  ※정기연차보수시 운전정지(S/D) 및 재가동(S/U) 절차 교육자료, 설비 신·증설·변경시 운전절차서 및 작업표준 교육교재, 위험성 평가 결과에 대한 근로자 교육교재 등 업무특성별 교육교재 등\n" +
						" ⓸ 현장근로자·운전원·조·반장·과부장 등 계층별 PSM교육 실시\n" +
						"   ※업무특성에 적합한 시기 및 교체를 선정하여 실습위주 교육 식시(특히 운전원)\n" +
						"   ※교육방식은 On-Line·집합·현장·초빙·체험 등 실정에 맞추어 선택\n" +
						" ⓹ 개인별·조별·직능별·계층별 교육 성과측정 및 결과분석\n" +
						"  ※평가는 주관식·객관식·면접·실습 등 다양한 평가방식을 적용하여 정량화\n" +
						" ⓺인사고과에 성과측정 결과(교육점수) 반영\n" +
						"  ※채용·보직변경·승진/승급 등 업무수행능력(인증)에 대한 자격조건 설정·시행\n" +
						" ⓻교육실적 기록관리 및 차기 교육계획(불참자 재교육·반복교육) 반영\n" +
						"\n" +
						"\n" +
						"(4)참고사항\n" +
						"⓵안전공단 및 관계사에서 제작한 PSM 교육교재 활용 가능\n" +
						"⓶안전공단에 요청할 경우 PSM 강사지원\n"); break;
				case 1 : curView.setText("-확인방법 \n ⓵교육훈련절차서, 연간교육계획 수립여부 및 적정성\n" +
						"⓶교육강사·교육내용·성과측정 결과 등 교육실적(교육일정) 확인\n"); break;

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
