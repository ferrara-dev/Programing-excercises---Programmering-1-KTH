package obligatoriskUppgift5;
import java.util.*;
public class TestPoly {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Punkt [] arr = new Punkt [] {new Punkt("A",1,1), new Punkt("B",2,4)};
		
		Polylinje poly = new Polylinje(arr);
		poly.setBredd(2);
		poly.setFarg("blå");
		
		System.out.println(poly.langd());
		System.out.println(poly.langd());
		System.out.println(poly.toString());
		int x = in.nextInt();
		int y = in.nextInt();
		in.nextLine();
		String name = in.nextLine();
		poly.laggTillFramfor(new Punkt(name, x, y), "B");
		System.out.println(poly.toString());
	}

}
