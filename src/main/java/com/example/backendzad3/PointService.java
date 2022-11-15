package com.example.backendzad3;

import org.springframework.stereotype.Service;

@Service
public class PointService {

    private Point[] points = new Point[0];

    public void addPoint(Point point){
        Point[] newPoints = new Point[points.length + 1];
        System.arraycopy(points, 0, newPoints, 0, points.length);
        newPoints[newPoints.length - 1] = point;
        points = newPoints;
    }

    public Point[] deletePoint(int id){
        Point[] newPoints = new Point[points.length - 1];
        int j = 0;
        for (int i = 0; i < points.length; i++){
            if ( i != id){
                newPoints[j] = points[i];
                j++;
            }
        }
        points = newPoints;
        return points;
    }

    public Point[] getAllPoints(){
        return points;
    }

    public Point[] getFirstNPoints(int n){
        Point[] newPoints = new Point[n];
        System.arraycopy(points, 0, newPoints, 0, n);
        return newPoints;
    }

    public double getDistance(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
