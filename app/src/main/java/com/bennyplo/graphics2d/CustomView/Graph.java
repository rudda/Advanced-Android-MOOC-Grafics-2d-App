package com.bennyplo.graphics2d.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.view.View;

public class Graph extends View {

    private Path linePath;
    int [] defaultData = {11, 29, 10, 20, 12, 5, 31, 24, 21, 13};

    public Graph(Context context) {
        super(context);
        
        initLineGraph();
    }

    private void initLineGraph() {

        Point points [] = new Point[defaultData.length];
        int min_value = -999999;
        int max_value =  999999;

        for(int i=0; i<defaultData.length; i++){
            points[i] = new Point(i, defaultData[i]);
            min_value = Math.min(min_value, defaultData[i]);
            max_value = Math.max(max_value, defaultData[i]);
        }


    }

    /**
     * method to drawing on screen :)
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }
}
