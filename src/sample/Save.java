package sample;

import java.io.PrintWriter;
import java.util.ArrayList;


public class Save {


    /*-------METHODS------*/


    //Save a Mark
    public static void save(Mark mark, PrintWriter printWriter) {
        printWriter.println("Mark=" + mark.getMarkName() + ";" + mark.getMark() + ";" + mark.getCoefficient());
    }

    //Save a Subject
    public static void save(Subject subject, PrintWriter printWriter) {
        printWriter.println("Subject=" + subject.getMarkName() + ";" + subject.getCoefficient());
        ArrayList<Mark> markArrayList = subject.getMarkArrayList();
        for (Mark mark : markArrayList) {
            save(mark, printWriter);
        }

    }

    //Save a Module
    public static void save(ModuleInterface moduleInterface, PrintWriter printWriter) {
        printWriter.println("Module=" + moduleInterface.getModule().getMarkName());
        ArrayList<SubjectInterface> subjectInterfaceArrayList = moduleInterface.getSubjectInterfaceArrayList();
        for (SubjectInterface subjectInterface : subjectInterfaceArrayList) {
            save(subjectInterface.getSubject(), printWriter);
        }
    }

    //Save a Semester
    public static void save(SemesterInterface semesterInterface, PrintWriter printWriter) {
        printWriter.print("Semester=" + semesterInterface.getName());
        ArrayList<ModuleInterface> moduleInterfaceArrayList = semesterInterface.getModuleInterfaceArrayList();
        for (ModuleInterface moduleInterface : moduleInterfaceArrayList) {
            save(moduleInterface, printWriter);
        }
    }


}