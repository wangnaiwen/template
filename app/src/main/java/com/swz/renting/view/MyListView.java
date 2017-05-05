package com.swz.renting.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by wnw on 2017/5/4.
 */

public class MyListView extends ListView{

    //重写ListView， 解决ScrollView中嵌套ListView，导致ListView显示不全的问题

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MyListView(Context context) {
        super(context);
    }
    public MyListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
