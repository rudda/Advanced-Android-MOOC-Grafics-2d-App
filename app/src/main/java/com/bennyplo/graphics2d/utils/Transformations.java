package com.bennyplo.graphics2d.utils;

import android.graphics.Point;

public class Transformations {

    public static  Point[] translate (Point input[], int px, int py) {
        double matrix[][]  = new double[3][3];
        matrix[0][0] =1;  matrix[0][1]= 0; matrix[0][2] = px;
        matrix[1][0]= 0;  matrix[1][1]= 1; matrix[1][2] = py;
        matrix[2][0]= 0;  matrix[2][1]= 0; matrix[2][2]= 1;

        return affineTransformation(input, matrix);
    }

    public static Point[] rotate (Point[] input, double theta) {
        double[][] matrix = new double[3][3];
        matrix[0][0] = Math.cos(theta); matrix[0][1] = - Math.sin(theta); matrix[0][2] = 0;
        matrix[1][0] = Math.sin(theta); matrix[1][1] = Math.cos(theta); matrix[1][2] = 0;
        matrix[2][0] = 0; matrix[2][1] = 0; matrix[2][2] = 1;
        return affineTransformation(input, matrix);
    }

    public static Point[] scale (Point[] input, double a, double b) {
        double[][] matrix = new double[3][3];
        matrix[0][0] = a; matrix[0][1] = 0; matrix[0][2] = 0;
        matrix[1][0] = 0; matrix[1][1] = b; matrix[1][2] = 0;
        matrix[2][0] = 0; matrix[2][1] = 0; matrix[2][2] = 1;
        return affineTransformation(input, matrix);
    }

    public static Point[] shear (Point[] input, double c, double d) {
        double[][] matrix = new double[3][3];
        matrix[0][0] = 1; matrix[0][1] = c; matrix[0][2] = 0;
        matrix[1][0] = d; matrix[1][1] = 1; matrix[1][2] = 0;
        matrix[2][0] = 0; matrix[2][1] = 0; matrix[2][2] = 1;
        return affineTransformation(input, matrix);
    }

    public static Point[] affineTransformation(Point[] input, double[][] matrix) {

        Point[] result = new Point[input.length];

        for (int i =0; i< input.length; i++){
            int t= (int) (matrix[0][0] * input[i].x + matrix[0][1] * input[i].y + matrix[0][2] );
            int u= (int) (matrix[1][0] * input[i].x + matrix[1][1] * input[i].y + matrix[1][2] );

            result[i]= new Point(t,u);
        }

        return result;
    }
}
