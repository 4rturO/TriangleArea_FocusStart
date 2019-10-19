package triangleArea;

public class Triangle {

	private final Point A;
	private final Point B;
	private final Point C;
	
	public Triangle( Point A, Point B, Point C )	//создание треугольника через точки
	{
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	public Triangle( String[] str )	//создание треугольника через строку с координатами
	{
		if (str.length == 6)
		{
			this.A = new Point( Integer.parseInt(str[0]), Integer.parseInt(str[1]) );
			this.B = new Point( Integer.parseInt(str[2]), Integer.parseInt(str[3]) );
			this.C = new Point( Integer.parseInt(str[4]), Integer.parseInt(str[5]) );
		}
		else
		{
			throw new IllegalArgumentException("Illegal string length");	//ошибка если переданная строка имеет длину, отличную от 6
		}
	}
	
	public Triangle( String str )	//создание треугольника через строку с координатами
	{
		String str_array[];
		str_array = str.split(" ");		
		if (str_array.length == 6)
		{
			this.A = new Point( Integer.parseInt(str_array[0]), Integer.parseInt(str_array[1]) );
			this.B = new Point( Integer.parseInt(str_array[2]), Integer.parseInt(str_array[3]) );
			this.C = new Point( Integer.parseInt(str_array[4]), Integer.parseInt(str_array[5]) );
		}
		else
		{
			throw new IllegalArgumentException("Illegal string length");	//ошибка если переданная строка имеет длину, отличную от 6
		}
	}
	
	public Triangle()	//создание треугольника через строку с координатами
	{
		this.A = new Point( 0, 0 );
		this.B = new Point( 0, 0 );
		this.C = new Point( 0, 0 );
	}
	
	public Point getPointA()
	{
		return A;
	}
	
	public Point getPointB()
	{
		return B;
	}
	
	public Point getPointC()
	{
		return C;
	}
	
	public boolean IsoscelesCheck()	//проверка на равноберденность. 
	{
		Side a = new Side(B,C);
		Side b = new Side(A,C);
		Side c = new Side(A,B);
		
		if ( a.equals(b) || a.equals(c) || b.equals(c) )
		{
			return true;
		}
		
		return false;
	}
	
	public double getArea()
	{
		return Math.abs( (A.getX() - C.getX()) * (B.getY() - C.getY()) - (B.getX() - C.getX()) * (A.getY() - C.getY()) ) / 2.0;
	}
	
	@Override
	public String toString()
	{
		return  A + " " + B + " "  + C;
	}
}
