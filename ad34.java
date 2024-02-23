import java.util.Calendar;
class calendardemo
{
	public static void main(String args[])
	{
		String months[]={"jan","feb","march","april","may","jun","july","aug","sep","oct","nov","dec"};
		Calendar cal=Calendar.getInstance();
		System.out.println("date =");
		System.out.println(months[cal.get(Calendar.MONTH)]);
		System.out.println(" "+cal.get(Calendar.DATE)+" ");
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println("time =");
		System.out.println(cal.get(Calendar.HOUR)+ " :");	
		System.out.println(cal.get(Calendar.MINUTE)+ " :");	
		System.out.println(cal.get(Calendar.SECOND)+ " :");	

		cal.set(Calendar.HOUR,10);
		cal.set(Calendar.MINUTE,29);
		cal.set(Calendar.SECOND,22);
		System.out.println(" update time =");	
		System.out.println(cal.get(Calendar.HOUR)+ " :");		
		System.out.println(cal.get(Calendar.MINUTE)+ " :");	
		System.out.println(cal.get(Calendar.SECOND)+ " :");	
	}
}