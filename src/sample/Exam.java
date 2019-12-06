package sample;

import java.util.ArrayList;
import java.util.Vector;

public class Exam extends Mark{

    private ArrayList<Mark> marks = new ArrayList<Mark>();

    public Exam(ArrayList<Mark> marks) {
        this.marks = marks;
    }

    public Exam(String markName, double mark, double coefficient, ArrayList<Mark> marks) {
        super(markName, mark, coefficient);
        this.marks = marks;
    }

    public Exam(String markName, double rawMark, int markLanguage, double coefficient, ArrayList<Mark> marks) {
        super(markName, rawMark, markLanguage, coefficient);
        this.marks = marks;
    }
}
