class nesting
{
	int m,n;
	nesting(int x,int y)
	{
		m=x;n=y;
	}
	int largest()
	{
		if(m>=n)
			return(m);
		else
			return(n);
	}
	void display()
	{
		int large=largest();
		System.out.println("largest value= "+large);
	}
}
class nestingtest
{
	public static void main(String args[])
	{
		nesting nest=new nesting(50,40);
		nest.display();
	}
}