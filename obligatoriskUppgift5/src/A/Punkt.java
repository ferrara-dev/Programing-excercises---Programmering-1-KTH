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
public class Punkt 
{
	static int x;
	static int y;
	static String namn;
	
	public Punkt(String namn, int x, int y) 
	{
		this.x= x;
		this.y = y;
		this.namn = namn;
	}
	public void setA(String aChar)
	{
		namn = aChar;
	}
	public String getNamn()
	{
		return namn;
	}
	public void setX(int x1)
	{
		x=x1;
	}
	
	public int getX() 
	{
		return x;
	}

	public void getY(int y1)
	{
		y=y1;
	}
	
	public int getY() 
	{
		return y;
	}
	
	public double avstand(Punkt p2) 
	{
		return 0;
	}
}
