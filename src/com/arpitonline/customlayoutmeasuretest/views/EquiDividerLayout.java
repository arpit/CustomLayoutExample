package com.arpitonline.customlayoutmeasuretest.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class EquiDividerLayout extends ViewGroup {
	
	private static final String TAG = "CustomLayout";
	private LinearLayout cll ;
	
	public EquiDividerLayout(Context context){
		super(context);
		init();
	}
	
	public EquiDividerLayout(Context context, AttributeSet attrs){
		super(context, attrs);
		init();
	}
	
	public EquiDividerLayout(Context context, AttributeSet attrs, int defStyle){
		super(context, attrs, defStyle);
		init();
	}
	
	private void init(){
		
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
		
//		At this time we need to call setMeasuredDimensions(). Lets just call the 
//		parent View's method (see https://github.com/android/platform_frameworks_base/blob/master/core/java/android/view/View.java) 
//		that does:
//		setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
//                getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
//		
		
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		

		int wspec = MeasureSpec.makeMeasureSpec(getMeasuredWidth()/getChildCount(), MeasureSpec.EXACTLY);
		int hspec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), MeasureSpec.EXACTLY);
		
		
		for(int i=0; i<getChildCount(); i++){
			View v = getChildAt(i);
			Log.d(TAG, "Measured Width / Height: "+getMeasuredWidth()+", "+getMeasuredHeight());			
			
			
			v.measure(wspec, hspec);
		}
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		int itemWidth = (r-l)/getChildCount();
		for(int i=0; i< this.getChildCount(); i++){
			View v = getChildAt(i);
			v.layout(itemWidth*i, t, (i+1)*itemWidth, b);
		}
		
	}

}
