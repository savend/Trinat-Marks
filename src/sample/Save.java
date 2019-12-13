package sample;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Save{
	public static void save(Mark mark, PrintWriter printWriter)  {
		

		printWriter.println("Mark=" + mark.getMarkName()+";"+mark.getMark()+";"+mark.getCoefficient() );
		
		
	   
	    
	}
	public static void save (Exam exam, PrintWriter printWriter) {
		printWriter.println("Exam=" + exam.getMarkName() + ";" + exam.getCoefficient());
        ArrayList<Mark> markArrayList = exam.getMarkArrayList();
        for (int i = 0; i < markArrayList.size(); i++) {
            save(markArrayList.get(i), printWriter);
        }

    }

    public static void save(SubjectInterface subjectInterface, PrintWriter printWriter) {
        printWriter.println("Subject=" + subjectInterface.getSubject().getMarkName() + ";" + subjectInterface.getSubject().getCoefficient());
        ArrayList<ExamInterface> examInterfaceArrayList = subjectInterface.getExamInterfaceArrayList();
        for (ExamInterface examInterface : examInterfaceArrayList) {
            save(examInterface.getExam(), printWriter);
        }
    }

    public static void save(SemesterInterface semesterInterface, PrintWriter printWriter) {
        printWriter.println("Semester=" + 1);
        ArrayList<SubjectInterface> subjectInterfaceArrayList = semesterInterface.getSubjectInterfaceArrayList();
        for (SubjectInterface subjectInterface : subjectInterfaceArrayList) {
            save(subjectInterface, printWriter);
        }
    }

	
}