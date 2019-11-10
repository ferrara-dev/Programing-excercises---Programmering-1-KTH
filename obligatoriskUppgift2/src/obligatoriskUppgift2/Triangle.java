/*
 * Author: Samuel Ferrara
 * Date
 */



/**********************************************UPPGIFTSBESKRIVNING ********************************************************
  
  En klass Triangel ska skapas: klassen ska innehålla flera statiska metoder som utför olika beräkningar i samband med en
  triangel. En metod tar emot vissa uppgifter, och beräknar och returnerar någon annan uppgift. Till exempel kan en metod 
  ta emot längden av en triangels sida och längden av motsvarande höjd, och returnera triangelns area. En annan metod kan 
  ta emot längderna av alla tre sidorna, och returnera antingen triangelns omkrets, dess area, en av triangelns medianer 
  eller bisektriser, eller något annat.
 **************************************************************************************************************************/



package obligatorisk2;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.geom.Point2D.Double;

import static java.lang.Math.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.util.*;
public class Triangle 
{
	public static double a;
	public static double b;
	public static double c;
	public static double x;
	public static double y;
	public static double perimeter;
	public static double semiPeri;
	public static double area;
	public static Point2D A; 
	public static Point2D B;
	public static Point2D C; 
	public static Point2D CoG;
	public static double medianA;
	public static double medianB;
	public static double medianC;
	/*static double X1;
	static double Y1;
	static double X2;
	static double Y2;
	static double X3;
	static double Y3;
	static double xCoG;
	static double yCoG;
	*/
	
	public Triangle()
	{
		
	}
	public void setSideA(double sideA)
	{
		a=sideA;
		
	}
	
	public double getSideA()
	{
		return a;
	}
	
	public void setSideB(double sideB)
	{
		b=sideB;
	}
	
	public double getSideB()
	{
		return b;
	}
	
	public void setSideC(double sideC)
	{
		
		c=sideC;
	}
	
	public double getSideC()
	{
		return c;
	}

	public static double getPerimeter()
	{
		perimeter = a+b+c;
		return perimeter;
	}
	
	public static double getSemiperimeter()
	{
		double s =  (a+b+c) / 2;
		semiPeri = s;
		return semiPeri;
	}
	/*************************************************************
	 		* Return triangle area *
		Calculates and returns the area using herons formula 
	**************************************************************/
	public static double getArea()
	{
		double s =  (a+b+c) / 2;
		area = sqrt(s*(s-a)*(s-b)*(s-c));
		return area;
	}

	public static double getMedianA()
	{
		double aSquare = Math.pow(a, 2);
		double bSquare = Math.pow(b, 2);
		double cSquare = Math.pow(c, 2);
		double medA = sqrt(2*cSquare + 2*bSquare-aSquare)/2;
		medianA = medA;
		return medianA;
	}
	
	public static double getMedianB()
	{
		double aSquare = Math.pow(a, 2);
		double bSquare = Math.pow(b, 2);
		double cSquare = Math.pow(c, 2);
		double medB = sqrt(2 * aSquare + 2 * cSquare - bSquare)/2;
		medianB = medB;
		return medianB;
		
	}
	public static double getMedianC()
	{
		double aSquare = Math.pow(a, 2);
		double bSquare = Math.pow(b, 2);
		double cSquare = Math.pow(c, 2);
		double medC = sqrt(2 * aSquare + 2 * bSquare - cSquare)/2;
		medianC = medC;
		return medianC;
		
	}

}


