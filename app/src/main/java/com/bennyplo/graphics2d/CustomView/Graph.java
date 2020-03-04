package com.bennyplo.graphics2d.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.Log;
import android.view.View;

import com.bennyplo.graphics2d.utils.Transformations;
import com.bennyplo.graphics2d.utils.Utils;

public class Graph extends View {

    private Path linePath;
    int [] defaultData = {11, 29, 10, 20, 12, 5, 31, 24, 21, 13};
    private Paint redPaint;


    public Graph(Context context) {
        super(context);

        redPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        redPaint.setStyle(Paint.Style.STROKE);//stroke only no fill
        redPaint.setColor(0xffff0000);//color red
        redPaint.setStrokeWidth(5);//set the line stroke width to 5

        int w = Utils.getScreenWidth(context), h = Utils.getScreenHeight(context) -70;
        Log.i("[values]", "height: " +h + " width: " + w );

        this.linePath = initLineGraph(w, h);
    }


    private Path initLineGraph(int width, int height) {

        Point points [] = new Point[defaultData.length];
        int min_value = 0;
        int max_value = 0;

        // whats the propose for that?
        for(int i=0; i<defaultData.length; i++){

            points[i] = new Point(i, defaultData[i]);
            min_value = Math.min(min_value, defaultData[i]);
            max_value = Math.max(max_value, defaultData[i]);

            Log.i( "[values]" , "min: " + min_value + " max: "  + max_value);

        }


        points = Transformations.translate(points, 0, min_value);
        double yscale = height / (double)(max_value - min_value);
        double xscale = width / (double) (points.length -1);

        points = Transformations.scale(points, xscale, yscale);
        Path result= new Path();
        result.moveTo(points[0].x, points[0].y);

        for(int i =1; i< points.length; i++ ){
            result.lineTo(points[i].x, points[i].y);
        }

        return result;

    }

    /**
     * method to drawing on screen :)
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.linePath, redPaint);
    }
}
