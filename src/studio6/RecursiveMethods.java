package studio6;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		if (n==0) {
			return 0.0;
		} else {
			double sum = 1/Math.pow(2, n) + geometricSum(n-1);
			return sum;
		}
	}

	
	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius, double radiusMinimumDrawingThreshold) {
		StdDraw.setPenColor(Color.BLACK);
		if (radius<= radiusMinimumDrawingThreshold) {
			return;
		}
		StdDraw.circle(xCenter, yCenter, radius);
		StdDraw.pause(10);
		circlesUponCircles(xCenter, yCenter+radius, radius/3,radiusMinimumDrawingThreshold);
		circlesUponCircles(xCenter, yCenter-radius, radius/3,radiusMinimumDrawingThreshold);
		circlesUponCircles(xCenter+radius, yCenter, radius/3,radiusMinimumDrawingThreshold);
		circlesUponCircles(xCenter-radius, yCenter, radius/3,radiusMinimumDrawingThreshold);
	}
	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversedHelper(int[] array,int i, int[] newArray) {
		if (i==array.length) {
			return newArray;
		} else {
			newArray[i] = array[array.length -1 -i];
			return (toReversedHelper(array,i+1,newArray));
		}
	}
	public static int[] toReversed(int[] array) {
		int i=0;
		return toReversedHelper(array,i,new int[array.length]);
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		if (p%q ==0) {
			return q;
		} else {
			return gcd(q,p%q);
		}
		
	}


}