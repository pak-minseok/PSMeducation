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
public class ScreenViewFlipper4_4 extends LinearLayout implements OnTouchListener {

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


	public ScreenViewFlipper4_4(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper4_4(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview4_4, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout4_4);
		flipper = (ViewFlipper) findViewById(R.id.flipper4_4);
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
						"●유해·위험설비의 점검, 정비 및 유지관리와 관계된 사항으로써, 설비의 중요도에 따라 검사.정비의 주기와 등급을 부여하여 관리함으로, 설비가 항상 최적의 성능과 안전운전을 유지하기 위한 절차이다.\n"); break;
				case 1 : curView.setText("■내용\n" +
						"●설비의 분류\n" +
						"공정을 구성하는 모든 기기의 중요도에 따라 등급(A,B,C)을 부여하여 관리한다.\n" +
						"A등급 : 문제점 발생시 그 파급효과가 제품생산에 막대한 영향을 미친는 설비 밋 사고가 치명적이고 사고빈도가 큰 것으로 우선 관리가 요구되는 설비\n" +
						"B등급 : 문제점 발생시 그 파급효과가 생산입부에 영향을 미치는 설비 및 사고 빈도가 치명적이고 큰 것으로 관리가 요구되는 설비\n" +
						"C등급 : 문제점 발생시 그 파급효과가 경미하고 사고빈도가 작은 설비\n" +
						"●일상점검\n" +
						"모든 설비에 대하여 설비 운전원이 일상 점검을 실시하는 사항\n" +
						"●예방점검\n" +
						"A,B,C 등급의 설비에 대하여 점검주기를 정하여 년간 계획에 의거 점검을 실시하는 사항\n" +
						"●교육\n" +
						"설비점검자 및 운전자에게 설비점검 및 안전운전과 관련된 내용을 교육하는 상\n" +
						"●정비\n" +
						"점검결과 결함 및 고장에 대하여 또는 주기적으로 행하는 예방적 조치로써의 부품의 교체 또는 수정하는 사항으로써 정비계획을 수립하고 정비작업절차서에 의한 정비를 실시하는 사항\n" +
						"●예비품 목록\n" +
						"연속운전에 필요한 예비품을 필요시 언제든지 구매할 수 있도록 예비품 목록을 작성/비치하는 사항\n" +
						"●설비의 유지관리\n" +
						"각 기기 및 설비에 대하여 점검/정비에 대한 이력을 기록 유지하는 사항\n"); break;
				case 2 : curView.setText("■업무 추진사항\n" +
						"\n" +
						"설비별 위험 등급에 따른 효율적인 관리 :\n" +
						"※설비 종류별 위험등급 분류체계 수립 및 절차서 유지 관리\n" +
						"※설비점검 마스터 작성, 종합계획수립 후 검사 등 실시, 설비이력관리\n"); break;


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
