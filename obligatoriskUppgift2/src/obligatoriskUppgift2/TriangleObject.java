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

import static java.lang.Math.sqrt;

import java.awt.geom.Point2D;

public class TriangleObject {
	
	private final double sideA, sideB, sideC;
	
	public TriangleObject(double sideA, double sideB, double sideC) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}
	public static double getPerimeter(TriangleObject obj)
	{
		return  obj.sideA+obj.sideB+obj.sideC;
	}
	public static double getSemiperimeter(TriangleObject obj)
	{
		return  getPerimeter(obj) / 2;
	}
	
	public static double getArea(TriangleObject obj)
	{
		double s = getSemiperimeter(obj);
		return sqrt(s*(s-obj.getSideA())*(s-obj.getSideB())*(s-obj.getSideC()));
	}
	
	public static double getMedian(TriangleObject obj, Side side)
	{
		double aSquare = Math.pow(obj.getSideA(), 2);
		double bSquare = Math.pow(obj.getSideB(), 2);
		double cSquare = Math.pow(obj.getSideC(), 2);
		
		switch(side) 
		{
			case A:
				return sqrt(2*cSquare + 2*bSquare-aSquare)/2;
			case B:
				return sqrt(2 * aSquare + 2 * cSquare - bSquare)/2;
			case C:
				return sqrt(2 * aSquare + 2 * bSquare - cSquare)/2;
			default:
				return 0;
		}
	}
	public static double getInnerRadius(TriangleObject obj)
	{
		double semi = getSemiperimeter(obj);
		double arr = getArea(obj);
		return arr/semi;
	}
	
	public static double getCircumRadius(TriangleObject obj)
	{
		double semi = getSemiperimeter(obj);
		double innerR = getInnerRadius(obj);
		double j = (obj.getSideA()*obj.getSideB()*obj.getSideC());
		return j /(4*innerR*semi);
	}
	public static Point2D getCoordinates(TriangleObject obj, Point point)
	{	
		double x1 = 0;
		double y1 = 0;
		Point2D A = new Point2D.Double(x1, y1);
		
		double x2 = obj.getSideB();
		double y2 = 0;
		Point2D B = new Point2D.Double(x2, y2);
		
		double aSquare = Math.pow(obj.getSideA(), 2);
		double b2 = 2 * obj.getSideB();
		double x3 = (aSquare)/(b2);
		double xSquare = Math.pow(x3, 2);
		double y3 = sqrt(aSquare - xSquare);
		Point2D C = new Point2D.Double(x3, y3);
		
		Point2D Def = new Point2D.Double(0,0);
		
		switch(point) 
		{
		   case AA:
			return A;
		   case BB:
			return B;
		   case CC:
			return C;
		   default:
			return Def;
		}
	}
	
	public double getSideA() 
	{
		return sideA;
	}

	public double getSideB() 
	{
		return sideB;
	}

	public double getSideC() 
	{
		return sideC;
	}
}
