package itm.com.psmeducation.ScreenViewFlipper4;


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
public class ScreenViewFlipper4_7 extends LinearLayout implements OnTouchListener {

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


	public ScreenViewFlipper4_7(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper4_7(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview4_7, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout4_7);
		flipper = (ViewFlipper) findViewById(R.id.flipper4_7);
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
			ImageView imageView = new ImageView(context);
			imageView.setImageResource(R.drawable.img4_7_2);
			switch (i) {
				case 0 : curView.setText("■개요\n" +
						"각종 안전 보건 교육을 효과적으로 실시하여 직원의 안전과 보건을 유지 증진하기 위한 계획/실행 사항이다.\n"); flipper.addView(curView);break;
				case 1 : curView.setText("■내용\n" +
						"●적용 범위\n" +
						"공정에 근무하는 전 근로자 및 도급업체 직원의 교육/훈련에 적용한다.\n" +
						"●교육/훈련 관련사항\n" +
						"※신규채용시 교육:신입직원이 현업에 배치되기 전에 실시하는 교육\n" +
						"※작업내용변경 교육:작업공정의 재배치등으로 작업 내용이 변경될 경우 실시하는 교육\n" +
						"※특별교육:유해 위험작업장에 근무하는 직원에게 실시하는 교육\n" +
						"※정기교육:작업자에게 매월 실시하는 교육\n" +
						"※직무교육:부서 교육계획에 의거 직무와 관계된 사항에 대하여 실시하는 교육\n" +
						"※전문화교육:안전관련 사외 전문기관에 위탁하여 실시하는 교육\n" +
						"※소방훈련:화재 폭발등 비상시 대처능력 향상을 위해 실시하는 훈련\n"); flipper.addView(curView);break;
				case 2 : flipper.addView(imageView); break;
				case 3:  curView.setText("■산업안전보건교육계획\n" +
						"\n" +
						"근로자(임직원)에 대한 실질적인PSM교육 :\n" +
						"※년간 교육계획의 수립 및 실행\n" +
						"※PSM 12개 구성 요소별 교육교재 작성\n" +
						"※계층별 PSM 교육 및 성과측정\n" +
						"※매년 12월 차기년도 교육계획 수립\n"); flipper.addView(curView);break;

			}
			curView.setTextColor(Color.BLACK);
			curView.setTextSize(20);

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
