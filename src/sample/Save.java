package sample;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Save{
	public static void save(Mark mark, PrintWriter printWriter)  {
		

		printWriter.println("Mark=" + mark.getMarkName()+";"+mark.getMark()+";"+mark.getCoefficient() );
		
		
	   
	    
	}
	public static void save (Exam exam, PrintWriter printWriter) {
		printWriter.println("Exam=" + exam.getMarkName() + ";" + exam.getCoefficient());
		ArrayList<Mark> noteTable = exam.getMarkArrayList();
		for(int i =0; i<noteTable.size(); i++) {
			save(noteTable.get(i), printWriter);
		}
		
		
	}

	
}