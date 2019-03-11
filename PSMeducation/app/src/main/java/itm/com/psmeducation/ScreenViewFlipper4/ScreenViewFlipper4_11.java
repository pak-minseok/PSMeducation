package itm.com.psmeducation.ScreenViewFlipper4;

import itm.com.psmeducation.R;

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

/**
 * ScreenView Flipper
 *
 * @author Mike
 */
public class ScreenViewFlipper4_11 extends LinearLayout implements OnTouchListener {
	PhotoViewAttacher mAttacher;
	ImageView m_imageView;

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


	public ScreenViewFlipper4_11(Context context) {
		super(context);

		init(context);
	}

	public ScreenViewFlipper4_11(Context context, AttributeSet attrs) {
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
		inflater.inflate(R.layout.screenview4_11, this, true);

		buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout4_11);
		flipper = (ViewFlipper) findViewById(R.id.flipper4_11);
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
						"공정의 운전중 발생한 사고의 조사 및 보고를 통해 사고의 근본 원인분석 및 문제점을 규명하여 개선대책을 수립/실시함으로써, 동종 또는 유사사고의 재발을 방지하는 절차이다.\n");flipper.addView(curView);break;
				case 1 : curView.setText("■내용\n" +
						"●적용범위 \n" +
						"공정에서 발생한 화재, 폭발, 유독가스누출 및 업무와 관련하여 발생한 인적, 물적사고와 아차사고등에 적용한다.\n" +
						"●공정사고조사 관련사항\n" +
						"고정사고는 사고의 등급(A,B,C,D)급에 따라 보고체계를 구성하며, 사고와 관련된 개선대책을 수립/시행한다.\n"); flipper.addView(curView);break;
				case 2 :m_imageView.setImageResource(R.drawable.img4_11_3);
					mAttacher = new PhotoViewAttacher(m_imageView);
					mAttacher.setScaleType(ScaleType.FIT_XY);
					flipper.addView(m_imageView); break;
				case 3 : curView.setText("■업무 추진사항\n" +
						"\n" +
						"정확한 사고 원인 규명 및 재방 방지:\n" +
						"※앗차사고(공정사고)를 포함하여 사고원인 조사 수행\n"); flipper.addView(curView);break;


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
