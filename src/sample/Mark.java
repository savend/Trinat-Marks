package sample;

public class Mark {

    private static final int MARK_FR = 0;
    private static final int MARK_DE = 1;
    private static final int MARK_CH = 2;

    private String markName; //Name of the Mark
    private double mark;    //Value of Mark in french system
    private double coefficient; //Mark coefficient
    private int markConvLine; //Line of MarkTable


    /*-----CONSTRUCTORS-----*/


    //Default constructor *best Mark* *Coefficient 0*
    public Mark() {
        System.out.println("Create new mark with default Values");
        this.markName = "NoName";
        this.mark = 16;
        this.coefficient = 1;

    }

    //Constructor if mark are given in FRENCH
    public Mark(String markName, double mark, double coefficient) {
        System.out.println("Create new mark with no specific language (FRENCH)");
        this.markName = markName;
        this.mark = roundMark(mark); //directly assign the mark to instance variable
        this.coefficient = coefficient;
        setMarkConvLine(this.mark, MARK_FR); //set the markConvLine from given mark

    }

    //Constructor if mark are given in specific language
    public Mark(String markName, double rawMark, int markLanguage, double coefficient) {
        System.out.println("Create new mark with specific language");
        setMarkConvLine(rawMark, markLanguage); //set the MarkConvLine to initialise the right mark
        this.markName = markName;
        setMark(); //set FRENCH mark from MarkConvLine Variable
        this.coefficient = coefficient;

    }


    /*-----GETTER-----*/


    public String getMarkName() {
        return markName;
    }

    public double getMark() {
        return mark;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public int getMarkConvLine() {
        return markConvLine;
    }


    /*-----SETTER-----*/


    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public void setMark(double mark) {
        this.mark = roundMark(mark); //Force new mark
        this.setMarkConvLine(this.mark); //update MarkConvLine
    }

    //Setter if another marklanguage are given
    public void setMark() {
        this.mark = markTable[markConvLine][MARK_FR];
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public void setMarkConvLine(int markConvLine) {
        this.markConvLine = markConvLine;
    }

    //Setter of MarkConvLine when new mark are setted
    public void setMarkConvLine(double mark) {
        for (int i = 0; i < markTable.length; i++) {
            if (roundMark(mark) == markTable[i][MARK_FR]) {
                this.setMarkConvLine(i);
            }
        }
    }

    //Setter of MarkConvLine for constructor from a given language
    public void setMarkConvLine(double markValue, int markLanguage) {

        System.out.println("Mark conversion, Set the Object markConvLine, ( for Mark Object constructor ) ");
        for (int i = 0; i < markTable.length; i++) {
            if (roundMark(markValue) == markTable[i][markLanguage]) {
                this.setMarkConvLine(i);
            }
        }
        this.setMark();

    }


    /*-----PRINT-----*/


    public String toString() {
        return "Mark{" +
                "markName='" + markName + '\'' +
                ", mark=" + mark +
                ", coefficient=" + coefficient +
                ", markConvLine=" + markConvLine +
                '}';
    }


    /*-----MARK CONVERSION METHODS-----*/


    //Method to return a mark in specific language
    public double markConversion(int outMarkLanguage) {
        System.out.println("Mark conversion, Get the Object markConvLine, return the specific Language Mark ");
        return markTable[this.getMarkConvLine()][outMarkLanguage];
    }


    /*-----ROUND MARK METHOD-----*/


    public double roundMark(double mark) {
        return ((double) Math.round(mark * 10)) / 10;
    }


    /*-----MARK TABLE-----*/


    //markTable[value][language]
    private static double[][] markTable = new double[][]{
            {16.0, 1.0, 6.0},   //french //German //Swiss
            {15.9, 1.1, 5.9},
            {15.8, 1.1, 5.9},
            {15.7, 1.1, 5.9},
            {15.6, 1.2, 5.8},
            {15.5, 1.2, 5.8},
            {15.4, 1.2, 5.7},
            {15.3, 1.3, 5.7},
            {15.2, 1.3, 5.6},
            {15.1, 1.4, 5.6},
            {15.0, 1.4, 5.5},
            {14.9, 1.5, 5.5},
            {14.8, 1.5, 5.4},
            {14.7, 1.6, 5.4},
            {14.6, 1.6, 5.3},
            {14.5, 1.6, 5.3},
            {14.4, 1.6, 5.2},
            {14.3, 1.7, 5.2},
            {14.2, 1.7, 5.1},
            {14.1, 1.8, 5.1},
            {14.0, 1.8, 5.0},
            {13.9, 1.9, 5.0},
            {13.8, 1.9, 4.9},
            {13.7, 1.9, 4.9},
            {13.6, 2.0, 4.9},
            {13.5, 2.0, 4.8},
            {13.4, 2.0, 4.8},
            {13.3, 2.1, 4.8},
            {13.2, 2.1, 4.8},
            {13.1, 2.2, 4.7},
            {13.0, 2.2, 4.7},
            {12.9, 2.3, 4.7},
            {12.8, 2.3, 4.7},
            {12.7, 2.3, 4.6},
            {12.6, 2.4, 4.6},
            {12.5, 2.4, 4.6},
            {12.4, 2.4, 4.6},
            {12.3, 2.5, 4.5},
            {12.2, 2.5, 4.5},
            {12.1, 2.6, 4.5},
            {12.0, 2.6, 4.5},
            {11.9, 2.7, 4.4},
            {11.8, 2.7, 4.4},
            {11.7, 2.7, 4.4},
            {11.6, 2.8, 4.4},
            {11.5, 2.8, 4.3},
            {11.4, 2.8, 4.3},
            {11.3, 2.9, 4.3},
            {11.2, 2.9, 4.3},
            {11.1, 3.0, 4.2},
            {11.0, 3.0, 4.2},
            {10.9, 3.1, 4.2},
            {10.8, 3.2, 4.2},
            {10.7, 3.3, 4.1},
            {10.6, 3.4, 4.1},
            {10.5, 3.5, 4.1},
            {10.4, 3.6, 4.1},
            {10.3, 3.7, 4.0},
            {10.2, 3.8, 4.0},
            {10.1, 3.9, 4.0},
            {10.0, 4.0, 4.0},
            {9.9, 4.1, 3.9},
            {9.8, 4.1, 3.9},
            {9.7, 4.1, 3.9},
            {9.6, 4.1, 3.8},
            {9.5, 4.1, 3.8},
            {9.4, 4.1, 3.8},
            {9.3, 4.1, 3.7},
            {9.2, 4.1, 3.7},
            {9.1, 4.1, 3.7},
            {9.0, 4.1, 3.6},
            {8.9, 4.2, 3.6},
            {8.8, 4.2, 3.6},
            {8.7, 4.2, 3.5},
            {8.6, 4.2, 3.5},
            {8.5, 4.2, 3.5},
            {8.4, 4.2, 3.4},
            {8.3, 4.2, 3.4},
            {8.2, 4.2, 3.4},
            {8.1, 4.2, 3.3},
            {8.0, 4.2, 3.3},
            {7.9, 4.3, 3.3},
            {7.8, 4.3, 3.2},
            {7.7, 4.3, 3.2},
            {7.6, 4.3, 3.2},
            {7.5, 4.3, 3.1},
            {7.4, 4.3, 3.1},
            {7.3, 4.3, 3.1},
            {7.2, 4.3, 3.0},
            {7.1, 4.3, 3.0},
            {7.0, 4.3, 3.0},
            {6.9, 4.4, 3.0},
            {6.8, 4.4, 2.9},
            {6.7, 4.4, 2.9},
            {6.6, 4.4, 2.9},
            {6.5, 4.4, 2.9},
            {6.4, 4.4, 2.8},
            {6.3, 4.4, 2.8},
            {6.2, 4.4, 2.8},
            {6.1, 4.4, 2.8},
            {6.0, 4.4, 2.7},
            {5.9, 4.5, 2.7},
            {5.8, 4.5, 2.7},
            {5.7, 4.5, 2.7},
            {5.6, 4.5, 2.6},
            {5.5, 4.5, 2.6},
            {5.4, 4.5, 2.6},
            {5.3, 4.5, 2.6},
            {5.2, 4.5, 2.5},
            {5.1, 4.5, 2.5},
            {5.0, 4.5, 2.5},
            {4.9, 4.6, 2.4},
            {4.8, 4.6, 2.4},
            {4.7, 4.6, 2.4},
            {4.6, 4.6, 2.3},
            {4.5, 4.6, 2.3},
            {4.4, 4.6, 2.3},
            {4.3, 4.6, 2.3},
            {4.2, 4.6, 2.2},
            {4.1, 4.6, 2.2},
            {4.0, 4.6, 2.2},
            {3.9, 4.7, 2.1},
            {3.8, 4.7, 2.1},
            {3.7, 4.7, 2.1},
            {3.6, 4.7, 2.0},
            {3.5, 4.7, 2.0},
            {3.4, 4.7, 2.0},
            {3.3, 4.7, 2.0},
            {3.2, 4.7, 1.9},
            {3.1, 4.7, 1.9},
            {3.0, 4.7, 1.9},
            {2.9, 4.8, 1.8},
            {2.8, 4.8, 1.8},
            {2.7, 4.8, 1.8},
            {2.6, 4.8, 1.7},
            {2.5, 4.8, 1.7},
            {2.4, 4.8, 1.7},
            {2.3, 4.8, 1.7},
            {2.2, 4.8, 1.6},
            {2.1, 4.8, 1.6},
            {2.0, 4.8, 1.6},
            {1.9, 4.9, 1.5},
            {1.8, 4.9, 1.5},
            {1.7, 4.9, 1.5},
            {1.6, 4.9, 1.4},
            {1.5, 4.9, 1.4},
            {1.4, 4.9, 1.4},
            {1.3, 4.9, 1.4},
            {1.2, 4.9, 1.3},
            {1.1, 4.9, 1.3},
            {1.0, 4.9, 1.3},
            {0.9, 5.0, 1.2},
            {0.8, 5.0, 1.2},
            {0.7, 5.0, 1.2},
            {0.6, 5.0, 1.1},
            {0.5, 5.0, 1.1},
            {0.4, 5.0, 1.1},
            {0.3, 5.0, 1.1},
            {0.2, 5.0, 1.0},
            {0.1, 5.0, 1.0},
            {0.0, 5.0, 1.0},
    };
}
