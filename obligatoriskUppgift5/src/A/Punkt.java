package A;
/*
En punkt i planet har sitt namn och sina koordinater. Punktens koordinater är hela tal.
En punkt kan bestämmas med ett namn och två heltalskoordinater. Det går även att bestämma en punkt utifrån en annan
punkt – en kopia kan skapas.
Man kan skapa en teckensträng som representerar en punkt. Denna teckensträng kan vara på formen (A 3 4). En punkts
namn och koordinater kan erhållas. Koordinaterna kan ändras, en koordinat i taget. Avståndet mellan två givna punkter kan
bestämmas. Man kan kontrollera huruvida två givna punkter är likadana eller inte.
En modell av en punkt i planet ska skapas: man ska skapa en definitionsklass som heter Punkt. 
 */
package obligatoriskUppgift5;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

//from   w w  w . j  a v a 2s .  c o m
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class Punkt 
{
	private String name;
	private int x;
	private int y;


	public Punkt(String name, int x, int y)
	{
		this.name = name;
		this.x = x;
		this.y = y;
		
	}
	
	public Punkt(Punkt p1) {
		this.name = p1.name;
		this.x = p1.x;
		this.y = p1.y;
	}
	

	
	public  void setNamn(String name)
	{
		this.name = name;
	}
	
	public  String getNamn()
	{
		return name;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getY()
	{
		return y;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getX()
	{
		return x;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punkt other = (Punkt) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
	
	@Override
	public String toString() {
		return "(" + name + ", " + x + ", " + y + ")";
	}

	public double distance(Punkt p)
	{
		return Math.sqrt(Math.pow((x-p.x) ,2) + Math.pow((y-p.y), 2));
	}
	
	public double distanceFromOrigo()
	{
		return distance(this);
	}
	
	 public void draw(Graphics2D g) {
		 g.drawString(getNamn(), getX()+1, getY()+1);
         g.drawOval(getX(), getY(), 10, 10);
     }
	 
	 
}

