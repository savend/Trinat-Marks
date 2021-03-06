import java.util.ArrayList;

public class Subject extends Mark {

    //Arraylist to stock the marks
    private ArrayList<Mark> markArrayList = new ArrayList<>();


    /*------CONSTRUCTORS-----*/

    //Default constructor *NoName* *best Mark* *Coefficient 0*
    public Subject() {
        super();
    }

    //Constructor to initialise a new Subject only with a Name
    public Subject(String markName) {
        super(markName, 0, 1);
    }

    //Constructor to force construction of french average Subject
    public Subject(String markName, double mark, double coefficient, ArrayList<Mark> marks) {
        super(markName, mark, coefficient);
        this.markArrayList = marks;
    }

    //Constructor to force construction of Subject
    public Subject(String markName, double rawMark, int markLanguage, double coefficient, ArrayList<Mark> marks) {
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
        return "Subject{" +
                "markArrayList=" + markArrayList +
                "average=" + this.getMark() +
                '}';
    }


    /*------METHODS------*/


    //Method to add a mark to the Subject
    public void addMark(Mark mark) {
        this.markArrayList.add(mark);
        this.average();
        System.out.println(this.markArrayList.get(this.markArrayList.size() - 1).toString());
    }

    //Method to calculate average of the subject et update the local mark
    public void average() {

        double total = 0;
        for (Mark mark : markArrayList) {
            total += (mark.getMark() * mark.getCoefficient());
        }

        this.setMark(total);
        System.out.println("average " + total);
    }

    public void deleteMark(int index) {
        this.markArrayList.remove(index);
    }

}
