import java.util.*;
class Gregoriancalendardemo
{
	public static void main(String args[])
	{
		String months[]={"jan","feb","march","april","may","jun","july","aug","sep","oct","nov","dec"};
		int year;
		GregorianCalendar gcal=new GregorianCalendar();
		System.out.println("date =");
		System.out.println(months[gcal.get(Calendar.MONTH)]);
		System.out.println(" "+gcal.get(Calendar.DATE)+" ");
		System.out.println(year=gcal.get(Calendar.YEAR));
		
		System.out.println("time =");
		System.out.println(gcal.get(Calendar.HOUR)+ " :");	
		System.out.println(gcal.get(Calendar.MINUTE)+ " :");	
		System.out.println(gcal.get(Calendar.SECOND)+ " :");

		if(gcal.isLeapYear(year))
			System.out.println("the current year is leap year");
		else
			System.out.println("the current year is not leap year");
	
	}
}