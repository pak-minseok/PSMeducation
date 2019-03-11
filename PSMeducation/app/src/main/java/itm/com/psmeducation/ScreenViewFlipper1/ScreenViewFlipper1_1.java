package itm.com.psmeducation.ScreenViewFlipper1;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
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
public class ScreenViewFlipper1_1 extends LinearLayout implements OnTouchListener {

	/**
	 * Count of index buttons. Default is 3
	 */
	public static int countIndexes = 1 ;

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


	public ScreenViewFlipper1_1(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper1_1(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		init(context);
	}

    /**
     * Initialize
     *
     * @param context
     */
	String str;
	final SpannableStringBuilder resultText = new SpannableStringBuilder();
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void init(Context context) {
		setBackgroundColor(0x00000000);

		// Layout inflation
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.screenview1_1, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout1_1);
		flipper = (ViewFlipper) findViewById(R.id.flipper1_1);
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

			final TextView curView = new TextView(context);
			switch (i) {
				case 0 :str = "\n" +
						"1\n" +
						"공정안전자료의 주기적인 보완 및 체계적관리\n" +
						"·공정안전자료 보완 및 관리규정 제정\n" +
						"·공정안전자료 관리시스템 구축 및 주기적 보완(원본관리)\n" +
						"·보완내용 공지 및 공정안전자료 제·개정목록 작성\n" +
						"2\n" +
						"공정위험성평가 체제구축 및 사후관리\n" +
						"·공정위험성평가 종합계획 수립·시행\n" +
						"·사업장 자체적인 위험성평가체제 구축\n" +
						"·주기적인 위험성 평가 실시 및 평가결과 사후관리\n" +
						"3\n" +
						"안전운전절차 보완 및 준수\n" +
						"·안전운전절차서의 제·개정 절차 표준화\n" +
						"·안전운전절차서의 주기적인 보완\n" +
						"·안전운전절차 준수 여부를 자체적으로 확인하기 위한 체제 구축\n" +
						"4\n" +
						"설비별 위험등급에 따른 효율적인 관리\n" +
						"·설비 종류별 위험등급 분류체계 수립 및 절차서 유지 ·관리\n" +
						"·설비점검 마스터 작성, 종합계획수립 후 검사등 실시, 설비이력관리\n" +
						"·장치·설비의 유지보수시스템 구축(전산화)\n" +
						"5\n" +
						"작업허가 절차 준수\n" +
						"·주기적인 안전작업허가 절차 개선·보완\n" +
						"·안전작업허가절차(발급·승인·입회)준수여부 확인\n" +
						"·안전작업허가서 내용 이행여부 수시점검\n" +
						"6\n" +
						"협력업체 선정시 안전관리 수준 반영\n" +
						"·객관적인 평가체제 구축\n" +
						"·협력업체 선정시 안전보건분야 실적 반영\n" +
						"·상주 및 비상주 협력업체에 대한 주기적인 평가 및 등급관리\n" +
						"7\n" +
						"근로자(임직원)에 대한 실질적인 PSM 교육\n" +
						"·년간 교육계획의 수립 및 실행\n" +
						"·PSM 12개 구성 요소별 교육교재 작성\n" +
						"·계층별 PSM 교육 및 성과측정\n" +
						"8\n" +
						"유해, 위험설비의 가동(시운전) 전 안전점검\n" +
						"·유해위험설비에 대한 설비별 가동전 점검표 작성 및 주기적인 보완\n" +
						"·가동전 점검실시, 점검결과에 따라 시운전 여부 판단\n" +
						"·유해위험요인 제거 후 가동\n" +
						"9\n" +
						"설비등 변경시 변경관리절차 준수\n" +
						"·변경의 범위(변경 판정기준)를 명확하게 설정·적용\n" +
						"·변경사유 발생시 변경관리 절차 준수\n" +
						"·변경관리위원회의 실질적인 활동 및 권한부여\n" +
						"10\n" +
						"객관적인 자체 감사 실시 및 사후조치\n" +
						"·정기적인 자체감사 계획 수립·실시\n" +
						"·자체감사 점검표(Check-List)의 주기적인 보완\n" +
						"·자체감사팀 구성 및 권한부여\n" +
						"11\n" +
						"정확한 사고원인 규명 및 재발 방지\n" +
						"·아차사고(공정사고)를 포함하여 사고원인조사 수행\n" +
						"·동종업체 사고사례 분석·활용\n" +
						"·자사 및 타사 사고사례 데이터베이스 구축\n" +
						"12\n" +
						"비상대응 시나리오 작성 및 주기적인 훈련\n" +
						"·최악의 상태를 가정한 비상대응 시나리오 작성\n" +
						"·종합적이고 입체적인 피해 최소화 전략 수립\n" +
						"·주기적인 자체비상훈련 및 외부 합동비상훈련\n\n";
					curView.setText(str);break;
			}
		//	Spannable spanText = Spannable.Factory.getInstance().newSpannable(str);
		//	spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 14, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		//	curView.setText(spanText);
			curView.setTextIsSelectable(true);
			curView.setOnLongClickListener(new OnLongClickListener() {

				@Override
				public boolean onLongClick(View v) {

					int startSelection = curView.getSelectionStart();
					int endSelection = curView.getSelectionEnd();

					//String selectedText = etx.getText().toString().substring(startSelection, endSelection);

					Spannable spannable=new SpannableString(curView.getText().toString());
					spannable.setSpan(new BackgroundColorSpan(Color.RED), startSelection, endSelection, 0);
					curView.setText(spannable);
					resultText.append(spannable);
					return true;
				}

			});
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
