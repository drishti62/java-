class workingdays
{
	enum days
	{
		sunday ,
		monday,
		tuesday,
		wednesday,
		thursday,
		friday,
		saturday;
	}
	public static void main(String args[])
	{
		for(days d:days.values())
		{
			weekend(d);
		}
	}
	private static void weekend(days d)
	{
		if(d.equals(days.sunday))
			System.out.println("value ="+d+" is a holiday");
		else
			System.out.println("value ="+d+"is a working day");
	}
}