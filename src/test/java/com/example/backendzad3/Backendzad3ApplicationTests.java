package com.example.backendzad3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Backendzad3ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testAddPoint() {
		PointService pointService = new PointService();
		Point point = new Point(1, 2);
		pointService.addPoint(point);
		Point[] points = pointService.getAllPoints();
		assert(points.length == 1);
		assert(points[0].getX() == 1 || points[0].getY() == 2);
	}

	@Test
	void testDeletePoint() {
		PointService pointService = new PointService();
		Point point = new Point(1, 2);
		pointService.addPoint(point);
		pointService.deletePoint(0);
		Point[] points = pointService.getAllPoints();
		assert(points.length == 0);
	}

	@Test
	void testGetAllPoints() {
		PointService pointService = new PointService();
		Point point = new Point(1, 2);
		pointService.addPoint(point);
		Point[] points = pointService.getAllPoints();
		assert(points.length == 1);
		assert(points[0].getX() == 1 || points[0].getY() == 2);

	}

	@Test
	void testGetFirstNPoints() {
		PointService pointService = new PointService();
		Point point = new Point(1, 2);
		pointService.addPoint(point);
		Point[] points = pointService.getFirstNPoints(1);
		assert(points.length == 1);
		assert(points[0].getX() == 1 || points[0].getY() == 2);

	}

	@Test
	void testGetDistance() {
		PointService pointService = new PointService();
		double distance = pointService.getDistance(1, 2, 3, 4);
		assert(distance == 2.8284271247461903);
	}




}
