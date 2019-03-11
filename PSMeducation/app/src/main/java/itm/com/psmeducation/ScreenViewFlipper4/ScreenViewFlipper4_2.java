package itm.com.psmeducation.ScreenViewFlipper4;
import uk.co.senab.photoview.PhotoViewAttacher;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

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
public class ScreenViewFlipper4_2 extends LinearLayout implements OnTouchListener {
	PhotoViewAttacher mAttacher;
	ImageView m_imageView;


	/**
	 * Count of index buttons. Default is 3
	 */
	public static int countIndexes = 15;

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


	public ScreenViewFlipper4_2(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper4_2(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview4_2, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout4_2);
		flipper = (ViewFlipper) findViewById(R.id.flipper4_2);
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



			switch (i) {
				case 0 : curView.setText("■개요\n" +
						"●위험성평가는 공정의 신·증설 또는 변경관리시 실시하는 사항으로써 " +
						"유해·위험설비 및 관계설비의 위험성을 파악하여 발생할 수 있는 사고에 대한 예방대책을 수립/시행하기 위한 절차이다.\n"); flipper.addView(curView);break;
				case 1 : curView.setText("■내용\n" +
						"●위험성평가 범위\n" +
						"위험성평가 대상공정 및 용어의 정의, 위험성평가기법 설명/실시 순서에 대하여 정의하며, 위험성평가의 시기는 신·증설 공정발생시, 시존 공정 중 변경관리 사항이 발생한 경우, 최초보고서 작성후 매 5년마다 실시한다.\n" +
						"●위험성평가 실시사항\n" +
						"공정도면 및 기초자료를 활용하여 위험성평가를 실시\n" +
						"●사고빈도 및 피해 최소화 대책\n" +
						"유해·위험설비 침 관계설비의 잠재위험 순위별로 사고발생 빈도를 최소화하기 위한 대책을 수립/시행\n"); flipper.addView(curView);break;
				case 2 : curView.setText("■위험성평가 사전준비\n" +
						"●평가체계 수립      ●팀 구성\n" +
						"●평가기법 고려      ●평가방법 교육\n" +
						"●기타 고려사항\n" +
						"-공정 Flow(P&ID)\n" +
						"-예상사고의 파급효과와 위험수진\n" +
						"-공정의 복잡성\n" +
						"-분석팀의 능력 및 경험\n" +
						"-소요시간\n"); flipper.addView(curView);break;
				case 3 : imageView.setImageResource(R.drawable.img4_2_3);
					mAttacher = new PhotoViewAttacher(imageView);
					mAttacher.setScaleType(ScaleType.FIT_XY);
					flipper.addView(imageView); break;
				case 4 : curView.setText("■위험성 평가 방법\n" +
						"●정성적 평가\n" +
						"-체크리스트 방법(Checklist)방법\n" +
						"-예비위험분석(PHA)\n" +
						"-사고예방질문기법(PHA)\n" +
						"-위험 및 운전분석(HAZOP)\n" +
						"-작업자 실수분석(Human Error Analysis\n" +
						"\n" +
						"●정량적 평가\n" +
						"-결합 수 분석(FTA : Fault Tree Analysis)\n" +
						"-사건 수 분석(ETA : Event Tree Analysis)\n" +
						"-원인/결과 분석(CAUSE/Consequence Analysis)\n"); flipper.addView(curView);break;
				case 5 : curView.setText("■체크리스트법(Checklist)\n" +
						"●일반적인 위험요소들을 확인하거나, 기준이 되는 절차에 따라 일이 진행되는가를 확인하는데 사용\n" +
						"●적용시기\n" +
						"-설계 : 설계의 모든 단계에서 위험요소를 체크\n" +
						"-시공 :  설계조건에 따라 작업이 진행되는지를 확인\n" +
						"-시운전 : 시운전시 진척 현황 체크\n" +
						"-정상운전 : 공정 운영시 기준 절차의 준수상태 체크\n" +
						"-운전정지 : SHUT DOWN시 내재되어 있는 위험 체크\n"); flipper.addView(curView);break;
				case 6 : imageView.setImageResource(R.drawable.img4_2_6);
					mAttacher = new PhotoViewAttacher(imageView);
					mAttacher.setScaleType(ScaleType.FIT_XY);
					flipper.addView(imageView); break;
				case 7 : curView.setText("■WHAT-IF 분석(사고예방 질문기법)\n" +
						"●사고를 유발시킬 수 있는 상황을 가정\n" +
						"-예상되는 결과 도출\n" +
						"-필요한 대책 마련\n" +
						"●설계, 시공, 운전단계 등에서 발생할 수 있는 이상 현상 분석\n" +
						"(또는 변경 설치시)\n" +
						"-다른 물질(원료)이 인입된다면\n" +
						"-A밸브 대신 B밸브를 조작한다면\n" +
						"-펌프가 가동이 안도니다면\n" +
						"●HAZOP후 추가로 누락된 부분 확인시\n"); flipper.addView(curView);break;
				case 8 : curView.setText("■WHAT-IF 분석 사례\n" +
						"\n" +
						"대상     : 저장탱크에톨루엔 Loading 작업\n" +
						"What-If  : Tank에 톨루엔 과충전\n" +
						"위험     : 톨루엔 overflow 및 유출\n" +
						"예상결과 : 작업자 상해\n" +
						"대책     : Tank에 level gauge 및 alarm 설치\n"); flipper.addView(curView);break;
				case 9 : curView.setText("■HAZOP(Hazard & Operability Review)개요\n" +
						"●영국 IC社에서 화학공정 및 위험물 저장/사용 설비에 적용 목적으로 개발\n" +
						"●방법\n" +
						"7가지 이탈Guide word(No.,Mowe,less,Aswell, Part OF, Recerse, Other Then)를 적용하여 위험요인을 도출하고 평가\n" +
						"●특징\n" +
						"-위험요인 도출 측면에 있어서 객관성 확보\n" +
						"-서류작업 과다\n" +
						"-작업자의 활동 및 보건측면을 포함하지 못함\n" +
						"-변형된 HAZOP 기법(E-HAZOP, M-HAZOP)개발\n"); flipper.addView(curView);break;
				case 10 : curView.setText("■HAZOP 평가절차\n" +
						"●목적, 범위 설정     ●Team 구성\n" +
						"●예비조사\n" +
						"-필요자료(data) 수집/분석\n" +
						"-수집된 data를 토대로 검토 일정 수립\n" +
						"●토론 및 검토       ●결과기록 및 후속조치\n"); flipper.addView(curView);break;
				case 11 : imageView.setImageResource(R.drawable.img4_2_11);mAttacher = new PhotoViewAttacher(imageView);
					mAttacher.setScaleType(ScaleType.FIT_XY);
					flipper.addView(imageView); break;
				case 12 : imageView.setImageResource(R.drawable.img4_2_12);mAttacher = new PhotoViewAttacher(imageView);
					mAttacher.setScaleType(ScaleType.FIT_XY);
					flipper.addView(imageView); break;
				case 13 : imageView.setImageResource(R.drawable.img4_2_13);mAttacher = new PhotoViewAttacher(imageView);
					mAttacher.setScaleType(ScaleType.FIT_XY);
					flipper.addView(imageView); break;
				case 14 : curView.setText("■HAZOP결과기록 및 후속조치(예)\n" +
						"\n" +
						"공정 위험성평가 체제구축 및 사후 관리 :\n" +
						"※공정위험성평가 종합계획 수립, 시행\n" +
						"※사업장 자체적인 위험성평가체제 구축\n" +
						"※주기적인 위험성평가 실시 및 평가결과 사후관리\n" +
						"※위험성 평가팀 구성\n" +
						"※변경요소 관리절차에 의거 위험성 평가 실시\n"); flipper.addView(curView);break;
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
