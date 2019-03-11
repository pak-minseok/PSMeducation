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
public class ScreenViewFlipper1_2 extends LinearLayout implements OnTouchListener {

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


	public ScreenViewFlipper1_2(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper1_2(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview1_2, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout1_2);
		flipper = (ViewFlipper) findViewById(R.id.flipper1_2);
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
						" ⓵사용하고 있는 유해위험물질 관련자료(MSDS)작성, 비치\n" +
						" ⓶각종 장치·설비(배관포함)계기 등의 관련자료(Data Sheet)확보\n" +
						" ⓷P&ID, PFD, 전기도면, 기계도면, 배치도(Layout Drawing)등 공장 안전가동에      필요한 각종 장치·설비에 대한 도면류 (Drawing)확보\n" +
						" ⓸PSM과 관련된 법 조항, 고시, 코드 등의 최신자료 비치 및 활용\n" +
						"\n" +
						"(2) 추진사항\n" +
						" ⓵공정안전자료 보완 및 관리규정 개정\n" +
						" ⓶공정안전자료의 전산화(Data Base) 및 주기적 보완(원본관리)\n" +
						" ⓷보완내용 공지 및 공정안전자료 제·개정 목록작성\n" +
						"\n" +
						"(3) 수행방법\n" +
						" ⓵자료관리, 보완 등에 관한 보완대상, 책임과 권한, 보완주기, 재개정 절차, 자료     관리 방법 등을 주요내용으로 하는 사내규정 제정\n" +
						" ⓶자료관리 System 구축(공정안전자료 전산화)\n" +
						" ⓷변경사유 발생 즉시 보완(UP-dating),현장과 도면의 일치(As-Bulit)\n" +
						" ⓸확인 및 검증(개정 및 자료 update 목록작성)\n" +
						"   *도면,Spec,Sheet등 기술자료의 정확도, 내용의 충실성, 주기적 Update 여부확인\n" +
						" ⓹보완사항에 대한 관련 직원간 정보공유\n" +
						" ⓺현장과 일치된 최신자료(Data Sheet) 및 도면류 배포활용\n" +
						"\n" +
						"(4)참고사항\n" +
						"⓵전산화시 엑셀등 저렴한 관련 S/W 및 Utility Program 활용 가능\n" +
						"⓶종합위험관리프로그램 상의 공정안전보고서 작성기능을 활용, 통합 D/B화 가능\n"); break;
				case 1 : curView.setText("-확인 방법 \n ⓵변경내역(요구/종결보고서),설비개선등록대장,교대일지,구매계획서확인\n" +
						"⓶제개정내역,근로자교육,현장고 공정안전자료 일치여부 등 확인\n" +
						"⓷확인사항이 많을 경우 표본추출(Random Sample)\n"); break;

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
