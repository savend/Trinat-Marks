package sample;

import java.util.ArrayList;

public class Exam extends Mark {

    //Arraylist to stock the marks
    protected ArrayList<Mark> markArrayList = new ArrayList<>();


    /*------CONSTRUCTORS-----*/

    //Default constructor *NoName* *best Mark* *Coefficient 0*
    public Exam() {
        super();
    }

    //Constructor to initialise a new Exam only with a Name
    public Exam(String markName) {
        super(markName, 0, 1);
    }

    //Constructor to force construction of french average Exam
    public Exam(String markName, double mark, double coefficient, ArrayList<Mark> marks) {
        super(markName, mark, coefficient);
        this.markArrayList = marks;
    }

    //Constructor to force construction of Exam
    public Exam(String markName, double rawMark, int markLanguage, double coefficient, ArrayList<Mark> marks) {
        super(markName, rawMark, markLanguage, coefficient);
        this.markArrayList = marks;
    }


    /*-----GETTER & SETTER-----*/


    public ArrayList<Mark> getMarkArrayList() {
        return markArrayList;
    }

    public void setMarkArrayList(ArrayList<Mark> markArrayList) {
        this.markArrayList = markArrayList;
    }

    @Override
    public double getMark() {
        average();
        return super.getMark();

    }

    /*-----PRINT-----*/


    @Override
    public String toString() {
        return "Exam{" +
                "markArrayList=" + markArrayList +
                "average=" + this.getMark() +
                '}';
    }


    /*------METHODS------*/


    //Method to add a mark to the Exam
    public void addMark(Mark mark) {
        this.markArrayList.add(mark);
        this.average();
        System.out.println(this.markArrayList.get(this.markArrayList.size() - 1).toString());
    }

    //Method to calculate average of the exam et update the local mark
    public void average() {

        double total = 0;
        for (Mark mark : markArrayList) {
            total += (mark.getMark() * mark.getCoefficient());
        }

        this.setMark(total);
        System.out.println("average" + total);
    }

    public void deleteMark(int index) {
        this.markArrayList.remove(index);
    }

}
