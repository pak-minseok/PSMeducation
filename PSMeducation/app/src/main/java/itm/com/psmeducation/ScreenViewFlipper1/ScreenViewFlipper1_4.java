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
public class ScreenViewFlipper1_4 extends LinearLayout implements OnTouchListener {

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


	public ScreenViewFlipper1_4(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper1_4(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview1_4, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout1_4);
		flipper = (ViewFlipper) findViewById(R.id.flipper1_4);
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
						" ⓵ 안전운전절차서(Manual 및 SOP) 구비\n" +
						" -연속공정:시운전, 정상, 비정상 운전정지(S/D) & 재가동(S/U)절차\n" +
						" -회분공정:제춤별·회분식반응기(Batch)별 절차서 작성 \n" +
						"(2) 추진사항\n" +
						" ⓵ 안전운전절차서의 제·개정 절차 표준화\n" +
						" ⓶ 안전운전절차서의 주기적인 보완\n" +
						" ⓷ 안전운전절차 준수여부를 자체적으로 확인하기 위한 체제 구축\n" +
						"\n" +
						"(3) 수행방법\n" +
						" ⓵ 안전운전절차서의 작성대장·내용·방법 등 제·개정절차 표준화\n" +
						" ⓶ 업무형태별·단위공정별·장치설비별로 안전운전절차서 작성\n" +
						"   ※변경요구서·발행·위험성평가 실시 후 반드시 절차서 변경 필요성 검토\n" +
						" ⓷ 근로자들이 수비게 이해할 수 있도록 흐름도(Block Diagram) 작성\n" +
						" ⓸ 일정기간마다 안전운전절차서에 대한 신뢰성 검증·보안\n" +
						" ⓹ 안전운전절차서 준수여부 점검체제 구축(책임 및 권한, 점검수단)\n" +
						"   ※부서장이 일정주기별로 운전원의 운전능력 평가·확인\n" +
						" ⓺절차서 제·개정시 구성원 모두가 숙지(공유)할 수 있도록 제어실·현장(Shelter) 등에\n" +
						"   사본 비치, 반복교육\n" +
						"   ※정기교육·특별교육·1일 엄무개시 미팅시 등 수시교육(교육내용 기록 보존)\n" +
						" ⓻제안제도 등을 통한 지속적인 보완(Revision)으로 절차서 최적화\n" +
						"   ※운전원·엔지니어 등의 풍부한 운전경험이 충분히 반영될 수 있는 체제 구축\n" +
						"\n" +
						"(4)참고사항\n" +
						"⓵외국사례 참조(Bench Marking) 및 동종 업계간 정보 교류\n" +
						"⓶단위공정별·업무형태별·근로자 특성별 등으로 상세구분 작성\n"); break;
				case 1 : curView.setText("-확인방법 \n ⓵안전운전절차서(Manual 및 SOP) 제·개정이력 확인\n" +
						"⓶사업장 자체적인 운전절차 준수여부점검실적 확인\n" +
						"⓷교육훈련 실적 및 운전원·정비원 등의 운전절차 숙지상태 확인\n"); break;

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
