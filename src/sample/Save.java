package sample;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.IOException;
/* Still don't know how to get acces on the object mark to get his Informations
 * like Markname, mark and coefficient
 */


public class Save{
	public static void save(Mark mark)  {
		
		mark.getMarkName();
		FileWriter fileWriter;
		PrintWriter printWriter;
		try {
			fileWriter = new FileWriter("data.txt");
			printWriter = new PrintWriter(fileWriter);
			printWriter.print(mark.getMarkName()+";"+mark.getMark()+";"+mark.getCoefficient() );
			
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	  
	   // printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
	    
	}

	
}