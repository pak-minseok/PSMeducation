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
public class ScreenViewFlipper1_12 extends LinearLayout implements OnTouchListener {

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


	public ScreenViewFlipper1_12(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper1_12(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview1_12, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout1_12);
		flipper = (ViewFlipper) findViewById(R.id.flipper1_12);
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
						" ⓵ 사고조사기준 확보\n" +
						" ⓶ 사고에 대한 책임소재 규명 및 처벌의 수단으로 활용 지양\n" +
						" \n" +
						"(2) 추진사항\n" +
						" ⓵ 앗차사고(공정사고)를 포함하여 사고원인조사 수행\n" +
						" ⓶ 동종업체 사고사례 분석·활용\n" +
						" ⓷ 자사 및 타사 사고사례 데이터베이스 구축\n" +
						"\n" +
						"(3) 수행방법\n" +
						" ⓵ 조사대상 범위에 대한 명확한 기준 설정\n" +
						" ⓶ 현장이 보존된 상태에서 24시간 이내에 공정·안전환경·공무·전기 계장 등 관련 전      문가로 조사팀 구성, 조사 착수(해당공정 근로자 참여)\n" +
						"   ※외부기관에서 사고원인조사를 실시하는 경우 제외\n" +
						" ⓷ 사고직전까지 운전 중 발생한 모든 이탈상황 파악, 정확한 이탈\n" +
						"    상황 발생의 근원적 사고원인 분석(Root Cause Analysis)\n" +
						"   ※현장상황을 사진·비디오 등으로 촬영하여 보존, 필요시 유사 상황 재현\n" +
						" ⓸ 사고조사기준에 규정된 양식을 사용하여 공정사고조사보고서 작성, 직접손실비용 및 추정 간접손실비용 명시\n" +
						"※조사보고서에는 조사자(팀) 전원의 소속·성명 기록, 서명날인, 5년간 보관\n" +
						"※공정사고(아차사고)는 공정사고조사보고서 양식 활용\n" +
						" ⓹ 재발방지를 위한 구체적인 장단기 대책 수립·시행\n" +
						"   ※재발방지대책 추진에 소요되는 투자비용 산정 명시\n" +
						" ⓺ 동종업종 관련기업에서 발생한 사교사례 수집, 동종사고 발생 가능\n" +
						" ⓻ 사고조사보고서를 활용하여 근로자 교육 실시(관계사 사고사례 포함)\n" +
						"\n" +
						"(4)참고사항\n" +
						"⓵안전공단에서 개발한 종합위험관리체제를 활용, 사고사례 데이터베이스 구축 가능\n"); break;
				case 1 : curView.setText("-확인방법 \n ⓵사고조사기준 적정성 확인\n" +
						"⓶사고조사 보고서 작성 및 재발방지대책 이행여부 확인\n" +
						"⓷사고목록·운전 및 생산이력·정비이력 등을 비교하여 대상여부 판단\n" +
						"⓸사고내용·조사자·원인 및 재발방지대책 등 확인, 실질조사여부 판단\n"); break;

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
