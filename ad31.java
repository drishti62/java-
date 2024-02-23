class room
{
	float length,breadth;
	room(float x,float y)
	{
		length=x;
		breadth=y;
	}
	room(float x)
	{
		length=breadth=x;
	}
	int area()
	{
		return(length * breadth);
	}
}
class mathoperation
{
	static float mul(float x,float y)
	{
		return x*y;
	}
	static float divide(float x,float y)
	{
		return x/y;
	}
}
class mathapplication
{
	public static void main(String args[ ])
	{
		float a=mathoperation.mul(4.0,5.0);
		float b=mathoperation.divide(a,2,0);
		System.out.println("b=" +b);
	}
}