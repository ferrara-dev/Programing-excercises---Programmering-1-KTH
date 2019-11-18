package A;
/*
En punkt i planet har sitt namn och sina koordinater. Punktens koordinater �r hela tal.
En punkt kan best�mmas med ett namn och tv� heltalskoordinater. Det g�r �ven att best�mma en punkt utifr�n en annan
punkt � en kopia kan skapas.
Man kan skapa en teckenstr�ng som representerar en punkt. Denna teckenstr�ng kan vara p� formen (A 3 4). En punkts
namn och koordinater kan erh�llas. Koordinaterna kan �ndras, en koordinat i taget. Avst�ndet mellan tv� givna punkter kan
best�mmas. Man kan kontrollera huruvida tv� givna punkter �r likadana eller inte.
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
