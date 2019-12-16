package sample;

import java.io.PrintWriter;
import java.util.ArrayList;


public class Save {


    /*-------METHODS------*/


    //Save a Mark
    public static void save(Mark mark, PrintWriter printWriter) {
        printWriter.println("Mark=" + mark.getMarkName() + ";" + mark.getMark() + ";" + mark.getCoefficient());
    }

    //Save a Exam
    public static void save(Exam exam, PrintWriter printWriter) {
        printWriter.println("Exam=" + exam.getMarkName() + ";" + exam.getCoefficient());
        ArrayList<Mark> markArrayList = exam.getMarkArrayList();
        for (Mark mark : markArrayList) {
            save(mark, printWriter);
        }

    }

    //Save a Subject
    public static void save(SubjectInterface subjectInterface, PrintWriter printWriter) {
        printWriter.println("Subject=" + subjectInterface.getSubject().getMarkName());
        ArrayList<ExamInterface> examInterfaceArrayList = subjectInterface.getExamInterfaceArrayList();
        for (ExamInterface examInterface : examInterfaceArrayList) {
            save(examInterface.getExam(), printWriter);
        }
    }

    //Save a Semester
    public static void save(SemesterInterface semesterInterface, PrintWriter printWriter) {
        printWriter.print("Semester=" + semesterInterface.getName());
        ArrayList<SubjectInterface> subjectInterfaceArrayList = semesterInterface.getSubjectInterfaceArrayList();
        for (SubjectInterface subjectInterface : subjectInterfaceArrayList) {
            save(subjectInterface, printWriter);
        }
    }


}