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
public class ScreenViewFlipper4_8 extends LinearLayout implements OnTouchListener {

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


	public ScreenViewFlipper4_8(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper4_8(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview4_8, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout4_8);
		flipper = (ViewFlipper) findViewById(R.id.flipper4_8);
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
						"신규 설비의 설치 또는 기존설비의주요 구조부분을 변경한 후 설비의 안전성을 종합적으로 검토하기 위해 가동전에 설계자, 시공사, 운전자, 안전관계자 및 기타 전문가동이 합동으로 실시하는 점검을 말한다.\n"); break;
				case 1 : curView.setText("■내용\n" +
						"●적용범위\n" +
						"신규 설비의 설치 똔느 공정 설비의 주요 구조부분에 대한 변경을 수행한 후 설비 가동전에 실시하는 점검\n" +
						"●점검 관련사항\n" +
						"※점검표의 작성: 가동전 점검표를 활용하되, 별도의 체크리스트를 활용 할 수 있다.\n" +
						"※점검실시: 신·증설비 외에도 설비의 임시설치나 가동 정지 후 재가동 경미한 설비의변경시 적용하며, 공사오나료 후부터 운전개시전까지의 기간동안 점검한다.\n" +
						"※점검결과: 점검결과에 대한 이상 유·무의 보고 및 관련서류를 운전부서에서 3년간 자체 보관한다.\n"); break;
				case 2 : curView.setText("■업무 추진사항\n" +
						"\n" +
						"유해, 위험설비의 가동(시운전)전 안전점검 :\n" +
						"※유해위험설비에 대한 설비별 가동전 점검표 작성 및 주기적인 보완\n" +
						"※가덩전 점검 실시, 점검결과에 따라 시운전 여부 판단\n" +
						"※유해위험요인 제거 후 가동\n" +
						"※시운전 절차시 작성\n"); break;

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
