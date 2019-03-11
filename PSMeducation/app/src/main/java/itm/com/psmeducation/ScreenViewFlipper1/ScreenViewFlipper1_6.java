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
public class ScreenViewFlipper1_6 extends LinearLayout implements OnTouchListener {

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


	public ScreenViewFlipper1_6(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper1_6(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview1_6, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout1_6);
		flipper = (ViewFlipper) findViewById(R.id.flipper1_6);
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
						" ⓵ 책임과 권한이 명시된 작업허가서 구비\n" +
						" -화기·밀폐공간출입·굴착·방사선·정전작업 등 종류별 세분화\n" +
						" -발행일시·작업내용·점검 및 확인사항·발행자·산소농도측정·중점 지적확인 사항·유효기    간·근무교대시 허가서 서명 등 내용포함\n" +
						"⓶ 안전작업허가서 내용 준수여부 점검절차 \n" +
						" \n" +
						"(2) 추진사항\n" +
						" ⓵ 주기적인 안전작업허가절차 개선·보완\n" +
						" ⓶ 안전작업허가절차(발급·승인·입회)준수여부 확인\n" +
						" ⓷ 안전작업허가서 내용 이행여부 수시점검\n" +
						"\n" +
						"(3) 수행방법\n" +
						" ⓵주기적으로 허가기준 및 절차 개선 필요성 검토, 필요시 개정·보완\n" +
						" ⓶허가대상 직업 명확히 구분, 허가서 발급·승인·입회 등의 책임구분 및 당해 작업과     관련된 생산·공무·안전 등 해당부서 실무책임자 서명\n" +
						"  ※사고발생시 모기업 관계자의 책임한계 명확히 구분, 8시간 초과시 허가서 재발급\n" +
						" ⓷허가서 발급시 현장 안전조치 확인(화기 : 비산불티차단막, 밀폐공간출입 : 산소농     도측정, 굴착 : 매설도면, 방사선:접근금지, 정전: 접지 등)\n" +
						"  ※현장확인 책임자(부서)지정,권한부여\n" +
						"  ※최초 용기출입·작업중지 후 재개시 등에는 반드시 산소(가연성가스) 농도측정(반드      시 2인1조 작업     시행, 원칙적으로 4시간 마다 농도측정) \n" +
						" ⓸작업전 위험성·비상대피요령 등 정비작업자 교육·평가(협력업체 포함)\n" +
						" ⓹관리감독자 지정 및 입회, 연장 작업 및 휴일 작업관리\n" +
						" ⓺작업시 허가조건 준수여부 수시 확인 (책임자 또는 부서 지정)\n" +
						" ⓻작업 완료 후 정상상태 확인, 허가서 보존·관리 등\n" +
						"\n" +
						"(4)참고사항\n" +
						"⓵허가대상 작업의 범위는 가능한 한 사업장내 모든 작업에 적용\n"); break;
				case 1 : curView.setText("-확인방법 \n ⓵허가기준 및 허가서 발행절차 적정성 확인\n" +
						"⓶공무작업이력, 변경관리내용 등을 확인, 작업별 허가서 발행실적 확인\n" +
						"  ※작성 및 점검항목 누락, 작성자·승인자 적정여부, 허가유효기간 준수여부 등\n" +
						"⓷정비작업 근로자 면담(협력업체 근로자 포함)\n"); break;

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
