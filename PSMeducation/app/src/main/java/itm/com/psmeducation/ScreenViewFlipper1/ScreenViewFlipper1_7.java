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
public class ScreenViewFlipper1_7 extends LinearLayout implements OnTouchListener {

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


	public ScreenViewFlipper1_7(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper1_7(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview1_7, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout1_7);
		flipper = (ViewFlipper) findViewById(R.id.flipper1_7);
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
						" ⓵ 협력업체 안전관리수준 평가기준 및 관련부서 통보 절차 보유\n" +
						" ⓶ 상주업체와 비상주(외주)업체로 구분 관리\n" +
						" \n" +
						"(2) 추진사항\n" +
						" ⓵ 객관적인 평가체제 구축\n" +
						" ⓶ 협력업체 선정시 안전보건분야 실적 반영\n" +
						" ⓷ 상주 및 비상주 협력업체에 대한 주기적인 평가 및 등급관리\n" +
						"\n" +
						"(3) 수행방법\n" +
						" ⓵ 협력업체 평가관리기준 작성 및 주기적 보완(상주·외주업체 구분)\n" +
						"  ※협력업체 선정평가·유지평가·등급관리 등의 기준 및 절차\n" +
						" ⓶상주 협력업체 및 외주협력업체에 대한 안전보건실적 평가\n" +
						"  -상주업체는 연간 안전보건실적을 평가\n" +
						"  -외주업체는 공사(작업) 건수별 안전실적 평가\n" +
						"  ※ 안전작업계획, 재해발생기록 및 관리상태, 안전작업절차 숙지 상태 및 작업 중 절       차 준수여부,       PSM 이행상태 등 평가\n" +
						" ⓷ 상주업체 연장 및 외주업체 선정시 안전보건실적 반영기준 설정 \n" +
						" ⓸ 업체별 평가결과 분석, 등급부여(예: 우수, 보통, 불량), 등급에 따라 입찰자격 제      한 및 인센티브 부여방안 강구\n" +
						" ⓹ 분기별 1회이상 간담회 실시, 상주 협력업체에 평가결과 설명 및 관련교육 지원\n" +
						"\n" +
						"(4)참고사항\n" +
						"⓵관련기업의 협력업체 이력관리 사례 참조\n"); break;
				case 1 : curView.setText("-확인방법 \n ⓵협력업체 선정과정 및 평가서 확인\n" +
						"⓶원청업체 재해율에 협력업체 재해율 포함 관리\n" +
						"⓷협력업체 안전성향상을 위한 모기업의 주요 활동으로 이행\n"); break;

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
