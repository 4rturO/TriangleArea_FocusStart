package triangleArea;

public class Side {

	private final Point A;
	private final Point B;
	
	public Side( Point A, Point B)
	{
		this.A = A;
		this.B = B;
	}
	
	public Point getPointA()
	{
		return A;
	}
	
	public Point getPointB()
	{
		return B;
	}
	
	public double getLength()
	{
		return Math.sqrt( Math.pow( (A.getX() - B.getX()) , 2 ) + Math.pow( (A.getY() - B.getY()) , 2 )  );
	}
	
	@Override
	public boolean equals( Object obj )
	{
		if (obj == this) 
		{
	        return true;
	    }
		
	    if (obj == null || obj.getClass() != this.getClass()) 
	    {
	        return false;
	    }
	    
	    Side secondSide = (Side)obj;
	    double eps = 0.00001;
	    if( Math.abs( this.getLength() - secondSide.getLength() ) < eps )
	    {
	    	return true;
	    }
	    
	    return false;
	}
	
	@Override
	public String toString()
	{
		return "Side(" + A + "," + B + ")";
	}
}
