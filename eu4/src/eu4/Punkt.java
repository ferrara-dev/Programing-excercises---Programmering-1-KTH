package eu4;

public class Punkt 
{
	String name;
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
	

	
	/*public  void setNamn(String name)
	{
		this.name = name;
	}*/
	public void setNamn(String name) 
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

	 
}
