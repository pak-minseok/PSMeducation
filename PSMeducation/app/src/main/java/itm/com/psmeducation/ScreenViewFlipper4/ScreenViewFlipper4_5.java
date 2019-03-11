package itm.com.psmeducation.ScreenViewFlipper4;

import uk.co.senab.photoview.PhotoViewAttacher;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

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
public class ScreenViewFlipper4_5 extends LinearLayout implements OnTouchListener {
	PhotoViewAttacher mAttacher;
	ImageView m_imageView;

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


	public ScreenViewFlipper4_5(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper4_5(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview4_5, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout4_5);
		flipper = (ViewFlipper) findViewById(R.id.flipper4_5);
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
			ImageView m_imageView = new ImageView(context);

			switch (i) {
				case 0 : curView.setText("■개요\n" +
						"회사내의 제조설비에 대한 점검·정비 또는 설비의 이전·신규설치 작업시 안전에 관한 필요한 사항을 규정하여 작업자의 안전·보건을 확보하기 위한 절차이다.\n"); flipper.addView(curView);break;
				case 1 : curView.setText("■내용\n" +
						"●적용범위\n" +
						"유해위험요소가 잠재되어 있는 공장내에서 시운전 또는 운전중 점검, 정비 또는 변경, 설비의 이전 신규설치 및 공정중 위험요소를 포함하는 작업을 수행할 때 작업자 및 설비를 보호하기위하여 사전에 취하여야 할 제반 안전조치를 하여야 할 작업\n" +
						"●용어의 정의\n" +
						"-작업 신청(시행)팀:작업장내의 보수 및 수리작업을 의뢰 또는 주관하는 부서\n" +
						"-작업허가 승인팀:작업허가서를 최종승인하는 부서\n" +
						"-작업 현장팀:작업이 수행될 팀에 작업 내용 및 시기를 통보\n" +
						"●작업절차\n" +
						"-작업계획 수립\n" +
						"실시하고자 하는 작업의 범위 및 방법등에 관한 계획 수립\n" +
						"-작업허가 의뢰\n" +
						"안전작업 의뢰서에 내용 기재후 전자결재로 작업의뢰\n" +
						"-작업허가 승인\n" +
						"작업내용의 검토 및 안전조치사항 확인 후 승인\n" +
						"-작업유형\n" +
						"화기작업/전기차단작업/제한공간 출입작업/고소작업/굴착작업/중량물취급작업/방사능취급작업/기타작업\n"); flipper.addView(curView);break;
				case 2 : m_imageView.setImageResource(R.drawable.img4_5_2);
					mAttacher = new PhotoViewAttacher(m_imageView);
					mAttacher.setScaleType(ScaleType.FIT_XY);
					flipper.addView(m_imageView); break;

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
