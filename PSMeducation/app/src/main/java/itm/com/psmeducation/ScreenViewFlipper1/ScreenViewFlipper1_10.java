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
public class ScreenViewFlipper1_10 extends LinearLayout implements OnTouchListener {

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


	public ScreenViewFlipper1_10(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper1_10(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview1_10, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout1_10);
		flipper = (ViewFlipper) findViewById(R.id.flipper1_10);
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
						" ⓵ 변경관리절차의 확립\n" +
						" ⓶ 변경관리 추진체제 구축\n" +
						" \n" +
						"(2) 추진사항\n" +
						" ⓵ 변경의 범위(변경 판정기준)를 명확하게 설정·적용\n" +
						" ⓶ 변경사유 발생시 변경관리 절차 준수\n" +
						" ⓷ 변경관리위원회의 실질적인 활동 및 권한부여\n" +
						"\n" +
						"(3) 수행방법\n" +
						" ⓵ 공정내 모든 변경사항에 대한 변경목록 작성(List-up)\n" +
						" ⓶ 변경 요구서/발의서 작성, 변경관리위원회 회부·검토\n" +
						" ⓷ 기본설계(P&ID→ 기술부서에서 수행)\n" +
						" ⓸ 변경공정/설비에 대한 위험성평가\n" +
						"    위험성평가시 관련분야 전문가 및 운전원 참여\n" +
						" ⓹ 위험성평가 지적사항에 대한 개선계획 수립, 개선완료시까지 추적관리\n" +
						"   ※작업허가서를 발급받은 후 공무부서 및 협력업체 작업실시\n" +
						" ⓺ 가동전 안전점검 결과 지적사항 개선·보완\n" +
						" ⓻ 설비목록·도면류 등 공정안전자료·절차서 등 수정·보완 (AS-    Bulit)\n" +
						" ⓼ 운전원·정비원·협력업체 직원 등 관련 근로자 교육\n" +
						" ⓽ 시운전 및 변경완료 후 개선효과 분석\n" +
						"\n" +
						"\n" +
						"(4)참고사항\n" +
						"⓵발의 부서와 기본/상세설계 부서 반드시 분리\n" +
						"⓶위험성평가는 당해설비에 적합한 평가기법 산정·활용\n"); break;
				case 1 : curView.setText("-확인방법 \n ⓵변경관리절차서 적정성, 교대근무·공무일지,정기보수결과 등 확인\n" +
						"⓶변경공정 위험성평가서·공정안전자료 보완(Updating) 실적 등 확인\n" +
						"⓷운전절차서 제·개정 이력 및 근로자 교육실적 확인\n"); break;

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
