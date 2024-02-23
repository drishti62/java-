import java.util.*;

class FormatDemo6
{
	public static void main(String args[])
	{
		Formatter fmt=new Formatter();
		Calendar cal=Calendar.getInstance();
		fmt.format(" today is day %te of %<tB,%<tY",cal);
		System.out.println(fmt);
		fmt.close();
}}