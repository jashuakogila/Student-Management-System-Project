package servlet;

public class Number_or_String {

	public static boolean isnumberornot(String s) {
		boolean status =false;
	for(int i=0;i<s.length();i++)
	{
		if(Character.isDigit(s.charAt(i))==true)
		{
			status=true;
		}
	}
	return status;
	}
}
