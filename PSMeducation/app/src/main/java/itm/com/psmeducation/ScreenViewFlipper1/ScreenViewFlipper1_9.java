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
public class ScreenViewFlipper1_9 extends LinearLayout implements OnTouchListener {

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


	public ScreenViewFlipper1_9(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper1_9(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview1_9, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout1_9);
		flipper = (ViewFlipper) findViewById(R.id.flipper1_9);
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
						" ⓵ 설비 가동전 점검대상·범위·방법 등 가동전점검 시행기준 확보\n" +
						"   ※실시시기·점검팀 구성·점검방법·점검표 작성·점검결과처리 등에 관한 기준 명시\n" +
						" ⓶ 가동전 점검표(Check-List) 확보\n" +
						" \n" +
						"(2) 추진사항\n" +
						" ⓵ 유해·위험설비에 대한 설비별 가동전 점검표 작성 및 주기적인 보완\n" +
						" ⓶ 가동전 점검 실시, 점검결과에 따라 시운전 여부 판단\n" +
						" ⓷ 유해위험요인 제거 후 기동\n" +
						"\n" +
						"(3) 수행방법\n" +
						" ⓵ 유해·위험설비에 대한 설비별 가동전 점검표 작성 및 주기적인 보완\n" +
						"   - 연속공정 : 유틸리티·원료투입-제품저장공정까지 공정별 점검표 작성\n" +
						"   ※자동제어밸브 개방점검표 작성 및 전수점검(제어실과 현장 동시수행)\n" +
						"   -회분공정 : 원료투입전 운전준비상태 점검표 작성\n" +
						"   ※필요한 경우 작업지시서에 점검항목을 포함하여 점검 실시\n" +
						"   -신규 또는 변경설비 : 가동전 점검표 작성 활용\n" +
						" ⓶ 운전부서 및 프로젝트 수행부서 전문가로 점검팀 구성\n" +
						" ⓷ 신규·변경 설비 완료 후 및 기존 유해·위험설비에 대한 운전정지 후 설비가동 전      에 점검표에 의거 설비 이상유무 확인 점검 \n" +
						"  ※설치공사 및 기기간 배관·배선공사 완료 후부터 운전개시 전까지의 기간에 실시\n" +
						" ⓸ 점검보고서 작성(서명날인)→ 개선요구사항 이행계획 수립·시행\n" +
						"   ※점검보고서는 시운전 적합·부적합 여부를 판정할 수 있도록 작성, 개선 항목은 시운전 전까지 개선이 완료될 수 있도       록 계획 수립\n" +
						" ⓹ 개선요구사항을 조치완료하고 운전자교육 실시 후 시운전\n" +
						" ⓺ 가동전 점검결과 보고서 및 개선이행계획서 보존\n" +
						" ⓻ 점검표 및 점검절차 주기적으로 보완(위험성평가결과 반영)\n" +
						"\n" +
						"\n" +
						"(4)참고사항\n" +
						"⓵제작기준 충족여부, 검사실시 및 합격여부, 설치기준, 시방서에따라 설치여부, 위험    성평가 결과 반영여부, 안전운전절차 및 자료 등 점검\n"); break;
				case 1 : curView.setText("-확인방법 \n ⓵가동전 점검기준(점검표 포함)의 적절성 확인\n" +
						"⓶대정비 보고서·변경관리 내용 등을 확인하여 가동전검검 필요성 판단\n" +
						"⓷점검실시여부 및 개선사항(Punch List) 조치여부 확인, 운전자 면담\n"); break;

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
