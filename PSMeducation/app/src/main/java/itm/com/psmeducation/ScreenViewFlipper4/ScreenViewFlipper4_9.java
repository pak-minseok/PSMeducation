// 1-2

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
public class ScreenViewFlipper4_9 extends LinearLayout implements OnTouchListener {

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


	public ScreenViewFlipper4_9(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper4_9(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview4_9, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout4_9);
		flipper = (ViewFlipper) findViewById(R.id.flipper4_9);
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
						"모든 공정기술, 설비, 절차등을 변경시키고자 할 때 이에 따른 안전검토, 점검 및 사후관리를 시행하여 변경하여 변경에 의한 위험을 예방하기 위한 절차이다.\n"); break;
				case 1 : curView.setText("■내용\n" +
						"●적용범위\n" +
						"변경요소 관리가 요구되는 공정, 기술, 절차등의 변경에 적용\n" +
						"(설비면경 중 교환은 변경요소관리에 적용하지 않음)\n" +
						"\n" +
						"●변경요소 관리 절차\t\n" +
						"※변경요구서 작성:변경대상 설비에 관련된 사양 및 도면을 첨부하여 작성한다.\n" +
						"※변경요구서 접수 및 검토: 변경관리위원회에서 선임된 검토자가 기술 및 안전성을 검토하여 변경관리위원회에 제출한다.\n" +
						"※변경승인 및 지시: 변경관리 위원회는 변경완료 사항을 점검/확인하고 변경에 관련된 제반서류에 변견내용을 기록 5년간 보관한다.\n"); break;
				case 2 : curView.setText("■업무 추진사항\n" +
						"\n" +
						"설비 등 변경 시 변경관리절차 준수\n" +
						"※변경의 범위(변경 판정기준)를 명확하게 설정, 적용\n" +
						"※변경사유 발생시 변경관리 절차 준수\n" +
						"※변경관리위원회의 실질적인 활동 및 권한부여\n" +
						"※관련서류는 변경주고나부서에서 5년간 보관한다.\n"); break;


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
