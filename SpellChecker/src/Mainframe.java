import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Character.isUpperCase;


public class Mainframe {
	
	static ArrayList<String> list = new ArrayList<String>();
	
	public static void find(String f) {
		ArrayList<String> recommendation = fill(f);
		
		String result;
		
		System.out.println(f);
		
		/*

		if(recommendation.get(0).equals("not found"))
		{
			return "not found";
		}
		
		if(!recommendation.get(0).equals("speculation"))
		{
			return recommendation.get(0);
		}
		result = "do you mean: " + "\n" + "\n";
		for(int i = 1; i<recommendation.size(); i++)
		{
			result = result +  "\t" + recommendation.get(i) + "\n";
		}
		return result;*/
	}
	
	public static boolean check(String f)
	{
        for (String aList : list) {
            if (aList.equals(f))
                return true;
            if (aList.equalsIgnoreCase(f)) return isUpperCase(f.charAt(0));
        }
		
		return false;
	}
	
	public static ArrayList<String>fill(String f)
	{
		boolean found = false;
		ArrayList<String> recommendation = new ArrayList<String>();
		recommendation.clear();
		recommendation.add("speculation");
		
		/// quick search of list for match ///

        for (String aList : list) {
            if (aList.equals(f)) {
                recommendation.clear();
                recommendation.add(aList);
                found = true;
                break;
            }
            if (aList.equalsIgnoreCase(f)) {
                if (isUpperCase(f.charAt(0))) {
                    recommendation.clear();
                    recommendation.add(aList);
                    found = true;
                    break;
                } else {
                    recommendation.add(aList);
                    found = true;
                    break;
                }
            }
        }
		
		/// mistake search of list for match ///
		
		for(int i = 0; i<list.size(); i++)
		{
			
		}
		
		/// not found protocol ///
		
		if(!found)
		{
			System.out.println("not found");
			recommendation.set(0,"not found");
		}
        else
        {
            System.out.println("found");
        }
		
		return recommendation;
	}

}
