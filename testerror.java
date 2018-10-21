import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;


public class testerror
{
	public static void main(String[] args)
	{	
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<Date>list=new ArrayList<>(10);
		for(int cnt1=0;cnt1<10;cnt1++)
			{
				try
					{
						Date date=dateformat.parse("09-12");
						list.add(date);
					}
						catch(ParseException e)
						{
							e.printStackTrace();
						}
	
			}
				
		SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<Date>list1=new ArrayList<>(10);
		try
		{
			for(int cnt1=0;cnt1<10;cnt1++)
				{
					Date date=dateformat1.parse("10-13");
					list1.add(date);
				}
		}		
			catch(ParseException e)
				{
					e.printStackTrace();
				}
	
			
	}

}

/*输出如下
java.text.ParseException: Unparseable date: "09-12"
        at java.base/java.text.DateFormat.parse(Unknown Source)
        at test.main(test.java:16)
java.text.ParseException: Unparseable date: "09-12"
        at java.base/java.text.DateFormat.parse(Unknown Source)
        at test.main(test.java:16)
java.text.ParseException: Unparseable date: "09-12"
        at java.base/java.text.DateFormat.parse(Unknown Source)
        at test.main(test.java:16)
java.text.ParseException: Unparseable date: "09-12"
        at java.base/java.text.DateFormat.parse(Unknown Source)
        at test.main(test.java:16)
java.text.ParseException: Unparseable date: "09-12"
        at java.base/java.text.DateFormat.parse(Unknown Source)
        at test.main(test.java:16)
java.text.ParseException: Unparseable date: "09-12"
        at java.base/java.text.DateFormat.parse(Unknown Source)
        at test.main(test.java:16)
java.text.ParseException: Unparseable date: "09-12"
        at java.base/java.text.DateFormat.parse(Unknown Source)
        at test.main(test.java:16)
java.text.ParseException: Unparseable date: "09-12"
        at java.base/java.text.DateFormat.parse(Unknown Source)
        at test.main(test.java:16)
java.text.ParseException: Unparseable date: "09-12"
        at java.base/java.text.DateFormat.parse(Unknown Source)
        at test.main(test.java:16)
java.text.ParseException: Unparseable date: "09-12"
        at java.base/java.text.DateFormat.parse(Unknown Source)
        at test.main(test.java:16)
		
		
java.text.ParseException: Unparseable date: "10-13"
        at java.base/java.text.DateFormat.parse(Unknown Source)
        at test.main(test.java:35)
结论：异常在循环中catch应该写在循环外，否则会循环执行catch
		*/













