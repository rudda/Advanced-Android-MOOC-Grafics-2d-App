package com.bennyplo.graphics2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.view.View;

import com.bennyplo.graphics2d.utils.Transformations;
import com.bennyplo.graphics2d.utils.Utils;

/**
 * Created by benlo on 09/05/2018.
 */

public class MyView extends View {

    private Paint redPaint;
    private Paint bluePaint;

    Point[] points = new Point[5];
    Path mlines = new Path();

    public void init() {

        points[0] = new Point(50, 300);
        points[1] = new Point(150, 400);
        points[2] = new Point(180, 340);
        points[3] = new Point(240, 420);
        points[4] = new Point(300, 200);

        mlines = new Path();
        mlines.moveTo(50,300);
        mlines.lineTo(150,400);
        mlines.lineTo(180,340);
        mlines.lineTo(240,420);
        mlines.lineTo(300,200);

        mlines.close();


    }

    public MyView(Context context) {
        super(context, null);
        init();
        //Add your initialisation code here
        redPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        redPaint.setStyle(Paint.Style.STROKE);//stroke only no fill
        redPaint.setColor(0xffff0000);//color red
        redPaint.setStrokeWidth(5);//set the line stroke width to 5

        bluePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        bluePaint.setStyle(Paint.Style.STROKE);//stroke only no fill
        bluePaint.setColor(Color.BLUE);//color red
        bluePaint.setStrokeWidth(5);//set the line stroke width to 5


    }

    public void updatePath(Point[] newPoints){
        mlines.reset();
        mlines.moveTo(newPoints[0].x,newPoints[0].y);

        for (int i = 1; i < newPoints.length; i++)
            mlines.lineTo(newPoints[i].x, newPoints[i].y);

        mlines.close();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //Add your drawing code here
        //canvas.drawRect(500,500,700,700,redPaint);
        //canvas.drawCircle(300,300,250, bluePaint);
        //canvas.drawCircle(600,600,185, bluePaint);


         canvas.drawPath(mlines, redPaint);
         Point[] npoints = Transformations.translate(points, 20, 40);
         updatePath(npoints);
         canvas.drawPath(mlines, bluePaint);

    }
}
