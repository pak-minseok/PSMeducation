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
public class ScreenViewFlipper1_3 extends LinearLayout implements OnTouchListener {

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


	public ScreenViewFlipper1_3(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper1_3(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview1_3, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout1_3);
		flipper = (ViewFlipper) findViewById(R.id.flipper1_3);
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
						" ⓵ 위험성평가 전문가 확보\n" +
						" ⓶ 위험성평가에 필요한 도면류·사고사례·프로그램 등 확보\n" +
						" \n" +
						"(2) 추진사항\n" +
						" ⓵ 공정위험성평가 종합계획 수립·시행\n" +
						" ⓶ 사업장 자체적인 위험성평가체제 구축\n" +
						" ⓷ 주기적인 위험성평가 실시 및 평가결과 사후관리\n" +
						"\n" +
						"(3) 수행방법\n" +
						" ⓵대상·방법·주기·등급판정·사후관리 등 위험성평가 규정 마련\n" +
						"   ※설비변경시 반드시 위험성평가, 매 3~5번 주기 반복시행\n" +
						"     (신규기법 권장)\n" +
						" ⓶위험성평가 전문가 양성, 평가팀(FTF)구성, 수시 활용\n" +
						" ⓷정성평가 후 상위등급에 대해 정량평가(QRA) 실시\n" +
						" ⓸위험도를 낮추기 위한 개선방안 강구(위험도 관리)\n" +
						" ⓹개선계획 작성·보고, 권고사항은 개선완료시까지 추적관리\n" +
						" ⓺위험성평가 재실시시 새로운 위험성평가기법 활용 권장\n" +
						" ⓻공정안전자료·안전운전절차서·비상조치계획 등에 위험성평가 결과 반영\n" +
						"   (Up-date), 근로자 교육실시(사내 PSM 교육교재로 활용)\n" +
						"\n" +
						"(4)참고사항\n" +
						"⓵위험성평가 교육 수강 후 자체수행 또는 외부 전문가(기관)활용\n" +
						"⓶종합위험관리시스템 활용\n" +
						"⓷공정위험특성에 적합한 위험성평가기법 선정 활용\n"); break;
				case 1 : curView.setText("-확인방법 \n ⓵위험성평가 결과보고서 및 개선권고사항 이행여부 확인\n" +
						"⓶위험성평가에 참여한 인력의 적정성 확인\n" +
						"⓷변경관리절차에 따른 위험성평가 실시여부 확인\n"); break;

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
