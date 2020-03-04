package com.bennyplo.graphics2d;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.bennyplo.graphics2d.CustomView.Graph;

public class MainActivity extends AppCompatActivity {
    private MyView mMyView=null;//a custom view for drawing
    private Graph graphView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //replace the view with my custom designed view

        mMyView=new MyView(this);
        graphView = new Graph(this);

        //setContentView(mMyView);
        setContentView(graphView);
    }

}
