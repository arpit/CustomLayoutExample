package com.arpitonline.customlayoutmeasuretest.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.arpitonline.customlayoutmeasuretest.R;

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
		cll = (LinearLayout)findViewById(R.id.child_linear_layout);
		Log.d(TAG, "onMeasure: "+widthMeasureSpec+", "+heightMeasureSpec);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		cll.measure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		
		if(changed){
			invalidate();
		}
		
		int itemWidth = (r-l)/getChildCount();
		
		Log.d(TAG, "Child LinearLayout Dimensions: "+cll.getWidth()+", "+cll.getHeight());
		
		for(int i=0; i< this.getChildCount(); i++){
			View v = getChildAt(i);
			v.layout(itemWidth*i, t, (i+1)*itemWidth, b);
		}
		
	}

}
