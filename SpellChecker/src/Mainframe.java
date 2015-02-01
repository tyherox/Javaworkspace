import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Mainframe {
	
	static ArrayList<String> list = new ArrayList<String>();
	
	public static int intialize() throws IOException
	{
		int counter = 0;
		File file = new File("src/Vocab/WordsEn.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine()) != null) {
		   System.out.println(line);
		   list.add(line);
		   counter++;
		}
		br.close();
		
		return counter;
	}
	
	public static String find(String f)
	{
		for(int i = 0; i<list.size(); i++)
		{
			if(list.get(i).equals(f))
			{
				return list.get(i);
			}
		}
		return "not found";
	}

}
